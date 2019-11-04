package by.home.repository;

import by.home.pojo.Device;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DeviceRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Device> findAll(int count) {
        return sessionFactory.getCurrentSession().createQuery("from Device", Device.class)
                .setMaxResults(count)
                .list();
    }

    public Device findDeviceById(Long id) {
        return sessionFactory.getCurrentSession()
                .get(Device.class,id);
    }

    public List<Device> findByUserId(Long userId, int count) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Device where userId = :param", Device.class)
                .setParameter("param", userId)
                .setMaxResults(count)
                .list();
    }

    public List<Device> findDeviceByType(String type, int count) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Device where type like :param2", Device.class)
                .setParameter("param2", '%'+type+'%')
                .setMaxResults(count)
                .list();
    }

    public List<Device> findDeviceByLocation(String location, int count) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Device where type like :param3", Device.class)
                .setParameter("param3", '%'+location+'%')
                .setMaxResults(count)
                .list();
    }

    public boolean save(Device device) {
        sessionFactory.getCurrentSession().persist(device);
        return true;
    }
}