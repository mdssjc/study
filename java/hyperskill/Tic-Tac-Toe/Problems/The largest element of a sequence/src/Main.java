import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int largest = 0;
        int n;
        do {
            n = scanner.nextInt();
            if (n > largest) {
                largest = n;
            }
        } while (n != 0);

        System.out.println(largest);
    }
}