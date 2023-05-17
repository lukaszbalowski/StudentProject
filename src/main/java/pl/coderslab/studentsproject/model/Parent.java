package pl.coderslab.studentsproject.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="parents")
@Getter
@Setter
@ToString
public class Parent {  // todo dodać relację many to many z students

        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        private long id;

        private String firstName;

        private String lastName;

        private String email;

        private String phone;


    }


