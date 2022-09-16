package com.itlize.joole.controller;

import com.itlize.joole.entity.Product;
import com.itlize.joole.entity.enums.*;
import com.itlize.joole.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {
    @Autowired
    ProductService productService;

    @GetMapping("/findProductsByLabels")
    public ResponseEntity<?> findProductsByLabels(@RequestParam(name = "brand", required = false) Brand brand,
                                                  @RequestParam(name = "manufacturer", required = false) Manufacturer manufacturer) {
        if (brand == null && manufacturer == null) {
            return new ResponseEntity<>("Use retrieve all instead", HttpStatus.OK);
        }
        List<Product> products = productService.findByBrandOrManufacturer(brand, manufacturer);
        if (products == null) return new ResponseEntity<>("Hello world", HttpStatus.OK);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/findProductsByFeatures")
    public ResponseEntity<?> findProductsByFeatures(@RequestParam(name = "useType", required = false) UseType useType,
                                                    @RequestParam(name = "application", required = false) Application application,
                                                    @RequestParam(name = "mountingLocation", required = false) MountingLocation mountingLocation,
                                                    @RequestParam(name = "accessories", required = false) Accessories accessories) {
        if (useType == null && application == null && mountingLocation == null && accessories == null) {
            return new ResponseEntity<>("Use retrieve all instead", HttpStatus.OK);
        }
        List<Product> products = productService.findByUseTypeOrApplicationOrMountingLocationOrAccessories(useType, application, mountingLocation, accessories);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

//    @GetMapping("/AdvancedSearch")
//    public  ResponseEntity<?> advancedSearch()
}
