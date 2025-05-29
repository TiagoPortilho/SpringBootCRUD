package com.tiago.crud.model;

import jakarta.persistence.*;

// Essa entity "fala" para nossa IDE que a gente ta usando uma anotação:
// (Específica a utilidade de atributos metodos e classes) e que essa classe é uma entidade.
@Entity(name = "product")
@Table(name = "product") // Fala que a entidade terá uma tabela com o nome "product" no banco de dados
public class Product {

    @Id // Aqui fala para o IDE que o proximo atributo abaixo se trata de um ID
    @GeneratedValue(strategy = GenerationType.AUTO)// E terá a estratégia de valor dele gerada automaticamente
    private Integer id;
    private String name;
    private Long price;

    public Product(Integer id, String name, Long price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

}
