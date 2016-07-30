package com.github.mdssjc.hfooad.ricksguitars;

import com.github.mdssjc.hfooad.ricksguitars.types.Builder;
import com.github.mdssjc.hfooad.ricksguitars.types.InstrumentType;
import com.github.mdssjc.hfooad.ricksguitars.types.Type;
import com.github.mdssjc.hfooad.ricksguitars.types.Wood;

public class InstrumentsTestDataBuilder {

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
  public static Instrument MANDOLIN1;
  public static Instrument BANJO1;

  private static void initialize() {
    InstrumentsTestDataBuilder.GUITAR1 = Instrument.builder()
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

    InstrumentsTestDataBuilder.GUITAR2 = Instrument.builder()
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

    InstrumentsTestDataBuilder.GUITAR3 = Instrument.builder()
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

    InstrumentsTestDataBuilder.GUITAR4 = Instrument.builder()
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

    InstrumentsTestDataBuilder.GUITAR5 = Instrument.builder()
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

    InstrumentsTestDataBuilder.GUITAR6 = Instrument.builder()
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

    InstrumentsTestDataBuilder.GUITAR7 = Instrument.builder()
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

    InstrumentsTestDataBuilder.GUITAR8 = Instrument.builder()
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

    InstrumentsTestDataBuilder.GUITAR9 = Instrument.builder()
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

    InstrumentsTestDataBuilder.GUITAR10 = Instrument.builder()
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

    InstrumentsTestDataBuilder.GUITAR11 = Instrument.builder()
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

    InstrumentsTestDataBuilder.MANDOLIN1 = Instrument.builder()
      .serialNumber("9019920")
      .price(5495.99)
      .spec(new InstrumentSpec()
        .addProperty("instrumentType", InstrumentType.MANDOLIN)
        .addProperty("builder", Builder.GIBSON)
        .addProperty("model", "F5-G")
        .addProperty("type", Type.ACOUSTIC)
        .addProperty("backWood", Wood.MAPLE)
        .addProperty("topWood", Wood.MAPLE))
      .build();

    InstrumentsTestDataBuilder.BANJO1 = Instrument.builder()
      .serialNumber("8900231")
      .price(2945.95)
      .spec(new InstrumentSpec()
        .addProperty("instrumentType", InstrumentType.BANJO)
        .addProperty("builder", Builder.GIBSON)
        .addProperty("model", "RB-3 Wreath")
        .addProperty("type", Type.ACOUSTIC)
        .addProperty("numStrings", 5)
        .addProperty("backWood", Wood.MAPLE))
      .build();
  }

  public static void initializeInventory(
      final Inventory<Instrument, InstrumentSpec> inventory) {
    initialize();
    inventory.add(InstrumentsTestDataBuilder.GUITAR1);
    inventory.add(InstrumentsTestDataBuilder.GUITAR2);
    inventory.add(InstrumentsTestDataBuilder.GUITAR3);
    inventory.add(InstrumentsTestDataBuilder.GUITAR4);
    inventory.add(InstrumentsTestDataBuilder.GUITAR5);
    inventory.add(InstrumentsTestDataBuilder.GUITAR6);
    inventory.add(InstrumentsTestDataBuilder.GUITAR7);
    inventory.add(InstrumentsTestDataBuilder.GUITAR8);
    inventory.add(InstrumentsTestDataBuilder.GUITAR9);
    inventory.add(InstrumentsTestDataBuilder.GUITAR10);
    inventory.add(InstrumentsTestDataBuilder.GUITAR11);
    inventory.add(InstrumentsTestDataBuilder.MANDOLIN1);
    inventory.add(InstrumentsTestDataBuilder.BANJO1);
  }
}
