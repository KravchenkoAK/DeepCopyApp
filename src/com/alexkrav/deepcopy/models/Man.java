package com.alexkrav.deepcopy.models;

import java.util.List;

public class Man {
    private String name;
    private int age;
    private List<String> favoriteBooks;
    private Address address;
    private boolean isResident;


    public Man(String name, int age, List<String> favoriteBooks, Address address, boolean isResident) {
        this.name = name;
        this.age = age;
        this.favoriteBooks = favoriteBooks;
        this.address = address;
        this.isResident = isResident;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getFavoriteBooks() {
        return favoriteBooks;
    }

    public void setFavoriteBooks(List<String> favoriteBooks) {
        this.favoriteBooks = favoriteBooks;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
