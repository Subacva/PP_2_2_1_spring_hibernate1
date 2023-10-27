package hiber;

import hiber.config.AppConfig;
import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      userService.add(new User("asa", "Lastname4", "user4@mail.ru",new Car(231,"asasa")));
      userService.add(new User("xz", "czxcz", "sdfsd@mail.ru",new Car(11,"dcz")));
      userService.add(new User("asa", "Lastname4", "user4@mail.ru",new Car(214,"211")));


      System.out.println(userService.getUserByCar("211", 214));





//      System.out.println();


//      List<User> users = userService.listUsers();
//      for (User user : users) {
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println("Car = "+user.getCar());
//         System.out.println();
//
      }

//    context.close();
   }

