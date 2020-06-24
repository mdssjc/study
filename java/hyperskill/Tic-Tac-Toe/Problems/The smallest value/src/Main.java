import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long m = scanner.nextLong();

        int smallest = 1;
        long value = 1;
        while (value <= m) {
            value *= smallest;
            smallest++;
        }

        System.out.println(smallest - 1);
    }
}