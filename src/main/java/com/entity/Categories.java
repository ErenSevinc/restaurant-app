package com.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SQLDelete(sql = "UPDATE categories "+"SET deleted = true "+"WHERE id = ?")
@Where(clause = "deleted = false")
public class Categories extends BaseEntity implements Serializable {

    private String name;
    private String description;


    @JsonBackReference
    @ManyToMany
    @JoinTable(name = "tb_categories_products", joinColumns = @JoinColumn(name = "category_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Products> products = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "media_id")
    private Media media;

}
