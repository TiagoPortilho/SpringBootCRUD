package com.tiago.crud.controllers;

import com.tiago.crud.model.Product;
import com.tiago.crud.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController // Fala para IDE quando compilar que toda essa classe será uma classe de controle.
@RequestMapping("/products") // Estou informando que para "/product" vou utilizar todos os metodos dessa classe.
public class ProductController {

    // O @Autowired faz com que a gente consiga instânciar o objeto que ta logo abaixo fazendo com que ele faça todas
    // as injeções de dependências necessárias para a gente conseguir utilizar o objeto.
    @Autowired
    ProductRepository repository;


    @GetMapping // Estou informando que o metodo abaixo será do tipo GET
    public ResponseEntity getAll(){ // ResponseEntity ja contém metodos e atributos específicos para poder utilizar as melhores práticas no momendo de retornar um dado de uma API
        List<Product> listProduct = repository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(listProduct);
    }
}
