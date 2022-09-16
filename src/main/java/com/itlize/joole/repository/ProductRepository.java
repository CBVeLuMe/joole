package com.itlize.joole.repository;

import com.itlize.joole.entity.Product;
import com.itlize.joole.entity.enums.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Optional<List<Product>> findByBrandOrManufacturer(Brand brand, Manufacturer manufacturer);

    Optional<List<Product>> findByUseTypeOrApplicationOrMountingLocationOrAccessories(
            UseType useType, Application application, MountingLocation mountingLocation, Accessories accessories
    );

//    Optional<List<Product>> findByModelYearBetween(Integer start, Integer end);
//    Optional<List<Product>> findByModelYearBefore(Integer year);
//    Optional<List<Product>> findByModelYearAfter(Integer year);
}
