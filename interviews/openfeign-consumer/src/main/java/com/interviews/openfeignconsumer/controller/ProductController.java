package com.interviews.openfeignconsumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.interviews.openfeignconsumer.model.Product;
import com.interviews.openfeignconsumer.openfeign.ProductFeign;


@RestController
@RequestMapping("/output")
public class ProductController {

	@Autowired
	ProductFeign pF;
	
	@GetMapping
	public List<Product> getAllProducts(){
		return pF.getAllProducts();
	}

	@PostMapping
	public Product createProduct(@RequestBody Product request){
		return pF.createProduct(request);
	}

	@PutMapping("/{id}")
	public String updateProduct(@RequestBody Product product, @PathVariable Integer id)	{
		return pF.updateProduct(product, id);
	}
	
	@PatchMapping("/{id}")
	public String patchProduct(@RequestBody Product product, @PathVariable Integer id)	{
		return pF.patchProduct(product, id);
	}
	
	
	@DeleteMapping("/{name}")
	public String deleteProduct(@PathVariable String name)	{
		return pF.deleteProduct(name);

	}


}
