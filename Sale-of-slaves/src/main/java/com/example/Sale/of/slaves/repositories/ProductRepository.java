package com.example.Sale.of.slaves.repositories;

import com.example.Sale.of.slaves.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
List<Product> findByTitle (String title);

}
