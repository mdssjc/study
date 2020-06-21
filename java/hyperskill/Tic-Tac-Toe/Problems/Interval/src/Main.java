import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        boolean interval1 = n > -15 && n <= 12;
        boolean interval2 = n > 14 && n < 17;
        boolean interval3 = n >= 19;

        if (interval1 || interval2 || interval3) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}