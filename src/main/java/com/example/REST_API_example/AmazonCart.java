package com.example.REST_API_example;

import io.swagger.annotations.ApiModelProperty;

public class AmazonCart {
    //this annotation belongs to swagger ..
    //it is used to get clarity on important Model fields in swagger UI..
    //It indicates important model fields with asterisk (*) mark.
    @ApiModelProperty(notes = "product id",name = "id",required = true)
    private int id;
    private String name;
    private int price;

    public AmazonCart(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
