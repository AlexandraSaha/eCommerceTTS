package com.tts.eCommerce.model;

import java.sql.Date;
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

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "product_id")
  private Long id;
  @Column(name = "name")
  @NotBlank(message = "Product name cannot be blank") //what is being sold?
  private String name;
  
  @Column(name = "retail_Price")
  @PositiveOrZero(message = "Product retail price cannot be negative") //but is zero really ok?
  private Double retailPrice;
  @Column(name = "cost_Price")
  @PositiveOrZero(message = "Product retail price cannot be negative") //but is zero really ok?
  private Double costPrice;
  @Column(name = "brand")
  @NotBlank(message = "Product brand cannot be blank") //somebody made it, right?
  private String brand;
  @Column(name = "model")
  @NotBlank(message = "Product model cannot be blank")
  private String category;
  @Column(name = "description")
  private String description; //is it ok to create a product and add a description later? or not?
  @Column(name = "inventory")
  private Integer inventory; //negative inventory doesn't really make sense, can't sell it if it isn't there 
  @Column(name = "image_url")
  private String image; //is it ok to create a product and add an image file path later? or not?
  

  

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




public Double getRetailPrice() {
	return retailPrice;
}




public void setRetailPrice(Double retailPrice) {
	this.retailPrice = retailPrice;
}




public Double getCostPrice() {
	return costPrice;
}




public void setCostPrice(Double costPrice) {
	this.costPrice = costPrice;
}




public String getBrand() {
	return brand;
}




public void setBrand(String brand) {
	this.brand = brand;
}




public String getCategory() {
	return category;
}




public void setCategory(String category) {
	this.category = category;
}




public String getDescription() {
	return description;
}




public void setDescription(String description) {
	this.description = description;
}




public Integer getInventory() {
	return inventory;
}




public void setInventory(Integer inventory) {
	this.inventory = inventory;
}




public String getImage() {
	return image;
}




public void setImage(String image) {
	this.image = image;
}




public Product() {
  }

  

}
