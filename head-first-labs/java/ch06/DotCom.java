import java.util.ArrayList;

public class DotCom {

  private ArrayList<String> locationCells;
  private String name;

  public DotCom(String n) {
    name = n;
  }

  public void setLocationCells(ArrayList<String> loc) {
    locationCells = loc;
  }

  public String checkYourself(String userGuess) {
    String result = "miss";
    int index = locationCells.indexOf(userGuess);

    if (index >= 0) {
      locationCells.remove(index);

      if (locationCells.isEmpty()) {
        result = "kill";
        System.out.println("Ouch! You sunk " + name + " : ( ");
      } else {
        result = "hit";
      }
    }

    return result;
  }
}
