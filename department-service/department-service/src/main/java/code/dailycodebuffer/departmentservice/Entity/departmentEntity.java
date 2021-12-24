package code.dailycodebuffer.departmentservice.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class departmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long departmentID;
    public String departmentName;
    public String departmentAddress;
}
