package org.cap.service;

import org.cap.dao.IProductDao;
import org.cap.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class ProductServiceImpl implements IProductService {

    private IProductDao productDao;

    public IProductDao getProductDao() {
        return productDao;
    }

    @Autowired
    public void setEmployeeDao(IProductDao dao) {
        this.productDao = dao;
    }

    @Override
    public Product add(Product product) {
    	product= productDao.add(product);
        return product;
    }
    
    @Override
    public List<Product> fetchAll() {
        return productDao.fetchAll();
    }


}
