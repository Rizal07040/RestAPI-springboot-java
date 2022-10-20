package com.javaguides.firstproject.model.repos;

import com.javaguides.firstproject.model.entities.ProductHp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductHpRepo extends JpaRepository<ProductHp,Long> {
}
