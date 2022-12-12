package com.example.opUsingPreparedStatement;

public class UpdateQueries {
    public String updateName()
    {
        return("UPDATE students SET s_name = ? WHERE s_reg_number = ?");

    }
    public String updateRegNum()
    {
        return("UPDATE students SET s_reg_number = ? WHERE s_reg_number = ?");

    }
    public String updateRollNum()
    {
        return("UPDATE students SET s_roll_number = ? WHERE s_reg_number = ?");

    }
    public String updateCourse()
    {
        return("UPDATE students SET s_course = ? WHERE s_reg_number = ?");

    }
    public String updateSemester()
    {
        return("UPDATE students SET s_standard = ? WHERE s_reg_number = ?");

    }
}
