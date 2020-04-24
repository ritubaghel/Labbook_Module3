package org.cap.dao;

import org.cap.entities.Product;

import java.util.List;

public interface IProductDao {

    Product add(Product product);
    List<Product> fetchAll();

}
