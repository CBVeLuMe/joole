package com.itlize.joole.service;

import com.itlize.joole.entity.Product;
import com.itlize.joole.entity.enums.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProductServiceTest {
    @Autowired
    private ProductService productService;

    @Test
    void findAll() {
        Assertions.assertNotNull(productService.findAll());
    }

    @Test
    void findById() {
        Product product = new Product();
        product.setBrand(Brand.placeholder);
        product.setManufacturer(Manufacturer.minka);
        product.setSeries("s");
        product.setModel("m");
        product.setUseType(UseType.commercial);
        product.setApplication(Application.outdoor);
        product.setMountingLocation(MountingLocation.roof);
        product.setAccessories(Accessories.with_light);
        product.setModelYear(2000);
        product.setAirflow(1f);
        product.setMinPower(1f);
        product.setMaxPower(1f);
        product.setMinOperatingVoltage(1f);
        product.setMaxOperatingVoltage(1f);
        product.setMinFanSpeed(1f);
        product.setMaxFanSpeed(1f);
        product.setNumberOfFanSpeeds(1f);
        product.setSoundAtMaxSpeed(1f);
        product.setMinHeight(1f);
        product.setMaxHeight(1f);
        product.setWight(1f);
        productService.save(product);
        Assertions.assertNotNull(productService.findById(product.getId()));
    }

    @Test
    void save() {
        Product product = new Product();
        product.setBrand(Brand.placeholder);
        product.setManufacturer(Manufacturer.minka);
        product.setSeries("s");
        product.setModel("m");
        product.setUseType(UseType.commercial);
        product.setApplication(Application.outdoor);
        product.setMountingLocation(MountingLocation.roof);
        product.setAccessories(Accessories.with_light);
        product.setModelYear(2000);
        product.setAirflow(1f);
        product.setMinPower(1f);
        product.setMaxPower(1f);
        product.setMinOperatingVoltage(1f);
        product.setMaxOperatingVoltage(1f);
        product.setMinFanSpeed(1f);
        product.setMaxFanSpeed(1f);
        product.setNumberOfFanSpeeds(1f);
        product.setSoundAtMaxSpeed(1f);
        product.setMinHeight(1f);
        product.setMaxHeight(1f);
        product.setWight(1f);
        productService.save(product);
        Assertions.assertNotNull(productService.findById(product.getId()));
    }

    @Test
    void deleteById() {
        Product product = new Product();
        product.setBrand(Brand.placeholder);
        product.setManufacturer(Manufacturer.minka);
        product.setSeries("s");
        product.setModel("m");
        product.setUseType(UseType.commercial);
        product.setApplication(Application.outdoor);
        product.setMountingLocation(MountingLocation.roof);
        product.setAccessories(Accessories.with_light);
        product.setModelYear(2000);
        product.setAirflow(1f);
        product.setMinPower(1f);
        product.setMaxPower(1f);
        product.setMinOperatingVoltage(1f);
        product.setMaxOperatingVoltage(1f);
        product.setMinFanSpeed(1f);
        product.setMaxFanSpeed(1f);
        product.setNumberOfFanSpeeds(1f);
        product.setSoundAtMaxSpeed(1f);
        product.setMinHeight(1f);
        product.setMaxHeight(1f);
        product.setWight(1f);
        productService.save(product);
        productService.deleteById(product.getId());
        Assertions.assertNull(productService.findById(product.getId()));
    }

    @Test
    void findByBrandAndManufacturer() {
        List<Product> products = productService.findByBrandOrManufacturer(
                Brand.placeholder,
                Manufacturer.minka
        );
        Assertions.assertNotNull(products);
    }

    @Test
    void findByUseTypeAndApplicationAndMountingLocationAndAccessories() {
        List<Product> products = productService.findByUseTypeOrApplicationOrMountingLocationOrAccessories(
                UseType.commercial,
                Application.outdoor,
                MountingLocation.roof,
                Accessories.with_light
        );
        Assertions.assertNotNull(products);
    }
}