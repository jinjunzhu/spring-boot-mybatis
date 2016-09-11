package boot.service;

import javax.annotation.Resource;

import org.junit.Test;

import boot.domain.Employee;
import boot.service.EmployeeService;
import boot.support.SpringTxTestCase;

public class EmployeeServiceTest extends SpringTxTestCase{

	@Resource
	private EmployeeService employeeService;
	
	@Test
	public void testGetEmployee(){
		Employee employee = employeeService.getEmployee("zhujinjun");
		assertEquals("9部", employee.getDepartment());
	}

	@Test
	public void testInsertEmployee(){
		Employee employee = employeeService.getEmployee("lisi");
		assertNull(employee);
		
		Employee employee1 = new Employee();
		employee1.setName("lisi");
		employee1.setDepartment("4部");
		employee1.setNumber(2002950l);
		employeeService.insertEmployee(employee1);
		
		employee = employeeService.getEmployee("lisi");
		assertNotNull(employee);
		
	}
}
