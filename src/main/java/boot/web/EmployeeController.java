package boot.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import boot.domain.Employee;
import boot.service.EmployeeService;


@Controller
public class EmployeeController {

	@Resource
	private EmployeeService employeeService;
	
	@RequestMapping("/employee/{name}")
	@ResponseBody
	public String getEmployeebyName(@PathVariable String name){
		Employee employee = employeeService.getEmployee(name);
		return null == employee?null:employee.getDepartment();
	}
	
	@RequestMapping("/employee/save/{name}/{department}/{number}")
	@ResponseBody
	public String saveEmployeebyName(@PathVariable String name,@PathVariable String department,@PathVariable Long number){
		Employee employee = new Employee();
		employee.setName(name);
		employee.setDepartment(department);
		employee.setNumber(number);
		try{
			employeeService.insertEmployee(employee);
			return "success!";
		}catch(Exception e){
			return e.toString();
		}
	}

}
