package com.entity;

import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SQLDelete(sql = "UPDATE users "+"SET deleted = true "+"WHERE id = ?")
@Where(clause = "deleted = false")
public class User extends BaseEntity {

    private String email;
    private String username;
    private String password;
    private boolean enabled;

    @ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinTable(
            name = "USER_ROLES",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles =new ArrayList<>();

}
