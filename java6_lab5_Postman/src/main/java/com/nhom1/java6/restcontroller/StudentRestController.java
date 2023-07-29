package com.nhom1.java6.restcontroller;

import com.nhom1.java6.Repository.StudentRepo;
import com.nhom1.java6.model.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class StudentRestController {
    @Autowired
    StudentRepo Sturepo;

    @GetMapping("/rest/students")
    public List<Students> getAll(Model model){
        return Sturepo.findAll();
    }

    @GetMapping("/rest/students/{email}")
    public Students getOne(@PathVariable("email") String email){
        return Sturepo.findById(email).get();
    }

    @PostMapping(" ")
    public Students post(@RequestBody Students student){
        Sturepo.save(student);
        return student;
    }

    @PutMapping("/rest/students/{email}")
    public Students put(@PathVariable("email") String email,@RequestBody Students student){
        Sturepo.save(student);
        return student;
    }

    @DeleteMapping("/rest/students/{email}")
    public void put(@PathVariable("email") String email){
        Sturepo.deleteById(email);
    }
}
