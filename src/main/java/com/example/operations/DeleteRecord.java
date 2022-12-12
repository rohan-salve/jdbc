package com.example.operations;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteRecord {
    public DeleteRecord(Connection con) throws SQLException
    {
        try{
            if(con != null)
            {
                Statement st = con.createStatement();
                if (st != null)
                {
                    System.out.println("Enter Reg Number to be Deleted - ");
                    Scanner sc = new Scanner(System.in);
                    int del_reg = sc.nextInt();
                    String deleteQuery =String.format("delete from students where s_reg_number = %d",del_reg);
                    System.out.println(deleteQuery);
                    int affectedRows = st.executeUpdate(deleteQuery);
                    System.out.println(affectedRows+" Rows Deleted");
                    sc.close();
                }
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
        finally {
            if(con != null)
            {
                con.close();
            }
        }
    }
}
