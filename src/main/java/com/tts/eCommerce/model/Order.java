package com.tts.eCommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Order {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  
  @NotEmpty(message = "Order must have a name")
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
  
  public Order(Long id, String name,
      String description) {
    this.id = id;
    this.name = name;
    this.description = description;
  }
  
  public Order() {}
  
  @Override
  public String toString() {
    return "Order [id=" + id + ", name=" + name
        + ", description=" + description + "]";
  }
  
}
