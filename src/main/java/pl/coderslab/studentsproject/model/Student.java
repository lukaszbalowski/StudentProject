package pl.coderslab.studentsproject.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="students")
@Getter
@Setter
@ToString
public class Student {

   @Id
   @GeneratedValue(strategy= GenerationType.IDENTITY)   // TODO dodać relację many to many z parents
   private long id;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private String birthDate;

    private String studyStartDate;


}
