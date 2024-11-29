import java.util.Scanner;
public class StarTriangle {
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			for (int u = 0; u < (n-i); u++) {
				System.out.print(" ");
			}
			for (int v = 0; v < ((i - 1) * 2 + 1); v++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}
}
