package com.example.opUsingPreparedStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class ViewRecord {
    public ViewRecord(Connection con) throws SQLException
    {
        try{
            if (con != null)
            {
                
                ResultSet resultSet ;

               
                    System.out.println("Enter Reg Number whose Details you want to See -");
                    Scanner sc = new Scanner(System.in);
                    int reg_num = sc.nextInt();
                    String selectQuery = "select * from students where s_reg_number = ?";
                    System.out.println(selectQuery);
                    
                    PreparedStatement prepStatement = con.prepareStatement(selectQuery);
                    prepStatement.setInt(1, reg_num);
                    resultSet = prepStatement.executeQuery();
                    if ( resultSet != null)
                    {System.out.println("Name\tRoll Num\tReg Num\tCourse\tSemester");
                        if(resultSet.next())
                        {
                        	
                            System.out.println(resultSet.getString(1)+"\t"+
                                    resultSet.getInt(2)+"\t\t"+
                                    resultSet.getInt(3)+"\t"+
                                    resultSet.getString(4)+"\t"+
                                    resultSet.getInt(5));
                        }

                        else System.out.println("Record not Available");
                        sc.close();
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
        finally {
            if (con != null)
            {
                con.close();
            }
        }
    }
}
