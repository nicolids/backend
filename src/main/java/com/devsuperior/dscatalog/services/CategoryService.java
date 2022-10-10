package com.devsuperior.dscatalog.services;

import com.devsuperior.dscatalog.dto.CategoryDto;
import com.devsuperior.dscatalog.entities.Category;
import com.devsuperior.dscatalog.repositories.CategoryRepository;
import com.devsuperior.dscatalog.services.exeptions.DataBaseException;
import com.devsuperior.dscatalog.services.exeptions.ServiceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional(readOnly = true) //garante a integridade da comunicação com o banco
    public Page<CategoryDto> findAllPage(PageRequest pageRequest) {
        Page<Category> list = categoryRepository.findAll(pageRequest);
//        List<CategoryDto> dtoList = list.stream().map(x -> new CategoryDto(x)).collect(Collectors.toList());
        return list.map(x -> new CategoryDto(x));
    }

    @Transactional(readOnly = true)
    public CategoryDto findById(Long id) {
        Optional<Category> obj = categoryRepository.findById(id); // o obj optional faz com que a busca nunca seja nula
        Category entity = obj.orElseThrow(() -> new ServiceNotFoundException("Entity not found"));
        return new CategoryDto(entity);
    }

    @Transactional(readOnly = true)
    public CategoryDto insert(CategoryDto dto) {
        Category entity = new Category();
        entity.setNome(dto.getNome());
        entity = categoryRepository.save(entity);
        return new CategoryDto(entity);
    }

    @Transactional
    public CategoryDto update(Long id, CategoryDto dto) {
        try {
            Category entity = categoryRepository.getReferenceById(id);
            entity.setNome(dto.getNome());
            entity = categoryRepository.save(entity);
            return new CategoryDto(entity);
        } catch (EntityNotFoundException e) {
            throw new ServiceNotFoundException("Id not found " + id);
        }

    }
    public void delete(Long id) {
        try {
            categoryRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ServiceNotFoundException("Id not found " + id);
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Integrity violation");
        }
    }


}
