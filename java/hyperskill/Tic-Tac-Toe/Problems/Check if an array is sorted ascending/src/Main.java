import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int len = scanner.nextInt();
        int[] values = new int[len];
        for (int i = 0; i < values.length; i++) {
            values[i] = scanner.nextInt();
        }

        boolean sorted = true;
        for (int i = 1; i < values.length; i++) {
            if (values[i] < values[i - 1]) {
                sorted = false;
                break;
            }
        }

        System.out.println(sorted);
    }
}