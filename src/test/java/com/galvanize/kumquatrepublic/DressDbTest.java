package com.galvanize.kumquatrepublic;

import com.galvanize.kumquatrepublic.entity.Brand;
import com.galvanize.kumquatrepublic.entity.Dress;
import com.galvanize.kumquatrepublic.repository.BrandRepo;
import com.galvanize.kumquatrepublic.repository.DressRepo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DressDbTest {
    @Autowired
    DressRepo dressRepo;
    @Autowired
    BrandRepo brandRepo;

    @Before
    public void setUp() throws Exception {
        dressRepo.deleteAll();
        brandRepo.deleteAll();
    }

    @Test
    public void saveAndReadTest() {
        Brand brand = brandRepo.save(new Brand("Gucci"));
        Dress dress = Dress.builder()
                .brand(brand)
                .color("yellow")
                .price(new BigDecimal(100.50))
                .build();
        Dress savedDress = dressRepo.save(dress);
        assertThat("expect that saved dress has ID", savedDress.getId(), is(notNullValue()));
    }
}
