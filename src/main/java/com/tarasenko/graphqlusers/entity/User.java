package com.tarasenko.graphqlusers.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User
{

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private long id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "age")
  private Integer age;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "company_id")
  private Company company;

  @OneToOne(targetEntity = Position.class)
  @JoinColumn(name = "position_id")
  private Position position;

}
