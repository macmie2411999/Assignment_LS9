package com.example.demostudentjson.controller;

/*
 * @Controller: Tao link trả lại giao diện HTML, JSO, ThymeLeaf
 * @RestController: @Controller, @ResponseBody : Xây dựng API
 * @RequestMapping: Tạo link ứng với class (giống Servlet)
 * Post Man
 * GET: truyền tham số dùng trên tab Param
 * POST: dùng tab Body
 * - form-data*: Dùng test dữ liệu có file hoặc không có file
 * - form-urlencoded: tham số sẽ thấy dudơcj ở link (không nhận file)
 * - raw*
 * */

import com.example.demostudentjson.pojo.Student;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/student")
public class StudentController {
    List<Student> studentList = new ArrayList<Student>();

    // mm
    @RequestMapping("/create/{name}/{age}")
    public Object createStudentPV(@PathVariable("name") String name, @PathVariable("age") String age) {
        studentList.add(new Student(name, age));
        return studentList;
    }

    @RequestMapping("/create")
    public Object createStudentRP(@RequestParam("name") String name, @RequestParam("age") String age) {
        studentList.add(new Student(name, age));
        return studentList;
    }

    @PostMapping("/creat/student")
    public Object createListStudentRB(@RequestBody Student student) {
        studentList.add(student);
        return student;
    }

    // bai chua anh Binh
    @PostMapping("/ab/create")
    public ResponseEntity<List<Student>> createStudentRequestParam(@RequestParam("name") String name, @RequestParam("age") String age) {
        studentList.add(new Student(name, age));
        return new ResponseEntity<List<Student>>(studentList, HttpStatus.OK);
    }

    @PostMapping("/ab/create/{name}/{age}")
    public ResponseEntity<List<Student>> createStudentPathvariable(@PathVariable("name") String name, @PathVariable("age") String age) {
        studentList.add(new Student(name, age));
        return new ResponseEntity<List<Student>>(studentList, HttpStatus.OK);
    }

    @PostMapping(value = "/ab/create", consumes = "application/json")
    public ResponseEntity<List<Student>> createStudentRequestBody(@RequestBody Student student) {
        studentList.add(student);
        return new ResponseEntity<List<Student>>(studentList, HttpStatus.OK);
    }
}

