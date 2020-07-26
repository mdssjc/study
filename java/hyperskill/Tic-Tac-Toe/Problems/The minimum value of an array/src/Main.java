import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] elements = new int[size];

        for (int i = 0; i < size; i++) {
            elements[i] = scanner.nextInt();
        }

        int minimum = elements[0];
        for (int i = 1; i < size; i++) {
            if (elements[i] < minimum) {
                minimum = elements[i];
            }
        }

        System.out.println(minimum);
    }
}