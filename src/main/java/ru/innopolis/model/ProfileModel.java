package ru.innopolis.model;


public class ProfileModel extends BaseModel{
    private static final long serialVersionUID = -4026015842066544347L;
    private String firstName;
    private String secondName;
    private String username;
    private UserModel user;

    public ProfileModel() {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }
}
