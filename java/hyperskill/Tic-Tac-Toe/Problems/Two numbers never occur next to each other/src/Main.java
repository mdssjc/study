import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();

        int[] values = new int[len];
        for (int i = 0; i < len; i++) {
            values[i] = scanner.nextInt();
        }

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int posN = -10;
        int posM = -10;
        boolean result = true;
        for (int i = 0; i < values.length; i++) {
            int value = values[i];

            if (value == n) {
                posN = i;
                result = result && Math.abs(posN - posM) > 1;
            }

            if (value == m) {
                posM = i;
                result = result && Math.abs(posN - posM) > 1;
            }
        }

        System.out.println(result);
    }
}