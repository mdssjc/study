package com.github.mdssjc.matchmaking;

import lombok.Getter;
import lombok.Setter;

public class PersonBeanImpl implements PersonBean {

  @Getter
  @Setter
  private String name;
  @Getter
  @Setter
  private String gender;
  @Getter
  @Setter
  private String interests;
  private int rating;
  private int ratingCount;

  @Override
  public int getHotOrNotRating() {
    if (this.ratingCount == 0) {
      return 0;
    }
    return this.rating / this.ratingCount;
  }

  @Override
  public void setHotOrNotRating(final int rating) {
    this.rating += rating;
    this.ratingCount++;
  }
}
