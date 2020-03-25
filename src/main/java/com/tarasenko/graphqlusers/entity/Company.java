package com.tarasenko.graphqlusers.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "companies")
@Getter
@Setter
public class Company
{

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "description")
  private String description;

  @OneToMany(mappedBy = "company", targetEntity = User.class, cascade = CascadeType.ALL, orphanRemoval = true)
  private List<User> users;

  @OneToMany(mappedBy = "company", targetEntity = Position.class, cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Position> positions;

}
