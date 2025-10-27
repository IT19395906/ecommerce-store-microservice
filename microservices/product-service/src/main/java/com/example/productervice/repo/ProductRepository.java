package com.example.productervice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.productervice.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
