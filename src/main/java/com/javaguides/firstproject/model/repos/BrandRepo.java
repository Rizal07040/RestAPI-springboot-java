package com.javaguides.firstproject.model.repos;

import com.javaguides.firstproject.model.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepo extends JpaRepository<Brand, Long> {
}
