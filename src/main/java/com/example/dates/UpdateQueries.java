package com.example.dates;

public class UpdateQueries {
    public String updateName()
    {
        return("UPDATE employee SET emp_name = ? WHERE emp_id = ?");

    }
    public String updateID()
    {
        return("UPDATE employee SET emp_id = ? WHERE emp_id = ?");

    }
    public String updateDOB()
    {
        return("UPDATE employee SET dob = ? WHERE emp_id = ?");

    }
    public String updateDOJ()
    {
        return("UPDATE employee SET doj = ? WHERE emp_id = ?");

    }
    public String updateDOM()
    {
        return("UPDATE employee SET dom = ? WHERE emp_id = ?");

    }
}
