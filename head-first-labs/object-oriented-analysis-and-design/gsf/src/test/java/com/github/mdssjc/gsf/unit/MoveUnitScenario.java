package com.github.mdssjc.gsf.unit;

import com.github.mdssjc.gsf.board.Board;
import com.github.mdssjc.gsf.board.Coordinate;
import org.junit.Test;

import static org.junit.Assert.*;

public class MoveUnitScenario {

  @Test
  public void demonstrateMoveUnit() {
    System.out.println("\n\nDemonstrate unit movement capability");
    final Board b = new Board(10, 10);
    System.out.println("Created a 10 x 10 board");
    final Unit u = new Unit(1);
    u.setProperty("name", "1st Infantry Division");
    System.out.println("Created 1st Infantry Division");
    b.addUnit(u, new Coordinate(3, 3));
    assertEquals(new Coordinate(3, 3), b.whereIs(u));
    System.out.println("Placed 1st Infantry Division on square (3, 3)");
    b.moveUnit(u, new Coordinate(5, 2));
    System.out.println(
        "Moved 1st Infantry Division from (3,3) to (5, 2)");
    assertEquals(0, b.getTileAt(new Coordinate(3, 3))
                     .getUnits()
                     .size());
    System.out.println("Where is 1st Infantry Division at? " + b.whereIs(u));
  }

  @Test
  public void testIllegalCoordinate() {
    final Board b = new Board(3, 3);

    try {
      b.getTileAt(new Coordinate(3, 0));
      fail("Expected out of bounds index");
    } catch (final Exception e) {
      assertTrue(true);
    }
  }

  @Test
  public void testMoveFromSingleUnitSquareToEmptySquare() {
    final Board b = new Board(10, 10);
    final Unit u = new Unit(1);

    b.addUnit(u, new Coordinate(1, 1));
    b.moveUnit(u, new Coordinate(2, 2));

    assertTrue(b.getTileAt(new Coordinate(2, 2))
                .containsUnit(u));
    assertFalse(b.getTileAt(new Coordinate(1, 1))
                 .containsUnit(u));
    assertEquals(new Coordinate(2, 2), b.whereIs(u));
  }

  @Test
  public void testMoveFromMultiUnitSquareToMultiUnitSquare() {
    final Board b = new Board(10, 10);
    final Unit u1 = new Unit(1);
    final Unit u2 = new Unit(2);
    final Unit u3 = new Unit(3);
    final Coordinate c1 = new Coordinate(3, 3);
    final Coordinate c2 = new Coordinate(4, 5);

    b.addUnit(u1, c1);
    b.addUnit(u2, c1);
    b.addUnit(u3, c2);
    b.moveUnit(u1, c2);

    assertFalse(b.getTileAt(c1)
                 .containsUnit(u1));
    assertTrue(b.getTileAt(c1)
                .containsUnit(u2));
    assertTrue(b.getTileAt(c2)
                .containsUnit(u1));
    assertTrue(b.getTileAt(c2)
                .containsUnit(u3));
    assertEquals(c2, b.whereIs(u1));
  }

  @Test
  public void testMoveUnitNotOnBoard() {
    final Board b = new Board(10, 10);
    final Unit u = new Unit(1);

    b.moveUnit(u, new Coordinate(3, 3));

    assertFalse(b.getTileAt(new Coordinate(3, 3))
                 .containsUnit(u));
  }

  @Test
  public void whereIsUnitNotOnBoard() {
    final Board b = new Board(10, 10);

    assertNull(b.whereIs(new Unit(1)));
  }
}
