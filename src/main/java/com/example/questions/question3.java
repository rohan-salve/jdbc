package com.example.questions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import com.example.opUsingPreparedStatement.*;

public class question3 {

	public static void main(String[] args) throws SQLException{
		// TODO Auto-generated method stub
		System.out.println(":::::::::::Welcome to School Database::::::::");
        System.out.println("Here is the list of Operations");
        System.out.println("1. Insert New Record");
        System.out.println("2. Update Existing Record");
        System.out.println("3. Delete Existing Record");
        System.out.println("4. View Student Details");
        System.out.println("What would you like to do here?");

        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/school";
        String user = "root";
        String password = "Folio@9480m"; // Give password Here
        con = DriverManager.getConnection(url, user, password);
        Scanner sc = new Scanner(System.in);
        switch (sc.nextInt()) {
            case 1 -> new CreateNewRecord(con);
            case 2 -> new UpdateRecord(con);
            case 3 -> new DeleteRecord(con);
            case 4 -> new ViewRecord(con);
        }
        if (sc !=null)
        {
        	sc.close();
        }
	}

}
