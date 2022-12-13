package com.example.dates;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;


public class ViewRecord {
    public ViewRecord(Connection con) throws SQLException
    {
        try{
            if (con != null)
            {
                
                ResultSet resultSet ;

               
                    System.out.println("Enter Reg Number whose Details you want to See -");
                    try (Scanner sc = new Scanner(System.in)) {
						int emp_id = sc.nextInt();
						String selectQuery = "select * from employee where emp_id = ?";
						System.out.println(selectQuery);
						
						PreparedStatement prepStatement = con.prepareStatement(selectQuery);
						prepStatement.setInt(1, emp_id);
						resultSet = prepStatement.executeQuery();
					}
                    if ( resultSet != null)
                    {System.out.println("EMP ID\tEMP Name\t DOB  \t DOJ \t DOM");
                        if(resultSet.next())
                        {
                        	System.out.println("Employee ID :: "+resultSet.getInt(1));
                        	System.out.println("Employee Name :: "+resultSet.getString(2));
                        	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                        	java.sql.Date userDOB = resultSet.getDate(3);
                        	String dob = sdf.format(userDOB);
                        	System.out.println("Date Of Birth :: "+dob);
                        	System.out.println("Date of Joinig :: "+sdf.format(resultSet.getDate(4)));
                        	System.out.println("Date of Marriage :: "+sdf.format(resultSet.getDate(5)));
                        }

                        else System.out.println("Record not Available");
                        
                    }
                
            }
        }
        catch (SQLException se)
        {
            se.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
       
        
    }
}
