package com.github.mdssjc.hfooad;

import com.github.mdssjc.hfooad.base.Guitar;
import com.github.mdssjc.hfooad.base.GuitarSpec;
import com.github.mdssjc.hfooad.base.Inventory;
import com.github.mdssjc.hfooad.base.builder.GuitarBuilder;
import com.github.mdssjc.hfooad.types.Builder;
import com.github.mdssjc.hfooad.types.Type;
import com.github.mdssjc.hfooad.types.Wood;

public class GuitarsTestDataBuilder {

  public static void initializeInventory(
      final Inventory<Guitar, GuitarSpec> inventory) {
    inventory.add(new GuitarBuilder()
                                     .setSerialNumber("11277")
                                     .setPrice(3999.95)
                                     .setBuilder(Builder.COLLINGS)
                                     .setModel("CJ")
                                     .setType(Type.ACOUSTIC)
                                     .setNumStrings(6)
                                     .setBackWood(Wood.INDIAN_ROSEWOOD)
                                     .setTopWood(Wood.SITKA)
                                     .makeGuitar());

    inventory.add(new GuitarBuilder()
                                     .setSerialNumber("V95693")
                                     .setPrice(1499.95)
                                     .setBuilder(Builder.FENDER)
                                     .setModel("Stratocastor")
                                     .setType(Type.ELECTRIC)
                                     .setNumStrings(6)
                                     .setBackWood(Wood.ALDER)
                                     .setTopWood(Wood.ALDER)
                                     .makeGuitar());

    inventory.add(new GuitarBuilder()
                                     .setSerialNumber("V9512")
                                     .setPrice(1549.95)
                                     .setBuilder(Builder.FENDER)
                                     .setModel("Stratocastor")
                                     .setType(Type.ELECTRIC)
                                     .setNumStrings(6)
                                     .setBackWood(Wood.ALDER)
                                     .setTopWood(Wood.ALDER)
                                     .makeGuitar());

    inventory.add(new GuitarBuilder()
                                     .setSerialNumber("122784")
                                     .setPrice(5495.95)
                                     .setBuilder(Builder.MARTIN)
                                     .setModel("D-18")
                                     .setType(Type.ACOUSTIC)
                                     .setNumStrings(6)
                                     .setBackWood(Wood.MAHOGANY)
                                     .setTopWood(Wood.ADIRONDACK)
                                     .makeGuitar());

    inventory.add(new GuitarBuilder()
                                     .setSerialNumber("76531")
                                     .setPrice(6295.95)
                                     .setBuilder(Builder.MARTIN)
                                     .setModel("OM-28")
                                     .setType(Type.ACOUSTIC)
                                     .setNumStrings(6)
                                     .setBackWood(Wood.BRAZILIAN_ROSEWOOD)
                                     .setTopWood(Wood.ADIRONDACK)
                                     .makeGuitar());

    inventory.add(new GuitarBuilder()
                                     .setSerialNumber("70108276")
                                     .setPrice(2295.95)
                                     .setBuilder(Builder.GIBSON)
                                     .setModel("Les Paul")
                                     .setType(Type.ELECTRIC)
                                     .setNumStrings(6)
                                     .setBackWood(Wood.MAHOGANY)
                                     .setTopWood(Wood.MAHOGANY)
                                     .makeGuitar());

    inventory.add(new GuitarBuilder()
                                     .setSerialNumber("82765501")
                                     .setPrice(1890.95)
                                     .setBuilder(Builder.GIBSON)
                                     .setModel("SG '61 Reissue")
                                     .setType(Type.ELECTRIC)
                                     .setNumStrings(6)
                                     .setBackWood(Wood.MAHOGANY)
                                     .setTopWood(Wood.MAHOGANY)
                                     .makeGuitar());

    inventory.add(new GuitarBuilder()
                                     .setSerialNumber("77023")
                                     .setPrice(6275.95)
                                     .setBuilder(Builder.MARTIN)
                                     .setModel("D-28")
                                     .setType(Type.ACOUSTIC)
                                     .setNumStrings(6)
                                     .setBackWood(Wood.BRAZILIAN_ROSEWOOD)
                                     .setTopWood(Wood.ADIRONDACK)
                                     .makeGuitar());

    inventory.add(new GuitarBuilder()
                                     .setSerialNumber("1092")
                                     .setPrice(12995.95)
                                     .setBuilder(Builder.OLSON)
                                     .setModel("SJ")
                                     .setType(Type.ACOUSTIC)
                                     .setNumStrings(12)
                                     .setBackWood(Wood.INDIAN_ROSEWOOD)
                                     .setTopWood(Wood.CEDAR)
                                     .makeGuitar());

    inventory.add(new GuitarBuilder()
                                     .setSerialNumber("566-62")
                                     .setPrice(8999.95)
                                     .setBuilder(Builder.RYAN)
                                     .setModel("Cathedral")
                                     .setType(Type.ACOUSTIC)
                                     .setNumStrings(12)
                                     .setBackWood(Wood.COCOBOLO)
                                     .setTopWood(Wood.CEDAR)
                                     .makeGuitar());

    inventory.add(new GuitarBuilder()
                                     .setSerialNumber("6 29584")
                                     .setPrice(2100.95)
                                     .setBuilder(Builder.PRS)
                                     .setModel("Dave Navarro Signature")
                                     .setType(Type.ELECTRIC)
                                     .setNumStrings(6)
                                     .setBackWood(Wood.MAHOGANY)
                                     .setTopWood(Wood.MAPLE)
                                     .makeGuitar());
  }
}
