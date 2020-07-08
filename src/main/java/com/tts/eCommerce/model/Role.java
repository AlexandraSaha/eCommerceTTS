package com.tts.eCommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="role_id")
  private Long id;
  
  private String role;

  public Long getId() {
    return id;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public Role(Long id, String role) {
    this.id = id;
    this.role = role;
  }

  public Role() {}

  @Override
  public String toString() {
    return "Role [id=" + id + ", role=" + role + "]";
  }
  
}
