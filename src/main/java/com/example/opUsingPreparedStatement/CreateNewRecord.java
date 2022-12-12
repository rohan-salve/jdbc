package com.example.opUsingPreparedStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CreateNewRecord
{

    public CreateNewRecord(Connection con) throws SQLException {
         
        Scanner sc = new Scanner(System.in);
        try {


            if (con != null) {

                
             
                    String s_name, s_course;
                    int s_reg_number, s_roll_number, s_standard;


                    System.out.println("Enter the required Information");
                    System.out.println("Student's name : ");
                    s_name = sc.nextLine();
                    System.out.println("Student's Registration Number -");
                    s_reg_number = sc.nextInt();
                    System.out.println("Student's Roll Number -");
                    s_roll_number = sc.nextInt();
                    System.out.println("Student's Course -");
                    s_course = sc.next();
                    System.out.println("Student's Semester -");
                    s_standard = sc.nextInt();

                    String insertQuery = "insert into students (`s_name`,`s_reg_number`,`s_roll_number`,`s_course`,`s_standard`)" +
                                    "values(?,?,?,?,?)";
                    
               
                    
                    PreparedStatement preStatement = con.prepareStatement(insertQuery);
                    
                    preStatement.setString(1, s_name);
                    preStatement.setInt(2, s_reg_number);
                    preStatement.setInt(3, s_roll_number);
                    preStatement.setString(4, s_course);
                    preStatement.setInt(5, s_standard);
                    
                    System.out.println(insertQuery);

                    int affectedRows = preStatement.executeUpdate();

                    System.out.println(affectedRows + " Updated");
                


            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
           

            
            if (con!= null){
                con.close();
            }
            if (sc != null){
                sc.close();
            }


        }
    }

}
