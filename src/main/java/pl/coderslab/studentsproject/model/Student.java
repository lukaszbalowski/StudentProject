package pl.coderslab.studentsproject.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "students")
@Getter
@Setter
public class Student {

   @Id
   @GeneratedValue(strategy= GenerationType.IDENTITY)   // TODO dodać relację many to many z parents
   @Column (name="student_id")
   private long id;

   @Column (name="first_name")
   private String firstName;

   @Column (name="last_name")
   private String lastName;

   @Column (name="email")
   private String email;

   @Column (name="phone")
   private String phone;

   @Column (name="birth_date")
   private String birthDate;

   @Column(name="study_start_date")
   private String studyStartDate;

   @Column (name="parent_id")
   private int parentId;


   @Column(name="class_id")
   private int classId;



}
