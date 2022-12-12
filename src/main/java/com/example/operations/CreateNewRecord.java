package com.example.operations;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CreateNewRecord
{

    public CreateNewRecord(Connection con) throws SQLException {
        Statement st = null;
        Scanner sc = new Scanner(System.in);
        try {


            if (con != null) {

                st = con.createStatement();
                if (st != null) {
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

                    String insertQuery = String.format
                            ("insert into students (`s_name`,`s_reg_number`,`s_roll_number`,`s_course`,`s_standard`)" +
                                    "values('%s',%d,%d,'%s',%d);", s_name, s_reg_number, s_roll_number, s_course, s_standard);
                    System.out.println(insertQuery);

                    int affectedRows = st.executeUpdate(insertQuery);

                    System.out.println(affectedRows + " Updated");
                }


            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if(st != null){
                st.close();

            }
            if (con!= null){
                con.close();
            }
            if (sc != null){
                sc.close();
            }


        }
    }

}
