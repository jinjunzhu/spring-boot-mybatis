package boot.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import boot.domain.Employee;
import boot.repository.dao1.EmployeeRepository;

@Service
public class EmployeeService {

	@Resource
	private EmployeeRepository employeeRepository;

	public Employee getEmployee(String name){
		return employeeRepository.getEmployeeByName(name);
	}

	@Transactional(value="firstTransactionManager",rollbackFor=Exception.class)
	public void insertEmployee(Employee employee){
		employeeRepository.insertEmployee(employee);
	}

}
