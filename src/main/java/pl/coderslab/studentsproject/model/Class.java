package pl.coderslab.studentsproject.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "classes")
@Getter
@Setter
public class Class {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // TODO dodać relację one to many z students
    @Column(name = "class_id")
    private long id;

    @Column(name = "class_name")
    private String className;

    @OneToMany(mappedBy = "classId", cascade = CascadeType.ALL)
    private List<Student> students;

    @Column(name = "description", length = 1000)
    private String description;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "class_teacher",
            joinColumns = @JoinColumn(name = "class_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id")
    )
    private List<Teacher> teachers;
}
