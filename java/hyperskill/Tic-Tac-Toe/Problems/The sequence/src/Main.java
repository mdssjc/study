import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int largest = 0;
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            if (n % 4 == 0 && n > largest) {
                largest = n;
            }
        }

        System.out.println(largest);
    }
}