package boot.repository.dao1;

import org.springframework.context.annotation.DependsOn;

import boot.domain.Employee;


@DependsOn("mybatisConfig")
public interface EmployeeRepository{

	Employee getEmployeeByName(String name);
	
	void insertEmployee(Employee employee);
	
	void updateEmployee(Employee employee);

}
