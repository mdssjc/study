import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int h = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int diff = h - b;
        int step = a - b;

        System.out.println(diff / step + (step - 1 + diff % step) / step);
    }
}