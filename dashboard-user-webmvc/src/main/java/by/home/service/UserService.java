package by.home.service;

import by.home.pojo.AppRole;
import by.home.pojo.AppUser;
import by.home.pojo.RoleName;
import by.home.repository.AppRoleRepository;
import by.home.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.logging.Logger;

@Service
public class UserService {

    private Logger log = Logger.getLogger(UserService.class.getName());

    @Autowired
    private AppUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AppRoleRepository roleRepository;

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public boolean saveUser(AppUser user) {
        log.info("Saving user = " + user);
        if (user == null || user.getName().isEmpty()
                || user.getEmail().isEmpty()
                || user.getPassword().isEmpty()
                || userRepository.findUserByEmail(user.getEmail()) != null)
            return false;
        AppRole userRole = roleRepository.findByRoleName(RoleName.USER);
        if (userRole == null) {
            userRole = new AppRole();
            userRole.setName(RoleName.USER);
            roleRepository.save(userRole);
        }
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        log.info("Encoded password: " + encodedPassword);
        user.setPassword(encodedPassword);
        user.setRoles(Set.of(userRole));
        userRepository.save(user);
        return true;
    }
}
