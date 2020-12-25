package com.entity;

import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SQLDelete(sql = "UPDATE category_table "+"SET deleted = true "+"WHERE id = ?")
@Where(clause = "deleted = false")
public class CategoryTable extends BaseEntity {

    private String name;
    private int amount;
//    @OneToMany(
//            cascade = CascadeType.ALL
//    )
//    @JoinColumn(name = "category_id")
//    private Set<RestaurantTable> tables;

}
