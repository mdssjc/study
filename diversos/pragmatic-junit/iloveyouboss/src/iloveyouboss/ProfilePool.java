package iloveyouboss;

import java.util.ArrayList;
import java.util.List;

public class ProfilePool {

  private final List<Profile> profiles = new ArrayList<>();

  public void add(final Profile profile) {
    this.profiles.add(profile);
  }

  public void score(final Criteria criteria) {
    // for (final Profile profile : this.profiles) {
    // profile.matches(criteria);
    // }
  }

  public List<Profile> ranked() {
    // Collections.sort(this.profiles,
    // (p1, p2) -> ((Integer) p2.score()).compareTo(p1.score()));
    // return this.profiles;
    return null;
  }
}
