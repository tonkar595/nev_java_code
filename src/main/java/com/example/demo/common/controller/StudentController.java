package com.example.demo.common.controller;


import com.example.demo.common.dto.UserReq;
import com.example.demo.common.dto.UserRes;
import com.example.demo.common.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public ResponseEntity<Void> create(@RequestBody UserReq userReq){
        studentService.saveStudent(userReq);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/show-all")
    public ResponseEntity<List<UserRes>> showAll(){
        List<UserRes> studentResList = studentService.findAll();
        return ResponseEntity.ok(studentResList);

    }

    @GetMapping("/show-by-id/{id}")
    public ResponseEntity<UserRes> showById(@PathVariable long id){
        UserRes userRes = studentService.findById(id);
        return ResponseEntity.ok(userRes);

    }

}
