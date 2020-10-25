package com.seandev.scratch.app;

import org.springframework.data.annotation.Id;

public class Customer {

  @Id
  public String id;

  public String firstName;
  public String lastName;
  public int count;

  public Customer() {}

  public Customer(String firstName, String lastName, int count) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.count = count;
  }
  
  public void increment() {
	  count ++;
  }
  
  public void decrement() {
	  count --;
  }

  @Override
  public String toString() {
    return String.format(
        "Customer[id=%s, firstName='%s', lastName='%s']",
        id, firstName, lastName);
  }

}