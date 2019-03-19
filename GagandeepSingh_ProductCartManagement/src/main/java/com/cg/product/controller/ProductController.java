package com.cg.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.product.beans.Product;
import com.cg.product.exceptions.ProductDetailsNotFoundException;
import com.cg.product.services.IProductService;
@Controller
public class ProductController {  // Controller class
	@Autowired
	IProductService services;             //object creation
	@RequestMapping(value= {"/addProduct"}, method=RequestMethod.POST, consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<String> addProductDetails(@ModelAttribute Product product) {
		services.addProduct(product);
		return new ResponseEntity<String>("Product added Successfully", HttpStatus.OK);
	}
	@RequestMapping(value= {"/delete/{id}"}, method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteProductDetails(@PathVariable(value="id") String id)  throws ProductDetailsNotFoundException {
		services.deleteProduct(id);
		return new ResponseEntity<String>("Product details are successfully deleted", HttpStatus.OK);
	}
	@RequestMapping(value= {"/products"}, method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE, headers="Accept=application/json")
	public ResponseEntity<List<Product>> viewAllProducts() {
		return new ResponseEntity<List<Product>>(services.viewProduct(), HttpStatus.OK);
	}
	@RequestMapping(value= {"/find"}, method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE, headers="Accept=application/json")
	public ResponseEntity<Product> getProduct(@RequestParam String id) throws ProductDetailsNotFoundException {
		return new ResponseEntity<Product>(services.findProduct(id), HttpStatus.OK);

	}
}
