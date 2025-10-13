package apis;

import org.junit.jupiter.api.Test;
import org.noear.solon.test.HttpTester;
import org.noear.solon.test.SolonTest;
import com.fliad.Application;

/**
 * @author noear 2022/10/26 created
 */
@SolonTest(Application.class)
public class WelcomeTest extends HttpTester {
    @Test
    public void WELCOME() throws Exception {
        assert path("/").get().equals("WELCOME");
    }
}
