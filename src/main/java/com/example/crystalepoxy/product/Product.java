package com.example.crystalepoxy.product;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
@Table
public class Product {
    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    private Long id;
    private String name;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ProductDescription> descriptions = new ArrayList<>();
    private Integer width;
    private Integer height;
    private Integer length;
    private Integer price;
    private String category;
    private String image;


    public Product(Long id,String name, List<String> descriptionStrings, Integer width, Integer height, Integer length, Integer price, String category, String image) {

        this.id = id;
        this.name = name;
        this.width = width;
        this.height = height;
        this.length = length;
        this.price = price;
        this.category = category;
        this.image = image;

        if (descriptionStrings != null) {
            for (String description : descriptionStrings) {
                this.descriptions.add(new ProductDescription(description, this));
            }
        }
    }
    public Product(String name, List<String> descriptionStrings, Integer width, Integer height, Integer length, Integer price, String category, String image) {
        this.name = name;
        this.width = width;
        this.height = height;
        this.length = length;
        this.price = price;
        this.category = category;
        this.image = image;

        if (descriptionStrings != null) {
            for (String description : descriptionStrings) {
                this.descriptions.add(new ProductDescription(description, this));
            }
        }
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProductDescription> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<ProductDescription> descriptions) {
        this.descriptions = descriptions;
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

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", descriptions=" + descriptions +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}