package anu;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Statement st = null;
		ResultSet rs = null;
		Connection con = null;
		Employee clerk = new Clerk();
		Employee programmer = new Programmer();
		Employee manager = new Manager();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Navya@123");
			st = con.createStatement();
			Scanner sc = new Scanner(System.in);
			Employee[] e = new Employee[5];
			int ch = 0, choice = 0, i = 0;
			do {
				System.out.println("1.CREATE \n2.DISPLAY \n3.SALARYS RISE \n4.EXIT");
				choice = sc.nextInt();
				if (ch == 4)
					break;
				switch (choice) {
				case 1:
					do {
						System.out.println("1.CLERK \n2.PROGRAMMER \n3.MANAGE \n4.EXIT");
						choice = sc.nextInt();
						if (ch == 4)
							break;
						switch (choice) {
						case 1:
							clerk.Create();
							break;
						case 2:
							programmer.Create();
							break;
						case 3:
							manager.Create();
							break;
						}
					} while (choice != 4);
				case 2:
					clerk.Display();
					break;
				case 3:
					clerk.SalaryRise();
					programmer.SalaryRise();
					manager.SalaryRise();
					System.out.println("Salary Rised!!");
					break;
				case 4:
					break;
				default:
					System.out.println("Invalid Choice.");
					break;
				}
			} while (ch != 4);

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}