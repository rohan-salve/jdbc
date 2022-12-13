package com.example.questions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.example.dates.*;
public class question2 {

	public static void main(String[] args) throws SQLException {
		 Connection con = null;
		    String url = "jdbc:mysql://localhost:3306/company";
		    String user = "root";
		    String password = "Folio@9480m"; // Give password Here
		    con = DriverManager.getConnection(url, user, password);
		    Scanner sc = new Scanner(System.in);
		    String choice = null;
		    int c =0;
		    do {
		    	System.out.println(":::::::::::Welcome to School Database::::::::");
		        System.out.println("Here is the list of Operations");
		        System.out.println("1. Insert New Record");
		        System.out.println("2. Update Existing Record");
		        System.out.println("3. Delete Existing Record");
		        System.out.println("4. View Employee Details");
		        System.out.println("What would you like to do here?");
				  
				    try{c= sc.nextInt();}
				    catch (InputMismatchException e) {
						System.out.println("Use Numbers!"); break;
					}
				    
				    	
				        
				    switch (c)
				    {
				        case 1 -> new CreateNewRecord(con);
				        case 2 -> new UpdateRecord(con);
				        case 3 -> new DeleteRecord(con);
				        case 4 -> new ViewRecord(con); 
				        default -> System.out.println("Invalid Option");
				    }
				     
				    System.out.println("Enter yes to Continue");
				    choice = sc.next();
				    }
				    while (choice.equalsIgnoreCase("yes"));
				    
				    System.out.println("Thank you for using Application ");
				    if (con != null)
				    {
				    	con.close();
				    }
				    
				    if (sc !=null)
				    {
				    	sc.close();
				    }// TODO Auto-generated method stub

	}

}
