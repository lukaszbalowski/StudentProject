package pl.coderslab.studentsproject.service;
import pl.coderslab.studentsproject.model.Parent;


import java.util.List;

public interface ParentService {

        List<Parent> getAllParents();

        Parent getParentById(long parentId);


    List<Parent> getAllParentsSortedByIdDesc();


    void updateParent(Parent parent);
}

