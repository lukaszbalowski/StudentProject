package pl.coderslab.studentsproject.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="classes")
@Getter
@Setter
@ToString
public class Classes {  // toto zdrobić relację many to many z students
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private String name;

    private String description;


}
