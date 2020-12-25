package com.entity;

import com.builder.MediaBuilder;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SQLDelete(sql = "UPDATE media "+"SET deleted = true "+"WHERE id = ?")
@Where(clause = "deleted = false")
public class Media extends BaseEntity {

    private String name;
    @Column(length = 1000000)
    private byte[] fileContent;


}
