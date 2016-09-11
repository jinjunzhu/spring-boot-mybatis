package boot.repository;

import org.springframework.stereotype.Repository;

import boot.domain.Department;
import boot.support.AbstractMybatisDaoSupport;

@Repository
public class DepartmentRepository extends AbstractMybatisDaoSupport<Department>{

	public Department getDepartment(String name){
		return selectOne(secondSqlSession, "Department.getDepartment", name);
	}
	
	public void insertDepartment(Department department){
		insert(secondSqlSession, "Department.saveDepartment", department);
	}

}
