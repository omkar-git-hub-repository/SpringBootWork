package com.practise.controller;

import com.practise.entity.Students;
import com.practise.repo.StudentRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyController {

        @GetMapping("/getAllStudents")
        public ResponseEntity <List<Students>> getName(){

            List<Students> studList1 = StudentRepo.SetAllEmployee();
            return new ResponseEntity<>(studList1, HttpStatus.OK);

        }

}
