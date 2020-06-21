import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        boolean p1 = n / 1000 == n % 10;
        boolean p2 = n / 100 % 10 == n % 100 / 10;

        if (p1 && p2) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}