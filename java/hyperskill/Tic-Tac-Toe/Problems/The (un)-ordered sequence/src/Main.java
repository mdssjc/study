import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean isOrderAsc = true;
        boolean isOrderDesc = true;

        int last = -1;
        while (true) {
            int value = scanner.nextInt();

            if (value == 0) {
                break;
            }

            if (last != -1) {
                isOrderAsc &= last <= value;
                isOrderDesc &= last >= value;
            }

            last = value;
        }

        System.out.println(isOrderAsc || isOrderDesc);
    }
}