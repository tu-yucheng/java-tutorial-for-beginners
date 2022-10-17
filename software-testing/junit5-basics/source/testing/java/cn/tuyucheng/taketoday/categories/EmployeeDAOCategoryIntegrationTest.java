package cn.tuyucheng.taketoday.categories;

import cn.tuyucheng.taketoday.junit.tags.example.Employee;
import cn.tuyucheng.taketoday.junit.tags.example.EmployeeDAO;
import cn.tuyucheng.taketoday.junit.tags.example.SpringJdbcConfig;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringJdbcConfig.class}, loader = AnnotationConfigContextLoader.class)
public class EmployeeDAOCategoryIntegrationTest {

    @Autowired
    private EmployeeDAO employeeDao;

    @Mock
    private JdbcTemplate jdbcTemplate;
    private EmployeeDAO employeeDAO;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
        employeeDAO = new EmployeeDAO();
        employeeDAO.setJdbcTemplate(jdbcTemplate);
    }

    @Test
    @Category(IntegrationTest.class)
    public void testAddEmployeeUsingSimpleJdbcInsert() {
        final Employee emp = new Employee();
        emp.setId(12);
        emp.setFirstName("testFirstName");
        emp.setLastName("testLastName");
        emp.setAddress("testAddress");

        Assert.assertEquals(employeeDao.addEmployeeUsingSimpleJdbcInsert(emp), 1);
    }

    @Test
    @Category(UnitTest.class)
    public void givenNumberOfEmployeeWhenCountEmployeeThenCountMatch() {
        // given
        Mockito.when(jdbcTemplate.queryForObject(Mockito.any(String.class), Mockito.eq(Integer.class))).thenReturn(1);

        // when
        int countOfEmployees = employeeDAO.getCountOfEmployees();

        // then
        assertThat(countOfEmployees, CoreMatchers.is(1));
    }
}