package com.cpulover.ecommerce.repository;

import com.cpulover.ecommerce.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin("http://localhost:4200") //origin of Angular app
public interface ProductRepository extends JpaRepository<Product, Long> {
    //endpoint: /products/search/findByCategoryId?id=<id>
    Page<Product> findByCategoryId(@RequestParam("id") Long id, Pageable pageable);
}
