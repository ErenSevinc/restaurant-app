package com.entity;

import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "tb_role")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SQLDelete(sql = "UPDATE roles "+"SET deleted = true "+"WHERE id = ?")
@Where(clause = "deleted = false")
public class Role extends BaseEntity {

    private String name;



}
