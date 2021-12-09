package com.pizza.pizza.dto.user.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaveUserRequestDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
