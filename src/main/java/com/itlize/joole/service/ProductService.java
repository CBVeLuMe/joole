package com.itlize.joole.service;

import com.itlize.joole.entity.Product;
import com.itlize.joole.entity.enums.*;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findById(Integer id);

    Product save(Product product);

    void deleteById(Integer id);

    List<Product> findByBrandOrManufacturer(Brand brand, Manufacturer manufacturer);

    List<Product> findByUseTypeOrApplicationOrMountingLocationOrAccessories(
            UseType useType, Application application, MountingLocation mountingLocation, Accessories accessories
    );
}
