package com.javaguides.firstproject.model.repos;

import com.javaguides.firstproject.model.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ProductItemRepo extends JpaRepository<ProductItem,Long> {

}
