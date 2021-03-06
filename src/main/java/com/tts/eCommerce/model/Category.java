package com.tts.eCommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Category {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name = "category_id")
  private Long id;
  
  @NotEmpty(message = "Category must have a name")
  private String name;
  private String description;
  
  public Long getId() {
    return id;
  }
  
  public String getName() {
    return name;
  }
  
  public String getDescription() {
    return description;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public void setDescription(String description) {
    this.description = description;
  }
  
  public Category(Long id, String name,
      String description) {
    this.id = id;
    this.name = name;
    this.description = description;
  }
  
  public Category() {}
  
  @Override
  public String toString() {
    return "Category [id=" + id + ", name=" + name
        + ", description=" + description + "]";
  }
  
}
