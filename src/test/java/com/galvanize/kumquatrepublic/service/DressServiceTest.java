package com.galvanize.kumquatrepublic.service;

import com.galvanize.kumquatrepublic.entity.Brand;
import com.galvanize.kumquatrepublic.entity.Dress;
import com.galvanize.kumquatrepublic.repository.BrandRepo;
import com.galvanize.kumquatrepublic.repository.DressRepo;
import com.sun.org.apache.bcel.internal.generic.ALOAD;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DressServiceTest {

    @MockBean
    DressRepo dressRepo;

    @MockBean
    BrandRepo brandRepo;

    @Autowired
    DressService dressService;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findByBrandTest() {
        Brand mockBrand = new Brand("Gucci");
        ArrayList<Brand> brands = new ArrayList<>(Arrays.asList(mockBrand));
        when(dressRepo.findAllByBrand(any())).thenReturn(new ArrayList<>());
        when(brandRepo.findAllByName(any())).thenReturn(brands);
        dressService.findByBrand(mockBrand.getName());
        verify(dressRepo, times(1)).findAllByBrand(mockBrand);
        verify(brandRepo, times(1)).findAllByName(mockBrand.getName());
    }

    @Test
    public void findByColorTest() {
        String mockColor = "yellow";
        when(dressRepo.findAllByColor(any())).thenReturn(new ArrayList<>());
        dressService.findByColor(mockColor);
        verify(dressRepo, times(1)).findAllByColor(mockColor);
    }


}