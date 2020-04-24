package org.cap.controller;

import org.cap.entities.Product;
import org.cap.service.IProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
public class HelloController {
    private static Logger Log= LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private IProductService productService;

 
    @GetMapping("/register")
    public ModelAndView registerPage() {
        return new ModelAndView("productregister");
    }

    @GetMapping("/processregister")
    public ModelAndView registerProduct(@RequestParam("prodid") int prodId,
    @RequestParam("prodname") String prodName,
    @RequestParam("prodprice") double prodPrice) {
        Product product=new Product();
        product.setProdId(prodId);
        product.setProdName(prodName);
        product.setProdPrice(prodPrice);
        product=productService.add(product);
        return new ModelAndView("productdetails",  "product", product);
    }

    @GetMapping("/displayall")
    public ModelAndView displayAll(){
        List<Product> products= productService.fetchAll();
        ModelAndView modelAndView=new ModelAndView("listproducts","products",products);
        return modelAndView;
    }



}
