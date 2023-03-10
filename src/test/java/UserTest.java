import com.example.usertest.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserTest {

    private User use1;
    private User use2;
    private String login;
    private String email;
    private final String EM = "@";
    private final String EML = ".";
    private final String userEmail = "New12er@1.";

    @Before
    public void createNullUser() {
        use1 = new User();
    }
    @Test
    public  void newUserShouldHaveNullLoginAndEmail () {
        Assert.assertEquals(null, use1.getEmail());
        Assert.assertEquals(null, use1.getLogin());
    }

    @Before
    public void createNewUser() {
        use2 = new User(login, email);
    }

    @Test
    public  void newUserShouldContainLoginAndEmail() {
        Assert.assertNotNull(use2.getLogin());
        Assert.assertNotNull(use2.getEmail());
    }

    @Test
    public void newUserShouldHaveLoginNotEgualEmail() {
        Assert.assertNotEquals(use2.getLogin(), use2.getEmail());
    }

    @Test
    public void newUserShouldHaveCorrectEmail() {
        String result = use2.createEmail(userEmail);
        Assert.assertTrue(result.contains(EML));
        Assert.assertTrue(result.contains(EM));
        Assert.assertEquals(userEmail, use2.getEmail());

    }
}
