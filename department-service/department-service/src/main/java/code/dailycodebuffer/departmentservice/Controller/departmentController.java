package code.dailycodebuffer.departmentservice.Controller;

import code.dailycodebuffer.departmentservice.Entity.departmentEntity;
import code.dailycodebuffer.departmentservice.Service.departmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
public class departmentController {
    @Autowired
    private departmentService departmentService;

    @PostMapping("/")
    public departmentEntity SaveDepartment(@RequestBody departmentEntity dept){
        return departmentService.SaveDepartment(dept);
    }

    @GetMapping("/{id}")
    public departmentEntity GetDepartment(@PathVariable("id") Long id){
        return departmentService.GetDepartment(id);
    }

}
