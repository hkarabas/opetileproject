import com.main.Main;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(value = Parameterized.class)
public class TestJobs {



    @Parameterized.Parameter
    public String testFile;


    @Parameterized.Parameters(name = "{index}: testFile - {0}")
    public static Object[] data() {
        return new Object[]{
                "jobs.xml",
                "jobs2.xml",
                "jobs3.xml"
        };
    }

    @Test
    public  void MainTest() {

        Main main = new Main(testFile);
        main.TestMain();

    }
}
