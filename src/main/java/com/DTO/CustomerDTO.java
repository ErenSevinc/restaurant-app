package com.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerDTO {
    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private MediaDTO mediaDTO;
}
