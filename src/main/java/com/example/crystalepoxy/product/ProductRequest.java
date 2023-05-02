package com.example.crystalepoxy.product;

import java.util.List;

public class ProductRequest {

    private String name;
    private List<String> descriptions;
    private Integer width;
    private Integer height;
    private Integer length;
    private Integer price;
    private String category;
    private String image;

    public ProductRequest(String name, List<String> descriptions, Integer width, Integer height, Integer length, Integer price, String category, String image) {
        this.name = name;
        this.descriptions = descriptions;
        this.width = width;
        this.height = height;
        this.length = length;
        this.price = price;
        this.category = category;
        this.image = image;
    }


    public  ProductRequest(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<String> descriptions) {
        this.descriptions = descriptions;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    // Constructors, getters, and setters
}