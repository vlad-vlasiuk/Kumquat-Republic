package com.galvanize.kumquatrepublic.repository;

import com.galvanize.kumquatrepublic.entity.Brand;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BrandRepo extends CrudRepository<Brand, Long> {
    List<Brand> findAllByName(String name);
}
