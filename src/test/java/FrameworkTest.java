import org.testng.annotations.Test;
import com.automationpractice.base.BaseTest;
import com.automationpractice.base.TestUtilities;

public class FrameworkTest extends BaseTest {
	
	@Test
	public void smokeTest() {
		driver.get("http://automationpractice.com/index.php");
		TestUtilities.sleep(3000);
	}

}
