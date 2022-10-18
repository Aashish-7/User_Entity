package com.entity.org.entity.example.dto;

public class UsersDto {

    private int userId;

    private String firstName;

    public UsersDto() {
    }

    public UsersDto(String firstName, int userId) {
        this.firstName = firstName;
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getUserId(){
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UsersDto{" +
                "firstName='" + firstName + '\'' +
                '}';
    }
}
