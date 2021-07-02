package anu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public abstract class Employee {
	String name, desig;
	int age, sal;
	Scanner sc = new Scanner(System.in);
	Statement st = null;
	ResultSet rs = null;
	Connection con = null;

	public void Create() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Navya@123");
			st = con.createStatement();
			System.out.println("ENTER NAME:");
			name = sc.next();
			System.out.println("ENTER AGE:");
			age = sc.nextInt();
			int b = st.executeUpdate("insert into Emptable1(name,age) values(" + "'" + name + "'" + "," + age + ")");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void Display() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Navya@123");
			st = con.createStatement();
			rs = st.executeQuery("select * from Emptable1;");
			while (rs.next()) {
				System.out.print("NAME: " + rs.getString("name") + "  ");
				System.out.print("AGE: " + rs.getInt("age") + "  ");
				System.out.print("SALARY: " + rs.getInt("salary") + "  ");
				System.out.print("DESIG: " + rs.getString("desig") + "\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public abstract void SalaryRise();

}
final class Clerk extends Employee {
	Statement st = null;
	ResultSet rs = null;
	Connection con = null;

	public Clerk() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Navya@123");
			st = con.createStatement();
			st.executeUpdate("insert into Emptable1(salary,desig)values(25000,'CLERK');");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void SalaryRise() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Navya@123");
			st = con.createStatement();
			st.executeUpdate("update Emptable1 set salary=35000 where design='CLERK';");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

final class Programmer extends Employee {
	Statement st = null;
	ResultSet rs = null;
	Connection con = null;

	public Programmer() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Navya@123");
			st = con.createStatement();
			st.executeUpdate("insert into Emptable1(salary,desig)values(30000,'PROGRAMMER');");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void SalaryRise() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Navya@123");
			st = con.createStatement();
			st.executeUpdate("update Emptable1 set salary=35000 where desig='PROGRAMMER';");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

final class Manager extends Employee {
	Statement st = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	Connection con = null;

	public Manager() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Navya@123");
			st = con.createStatement();
			st.executeUpdate("insert into Emptable1(salary,desig)values(30000,'MANAGER');");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void SalaryRise() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Navya@123");
			st = con.createStatement();
			st.executeUpdate("update Emptable1 set salary=36000 where desig='MANAGER';");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

	


