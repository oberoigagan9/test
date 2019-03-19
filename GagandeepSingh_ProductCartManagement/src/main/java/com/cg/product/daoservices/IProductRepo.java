package com.cg.product.daoservices;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.product.beans.Product;

public interface IProductRepo extends JpaRepository<Product, String> { //does the work for JPA repositories used

}
