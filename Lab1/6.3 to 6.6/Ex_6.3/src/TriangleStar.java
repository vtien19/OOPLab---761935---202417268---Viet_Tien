import java.util.Scanner;

public class TriangleStar {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Nhap so dong: ");
        int n = input.nextInt();

        for (int i = 1; i <= n; i++) {

            // in khoảng trắng
            for (int j = i; j < n; j++) {
                System.out.print(" ");
            }

            // in dấu *
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}