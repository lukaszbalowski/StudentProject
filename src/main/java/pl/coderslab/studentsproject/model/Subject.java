package pl.coderslab.studentsproject.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "subjects")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id")
    private long id;

    @Column(name = "subject_name")
    private String subjectName;

    @Column(name = "subject_description")
    private String subjectDescription;

    @ManyToMany(mappedBy = "subjects")
    private List<Teacher> teachers;

}
