package SpringBootTest.testData;
import lombok.Data;

@Data
public class LoginCase {
    private String id;
    private String userName;
    private String password;
    private String expected;

}
