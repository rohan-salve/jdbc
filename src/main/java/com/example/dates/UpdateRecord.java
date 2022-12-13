package com.example.dates;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class UpdateRecord {
    public UpdateRecord(Connection con) throws SQLException {
        
        try (Scanner sc = new Scanner(System.in)) {
			try {


			    if (con != null) {

			        
			      
			            String add_new;
			            int  user_emp_id, attribute ;
			            String updateQuery = null ;
			            System.out.println("Enter Registration Number to update Record - ");
			            user_emp_id = sc.nextInt();
			            System.out.println("Which Attribute you want to Update?");
			            System.out.println("1. Name");
			            System.out.println("2. Registration Number");
			            System.out.println("3. Roll Number");
			            System.out.println("4. Course");
			            System.out.println("5. Semester");
			            attribute = sc.nextInt();
			            PreparedStatement prepStatement = null;
			           
			            switch (attribute) {
			                case 1 -> {
			                    System.out.println("Enter the required Information");
			                    System.out.println("Employee's name : ");
			                    add_new = sc.next();
			                    UpdateQueries up = new UpdateQueries();
			                    updateQuery = up.updateName();
			                    prepStatement = con.prepareStatement(updateQuery);

			                    prepStatement.setString(1, add_new);

			                }
			                case 2 -> {
			                    System.out.println("Enter the required Information");
			                    System.out.println("Employee's ID : ");
			                    add_new = sc.next();
			                    
			                    
			                    UpdateQueries up = new UpdateQueries();
			                    updateQuery = up.updateID();
			                    prepStatement = con.prepareStatement(updateQuery);

			                    prepStatement.setInt(1, Integer.parseInt(add_new));
								
			                }
			                case 3 -> {
			                    System.out.println("Enter the required Information");
			                    System.out.println("Employee's DOB in - Date of Birth in - dd-MM-yyyy format -: ");
			                    add_new = sc.next();
			                    try {
			                    UpdateQueries up = new UpdateQueries();
			                    updateQuery = up.updateDOB();
			                    prepStatement = con.prepareStatement(updateQuery);
			                    
			                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			                    java.util.Date add_new_date = sdf.parse(add_new);
			                    long time = add_new_date.getTime();
			                    java.sql.Date sqlDate = new  java.sql.Date(time);

			                    prepStatement.setDate(1, sqlDate);
			                    }
			                    catch ( Exception e  )
			                    {
			                    	System.out.println("Entred Wrong Date Format ");
			                    }
			                    
			                }
			                case 4 -> {
			                    System.out.println("Enter the required Information");
			                    System.out.println("Employee's DOJ in - MM-dd-yyyy format: ");
			                    add_new = sc.next();
			                    try {
			                    UpdateQueries up = new UpdateQueries();
			                    updateQuery = up.updateDOJ();
			                    prepStatement = con.prepareStatement(updateQuery);
			                    
			                    SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
			                    java.util.Date add_new_date = sdf.parse(add_new);
			                    long time = add_new_date.getTime();
			                    java.sql.Date sqlDate = new  java.sql.Date(time);

			                    prepStatement.setDate(1, sqlDate);
			                    }
			                    catch ( Exception e  )
			                    {
			                    	System.out.println("Entred Wrong Date Format ");
			                    }
			                    
			                    
			                }
			                case 5 -> {
			                    System.out.println("Enter the required Information");
			                    System.out.println("Employee's DOM in - Date of Birth in - yyyy-MM-dd format - ");
			                    add_new = sc.next();
			                    try {
			                    UpdateQueries up = new UpdateQueries();
			                    updateQuery = up.updateDOM();
			                    prepStatement = con.prepareStatement(updateQuery);

			                    prepStatement.setDate(1, java.sql.Date.valueOf(add_new));
			                    }
			                    catch ( Exception e  )
			                    {
			                    	System.out.println("Entred Wrong Date Format ");
			                    }
			                    
			                    
			                }
			                default -> throw new IllegalStateException("Unexpected value: " + attribute);
			            }

			           System.out.println(updateQuery);
			           
			           
			           prepStatement.setInt(2, user_emp_id);

			            int affectedRows = prepStatement.executeUpdate();

			            System.out.println(affectedRows + " Updated");
			        


			    }
			} catch (SQLException se) {
			    se.printStackTrace();
			} catch (Exception e) {
			    e.printStackTrace();
			}
		}
      
    }
    }

