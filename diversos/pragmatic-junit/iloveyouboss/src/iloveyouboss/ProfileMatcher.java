package iloveyouboss;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class ProfileMatcher {

  private final Map<String, Profile> profiles          = new HashMap<>();
  private static final int           DEFAULT_POOL_SIZE = 4;
  private final ExecutorService      executor          = Executors.newFixedThreadPool(
      ProfileMatcher.DEFAULT_POOL_SIZE);

  ExecutorService getExecutor() {
    return this.executor;
  }

  public void add(final Profile profile) {
    this.profiles.put(profile.getId(), profile);
  }

  public void findMatchingProfiles(
      final Criteria criteria, final MatchListener listener,
      final List<MatchSet> matchSets,
      final BiConsumer<MatchListener, MatchSet> processFunction) {

    for (final MatchSet set : matchSets) {
      this.executor.execute(() -> processFunction.accept(listener, set));
    }
    this.executor.shutdown();
  }

  public void findMatchingProfiles(
      final Criteria criteria, final MatchListener listener) {
    findMatchingProfiles(criteria, listener, collectMatchSets(criteria),
        this::process);
  }

  public void process(final MatchListener listener, final MatchSet set) {
    if (set.matches()) {
      listener.foundMatch(this.profiles.get(set.getProfileId()), set);
    }
  }

  public List<MatchSet> collectMatchSets(final Criteria criteria) {
    return this.profiles.values()
                        .stream()
                        .map(profile -> profile.getMatchSet(
                            criteria))
                        .collect(Collectors.toList());
  }
}
