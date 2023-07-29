package com.nhom1.java6.restcontroller;

import com.nhom1.java6.Repository.CategoryRepository;
import com.nhom1.java6.model.Category;
import com.nhom1.java6.model.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class CategoryRestController {
    @Autowired
    CategoryRepository categoryDao;

    @GetMapping("/rest/category")
    public ResponseEntity<List<Category>> getALL(){
        return ResponseEntity.ok(categoryDao.findAll());
    }

    @GetMapping("/rest/category/{maLoai}")
    public ResponseEntity<Category> getId(@PathVariable("maLoai") int maLoai){
        if(!categoryDao.existsById(maLoai)) {
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(categoryDao.findById(maLoai).get());
        }
    }

    @PostMapping("/rest/category")
    public ResponseEntity<Category> post(@RequestBody Category category){
        if(categoryDao.existsById(category.getMaLoai())){
            return ResponseEntity.badRequest().build();
        }
        categoryDao.save(category);
        return ResponseEntity.ok(category);
    }

    @PutMapping("/rest/category")
    public ResponseEntity<Category> put(@RequestBody Category category){
        if(categoryDao.existsById(category.getMaLoai())){
            categoryDao.save(category);
            return ResponseEntity.ok(category);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/rest/category/{maLoai}")
    public void delete(@PathVariable("maLoai") int maLoai){
        categoryDao.deleteById(maLoai);
    }
}
