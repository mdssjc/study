import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int value = 1;
        int count = 0;
        while (count < n) {
            for (int i = 0; i < value; i++) {
                count++;
                System.out.print(value + " ");

                if (count == n) {
                    break;
                }
            }
            value++;
        }
    }
}