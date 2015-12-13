import java.util.List;

import base.Guitar;
import base.GuitarSpec;
import base.Inventory;
import base.builder.GuitarBuilder;
import types.Builder;
import types.Type;
import types.Wood;

public class FindGuitarTester {

    public static void main(String[] args) {
        // Set up Rick's guitar inventory
        Inventory<Guitar> inventory = new Inventory<>();
        initializeInventory(inventory);

        GuitarSpec whatErinLikes = new GuitarSpec(Builder.FENDER,
                "Stratocastor", Type.ELECTRIC, 6, Wood.ALDER, Wood.ALDER);
        List<Guitar> matchingGuitars = inventory.search(whatErinLikes);
        
        if (!matchingGuitars.isEmpty()) {
            System.out.println("Erin, you might like these guitars:");
            for (Guitar guitar : matchingGuitars) {
                GuitarSpec spec = guitar.getSpec();
                System.out.println("  We have a " + spec.getBuilder() + " "
                        + spec.getModel() + " " + spec.getType()
                        + " guitar:\n     " + spec.getBackWood()
                        + " back and sides,\n     " + spec.getTopWood()
                        + " top.\n  You can have it for only $"
                        + guitar.getPrice() + "!\n  ----");
            }
        } else {
            System.out.println("Sorry, Erin, we have nothing for you.");
        }
    }

    private static void initializeInventory(Inventory<Guitar> inventory) {
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
