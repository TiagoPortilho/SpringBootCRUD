package com.tiago.crud.controllers;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.tiago.crud.dtos.ProductDto;
import com.tiago.crud.model.Product;
import com.tiago.crud.repositories.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable(value = "id") Integer id){
        Optional product = repository.findById(id);
        if (product.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
        else {
            return ResponseEntity.status(HttpStatus.FOUND).body(product.get());
        }
    }

    // O @RequestBody fala que no momento que usarmos o POST(@PostMapping) é necessário ter um objeto do tipo product no
    // corpo da requisição.
    @PostMapping
    public ResponseEntity save(@RequestBody ProductDto dto){
        var product = new Product(); // 1 - Crio o objeto product vazio
        BeanUtils.copyProperties(dto, product); // 2 - Copio os valores de dto para projects
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        Optional<Product> product = repository.findById(id);
        if (product.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
        else {
            repository.delete(product.get());
            return ResponseEntity.status(HttpStatus.OK).body("Product deleted");
        }
    }
}
