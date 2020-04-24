package org.cap.controller;

import org.apache.commons.logging.Log;
import org.cap.dto.ProductDto;
import org.cap.entities.Product;
import org.cap.exceptions.ProductNotFoundException;
import org.cap.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import javax.persistence.EntityNotFoundException;

@RestController
public class ProductRestController {

    @Autowired
    private IProductService service;

    
    @PostMapping("/products/add")
    public ResponseEntity<Product> addEmployee(@RequestBody ProductDto dto) {
        Product product = convert(dto);
        product = service.add(product);
        ResponseEntity<Product> response = new ResponseEntity<>(product, HttpStatus.OK);
        return response;
    }

    Product convert(ProductDto dto) {
        Product product = new Product();
        product.setProdId(dto.getProdId());
        product.setProdName(dto.getProdName());
        product.setProdPrice(dto.getProdPrice());
        return product;
    }


    @GetMapping("/products")
    public ResponseEntity<List<Product>> fetchAll() {
        List<Product> products = service.fetchAll();
        ResponseEntity<List<Product>> response = new ResponseEntity<>(products, HttpStatus.OK);
        return response;
    }

    
   /* @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleEmployeeNotFound(ProductNotFoundException exception){
	String exceptionMsg=exception.getMessage();
	ResponseEntity<String> response=new ResponseEntity<>(exceptionMsg,HttpStatus.NOT_FOUND);
	return response;
}
    
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handleEmployeeNotFound(Throwable exception){
	String msg="something went wrong";
	ResponseEntity<String> response=new ResponseEntity<>(msg,HttpStatus.INTERNAL_SERVER_ERROR);
	return response;
}*/
 
    
}
