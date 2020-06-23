import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n;
        int sum = 0;
        do {
            n = scanner.nextInt();
            sum += n;
        } while (n != 0);

        System.out.println(sum);
    }
}