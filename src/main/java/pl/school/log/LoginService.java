package pl.school.log;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public boolean validateUser(String userid, String password) {
        return userid.equalsIgnoreCase("darek")
                && password.equalsIgnoreCase("123");
    }

}
