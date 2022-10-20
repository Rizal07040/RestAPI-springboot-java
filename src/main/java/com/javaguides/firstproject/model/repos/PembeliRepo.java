package com.javaguides.firstproject.model.repos;

import com.javaguides.firstproject.model.entities.Pembeli;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PembeliRepo extends JpaRepository<Pembeli,Long> {
}
