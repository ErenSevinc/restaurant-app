package com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CategoryTable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String name;
    private int amount;
//    @OneToMany(
//            cascade = CascadeType.ALL
//    )
//    @JoinColumn(name = "category_id")
//    private Set<RestaurantTable> tables;

}
