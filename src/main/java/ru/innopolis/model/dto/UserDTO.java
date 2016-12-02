package ru.innopolis.model.dto;

/**
 * This class is used to transfer data to user table
 */
public class UserDTO {
    private int id;
    private String firstName;
    private String secondName;
    private String email;
    private String password;

    public UserDTO() {
    }

    public UserDTO(int id, String firstName, String secondName, String email, String password) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

