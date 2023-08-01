package com.example.Airbnb.model.userModel;


import com.example.Airbnb.model.imageModel.ImageDto;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;


@Getter
@Setter
@NoArgsConstructor
public class UserDto {

    private long id;
    @NotNull
    @NotEmpty
    private String username;

    private String firstName;
    private String lastName;

    private String email;
    private String number;

    private Boolean approved;

    private ImageDto image;
}
