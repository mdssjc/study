package com.github.mdssjc.routefinder.subway;

import lombok.Data;

@Data
public class Connection {

  private final Station station1;
  private final Station station2;
  private final String lineName;
}
