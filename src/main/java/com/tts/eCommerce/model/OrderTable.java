package com.tts.eCommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class OrderTable {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name = "order_id")
  private Long id;
  
  @NotEmpty(message = "Order must have a name")
  private String ordername;
  private String description;
  
  public Long getId() {
    return id;
  }
  
  
  public String getOrdername() {
	return ordername;
}


public void setOrdername(String ordername) {
	this.ordername = ordername;
}


public void setId(Long id) {
	this.id = id;
}


public String getDescription() {
    return description;
  }
  
  
  
  public void setDescription(String description) {
    this.description = description;
  }
  
  public OrderTable(Long id, String ordername,
      String description) {
    this.id = id;
    this.ordername = ordername;
    this.description = description;
  }
  
  public OrderTable() {}
  
  @Override
  public String toString() {
    return "Order [id=" + id + ", name=" + ordername
        + ", description=" + description + "]";
  }
  
}
