package com.example.dates;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class CreateNewRecord {

	public CreateNewRecord(Connection con) throws SQLException {

		Scanner sc = new Scanner(System.in);
		try {

			if (con != null) {

				String emp_name;
				int emp_id;
				String dob, doj, dom;

				System.out.println("Enter the required Information");

				System.out.println("Employee's  Id Number -");
				emp_id = sc.nextInt();
				System.out.println("Employee's name : ");
				emp_name = sc.next();
				
				System.out.println("Employee's Date of Birth in - dd-MM-yyyy format");
				dob = sc.next();
				System.out.println("Employee's Date of Joining in - Date of Birth in - MM-dd-yyyy format -");
				doj = sc.next();
				System.out.println("Employee's Date of Marriage in - Date of Birth in - yyyy-MM-dd format -");
				dom = sc.next();
				
				

				String insertQuery = "insert into employee (`emp_id`,`emp_name`,`dob`,`doj`,`dom`)"
						+ "values(?,?,?,?,?)";

				PreparedStatement preStatement = con.prepareStatement(insertQuery);
				try {
				SimpleDateFormat dmy = new SimpleDateFormat("dd-MM-yyyy");
				SimpleDateFormat mdy = new SimpleDateFormat("MM-dd-yyyy");
				java.util.Date udob = dmy.parse(dob);
				long time = udob.getTime();
				java.sql.Date sqldob = new java.sql.Date(time);
				
				java.util.Date udoj = mdy.parse(doj);
				time = udoj.getTime();
				java.sql.Date sqldoj = new java.sql.Date(time);
				
				java.sql.Date sqldom = java.sql.Date.valueOf(dom);
				
										
				 preStatement.setInt(1, emp_id);
				 preStatement.setString(2, emp_name);
				 preStatement.setDate(3, sqldob);
				 preStatement.setDate(4, sqldoj);
				 preStatement.setDate(5, sqldom);
				
				}
				
				 catch ( java.text.ParseException e  )
	                {
	                	System.out.println("Entered Wrong Date Format ");
	                }
				catch (Exception e)
				{
					e.printStackTrace();
				}

				System.out.println(insertQuery);

				int affectedRows = preStatement.executeUpdate();

				System.out.println(affectedRows + " Updated");

			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
