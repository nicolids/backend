package com.devsuperior.dscatalog.services;

import com.devsuperior.dscatalog.dto.CategoryDto;
import com.devsuperior.dscatalog.entities.Category;
import com.devsuperior.dscatalog.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional(readOnly = true) //garante a integridade da comunicação com o banco
    public List<CategoryDto> findAll(){
        List<Category> list = categoryRepository.findAll();
//        List<CategoryDto> dtoList = list.stream().map(x -> new CategoryDto(x)).collect(Collectors.toList());
        return list.stream().map(x -> new CategoryDto(x)).collect(Collectors.toList());
    }
}
