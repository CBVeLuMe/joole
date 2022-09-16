package com.itlize.joole.service.impl;

import com.itlize.joole.entity.Product;
import com.itlize.joole.entity.enums.*;
import com.itlize.joole.repository.ProductRepository;
import com.itlize.joole.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findByBrandOrManufacturer(Brand brand, Manufacturer manufacturer) {
        return productRepository.findByBrandOrManufacturer(brand, manufacturer).orElse(null);
    }

    @Override
    public List<Product> findByUseTypeOrApplicationOrMountingLocationOrAccessories(
            UseType useType, Application application, MountingLocation mountingLocation, Accessories accessories
    ) {
        return productRepository.findByUseTypeOrApplicationOrMountingLocationOrAccessories(
                useType, application, mountingLocation, accessories
        ).orElse(null);
    }
}
