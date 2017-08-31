package com.example.harshad.nimap.model;

import java.util.ArrayList;

/**
 * Created by harshad on 24/08/2017.
 */

public class Data {

    private String CategoryName;
    private ArrayList<CategoryImage>categoryImageArrayList;

    public ArrayList<CategoryImage> getCategoryImageArrayList() {
        return categoryImageArrayList;
    }

    public void setCategoryImageArrayList(ArrayList<CategoryImage> categoryImageArrayList) {
        this.categoryImageArrayList = categoryImageArrayList;
    }

    public static class CategoryImage{
        private String iphoneImage;

       public String getIphoneImage() {
           return iphoneImage;
       }

       public void setIphoneImage(String iphoneImage) {
           this.iphoneImage = iphoneImage;
       }
   }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }


}
