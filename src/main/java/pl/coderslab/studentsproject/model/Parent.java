package pl.coderslab.studentsproject.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "parents")
@Getter
@Setter
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // TODO dodać relację many to many z students
    @Column(name = "parent_id")
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    public Parent(String firstName, String lastName, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public Parent() {
    }
}