package com.cg.product.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cg.product.beans.Product;
import com.cg.product.daoservices.IProductRepo;
import com.cg.product.exceptions.ProductDetailsNotFoundException;
@Component("iProductService")
public class ProductServiceImpl implements IProductService {
	@Autowired
	private IProductRepo services;     //connects
	public ProductServiceImpl() {}
	@Override
	public boolean addProduct(Product product) {   //add product
		services.save(product);
		return true;
	}
	@Override
	public boolean deleteProduct(String id) throws ProductDetailsNotFoundException {            //delete product
		services.delete(findProduct(id));
		return true;
	}
	@Override
	public List<Product> viewProduct() {  // view all products
		return services.findAll();
	}
	@Override
	public Product findProduct(String id) throws ProductDetailsNotFoundException { // find product
		return services.findById(id).orElseThrow(()->new ProductDetailsNotFoundException("Product details not found"));
	}
	@Override
	public boolean updateProduct(Product product, String id) throws ProductDetailsNotFoundException { //update product
		findProduct(id);
		addProduct(product);
		return true;
	}
}





