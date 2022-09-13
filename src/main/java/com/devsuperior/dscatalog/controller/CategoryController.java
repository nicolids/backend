package com.devsuperior.dscatalog.controller;

import com.devsuperior.dscatalog.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        List<Category> list= new ArrayList<>();
        list.add(new Category(1L,"Books"));
        list.add(new Category(2L,"Eletronics"));
        return ResponseEntity.ok().body(list);
    }
}
