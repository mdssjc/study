import java.util.ArrayList;

public class DotComBust {

  private GameHelper helper;
  private ArrayList<DotCom> dotComsList;
  private int numOfGuesses;

  public static void main(String[] args) {
    DotComBust game = new DotComBust();
    game.setUpGame();
    game.startPlaying();
  }

  public void setUpGame() {
    helper = new GameHelper();
    dotComsList = new ArrayList();
    dotComsList.add(new DotCom("Pets.com"));
    dotComsList.add(new DotCom("eToys.com"));
    dotComsList.add(new DotCom("Go2.com"));

    System.out.println("Your goal is to sink three dot coms.");
    System.out.println("Pets.com, eToys.com, Go2.com");
    System.out.println("Try to sink them all in the fewest number of guesses");

    for (DotCom dotComToSet : dotComsList) {
      ArrayList<String> newLocation = helper.placeDotCom(3);
      dotComToSet.setLocationCells(newLocation);
    }
  }

  public void startPlaying() {
    while (!dotComsList.isEmpty()) {
      String userGuess = helper.getUserInput("Enter a guess");
      checkUserGuess(userGuess);
    }
    finishGame();
  }

  public void checkUserGuess(String userGuess) {
    numOfGuesses++;
    String result = "miss";

    for (DotCom dotComToTest : dotComsList) {
      result = dotComToTest.checkYourself(userGuess);
      if (result.equals("hit")) {
        break;
      }
      if (result.equals("kill")) {
        dotComsList.remove(dotComToTest);
        break;
      }
    }
    System.out.println(result);
  }

  public void finishGame() {
    System.out.println("All Dot Coms are dead! Your stock is now worthless.");
    if (numOfGuesses <= 18) {
      System.out.println("It only took you " + numOfGuesses + " guesses.");
      System.out.println(" You got out before your options sank.");
    } else {
      System.out.println("Took you long enough. " + numOfGuesses + " guesses.");
      System.out.println("Fish are dancing with your options.");
    }
  }
}
