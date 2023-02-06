package web.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {

    private int id;

    @NotNull(message = "Нельзя добавить человека без имени")
    @NotEmpty(message = "Нельзя добавить человека без имени")
    @Size(min = 2, max = 20, message = "Имя должно содержать не менее 2 и не более 20 символов")
    private String firstName;

    @NotNull(message = "Нельзя добавить человека без фамилии")
    @NotEmpty(message = "Нельзя добавить человека без фамилии")
    @Size(min = 1, max = 40, message = "Фамилия должна содержать не менее 1 и не более 40 символов")
    private String lastName;

    @NotNull(message = "Укажите пол человка")
    @NotEmpty(message = "Укажите пол человка")
    private String gender;

    public User(){}

    public User(int id, String firstName, String lastName, String gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
