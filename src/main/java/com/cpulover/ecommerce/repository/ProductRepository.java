package com.cpulover.ecommerce.repository;

import com.cpulover.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200") //origin of Angular app
public interface ProductRepository extends JpaRepository<Product, Long> {
}
