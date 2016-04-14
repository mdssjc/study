package iloveyouboss;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class ProfilePoolTest {

  private ProfilePool     pool;
  private Profile         langrsoft;
  private Profile         smeltInc;
  private BooleanQuestion doTheyReimburseTuition;

  @Before
  public void create() {
    this.pool = new ProfilePool();
    this.langrsoft = new Profile("Langrsoft");
    this.smeltInc = new Profile("Smelt Inc.");
    this.doTheyReimburseTuition = new BooleanQuestion(1, "Reimburses tuition?");
  }

  @Test
  @Ignore("Useless class")
  public void answersResultsInScoredOrder() {
    this.smeltInc.add(new Answer(this.doTheyReimburseTuition, Bool.FALSE));
    this.pool.add(this.smeltInc);
    this.langrsoft.add(new Answer(this.doTheyReimburseTuition, Bool.TRUE));
    this.pool.add(this.langrsoft);
    this.pool.score(
        soleNeed(this.doTheyReimburseTuition, Bool.TRUE, Weight.Important));
    final List<Profile> ranked = this.pool.ranked();

    assertThat(ranked.toArray(),
        equalTo(new Profile[] { this.langrsoft, this.smeltInc }));
  }

  private Criteria soleNeed(final Question question, final int value,
      final Weight weight) {
    final Criteria criteria = new Criteria();
    criteria.add(new Criterion(new Answer(question, value), weight));
    return criteria;
  }
}
