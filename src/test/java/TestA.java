import com.gsh.Service.StudentService;
import com.gsh.Service.impl.StudentServiceImpl;

import com.gsh.domain.Student;
import com.gsh.utils.ServiceFactory;
import org.junit.Test;

import java.util.List;

public class TestA {
    @Test
    public void test01(){

        StudentServiceImpl ss = new StudentServiceImpl();

        List<Student> allStudent = ss.getAllStudent();


    }

    @Test
    public void test02(){

        StudentService ss = (StudentService) ServiceFactory.getService(new StudentServiceImpl());

        List<Student> allStudent = ss.getAllStudent();

        allStudent.forEach(stu-> System.out.println(stu));
    }
}
