package boot.service;

import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import boot.domain.Employee;
import boot.repository.EmployeeRepository;

@EnableTransactionManagement
@Service
public class EmployeeService {

	@Resource
	private EmployeeRepository employeeRepository;
	
	@Transactional(readOnly=true)
	public Employee getEmployee(String name){
		return employeeRepository.getEmployeeByName(name);
	}
	
	public void insertEmployee(Employee employee){
		employeeRepository.insertEmployee(employee);
	}
	
	@Transactional(value="firstTransactionManager",propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED,rollbackFor=Exception.class)
	public void insertEmployeeInTransaction(Employee employee) throws IOException{
		employeeRepository.insertEmployee(employee);
		//throw new IOException("test roll back");
	}

}
