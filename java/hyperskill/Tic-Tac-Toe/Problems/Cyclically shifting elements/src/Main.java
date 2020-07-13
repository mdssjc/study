import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] elements = new int[n];

        for (int i = 0; i < elements.length; i++) {
            int position = (i + 1) % elements.length;
            elements[position] = scanner.nextInt();
        }

        for (int element : elements) {
            System.out.print(element + " ");
        }
    }
}