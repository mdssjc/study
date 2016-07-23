package com.github.mdssjc.hfooad.ricksguitars;

import com.github.mdssjc.hfooad.ricksguitars.builder.GuitarBuilder;
import com.github.mdssjc.hfooad.ricksguitars.types.Builder;
import com.github.mdssjc.hfooad.ricksguitars.types.Type;
import com.github.mdssjc.hfooad.ricksguitars.types.Wood;

public class GuitarsTestDataBuilder {

  public static Instrument GUITAR1;
  public static Instrument GUITAR2;
  public static Instrument GUITAR3;
  public static Instrument GUITAR4;
  public static Instrument GUITAR5;
  public static Instrument GUITAR6;
  public static Instrument GUITAR7;
  public static Instrument GUITAR8;
  public static Instrument GUITAR9;
  public static Instrument GUITAR10;
  public static Instrument GUITAR11;

  private static void initialize() {
    GUITAR1 = new GuitarBuilder()
                                 .setSerialNumber("11277")
                                 .setPrice(3999.95)
                                 .setBuilder(Builder.COLLINGS)
                                 .setModel("CJ")
                                 .setType(Type.ACOUSTIC)
                                 .setNumStrings(6)
                                 .setBackWood(Wood.INDIAN_ROSEWOOD)
                                 .setTopWood(Wood.SITKA)
                                 .makeGuitar();

    GUITAR2 = new GuitarBuilder()
                                 .setSerialNumber("V95693")
                                 .setPrice(1499.95)
                                 .setBuilder(Builder.FENDER)
                                 .setModel("Stratocastor")
                                 .setType(Type.ELECTRIC)
                                 .setNumStrings(6)
                                 .setBackWood(Wood.ALDER)
                                 .setTopWood(Wood.ALDER)
                                 .makeGuitar();

    GUITAR3 = new GuitarBuilder()
                                 .setSerialNumber("V9512")
                                 .setPrice(1549.95)
                                 .setBuilder(Builder.FENDER)
                                 .setModel("Stratocastor")
                                 .setType(Type.ELECTRIC)
                                 .setNumStrings(6)
                                 .setBackWood(Wood.ALDER)
                                 .setTopWood(Wood.ALDER)
                                 .makeGuitar();

    GUITAR4 = new GuitarBuilder()
                                 .setSerialNumber("122784")
                                 .setPrice(5495.95)
                                 .setBuilder(Builder.MARTIN)
                                 .setModel("D-18")
                                 .setType(Type.ACOUSTIC)
                                 .setNumStrings(6)
                                 .setBackWood(Wood.MAHOGANY)
                                 .setTopWood(Wood.ADIRONDACK)
                                 .makeGuitar();

    GUITAR5 = new GuitarBuilder()
                                 .setSerialNumber("76531")
                                 .setPrice(6295.95)
                                 .setBuilder(Builder.MARTIN)
                                 .setModel("OM-28")
                                 .setType(Type.ACOUSTIC)
                                 .setNumStrings(6)
                                 .setBackWood(Wood.BRAZILIAN_ROSEWOOD)
                                 .setTopWood(Wood.ADIRONDACK)
                                 .makeGuitar();

    GUITAR6 = new GuitarBuilder()
                                 .setSerialNumber("70108276")
                                 .setPrice(2295.95)
                                 .setBuilder(Builder.GIBSON)
                                 .setModel("Les Paul")
                                 .setType(Type.ELECTRIC)
                                 .setNumStrings(6)
                                 .setBackWood(Wood.MAHOGANY)
                                 .setTopWood(Wood.MAHOGANY)
                                 .makeGuitar();

    GUITAR7 = new GuitarBuilder()
                                 .setSerialNumber("82765501")
                                 .setPrice(1890.95)
                                 .setBuilder(Builder.GIBSON)
                                 .setModel("SG '61 Reissue")
                                 .setType(Type.ELECTRIC)
                                 .setNumStrings(6)
                                 .setBackWood(Wood.MAHOGANY)
                                 .setTopWood(Wood.MAHOGANY)
                                 .makeGuitar();

    GUITAR8 = new GuitarBuilder()
                                 .setSerialNumber("77023")
                                 .setPrice(6275.95)
                                 .setBuilder(Builder.MARTIN)
                                 .setModel("D-28")
                                 .setType(Type.ACOUSTIC)
                                 .setNumStrings(6)
                                 .setBackWood(Wood.BRAZILIAN_ROSEWOOD)
                                 .setTopWood(Wood.ADIRONDACK)
                                 .makeGuitar();

    GUITAR9 = new GuitarBuilder()
                                 .setSerialNumber("1092")
                                 .setPrice(12995.95)
                                 .setBuilder(Builder.OLSON)
                                 .setModel("SJ")
                                 .setType(Type.ACOUSTIC)
                                 .setNumStrings(12)
                                 .setBackWood(Wood.INDIAN_ROSEWOOD)
                                 .setTopWood(Wood.CEDAR)
                                 .makeGuitar();

    GUITAR10 = new GuitarBuilder()
                                  .setSerialNumber("566-62")
                                  .setPrice(8999.95)
                                  .setBuilder(Builder.RYAN)
                                  .setModel("Cathedral")
                                  .setType(Type.ACOUSTIC)
                                  .setNumStrings(12)
                                  .setBackWood(Wood.COCOBOLO)
                                  .setTopWood(Wood.CEDAR)
                                  .makeGuitar();

    GUITAR11 = new GuitarBuilder()
                                  .setSerialNumber("6 29584")
                                  .setPrice(2100.95)
                                  .setBuilder(Builder.PRS)
                                  .setModel("Dave Navarro Signature")
                                  .setType(Type.ELECTRIC)
                                  .setNumStrings(6)
                                  .setBackWood(Wood.MAHOGANY)
                                  .setTopWood(Wood.MAPLE)
                                  .makeGuitar();
  }

  public static void initializeInventory(
      final Inventory<Instrument, InstrumentSpec> inventory) {
    initialize();
    inventory.add(GUITAR1);
    inventory.add(GUITAR2);
    inventory.add(GUITAR3);
    inventory.add(GUITAR4);
    inventory.add(GUITAR5);
    inventory.add(GUITAR6);
    inventory.add(GUITAR7);
    inventory.add(GUITAR8);
    inventory.add(GUITAR9);
    inventory.add(GUITAR10);
    inventory.add(GUITAR11);
  }
}
