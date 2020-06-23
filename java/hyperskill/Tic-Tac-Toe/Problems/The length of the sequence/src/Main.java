import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = 0;
        int n = scanner.nextInt();
        while (n != 0) {
            count++;
            n = scanner.nextInt();
        }

        System.out.println(count);
    }
}