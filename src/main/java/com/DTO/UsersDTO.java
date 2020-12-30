package com.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class UsersDTO {

    private int id;
    @NotNull(message ="mail bos olamaz")
    @Email
    private String email;
    @NotNull(message ="username bos olamaz")
    private String username;
    @NotNull(message ="password bos olamaz")
    @Size(min = 4,message = "sifre en az 4 karakter olmalidir")
    private String password;
    @NotNull(message ="aktiflik durumu bos olamaz")
    private boolean enabled;
    @NotNull(message ="roller bos olamaz")
    private List<RoleDTO> rolesDTO=new ArrayList<>();

}
