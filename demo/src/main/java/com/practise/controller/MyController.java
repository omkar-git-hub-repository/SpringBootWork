package com.practise.controller;

import com.practise.entity.Students;
import com.practise.repo.StudentRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MyController {

    @GetMapping("/getAllStudents")
    public ResponseEntity<List<Students>> getName() {

        List<Students> studList1 = StudentRepo.SetAllStudents();
        return new ResponseEntity<>(studList1, HttpStatus.OK);
    }

    @GetMapping("/getById/{studId}")
    public ResponseEntity<Students> getById(@PathVariable("studId") int studId) {

        List<Students> studList = StudentRepo.SetAllStudents();
        for (Students s : studList) {
            if (studId == s.getId()) {
                return new ResponseEntity<>(s, HttpStatus.OK);
            }
        }
        Students s1 = new Students();
        return new ResponseEntity<>(s1, HttpStatus.NOT_FOUND);
    }

    // StudentsWith > 75 mark  using Stream Operation
    @GetMapping("/DistinctStudent")
    public ResponseEntity<List<Students>> getDistinctStudents() {

        List<Students> studentsList = StudentRepo.SetAllStudents();
        List<Students> DistinctStudent = studentsList.stream().filter(k -> k.getMarks() > 85).toList();

        return new ResponseEntity<>(DistinctStudent, HttpStatus.OK);
    }

    // Get Student By First name
    @GetMapping("/getByName/{fName}")
    public ResponseEntity<List<Students>> getByName(@PathVariable("fName") String fName) {

        List<Students> studentsList = StudentRepo.SetAllStudents();
        List<Students> matchedStudent = new ArrayList<>();
        for (Students s : studentsList) {
            if (fName.equalsIgnoreCase(s.getfName())) {
                matchedStudent.add(s);
            }
        }
        if (!matchedStudent.isEmpty()) {
            return new ResponseEntity<>(matchedStudent, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // get List Of Students by their course
    @GetMapping("/getByCourse/{Course}")
    public ResponseEntity<List<Students>> getbyCourse(@PathVariable("Course") String Course) {

        List<Students> studentsList = StudentRepo.SetAllStudents();
        List<Students> matchedStudent = new ArrayList<>();

        for (Students s : studentsList) {
            if (Course.equalsIgnoreCase(s.getCourse())) {
                matchedStudent.add(s);
            }
        }
        if (!matchedStudent.isEmpty()) {
            return new ResponseEntity<>(matchedStudent, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Add get response method
    @GetMapping("/getAlldata")
    public ResponseEntity<List<Students>> getAllStudentsData(@RequestParam(required = false) List<String> fName){
        List<Students> studentsList = StudentRepo.SetAllStudents();
        List<Students> matchedStudent = new ArrayList<>();

        if (fName == null || fName.isEmpty())
        {
            return new ResponseEntity<>(studentsList, HttpStatus.OK);
        }

        for (Students s : studentsList) {
            for (String name : fName) {
                if (name.equalsIgnoreCase(s.getfName())) {
                    matchedStudent.add(s);
                    break;
                }
            }
        }
        return new ResponseEntity<>(matchedStudent, HttpStatus.OK);
    }
}
