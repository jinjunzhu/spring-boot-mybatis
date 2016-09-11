package boot.service;

import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import boot.domain.Department;
import boot.repository.DepartmentRepository;


@Service
//@EnableTransactionManagement
public class DepartmentService {

	@Resource
	private DepartmentRepository departmentRepository;
	
	@Transactional(readOnly=true)
	public Department getDepartment(String name){
		return departmentRepository.getDepartment(name);
	}
	
	@Transactional(value="secondTransactionManager",propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED,rollbackFor=Exception.class)
	public void insertDepartment(Department department) throws IOException{
		departmentRepository.insertDepartment(department);
		//throw new IOException("test rollback");
	}

}
