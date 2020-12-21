package com.entity;

import com.entity.Categories;
import com.entity.Media;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tb_products")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String brand;
    private double price;


    @JsonManagedReference
    @ManyToMany(mappedBy = "products")
    private List<Categories> categories=new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "media_id")
    private Media media;

}
