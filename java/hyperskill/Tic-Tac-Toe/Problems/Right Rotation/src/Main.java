import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] values = scanner.nextLine().split(" ");
        String[] newValues = new String[values.length];

        int rotations = scanner.nextInt();
        if (rotations > values.length) {
            rotations %= values.length;
        }

        System.arraycopy(values, values.length - rotations, newValues, 0, rotations);
        System.arraycopy(values, 0, newValues, rotations, values.length - rotations);

        for (String value : newValues) {
            System.out.print(value + " ");
        }
    }
}