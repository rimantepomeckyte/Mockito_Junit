import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MockitoTest {
    Student studentLocal;
    StudentDAO studentDAO;
    @Mock
    StudentDAOI studentDAOI;
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Before
    public void setUp() {
        studentDAO = new StudentDAO(studentDAOI);
        studentLocal = new Student("Antanelis11", "IT 18/1 T", 2.5, "KTU", 9, "2021-02-26");
    }

    @Test
    public void searchByIdTest() {
        Student studentRemote = new Student("Antanelis11", "IT 18/1 T", 2.5, "KTU", 9, "2021-02-26");
        when(studentDAOI.searchById(1)).thenReturn(studentRemote);
        isStudentEqual(studentLocal, studentDAO.searchById(1));
        verify(studentDAOI).searchById(1);

    }

    private void isStudentEqual(Student studentLocal, Student studentRemote){
        Assert.assertEquals(studentLocal.getId(), studentRemote.getId());

    }

}
