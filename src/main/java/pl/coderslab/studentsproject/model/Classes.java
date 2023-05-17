package pl.coderslab.studentsproject.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "classes")
@Getter
@Setter
public class Classes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // TODO dodać relację one to many z students
    @Column(name = "class_id")
    private long id;

    @Column(name = "class_name")
    private String className;

    @Column(name = "description", length = 1000)
    private String description;
}
