package code.dailycodebuffer.departmentservice.Repository;

import code.dailycodebuffer.departmentservice.Entity.departmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface departmentRepository extends JpaRepository<departmentEntity, Long> {

    departmentEntity findByDepartmentID(Long id);

}
