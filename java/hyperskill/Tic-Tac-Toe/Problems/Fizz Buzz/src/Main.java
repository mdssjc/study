import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextInt();
        int stop = scanner.nextInt();

        for (int i = start; i <= stop; i++) {
            boolean isDiv3 = i % 3 == 0;
            boolean isDiv5 = i % 5 == 0;

            if (isDiv3 && isDiv5) {
                System.out.println("FizzBuzz");
            } else if (isDiv3) {
                System.out.println("Fizz");
            } else if (isDiv5) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }
}