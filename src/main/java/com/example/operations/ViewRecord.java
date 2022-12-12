package com.example.operations;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ViewRecord {
    public ViewRecord(Connection con) throws SQLException
    {
        try{
            if (con != null)
            {
                Statement st = con.createStatement();
                ResultSet resultSet ;

                if (st != null)
                {
                    System.out.println("Enter Reg Number whose Details you want to See -");
                    Scanner sc = new Scanner(System.in);
                    int reg_num = sc.nextInt();
                    String selectQuery = String.format("select * from students where s_reg_number = %d",reg_num);
                    System.out.println(selectQuery);
                    System.out.println("Name\tRoll Num\tReg Num\tCourse\tSemester");
                    resultSet = st.executeQuery(selectQuery);
                    if ( resultSet != null)
                    {
                        if(resultSet.next())
                        {
                            System.out.println(resultSet.getString(1)+"\t\t"+
                                    resultSet.getInt(2)+"\t\t"+
                                    resultSet.getInt(3)+"\t\t"+
                                    resultSet.getString(4)+"\t\t"+
                                    resultSet.getInt(5));
                        }

                        else System.out.println("Record not Available");
                        sc.close();
                    }
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
