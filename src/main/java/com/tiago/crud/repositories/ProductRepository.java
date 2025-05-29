package com.tiago.crud.repositories;

import com.tiago.crud.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

// Para cada entidade que mapear no projeto caso a gente queira que ela entre em contato com o banco de dados
// A gente tem que criar um REPOSITORY para ela e extender a JpaRepository<CLASSE DE ENTIDADE, TIPO DO ID>
// (A JpaRepository possui os metodos necessários já, padronizados e implementados para efetuar o contato com o
// banco de dados.
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
