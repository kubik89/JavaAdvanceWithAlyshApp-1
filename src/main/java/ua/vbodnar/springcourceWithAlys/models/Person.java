package ua.vbodnar.springcourceWithAlys.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person {
    private int id;

    @NotEmpty(message = "Name couldn't be empty")
    @Size(min = 2, max = 20, message = "Name could be between 2 and 20 letters")
    private String name;

//    @NotEmpty (message = "Age couldn't be empty") - не працює з int Значеннями
    @Min(value = 0, message = "Age must equal 0 or more")
    private int age;

    @NotEmpty(message = "Email couldn't be empty")
    @Email(message = "Email must be valid")
    private String email;


}
