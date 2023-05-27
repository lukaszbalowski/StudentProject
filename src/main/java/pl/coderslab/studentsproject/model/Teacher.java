package pl.coderslab.studentsproject.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "teachers")
@Getter
@Setter
public class Teacher {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "teacher_id")
        private long id;

        @Column(name = "first_name")
        private String firstName;

        @Column(name = "last_name")
        private String lastName;

        @Column(name = "email")
        private String email;

        @Column(name = "phone")
        private String phone;

        @ManyToMany(mappedBy = "teachers")
        private List<Class> classes;

        @ManyToMany(cascade = CascadeType.ALL)
        @JoinTable(
                name = "teacher_subject",
                joinColumns = @JoinColumn(name = "teacher_id"),
                inverseJoinColumns = @JoinColumn(name = "subject_id")
        )
        private List<Subject> subjects;

    }
