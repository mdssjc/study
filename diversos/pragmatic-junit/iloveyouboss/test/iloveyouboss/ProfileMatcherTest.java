package iloveyouboss;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

import iloveyouboss.domain.BooleanQuestion;

public class ProfileMatcherTest {

  private BooleanQuestion question;
  private Criteria        criteria;
  private ProfileMatcher  matcher;
  private Profile         matchingProfile;
  private Profile         nonMatchingProfile;
  private MatchListener   listener;

  @Before
  public void create() {
    this.question = new BooleanQuestion("");
    this.criteria = new Criteria();
    this.criteria.add(new Criterion(matchingAnswer(), Weight.MustMatch));
    this.matchingProfile = createMatchingProfile("matching");
    this.nonMatchingProfile = createNonMatchingProfile("nonMatching");
  }

  private Profile createMatchingProfile(final String name) {
    final Profile profile = new Profile(name);
    profile.add(matchingAnswer());
    return profile;
  }

  private Profile createNonMatchingProfile(final String name) {
    final Profile profile = new Profile(name);
    profile.add(nonMatchingAnswer());
    return profile;
  }

  @Before
  public void createMatchListener() {
    this.listener = mock(MatchListener.class);
  }

  @Before
  public void createMatcher() {
    this.matcher = new ProfileMatcher();
  }

  @Test
  public void processNotifiesListenerOnMatch() {
    this.matcher.add(this.matchingProfile);
    final MatchSet set = this.matchingProfile.getMatchSet(this.criteria);

    this.matcher.process(this.listener, set);

    verify(this.listener).foundMatch(this.matchingProfile, set);
  }

  @Test
  public void processDoesNotNotifyListenerWhenNoMatch() {
    this.matcher.add(this.nonMatchingProfile);
    final MatchSet set = this.nonMatchingProfile.getMatchSet(this.criteria);

    this.matcher.process(this.listener, set);

    verify(this.listener, never()).foundMatch(this.matchingProfile, set);
  }

  @Test
  public void gathersMatchingProfiles() {
    final Set<String> processedSets = Collections.synchronizedSet(
        new HashSet<>());
    final BiConsumer<MatchListener, MatchSet> processFunction = (listener,
        set) -> {
      processedSets.add(set.getProfileId());
    };
    final List<MatchSet> matchSets = createMatchSets(100);

    this.matcher.findMatchingProfiles(this.criteria, this.listener, matchSets,
        processFunction);

    while (!this.matcher.getExecutor()
                        .isTerminated()) {
      // WAIT
    }

    assertThat(processedSets, equalTo(matchSets.stream()
                                               .map(MatchSet::getProfileId)
                                               .collect(Collectors.toSet())));
  }

  @Test
  public void collectsMatchSets() {
    this.matcher.add(this.matchingProfile);
    this.matcher.add(this.nonMatchingProfile);
    final List<MatchSet> sets = this.matcher.collectMatchSets(this.criteria);
    assertThat(sets.stream()
                   .map(set -> set.getProfileId())
                   .collect(Collectors.toSet()),
        equalTo(new HashSet<>(Arrays.asList(this.matchingProfile.getId(),
            this.nonMatchingProfile.getId()))));
  }

  private Answer matchingAnswer() {
    return new Answer(this.question, Bool.TRUE);
  }

  private Answer nonMatchingAnswer() {
    return new Answer(this.question, Bool.FALSE);
  }

  private List<MatchSet> createMatchSets(final int count) {
    final List<MatchSet> sets = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      sets.add(new MatchSet(String.valueOf(i), null, null));
    }
    return sets;
  }
}
