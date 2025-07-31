package com.practise.controller;

import com.practise.entity.Students;
import com.practise.repo.StudentRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyController {

    @GetMapping("/getAllStudents")
    public ResponseEntity<List<Students>> getName() {

        List<Students> studList1 = StudentRepo.SetAllStudents();
        return new ResponseEntity<>(studList1, HttpStatus.OK);
    }

    @GetMapping("/getById/{studId}")
    public ResponseEntity<Students> getById(@PathVariable("studId") int studId){

        List<Students> studList = StudentRepo.SetAllStudents();
        for (Students s : studList)
        {
            if (studId == s.getId())
            {
                return new ResponseEntity<>(s, HttpStatus.OK);
            }
        }
        Students s1 = new Students();
        return new ResponseEntity<>(s1, HttpStatus.NOT_FOUND);
    }


    // StudentsWith > 75 mark
    @GetMapping("/DistinctStudent")
    public ResponseEntity<List<Students>> getDistinctStudents(){

        List<Students> studentsList = StudentRepo.SetAllStudents();
        List<Students> DistinctStudent =  studentsList.stream().filter( k -> k.getMarks() > 85 ).toList();

        return new ResponseEntity<>(DistinctStudent, HttpStatus.OK);
    }


}
