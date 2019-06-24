package com.btp.models;

import java.util.ArrayList;

public class NavBar {

    private int careerCategoryId;
    private String categoryName;
    private ArrayList<String> professionName;

    public NavBar(int careerCategoryId, String categoryName, ArrayList<String> professionName) {
        this.careerCategoryId = careerCategoryId;
        this.categoryName = categoryName;
        this.professionName = professionName;
    }

    @Override
    public String toString() {
        return "{" +
            " careerCategoryId=" + getCareerCategoryId() + "" +
            ", categoryName='" + getCategoryName() + "'" +
            ", professionName='" + getProfessionName() + "'" +
            "}";
    }

    public int getCareerCategoryId() {
        return this.careerCategoryId;
    }

    public void setCareerCategoryId(int careerCategoryId) {
        this.careerCategoryId = careerCategoryId;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public ArrayList<String> getProfessionName() {
        return this.professionName;
    }

    public void setProfessionName(ArrayList<String> professionName) {
        this.professionName = professionName;
    }
}