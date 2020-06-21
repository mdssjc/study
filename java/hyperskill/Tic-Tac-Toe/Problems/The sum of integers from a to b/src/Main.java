import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int acc = 0;
        for (int i = a; i <= b; i++) {
            acc += i;
        }
        System.out.println(acc);
    }
}