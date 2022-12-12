package com.example.opUsingPreparedStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateRecord {
    public UpdateRecord(Connection con) throws SQLException {
        Statement st = null;
        Scanner sc = new Scanner(System.in);
        try {


            if (con != null) {

                
              
                    String add_new;
                    int  user_reg_num, attribute ;
                    String updateQuery = null ;
                    System.out.println("Enter Registration Number to update Record - ");
                    user_reg_num = sc.nextInt();
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
                            System.out.println("Student's name : ");
                            add_new = sc.next();
                            UpdateQueries up = new UpdateQueries();
                            updateQuery = up.updateName();
                            prepStatement = con.prepareStatement(updateQuery);

                            prepStatement.setString(1, add_new);

                        }
                        case 2 -> {
                            System.out.println("Enter the required Information");
                            System.out.println("Student's Registration Number : ");
                            add_new = sc.next();
                            UpdateQueries up = new UpdateQueries();
                            updateQuery = up.updateRegNum();
                            prepStatement = con.prepareStatement(updateQuery);

                            prepStatement.setInt(1, Integer.parseInt(add_new));
							
                        }
                        case 3 -> {
                            System.out.println("Enter the required Information");
                            System.out.println("Student's Roll Number : ");
                            add_new = sc.next();
                            UpdateQueries up = new UpdateQueries();
                            updateQuery = up.updateRollNum();
                            prepStatement = con.prepareStatement(updateQuery);

                            prepStatement.setInt(1, Integer.parseInt(add_new));
                        }
                        case 4 -> {
                            System.out.println("Enter the required Information");
                            System.out.println("Student's Course Name : ");
                            add_new = sc.next();
                            UpdateQueries up = new UpdateQueries();
                            updateQuery = up.updateCourse();
                            prepStatement = con.prepareStatement(updateQuery);

                            prepStatement.setString(1, add_new);
                        }
                        case 5 -> {
                            System.out.println("Enter the required Information");
                            System.out.println("Student's Semester : ");
                            add_new = sc.next();
                            UpdateQueries up = new UpdateQueries();
                            updateQuery = up.updateSemester();
                            prepStatement = con.prepareStatement(updateQuery);

                            prepStatement.setInt(1, Integer.parseInt(add_new));
                        }
                        default -> throw new IllegalStateException("Unexpected value: " + attribute);
                    }

                   System.out.println(updateQuery);
                   
                   
                   prepStatement.setInt(2, user_reg_num);

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

