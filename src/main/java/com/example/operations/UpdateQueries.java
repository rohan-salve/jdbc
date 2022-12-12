package com.example.operations;

public class UpdateQueries {
    public String updateName(int reg_num, String name)
    {
        return(String.format("UPDATE students SET s_name = '%s' WHERE s_reg_number = %d",name,reg_num));

    }
    public String updateRegNum(int reg_num, int reg_new)
    {
        return(String.format("UPDATE students SET s_reg_number = '%d' WHERE s_reg_number = %d",reg_new,reg_num));

    }
    public String updateRollNum(int reg_num, int roll_num)
    {
        return(String.format("UPDATE students SET s_roll_number = '%d' WHERE s_reg_number = %d",roll_num,reg_num));

    }
    public String updateCourse(int reg_num, String course)
    {
        return(String.format("UPDATE students SET s_course = '%s' WHERE s_reg_number = %d",course,reg_num));

    }
    public String updateSemester(int reg_num, int sem)
    {
        return(String.format("UPDATE students SET s_standard = '%d' WHERE s_reg_number = %d",sem,reg_num));

    }
}
