import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int value = scanner.nextInt();
            if (value == 0) {
                break;
            }

            System.out.println(value % 2 == 0 ? "even" : "odd");
        }
    }
}