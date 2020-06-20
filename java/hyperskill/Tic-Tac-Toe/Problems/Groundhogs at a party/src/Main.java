import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cups = scanner.nextInt();
        boolean weekend = scanner.nextBoolean();

        System.out.println(!weekend && cups >= 10 && cups <= 20
                || weekend && cups >= 15 && cups <= 25);
    }
}