package com.galvanize.kumquatrepublic.service;

import com.galvanize.kumquatrepublic.entity.Brand;
import com.galvanize.kumquatrepublic.entity.Dress;
import com.galvanize.kumquatrepublic.repository.BrandRepo;
import com.galvanize.kumquatrepublic.repository.DressRepo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

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
        when(dressRepo.findAllByBrand(any())).thenReturn(new ArrayList<>());
        dressService.findByBrand(mockBrand);
        verify(dressRepo, times(1)).findAllByBrand(mockBrand);
    }

}