package com.devsuperior.dscatalog.dto;

import com.devsuperior.dscatalog.entities.Category;

import java.io.Serializable;

public class CategoryDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String nome;

    public CategoryDto() {
    }

    public CategoryDto(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public CategoryDto(Category entity){
        this.id = entity.getId();
        this.nome = entity.getNome();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
