package by.home.security;

import by.home.pojo.AppUser;
import by.home.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class AuthService implements UserDetailsService {

    private static Logger log = Logger.getLogger(AuthService.class.getName());

    @Autowired
    private AppUserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) {
        AppUser appUser = userRepository.findUserByEmail(username);
        if (appUser == null) {
            throw new UsernameNotFoundException("User not found");
        }
        User user = new User(appUser.getEmail(),
                appUser.getPassword(),
                appUser.getAppRoles().stream()
                        .map(appRole -> new SimpleGrantedAuthority("ROLE_"+
                                appRole.getName().name()))
                        .collect(Collectors.toSet()));
        log.info("Returned user: " + user);
        return user;
    }
}
