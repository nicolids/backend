package com.devsuperior.dscatalog.entities;

import javax.persistence.*;
import java.io.Serializable; //para ser convertido em sequência de bites
import java.util.Objects;

@Entity
@Table(name= "tb_category")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    public Category(){

    }

    public Category(Long id, String nome) {
        this.id = id;
        this.nome = nome;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;
        Category category = (Category) o;
        return Objects.equals(getId(), category.getId()) && Objects.equals(getNome(), category.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome());
    }
}
