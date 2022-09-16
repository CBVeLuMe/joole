package com.itlize.joole.controller;

import com.itlize.joole.entity.Product;
import com.itlize.joole.entity.ProjectProduct;
import com.itlize.joole.entity.enums.*;
import com.itlize.joole.service.ProductService;
import com.itlize.joole.service.ProjectProductService;
import com.itlize.joole.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/controller")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private ProjectProductService projectProductService;

    @GetMapping("/products")
    public ResponseEntity<?> readAll() {
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<?> readById(@PathVariable("id") Integer id) {
        Product product = productService.findById(id);
        if (product == null) {
            return new ResponseEntity<>("Cannot find product id " + id, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping("/products")
    public ResponseEntity<?> create(@RequestParam(name = "brand") Brand brand,
                                    @RequestParam(name = "manufacturer") Manufacturer manufacturer,
                                    @RequestParam(name = "series") String series,
                                    @RequestParam(name = "model") String model,
                                    @RequestParam(name = "useType") UseType useType,
                                    @RequestParam(name = "application") Application application,
                                    @RequestParam(name = "mountingLocation") MountingLocation mountingLocation,
                                    @RequestParam(name = "accessories") Accessories accessories,
                                    @RequestParam(name = "modelYear", required = false) Integer modelYear,
                                    @RequestParam(name = "airflow", required = false) Float airflow,
                                    @RequestParam(name = "min-power", required = false) Float minPower,
                                    @RequestParam(name = "maxPower", required = false) Float maxPower,
                                    @RequestParam(name = "minOperatingVoltage", required = false) Float minOperatingVoltage,
                                    @RequestParam(name = "maxOperatingVoltage", required = false) Float maxOperatingVoltage,
                                    @RequestParam(name = "minFanSpeed", required = false) Float minFanSpeed,
                                    @RequestParam(name = "maxFanSpeed", required = false) Float maxFanSpeed,
                                    @RequestParam(name = "numberOfFanSpeeds", required = false) Float numberOfFanSpeeds,
                                    @RequestParam(name = "soundAtMaxSpeed", required = false) Float soundAtMaxSpeed,
                                    @RequestParam(name = "minHeight", required = false) Float minHeight,
                                    @RequestParam(name = "maxHeight", required = false) Float maxHeight,
                                    @RequestParam(name = "wight", required = false) Float wight) {
        Product product = new Product();
        product.setBrand(brand);
        product.setManufacturer(manufacturer);
        product.setSeries(series);
        product.setModel(model);
        product.setUseType(useType);
        product.setApplication(application);
        product.setMountingLocation(mountingLocation);
        product.setAccessories(accessories);
        product.setModelYear(modelYear);
        product.setAirflow(airflow);
        product.setMinPower(minPower);
        product.setMaxPower(maxPower);
        product.setMinOperatingVoltage(minOperatingVoltage);
        product.setMaxOperatingVoltage(maxOperatingVoltage);
        product.setMinFanSpeed(minFanSpeed);
        product.setMaxFanSpeed(maxFanSpeed);
        product.setNumberOfFanSpeeds(numberOfFanSpeeds);
        product.setSoundAtMaxSpeed(soundAtMaxSpeed);
        product.setMinHeight(minHeight);
        product.setMaxHeight(maxHeight);
        product.setWight(wight);
        productService.save(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @DeleteMapping("/products/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        productService.deleteById(id);
    }

    @GetMapping("/readProductsFromProject")
    public ResponseEntity<?> readProductsFromProject(@RequestParam(name = "projectId") Integer projectId) {
        List<ProjectProduct> projectProducts = projectProductService.findByProjectId(projectId);
        if (projectProducts == null) {
            return new ResponseEntity<>("Cannot find project id" + projectId, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(projectProducts, HttpStatus.OK);
    }

    @PutMapping("/updateProductToProject")
    public ResponseEntity<?> updateProductToProject(@RequestParam(name = "projectId") Integer projectId,
                                                    @RequestParam(name = "productId") Integer productId) {
        // Find by both ids, if not null, return a message.
        ProjectProduct projectProduct = new ProjectProduct();
        projectProduct.setProduct(productService.findById(productId));
        projectProduct.setProject(projectService.findById(projectId));
        projectProductService.save(projectProduct);
        return new ResponseEntity<>(projectProduct, HttpStatus.OK);
    }

    // Fulfill a delete method by both ids. Also, need to check the condition find both not null.
    @DeleteMapping("/deleteProductFromProject")
    public ResponseEntity<?> deleteProductFromProject(@RequestParam(name = "projectId") Integer projectId,
                                                      @RequestParam(name = "productId") Integer productId) {
        return new ResponseEntity<>("No method body for now.", HttpStatus.OK);
    }
}