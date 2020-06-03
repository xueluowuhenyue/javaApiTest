package SpringBootTest.testData;
import lombok.Data;

@Data
public class UserInfo {
    private String userName;
    private String age;

    public UserInfo(String userName, String age) {
        this.userName = userName;
        this.age = age;
    }

    public UserInfo() {
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public String getAge() {
        return age;
    }
}
