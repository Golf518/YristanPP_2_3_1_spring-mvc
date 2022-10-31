package web.dao;

import org.springframework.stereotype.Component;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class UserDaoImp implements UserDAO{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUser() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();

    }

    @Override
    public void saveUsers(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUsers(int id) {
        User user = getUsers(id);
        entityManager.remove(user);
    }

    @Override
    public User getUsers(int id) {
        TypedQuery<User> query = entityManager.createQuery("select u from User u where u.id=:id", User.class);
        query.setParameter("id", id);
        return query.getResultList().stream().findAny().orElse(null);
    }

    @Override
    public void updateUsers(User updateUsers) {
        entityManager.merge(updateUsers);
        entityManager.flush();

    }
}

