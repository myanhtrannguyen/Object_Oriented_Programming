import java.util.Scanner;

public class Calender {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String month = sc.nextLine();
        int year = sc.nextInt();
        
        String arr[] = {"January", "Jan.", "Jan", "1", "February", "Feb.", "Feb", "2", "March", "Mar.", "Mar", "3", "April", "Apr.", "Apr", "4", "May", "5", "June", "Jun", "6", "July", "Jul", "7", "August", "Aug.", "Aug", "8", "September", "Sept.", "Sep", "9", "October", "Oct.", "Oct", "10", "November", "Nov.", "Nov", "11", "December", "Dec.", "Dec", "12"};
        
        boolean found = false; 
        for (int i = 0; i < arr.length; i++) {
            if (month.equals(arr[i])) {
                found = true; 
                if (year >= 0) {
                    if (month.equals("February") || month.equals("Feb.") || month.equals("Feb") || month.equals("2")) {
                        if (year % 4 != 0) {
                            System.out.println("28 days");
                        } else {
                            if (year % 100 == 0 && year % 4 == 0) {
                                System.out.println("28 days");
                            } else {
                                System.out.println("29 days");
                            }
                        }
                    } else if (month.equals("April") || month.equals("Apr.") || month.equals("Apr") || month.equals("4") || month.equals("June") || month.equals("Jun") || month.equals("6") || month.equals("September") || month.equals("Sept.") || month.equals("Sep") || month.equals("9") || month.equals("November") || month.equals("Nov.") || month.equals("Nov") || month.equals("11")) {
                        System.out.println("30 days");
                    } else {
                        System.out.println("31 days");
                    }
                } else {
                    System.out.println("Invalid year");
                }
                break; 
            }
        }
        if (!found) {
            System.out.println("Invalid month");
        }
    }
}
