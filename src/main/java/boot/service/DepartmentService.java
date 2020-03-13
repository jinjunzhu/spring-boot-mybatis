package boot.service;

import javax.annotation.Resource;

import org.junit.Assert;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import boot.domain.Department;
import boot.repository.dao2.DepartmentRepository;

@Service
public class DepartmentService {

	@Resource
	private DepartmentRepository departmentRepository;


	@Transactional(value="secondTransactionManager", rollbackFor=Exception.class)
	public Department getDepartment(String name){
		return departmentRepository.getDepartment(name);
	}

	@Transactional(value="secondTransactionManager", rollbackFor=Exception.class)
	public void insertDepartment(Department department) throws Exception {
		departmentRepository.insertDepartment(department);
	}

}
