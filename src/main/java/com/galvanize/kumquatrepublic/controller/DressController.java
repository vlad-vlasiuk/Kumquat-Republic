package com.galvanize.kumquatrepublic.controller;

import com.galvanize.kumquatrepublic.entity.Brand;
import com.galvanize.kumquatrepublic.entity.Dress;
import com.galvanize.kumquatrepublic.repository.BrandRepo;
import com.galvanize.kumquatrepublic.repository.DressRepo;
import com.galvanize.kumquatrepublic.service.DressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/dresses")
public class DressController {

    private final DressRepo dressRepo;
    private final BrandRepo brandRepo;
    private final DressService dressService;

    @Autowired
    public DressController(DressRepo dressRepo, BrandRepo brandRepo, DressService dressService) {
        this.dressRepo = dressRepo;
        this.brandRepo = brandRepo;
        this.dressService = dressService;
    }

    @GetMapping("/all")
    public Iterable<Dress> getAll() {
        return dressRepo.findAll();
    }


    @GetMapping("/brand/{brand}")
    public Iterable<Dress> findByBrand(@PathVariable String brand) {
        return dressService.findByBrand(brand);
    }

    @GetMapping("/color/{color}")
    public Iterable<Dress> findByColor(@PathVariable String color) {
        return dressService.findByColor(color);
    }

    @GetMapping("/price/from/{priceFrom}/to/{priceTo}")
    public Iterable<Dress> findByPrice(@PathVariable BigDecimal priceFrom,
                                       @PathVariable BigDecimal priceTo) {
        return dressRepo.findAllByPriceBetween(priceFrom, priceTo);
    }

    @GetMapping("/brand/{brand}/color/{color}")
    public Iterable<Dress> findByBrandAndColor(@PathVariable String brand,
                                               @PathVariable String color) {
        List<Brand> allByName = brandRepo.findAllByName(brand);
        return dressRepo.findAllByBrandAndColor(allByName.get(0), color);
    }

    @GetMapping("/price/from/{priceFrom}/to/{priceTo}/order/{order}")
    public Iterable<Dress> findByPriceWithOrder(@PathVariable BigDecimal priceFrom,
                                                @PathVariable BigDecimal priceTo,
                                                @PathVariable String order) {
        if ("desc".equals(order))
            return dressRepo.findAllByPriceBetweenOrderByPriceDesc(priceFrom, priceTo);
        else
            return dressRepo.findAllByPriceBetweenOrderByPriceAsc(priceFrom,priceTo);
    }

}
