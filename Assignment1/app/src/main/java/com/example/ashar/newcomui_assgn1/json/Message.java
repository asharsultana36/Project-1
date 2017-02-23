package com.example.ashar.newcomui_assgn1.json;

import java.util.List;

/**
 * Created by ashar on 15/2/17.
 */

public class Message
{
    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }



    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public String getImagePrefixURL() {
        return imagePrefixURL;
    }

    public void setImagePrefixURL(String imagePrefixURL) {
        this.imagePrefixURL = imagePrefixURL;
    }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

    private List<Products> products;
    private int totalPages;
    private int totalCount;
    private String imagePrefixURL;
}
