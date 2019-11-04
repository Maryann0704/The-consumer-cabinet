package by.home.repository;

import by.home.pojo.AppUser;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.logging.Logger;

@Repository
public class AppUserRepository {

    private static Logger log = Logger.getLogger(AppUserRepository.class.getName());

    @Autowired
    private SessionFactory sessionFactory;

    public void save(AppUser user) {
        log.info("Save user: " + user);
        sessionFactory.getCurrentSession().save(user);
    }

    public AppUser findUserByEmail(String email) {
        try {
            return sessionFactory.getCurrentSession()
                    .createQuery("from AppUser where email like :param1", AppUser.class)
                    .setParameter("param1", email)
                    .getSingleResult();
        } catch (Exception e) {
            log.warning(e.getMessage());
            return null;
        }
    }

}
