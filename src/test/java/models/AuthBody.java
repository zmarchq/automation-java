package models;

import lombok.Data;

@Data
public class AuthBody {

    private String email;
    private String password;
}
