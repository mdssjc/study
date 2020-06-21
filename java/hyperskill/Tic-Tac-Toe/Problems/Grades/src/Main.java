import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] grades = {0, 0, 0, 0};

        for (int i = 0; i < n; i++) {
            int grade = scanner.nextInt();

            if (grade == 5) {
                grades[0]++;
            } else if (grade == 4) {
                grades[1]++;
            } else if (grade == 3) {
                grades[2]++;
            } else if (grade == 2) {
                grades[3]++;
            }
        }

        System.out.print(grades[3] + " ");
        System.out.print(grades[2] + " ");
        System.out.print(grades[1] + " ");
        System.out.print(grades[0]);
    }
}