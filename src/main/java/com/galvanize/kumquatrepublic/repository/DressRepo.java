package com.galvanize.kumquatrepublic.repository;

import com.galvanize.kumquatrepublic.entity.Brand;
import com.galvanize.kumquatrepublic.entity.Dress;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

public interface DressRepo extends CrudRepository<Dress, Long> {
    List<Dress> findAllByBrandIn(List<Brand> brands);
    List<Dress> findAllByColor(String color);
    List<Dress> findAllByPriceBetween(BigDecimal priceFrom, BigDecimal priceTo);
    List<Dress> findAllByBrandAndColor(Brand brand, String color);
    List<Dress> findAllByPriceBetweenOrderByPriceDesc(BigDecimal priceFrom, BigDecimal priceTo);
    List<Dress> findAllByPriceBetweenOrderByPriceAsc(BigDecimal priceFrom, BigDecimal priceTo);
}
