package pl.coderslab.studentsproject.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.ToString;



@Entity
@Table(name = "students")
@Getter
@Setter
public class Student {

   @Id
   @GeneratedValue(strategy= GenerationType.IDENTITY)
   @Column (name="student_id")
   private Long id;

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
   private Integer parentId;

//   @ManyToOne
//   @JoinColumn(name = "classId")
//   private Class class;

   @Column(name="class_id")
   private Integer classId;



}
