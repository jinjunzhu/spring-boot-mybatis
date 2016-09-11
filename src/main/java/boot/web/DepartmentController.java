package boot.web;

import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import boot.domain.Department;
import boot.service.DepartmentService;

@Controller
public class DepartmentController {

	@Resource
	private DepartmentService departmentService;
	
	@RequestMapping("/department/{name}")
	@ResponseBody
	public String getDepartment(@PathVariable String name){
		Department department = departmentService.getDepartment(name);
		return null == department?null:department.getName();
	}
	
	@RequestMapping("/department/save/{name}/{level}")
	@ResponseBody
	public String insertDepartment(@PathVariable String name,@PathVariable Integer level){
		Department department = new Department();
		department.setName(name);
		department.setLevel(level);
		try {
			departmentService.insertDepartment(department);
		} catch (IOException e) {
			return e.toString();
		}
		return "success!";
	}

}
