package boot.service;

import javax.annotation.Resource;

import boot.support.AbstractSpringbootTest;
import org.junit.Assert;
import org.junit.Test;
import boot.domain.Employee;

public class EmployeeServiceTest extends AbstractSpringbootTest {

	@Resource
	private EmployeeService employeeService;
	
	@Test
	public void testGetEmployee(){
		Employee employee = employeeService.getEmployee("jinjunzhu");
		Assert.assertEquals("department", employee.getDepartment());
	}

	@Test
	public void testInsertEmployee(){
		Employee employee = employeeService.getEmployee("wangwu");
		Assert.assertNull(employee);
		
		Employee employee1 = new Employee();
		employee1.setName("wangwu");
		employee1.setDepartment("4");
		employee1.setNumber(2002950l);
		employeeService.insertEmployee(employee1);
		
		employee = employeeService.getEmployee("wangwu");
		Assert.assertNotNull(employee);
		
	}
}
