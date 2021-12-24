package code.dailycodebuffer.departmentservice.Service;

import code.dailycodebuffer.departmentservice.Entity.departmentEntity;
import code.dailycodebuffer.departmentservice.Repository.departmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class departmentService {

    @Autowired
    private departmentRepository departmentRepository;

    public departmentEntity GetDepartment(Long id) {
        return departmentRepository.findByDepartmentID(id);
    }

    public departmentEntity SaveDepartment(departmentEntity dept) {
        return departmentRepository.save(dept);
    }
}
