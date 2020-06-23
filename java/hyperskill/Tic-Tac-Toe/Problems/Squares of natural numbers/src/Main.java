import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int count = 1;
        int square = count * count;

        while (square <= n) {
            System.out.println(square);
            count++;
            square = count * count;
        }
    }
}