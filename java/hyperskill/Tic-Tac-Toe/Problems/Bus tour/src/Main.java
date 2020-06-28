import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int height = scanner.nextInt();
        int bridges = scanner.nextInt();

        for (int i = 1; i <= bridges; i++) {
            int heightBridge = scanner.nextInt();

            if (height >= heightBridge) {
                System.out.println("Will crash on bridge " + i);
                break;
            }

            if (i == bridges) {
                System.out.println("Will not crash");
            }
        }
    }
}