package com.github.mdssjc.hfooad.ricksguitars;

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
    GuitarsTestDataBuilder.GUITAR1 = Instrument.builder()
      .serialNumber("11277")
      .price(3999.95)
      .spec(new InstrumentSpec()
        .addProperty("instrumentType", InstrumentType.GUITAR)
        .addProperty("builder", Builder.COLLINGS)
        .addProperty("model", "CJ")
        .addProperty("type", Type.ACOUSTIC)
        .addProperty("numStrings", 6)
        .addProperty("backWood", Wood.INDIAN_ROSEWOOD)
        .addProperty("topWood", Wood.SITKA))
      .build();

    GuitarsTestDataBuilder.GUITAR2 = Instrument.builder()
      .serialNumber("V95693")
      .price(1499.95)
      .spec(new InstrumentSpec()
        .addProperty("instrumentType", InstrumentType.GUITAR)
        .addProperty("builder", Builder.FENDER)
        .addProperty("model", "Stratocastor")
        .addProperty("type", Type.ELECTRIC)
        .addProperty("numStrings", 6)
        .addProperty("backWood", Wood.ALDER)
        .addProperty("topWood", Wood.ALDER))
      .build();

    GuitarsTestDataBuilder.GUITAR3 = Instrument.builder()
      .serialNumber("V9512")
      .price(1549.95)
      .spec(new InstrumentSpec()
        .addProperty("instrumentType", InstrumentType.GUITAR)
        .addProperty("builder", Builder.FENDER)
        .addProperty("model", "Stratocastor")
        .addProperty("type", Type.ELECTRIC)
        .addProperty("numStrings", 6)
        .addProperty("backWood", Wood.ALDER)
        .addProperty("topWood", Wood.ALDER))
      .build();

    GuitarsTestDataBuilder.GUITAR4 = Instrument.builder()
      .serialNumber("122784")
      .price(5495.95)
      .spec(new InstrumentSpec()
        .addProperty("instrumentType", InstrumentType.GUITAR)
        .addProperty("builder", Builder.MARTIN)
        .addProperty("model", "D-18")
        .addProperty("type", Type.ACOUSTIC)
        .addProperty("numStrings", 6)
        .addProperty("backWood", Wood.MAHOGANY)
        .addProperty("topWood", Wood.ADIRONDACK))
      .build();

    GuitarsTestDataBuilder.GUITAR5 = Instrument.builder()
      .serialNumber("76531")
      .price(6295.95)
      .spec(new InstrumentSpec()
        .addProperty("instrumentType", InstrumentType.GUITAR)
        .addProperty("builder", Builder.MARTIN)
        .addProperty("model", "OM-28")
        .addProperty("type", Type.ACOUSTIC)
        .addProperty("numStrings", 6)
        .addProperty("backWood", Wood.BRAZILIAN_ROSEWOOD)
        .addProperty("topWood", Wood.ADIRONDACK))
      .build();

    GuitarsTestDataBuilder.GUITAR6 = Instrument.builder()
      .serialNumber("70108276")
      .price(2295.95)
      .spec(new InstrumentSpec()
        .addProperty("instrumentType", InstrumentType.GUITAR)
        .addProperty("builder", Builder.GIBSON)
        .addProperty("model", "Les Paul")
        .addProperty("type", Type.ELECTRIC)
        .addProperty("numStrings", 6)
        .addProperty("backWood", Wood.MAHOGANY)
        .addProperty("topWood", Wood.MAHOGANY))
      .build();

    GuitarsTestDataBuilder.GUITAR7 = Instrument.builder()
      .serialNumber("82765501")
      .price(1890.95)
      .spec(new InstrumentSpec()
        .addProperty("instrumentType", InstrumentType.GUITAR)
        .addProperty("builder", Builder.GIBSON)
        .addProperty("model", "SG '61 Reissue")
        .addProperty("type", Type.ELECTRIC)
        .addProperty("numStrings", 6)
        .addProperty("backWood", Wood.MAHOGANY)
        .addProperty("topWood", Wood.MAHOGANY))
      .build();

    GuitarsTestDataBuilder.GUITAR8 = Instrument.builder()
      .serialNumber("77023")
      .price(6275.95)
      .spec(new InstrumentSpec()
        .addProperty("instrumentType", InstrumentType.GUITAR)
        .addProperty("builder", Builder.MARTIN)
        .addProperty("model", "D-28")
        .addProperty("type", Type.ACOUSTIC)
        .addProperty("numStrings", 6)
        .addProperty("backWood", Wood.BRAZILIAN_ROSEWOOD)
        .addProperty("topWood", Wood.ADIRONDACK))
      .build();

    GuitarsTestDataBuilder.GUITAR9 = Instrument.builder()
      .serialNumber("1092")
      .price(12995.95)
      .spec(new InstrumentSpec()
        .addProperty("instrumentType", InstrumentType.GUITAR)
        .addProperty("builder", Builder.OLSON)
        .addProperty("model", "SJ")
        .addProperty("type", Type.ACOUSTIC)
        .addProperty("numStrings", 12)
        .addProperty("backWood", Wood.INDIAN_ROSEWOOD)
        .addProperty("topWood", Wood.CEDAR))
      .build();

    GuitarsTestDataBuilder.GUITAR10 = Instrument.builder()
      .serialNumber("566-62")
      .price(8999.95)
      .spec(new InstrumentSpec()
        .addProperty("instrumentType", InstrumentType.GUITAR)
        .addProperty("builder", Builder.RYAN)
        .addProperty("model", "Cathedral")
        .addProperty("type", Type.ACOUSTIC)
        .addProperty("numStrings", 12)
        .addProperty("backWood", Wood.COCOBOLO)
        .addProperty("topWood", Wood.CEDAR))
      .build();

    GuitarsTestDataBuilder.GUITAR11 = Instrument.builder()
      .serialNumber("6 29584")
      .price(2100.95)
      .spec(new InstrumentSpec()
        .addProperty("instrumentType", InstrumentType.GUITAR)
        .addProperty("builder", Builder.PRS)
        .addProperty("model", "Dave Navarro Signature")
        .addProperty("type", Type.ELECTRIC)
        .addProperty("numStrings", 6)
        .addProperty("backWood", Wood.MAHOGANY)
        .addProperty("topWood", Wood.MAPLE))
      .build();
  }

  public static void initializeInventory(
      final Inventory<Instrument, InstrumentSpec> inventory) {
    initialize();
    inventory.add(GuitarsTestDataBuilder.GUITAR1);
    inventory.add(GuitarsTestDataBuilder.GUITAR2);
    inventory.add(GuitarsTestDataBuilder.GUITAR3);
    inventory.add(GuitarsTestDataBuilder.GUITAR4);
    inventory.add(GuitarsTestDataBuilder.GUITAR5);
    inventory.add(GuitarsTestDataBuilder.GUITAR6);
    inventory.add(GuitarsTestDataBuilder.GUITAR7);
    inventory.add(GuitarsTestDataBuilder.GUITAR8);
    inventory.add(GuitarsTestDataBuilder.GUITAR9);
    inventory.add(GuitarsTestDataBuilder.GUITAR10);
    inventory.add(GuitarsTestDataBuilder.GUITAR11);
  }
}
