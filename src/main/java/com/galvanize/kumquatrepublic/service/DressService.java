package com.galvanize.kumquatrepublic.service;

import com.galvanize.kumquatrepublic.entity.Brand;
import com.galvanize.kumquatrepublic.entity.Dress;
import com.galvanize.kumquatrepublic.repository.BrandRepo;
import com.galvanize.kumquatrepublic.repository.DressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class DressService {

    private final DressRepo dressRepo;
    private final BrandRepo brandRepo;

    @Autowired
    public DressService(DressRepo dressRepo, BrandRepo brandRepo) {
        this.dressRepo = dressRepo;
        this.brandRepo = brandRepo;
    }

    public Iterable<Dress> findByBrand(String brand) {
        List<Brand> allByName = brandRepo.findAllByName(brand);
        return dressRepo.findAllByBrand(allByName.get(0));
    }

    public Iterable<Dress> findByColor(String color) {
        return null;
    }

    public Iterable<Dress> findByPrice(BigDecimal priceFrom, BigDecimal priceTo) {
        return null;
    }

    public Iterable<Dress> findByBrandAndColor(Brand brand, String color) {
        return null;
    }

    public Iterable<Dress> findByPriceWithOrder(BigDecimal priceFrom, BigDecimal priceTo, String order) {
        return null;
    }

}
