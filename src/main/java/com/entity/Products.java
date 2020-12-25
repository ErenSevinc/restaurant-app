package com.entity;

import com.entity.Categories;
import com.entity.Media;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tb_products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SQLDelete(sql = "UPDATE tb_products "+"SET deleted = true "+"WHERE id = ?")
@Where(clause = "deleted = false")
public class Products extends BaseEntity{

    private String name;
    private String brand;
    private double price;

    @JsonManagedReference
    @ManyToMany(mappedBy = "products",fetch = FetchType.EAGER)
    private List<Categories> categories=new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "media_id")
    private Media media;

}
