package boot.repository.dao2;


import boot.domain.Department;
import org.springframework.context.annotation.DependsOn;

@DependsOn("mybatisConfig1")
public interface DepartmentRepository{

	Department getDepartment(String name);

	void insertDepartment(Department department);

}
