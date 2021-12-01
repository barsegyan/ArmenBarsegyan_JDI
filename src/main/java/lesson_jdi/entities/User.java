package lesson_jdi.entities;


import com.epam.jdi.tools.DataClass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User extends DataClass<User> {

    private String login = "Roman";
    private String password = "Jdi1234";
    private String fullName = "Roman Iovlev";

}
