package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }


   @Override
   public void add(Car car) {
      sessionFactory.getCurrentSession().save(car);
   }


   @Override
   public List<Car> listCars() {
      TypedQuery<Car> query=sessionFactory.getCurrentSession().createQuery("from Car");
      return query.getResultList();
   }


   public User getUserByCar(String model, int series) {
      TypedQuery<User> typedQuery
              = sessionFactory.getCurrentSession().createQuery("from User u where u.car.model = :model and u.car.Series = : series", User.class);
      typedQuery.setParameter("model", model).setParameter("series", series);
      return typedQuery.getSingleResult();
   }
}
