package com.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
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

    public CategoryTable() {
    }

    public CategoryTable(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Set<RestaurantTable> getTables() {
//        return tables;
//    }
//
//    public void setTables(Set<RestaurantTable> tables) {
//        this.tables = tables;
//    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
