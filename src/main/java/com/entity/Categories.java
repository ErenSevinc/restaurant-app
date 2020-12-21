package com.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Categories implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    //(
//            mappedBy = "category",
//            cascade =CascadeType.ALL
//    )

    @JsonBackReference
    @ManyToMany
    @JoinTable(name = "tb_categories_products", joinColumns = @JoinColumn(name = "category_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Products> products = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "media_id")
    private Media media;

}
