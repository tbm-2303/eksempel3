package Services;

import Mappers.Database;
import Mappers.UserMapper;
import objects.User;
import org.omg.CORBA.UserException;

import java.sql.SQLException;

public class UserFacade {

    UserMapper userMapper;

    public UserFacade(Database database) {

        userMapper = new UserMapper(database);
    }

    public User Login(String email, String password) throws SQLException, Services.UserException {
        return userMapper.Login(email, password);
    }

    public User SignUp(User user) throws SQLException, Services.UserException {
        userMapper.SignUp(user);
        return user;
    }


}
