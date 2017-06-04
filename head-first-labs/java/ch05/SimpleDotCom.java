public class SimpleDotCom {

  private int[] locationCells;
  private int numOfHits;

  public String checkYourself(String userGuess) {
    int guess = Integer.parseInt(userGuess);
    String result = "miss";

    for (int cell : this.locationCells) {
      if (guess == cell) {
        result = "hit";
        this.numOfHits++;
        break;
      }
    }

    if (this.numOfHits == this.locationCells.length) {
      result = "kill";
    }

    System.out.println(result);
    return result;
  }

  public void setLocationCells(int[] loc) {
    this.locationCells = loc;
  }
}
