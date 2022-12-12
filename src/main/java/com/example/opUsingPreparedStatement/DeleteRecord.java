package com.example.opUsingPreparedStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteRecord {
    public DeleteRecord(Connection con) throws SQLException
    {
        try{
            if(con != null)
            {
                
              
                    System.out.println("Enter Reg Number to be Deleted - ");
                    Scanner sc = new Scanner(System.in);
                    int del_reg = sc.nextInt();
                    String deleteQuery ="delete from students where s_reg_number = ?";
                    System.out.println(deleteQuery);
                    PreparedStatement prepStatement = con.prepareStatement(deleteQuery);
                    prepStatement.setInt(1, del_reg);
                    int affectedRows = prepStatement.executeUpdate();
                    System.out.println(affectedRows+" Rows Deleted");
                    sc.close();
                
            }
        }
        catch (SQLException se)
        {
            se.printStackTrace();
        }
        catch (Exception e )
        {
            e.printStackTrace();
        }
        
    }
}
