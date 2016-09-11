package boot.repository;

import org.springframework.stereotype.Repository;

import boot.domain.Employee;
import boot.support.AbstractMybatisDaoSupport;


@Repository
public class EmployeeRepository extends AbstractMybatisDaoSupport<Employee>{

	public Employee getEmployeeByName(String name){
		return selectOne(firstSqlSession,"Employee.getEmployeeByName", name);
	}
	
	public void insertEmployee(Employee employee){
		insert(firstSqlSession,"Employee.saveEmployee", employee);
	}
	
	public void updateEmployee(Employee employee){
		update(firstSqlSession,"Employee.updateEmployee", employee);
	}

}
