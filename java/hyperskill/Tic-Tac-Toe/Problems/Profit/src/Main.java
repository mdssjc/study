import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();
        int p = scanner.nextInt();
        int k = scanner.nextInt();

        int years = 0;
        double acc = m;
        while (acc < k) {
            acc += p / 100.0 * acc;
            years++;
        }

        System.out.println(years);
    }
}