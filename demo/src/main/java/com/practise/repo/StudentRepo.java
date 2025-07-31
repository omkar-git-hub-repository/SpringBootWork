package com.practise.repo;

import com.practise.entity.Students;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

public class StudentRepo {

    public static List<Students> SetAllStudents() {

        Students s1 = new Students(1, "Amit", "Sharma", "Java", 85.6f);
        Students s2 = new Students(2, "Sneha", "Patil", "Python", 91.2f);
        Students s3 = new Students(3, "Rahul", "Verma", "C++", 78.5f);
        Students s4 = new Students(4, "Pooja", "Desai", "JavaScript", 88.4f);
        Students s5 = new Students(5, "Ravi", "Kumar", "Data Science", 92.0f);
        Students s6 = new Students(6, "Neha", "Joshi", "HTML", 81.3f);
        Students s7 = new Students(7, "Vikram", "Singh", "Java", 75.9f);
        Students s8 = new Students(8, "Divya", "Mehta", "SQL", 89.6f);
        Students s9 = new Students(9, "Karan", "Gupta", "C#", 83.1f);
        Students s10 = new Students(10, "Anjali", "Nair", "Machine Learning", 94.5f);

        Students s11 = new Students(11, "Mehul", "Tiwari", "Java", 68.4f);
        Students s12 = new Students(12, "Priya", "Jadhav", "Python", 70.0f);
        Students s13 = new Students(13, "Suresh", "Yadav", "C++", 65.9f);
        Students s14 = new Students(14, "Ritika", "Kapoor", "JavaScript", 73.2f);
        Students s15 = new Students(15, "Deepak", "Mali", "Data Science", 69.7f);
        Students s16 = new Students(16, "Tina", "More", "Java", 64.5f);
        Students s17 = new Students(17, "Aarav", "Shetty", "SQL", 71.3f);
        Students s18 = new Students(18, "Nikita", "Kulkarni", "C#", 62.8f);
        Students s19 = new Students(19, "Rohan", "Patel", "Machine Learning", 74.2f);
        Students s20 = new Students(20, "Gaurav", "Bhatt", "HTML", 66.6f);


        List<Students> studList = Arrays.asList(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15, s15, s16, s17, s18, s19, s20);
        return studList;

    }
}
