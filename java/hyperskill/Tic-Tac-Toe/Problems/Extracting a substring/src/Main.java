import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        int begin = scanner.nextInt();
        int end = scanner.nextInt();

        System.out.println(text.substring(begin, ++end));
    }
}