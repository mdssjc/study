import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        while (true) {
            int value = scanner.nextInt();

            if (value == 0) {
                break;
            }

            sum += value;

            if (sum >= 1000) {
                sum -= 1000;
                break;
            }
        }

        System.out.println(sum);
    }
}