package com.tts.eCommerce.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

@Entity
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "product_id")
  private Long id;

  @NotBlank(message = "A product must have a brand name")
  private String brand;
  @NotBlank(message = "A product must have a model")
  private String model;
  @NotBlank(message = "A product must have a name")
  private String name;

  @PositiveOrZero(message = "A product cannot have a negative cost price")
  private Double costPrice;
  @PositiveOrZero(message = "A product cannot have a negative retail price")
  private Double retailPrice;
  @PositiveOrZero(message = "A product cannot have a negative inventory")
  private Integer inventory;
  private String description;
  private String imageUrl;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "product_category", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
  private Set<Order> categories;

  public Long getId() {
    return id;
  }

  public String getBrand() {
    return brand;
  }

  public String getModel() {
    return model;
  }

  public String getName() {
    return name;
  }

  public Double getCostPrice() {
    return costPrice;
  }

  public Double getRetailPrice() {
    return retailPrice;
  }

  public Integer getInventory() {
    return inventory;
  }

  public String getDescription() {
    return description;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public Set<Order> getCategories() {
    return categories;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setCostPrice(Double costPrice) {
    this.costPrice = costPrice;
  }

  public void setRetailPrice(Double retailPrice) {
    this.retailPrice = retailPrice;
  }

  public void setInventory(Integer inventory) {
    this.inventory = inventory;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public void setCategories(Set<Order> categories) {
    this.categories = categories;
  }

  public Product(Long id,
      @NotBlank(message = "A product must have a brand name") String brand,
      @NotBlank(message = "A product must have a model") String model,
      @NotBlank(message = "A product must have a name") String name,
      @PositiveOrZero(message = "A product cannot have a negative cost price") Double costPrice,
      @PositiveOrZero(message = "A product cannot have a negative retail price") Double retailPrice,
      @PositiveOrZero(message = "A product cannot have a negative inventory") Integer inventory,
      String description, String imageUrl,
      Set<Order> categories) {
    this.id = id;
    this.brand = brand;
    this.model = model;
    this.name = name;
    this.costPrice = costPrice;
    this.retailPrice = retailPrice;
    this.inventory = inventory;
    this.description = description;
    this.imageUrl = imageUrl;
    this.categories = categories;
  }
  
  public Product(Long id,
      @NotBlank(message = "A product must have a brand name") String brand,
      @NotBlank(message = "A product must have a model") String model,
      @NotBlank(message = "A product must have a name") String name
      ) {
    this.id = id;
    this.brand = brand;
    this.model = model;
    this.name = name;
  }

  public Product() {
  }

  @Override
  public String toString() {
    return "Product [id=" + id + ", brand=" + brand
        + ", model=" + model + ", name=" + name
        + ", costPrice=" + costPrice + ", retailPrice="
        + retailPrice + ", inventory=" + inventory
        + ", description=" + description + ", imageUrl="
        + imageUrl + ", categories=" + categories + "]";
  }

}
