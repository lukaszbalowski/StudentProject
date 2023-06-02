package pl.coderslab.studentsproject.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Entity
@Table(name = "classes")
@Getter
@Setter
public class Class {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id")
    private long id;

    @Column(name = "class_name")
    private String className;

    @OneToMany(mappedBy = "classId", cascade = CascadeType.ALL)
    private List<Student> students;

    @Column(name = "description", length = 1000)
    private String description;

    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(
            name = "class_teacher",
            joinColumns = @JoinColumn(name = "class_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id")
    )
    private List<Teacher> teachers;

    public void addTeacher(Teacher teacher) throws SQLIntegrityConstraintViolationException {
         try {
                teachers.add(teacher);
                teacher.getClasses().add(this);
            } catch (Exception ex) {

                if (ex instanceof SQLIntegrityConstraintViolationException) {
                    throw new SQLIntegrityConstraintViolationException("Błąd podczas dodawania nauczyciela do klasy");
                } else {
                    throw ex;
                }
            }
        }


    public void removeTeacher(Teacher teacher) {

        teachers.remove(teacher);
        teacher.getClasses().remove(this);
    }

}
