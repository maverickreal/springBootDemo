package com.maverick;

import java.util.Objects;
import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

//public record Customer(String name, String email, int id, int age){}

@Entity
public class Customer {
    private String name;
    private String email;
    @Id @SequenceGenerator(name = "customer_id_sequence", sequenceName = "customer_id_sequence", allocationSize = 1) @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_id_sequence")
    private int id;
    private int age;

    public Customer(){}

    public Customer(String name, String email, int id, int age) {
        this.name = name;
        this.email = email;
        this.id = id;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public void setName(String Name){
        name = Name;
    }

    public void setEmail(String Email) {
        email = Email;
    }

    public void setId(int Id) {
        id = Id;
    }

    public void setAge(int Age) {
        age = Age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id &&
                age == customer.age &&
                Objects.equals(name, customer.name) &&
                Objects.equals(email, customer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, id, age);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }
}
