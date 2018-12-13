package com.galvanize.kumquatrepublic.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Long id;

    String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    List<Dress> dresses = new ArrayList<>();

    public Brand(String name) {
        this.name = name;
    }
}
