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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "media_id")
    private Media media;


}
