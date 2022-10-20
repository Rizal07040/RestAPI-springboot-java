package com.javaguides.firstproject.model.repos;

import com.javaguides.firstproject.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepo extends CrudRepository<Product,Long> {

    List<Product> findByNameContains(String name);
}
