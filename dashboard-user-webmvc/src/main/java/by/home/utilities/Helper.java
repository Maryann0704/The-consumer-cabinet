package by.home.utilities;

import by.home.pojo.AppUser;
import by.home.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

public class Helper {

    @Autowired
    private static AppUserRepository userRepository;


    public static AppUser getAppUser() {
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepository.findUserByEmail(email);
    }

}
