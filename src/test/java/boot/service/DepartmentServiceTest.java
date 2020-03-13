package boot.service;

import boot.domain.Department;
import boot.support.AbstractSpringbootTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author jinjunzhu
 * @date 2020/3/12
 */
public class DepartmentServiceTest extends AbstractSpringbootTest {

    @Resource
    private DepartmentService departmentService;

    @Test
    public void testGet(){
        Assert.assertTrue(departmentService.getDepartment("department1").getLevel() == 1);
    }

    @Test
    @Transactional(value="secondTransactionManager", rollbackFor=Exception.class)
    public void testInsert() throws Exception{
        Assert.assertNull(departmentService.getDepartment("jinjunzhu"));

        Department department = new Department();
        department.setLevel(2);
        department.setName("jinjunzhu");
        department.setId(2l);
        departmentService.insertDepartment(department);

        Department department1 = departmentService.getDepartment("jinjunzhu");
        Assert.assertNotNull(department1);
    }
}
