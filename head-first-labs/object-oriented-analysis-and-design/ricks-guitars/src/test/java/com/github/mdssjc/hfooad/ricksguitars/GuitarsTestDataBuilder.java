package com.github.mdssjc.hfooad.ricksguitars;

import static com.github.mdssjc.hfooad.ricksguitars.InstrumentType.GUITAR;

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
                                               .instrumentType(GUITAR)
                                               .spec(new GuitarSpec(
                                                   Builder.COLLINGS, "CJ",
                                                   Type.ACOUSTIC, 6,
                                                   Wood.INDIAN_ROSEWOOD,
                                                   Wood.SITKA))
                                               .build();

    GuitarsTestDataBuilder.GUITAR2 = Instrument.builder()
                                               .serialNumber("V95693")
                                               .price(1499.95)
                                               .instrumentType(GUITAR)
                                               .spec(new GuitarSpec(
                                                   Builder.FENDER,
                                                   "Stratocastor",
                                                   Type.ELECTRIC, 6, Wood.ALDER,
                                                   Wood.ALDER))
                                               .build();

    GuitarsTestDataBuilder.GUITAR3 = Instrument.builder()
                                               .serialNumber("V9512")
                                               .price(1549.95)
                                               .instrumentType(GUITAR)
                                               .spec(new GuitarSpec(
                                                   Builder.FENDER,
                                                   "Stratocastor",
                                                   Type.ELECTRIC, 6, Wood.ALDER,
                                                   Wood.ALDER))
                                               .build();

    GuitarsTestDataBuilder.GUITAR4 = Instrument.builder()
                                               .serialNumber("122784")
                                               .price(5495.95)
                                               .instrumentType(GUITAR)
                                               .spec(new GuitarSpec(
                                                   Builder.MARTIN, "D-18",
                                                   Type.ACOUSTIC, 6,
                                                   Wood.MAHOGANY,
                                                   Wood.ADIRONDACK))
                                               .build();

    GuitarsTestDataBuilder.GUITAR5 = Instrument.builder()
                                               .serialNumber("76531")
                                               .price(6295.95)
                                               .instrumentType(GUITAR)
                                               .spec(new GuitarSpec(
                                                   Builder.MARTIN, "OM-28",
                                                   Type.ACOUSTIC, 6,
                                                   Wood.BRAZILIAN_ROSEWOOD,
                                                   Wood.ADIRONDACK))
                                               .build();

    GuitarsTestDataBuilder.GUITAR6 = Instrument.builder()
                                               .serialNumber("70108276")
                                               .price(2295.95)
                                               .instrumentType(GUITAR)
                                               .spec(new GuitarSpec(
                                                   Builder.GIBSON, "Les Paul",
                                                   Type.ELECTRIC, 6,
                                                   Wood.MAHOGANY,
                                                   Wood.MAHOGANY))
                                               .build();

    GuitarsTestDataBuilder.GUITAR7 = Instrument.builder()
                                               .serialNumber("82765501")
                                               .price(1890.95)
                                               .instrumentType(GUITAR)
                                               .spec(new GuitarSpec(
                                                   Builder.GIBSON,
                                                   "SG '61 Reissue",
                                                   Type.ELECTRIC, 6,
                                                   Wood.MAHOGANY,
                                                   Wood.MAHOGANY))
                                               .build();

    GuitarsTestDataBuilder.GUITAR8 = Instrument.builder()
                                               .serialNumber("77023")
                                               .price(6275.95)
                                               .instrumentType(GUITAR)
                                               .spec(new GuitarSpec(
                                                   Builder.MARTIN, "D-28",
                                                   Type.ACOUSTIC, 6,
                                                   Wood.BRAZILIAN_ROSEWOOD,
                                                   Wood.ADIRONDACK))
                                               .build();

    GuitarsTestDataBuilder.GUITAR9 = Instrument.builder()
                                               .serialNumber("1092")
                                               .price(12995.95)
                                               .instrumentType(GUITAR)
                                               .spec(
                                                   new GuitarSpec(Builder.OLSON,
                                                       "SJ", Type.ACOUSTIC, 12,
                                                       Wood.INDIAN_ROSEWOOD,
                                                       Wood.CEDAR))
                                               .build();

    GuitarsTestDataBuilder.GUITAR10 = Instrument.builder()
                                                .serialNumber("566-62")
                                                .price(8999.95)
                                                .instrumentType(GUITAR)
                                                .spec(new GuitarSpec(
                                                    Builder.RYAN, "Cathedral",
                                                    Type.ACOUSTIC, 12,
                                                    Wood.COCOBOLO, Wood.CEDAR))
                                                .build();

    GuitarsTestDataBuilder.GUITAR11 = Instrument.builder()
                                                .serialNumber("6 29584")
                                                .price(2100.95)
                                                .instrumentType(GUITAR)
                                                .spec(new GuitarSpec(
                                                    Builder.PRS,
                                                    "Dave Navarro Signature",
                                                    Type.ELECTRIC, 6,
                                                    Wood.MAHOGANY, Wood.MAPLE))
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
