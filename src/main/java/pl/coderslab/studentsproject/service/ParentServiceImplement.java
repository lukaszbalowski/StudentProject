package pl.coderslab.studentsproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.coderslab.studentsproject.model.Parent;
import pl.coderslab.studentsproject.repository.ParentRepository;

import java.util.List;

@Service
public class ParentServiceImplement implements ParentService {

    @Autowired
    ParentRepository parentRepository;

    @Override
    public List<Parent> getAllParents() {
        return parentRepository.findAll();
    }

    @Override
    public Parent getParentById(long parentId) {
        return parentRepository.findById(parentId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid parent ID: " + parentId));
    }

    @Override
    public List<Parent> getAllParentsSortedByIdDesc() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        return parentRepository.findAll(sort);
    }

    @Override
    public void updateParent(Parent parent) {
    parentRepository.save(parent);
    }

    @Override

    public Page<Parent> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortField).ascending() : Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.parentRepository.findAll(pageable);
    }


}
