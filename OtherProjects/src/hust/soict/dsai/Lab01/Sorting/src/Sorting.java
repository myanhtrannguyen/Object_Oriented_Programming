import java.util.Scanner;
public class Sorting {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the length of array: ");
		int n = sc.nextInt();
		int arr[] = new int[n];
		int u = 0;
		int res = 0;
		System.out.println("Enter the data: ");
		for (int i = 0; i < n; i ++) {
			arr[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j ++) {
				if (arr[j] <= arr[i]) {
					u = arr[i];
					arr[i] = arr[j];
					arr[j] = u;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			res += arr[i];
			System.out.print(arr[i] + " ");
		}
		System.out.println("");
		System.out.println((res/n));
	}
}
