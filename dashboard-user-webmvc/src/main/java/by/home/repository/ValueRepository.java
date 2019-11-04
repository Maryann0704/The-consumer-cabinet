package by.home.repository;

import by.home.pojo.Value;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ValueRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Value> findAll(int count) {
        return sessionFactory.getCurrentSession().createQuery("from Value", Value.class)
                .setMaxResults(count)
                .list();
    }

    public Value findValueById(Long id) {
        return sessionFactory.getCurrentSession()
                .get(Value.class,id);
    }

    public List<Value> findByDeviceId(Long deviceId, int count) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Value where deviceId = :param", Value.class)
                .setParameter("param", deviceId)
                .setMaxResults(count)
                .list();
    }

    public List<Value> findValueByDate(String date, int count) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Value where measureDate like :param2", Value.class)
                .setParameter("param2", '%'+date+'%')
                .setMaxResults(count)
                .list();
    }

    public boolean add(Value value) {
        sessionFactory.getCurrentSession().persist(value);
        return true;
    }
}