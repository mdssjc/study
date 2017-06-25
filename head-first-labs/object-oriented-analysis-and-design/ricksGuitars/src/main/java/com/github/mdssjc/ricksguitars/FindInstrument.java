package com.github.mdssjc.ricksguitars;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FindInstrument {

  public static void main(final String[] args) {
    // Set up Rick’s inventory
    final Inventory inventory = new Inventory();
    initializeInventory(inventory);

    final HashMap<String, Object> properties = new HashMap<>();
    properties.put("builder", Builder.GIBSON);
    properties.put("backWood", Wood.MAPLE);
    final InstrumentSpec clientSpec = new InstrumentSpec(properties);

    final Iterator<Instrument> matchingGuitars = inventory.search(clientSpec);
    if (matchingGuitars.hasNext()) {
      System.out.println("You might like these instruments:");
      while (matchingGuitars.hasNext()) {
        final Instrument instrument = matchingGuitars.next();
        final InstrumentSpec spec = instrument.getSpec();
        System.out.printf("We have a %s with the following properties:%n",
                          spec.getProperty("instrumentType"));
        spec.getProperties()
            .keySet()
            .forEach(k -> {
              if (!k.equals("instrumentType")) {
                System.out.printf("    %s: %s%n", k, spec.getProperty(k));
              }
            });
        System.out.printf("  You can have this %s for $ %.2f%n---%n",
                          spec.getProperty("instrumentType"),
                          instrument.getPrice());
      }
    } else {
      System.out.println("Sorry, we have nothing for you.");
    }
  }

  private static void initializeInventory(final Inventory inventory) {
    final Map properties = new HashMap();
    properties.put("instrumentType", InstrumentType.GUITAR);
    properties.put("builder", Builder.COLLINGS);
    properties.put("model", "CJ");
    properties.put("type", Type.ACOUSTIC);
    properties.put("numStrings", 6);
    properties.put("topWood", Wood.INDIAN_ROSEWOOD);
    properties.put("backWood", Wood.SITKA);
    inventory.addInstrument("11277", 3999.95, new InstrumentSpec(properties));

    properties.put("builder", Builder.MARTIN);
    properties.put("model", "D-18");
    properties.put("topWood", Wood.MAHOGANY);
    properties.put("backWood", Wood.ADIRONDACK);
    inventory.addInstrument("122784", 5495.95, new InstrumentSpec(properties));

    properties.put("builder", Builder.FENDER);
    properties.put("model", "Stratocastor");
    properties.put("type", Type.ELECTRIC);
    properties.put("topWood", Wood.ALDER);
    properties.put("backWood", Wood.ALDER);
    inventory.addInstrument("V95693", 1499.95, new InstrumentSpec(properties));
    inventory.addInstrument("V9512", 1549.95, new InstrumentSpec(properties));

    properties.put("builder", Builder.GIBSON);
    properties.put("model", "Les Paul");
    properties.put("topWood", Wood.MAPLE);
    properties.put("backWood", Wood.MAPLE);
    inventory.addInstrument("70108276", 2295.95,
                            new InstrumentSpec(properties));

    properties.put("model", "SG '61 Reissue");
    properties.put("topWood", Wood.MAHOGANY);
    properties.put("backWood", Wood.MAHOGANY);
    inventory.addInstrument("82765501", 1890.95,
                            new InstrumentSpec(properties));

    properties.put("instrumentType", InstrumentType.MANDOLIN);
    properties.put("type", Type.ACOUSTIC);
    properties.put("model", "F-5G");
    properties.put("backWood", Wood.MAPLE);
    properties.put("topWood", Wood.MAPLE);
    properties.remove("numStrings");
    inventory.addInstrument("9019920", 5495.99, new InstrumentSpec(properties));

    properties.put("instrumentType", InstrumentType.BANJO);
    properties.put("model", "RB-3 Wreath");
    properties.remove("topWood");
    properties.put("numStrings", 5);
    inventory.addInstrument("8900231", 2945.95, new InstrumentSpec(properties));
  }
}
