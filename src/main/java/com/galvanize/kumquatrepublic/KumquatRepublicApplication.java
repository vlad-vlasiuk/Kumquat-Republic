package com.galvanize.kumquatrepublic;

import com.galvanize.kumquatrepublic.entity.Brand;
import com.galvanize.kumquatrepublic.entity.Dress;
import com.galvanize.kumquatrepublic.repository.BrandRepo;
import com.galvanize.kumquatrepublic.repository.DressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class KumquatRepublicApplication implements CommandLineRunner {

    private final BrandRepo brandRepo;
    private final DressRepo dressRepo;

    @Autowired
    public KumquatRepublicApplication(BrandRepo brandRepo, DressRepo dressRepo) {
        this.brandRepo = brandRepo;
        this.dressRepo = dressRepo;
    }

    public static void main(String[] args) {
        SpringApplication.run(KumquatRepublicApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Brand gucci = brandRepo.save(new Brand("Gucci"));
        Brand marni = brandRepo.save(new Brand("Marni"));
        Brand bottega = brandRepo.save(new Brand("Bottega"));
        Brand prada = brandRepo.save(new Brand("Prada"));
        Brand victoria = brandRepo.save(new Brand("Victoria"));
        Brand celine = brandRepo.save(new Brand("Celine"));
        Brand jil = brandRepo.save(new Brand("Jil"));

        dressRepo.save(Dress.builder()
                .brand(gucci)
                .color("yellow")
                .price(new BigDecimal(2272.00))
                .build());

        dressRepo.save(Dress.builder()
                .brand(gucci)
                .color("red")
                .price(new BigDecimal(1966.00))
                .build());

        dressRepo.save(Dress.builder()
                .brand(marni)
                .color("brown")
                .price(new BigDecimal(999.00))
                .build());

        dressRepo.save(Dress.builder()
                .brand(marni)
                .color("pink")
                .price(new BigDecimal(1129.00))
                .build());

        dressRepo.save(Dress.builder()
                .brand(bottega)
                .color("black")
                .price(new BigDecimal(2200.00))
                .build());

        dressRepo.save(Dress.builder()
                .brand(prada)
                .color("black")
                .price(new BigDecimal(1650.00))
                .build());

        dressRepo.save(Dress.builder()
                .brand(victoria)
                .color("blue")
                .price(new BigDecimal(927.00))
                .build());

        dressRepo.save(Dress.builder()
                .brand(celine)
                .color("red")
                .price(new BigDecimal(1901.00))
                .build());

        dressRepo.save(Dress.builder()
                .brand(jil)
                .color("orange")
                .price(new BigDecimal(511.00))
                .build());
    }
}

