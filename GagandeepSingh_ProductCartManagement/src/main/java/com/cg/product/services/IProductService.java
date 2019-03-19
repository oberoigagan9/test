package com.cg.product.services;
import java.util.List;
import com.cg.product.beans.Product;
import com.cg.product.exceptions.ProductDetailsNotFoundException;
public interface IProductService {
	boolean addProduct(Product product);              // functions that need to be done
	boolean updateProduct(Product product,String id) throws ProductDetailsNotFoundException;
	boolean deleteProduct(String id) throws ProductDetailsNotFoundException;
	List<Product> viewProduct();
	Product findProduct(String id) throws ProductDetailsNotFoundException;
}


