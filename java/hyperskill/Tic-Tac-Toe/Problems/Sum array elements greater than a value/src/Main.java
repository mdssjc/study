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

        int sum = 0;
        for (int i = 0; i < len; i++) {
            if (values[i] > n) {
                sum += values[i];
            }
        }

        System.out.println(sum);
    }
}