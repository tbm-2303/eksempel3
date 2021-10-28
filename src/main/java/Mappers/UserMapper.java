package Mappers;

import objects.User;
import org.omg.CORBA.UserException;


import java.sql.*;

public class UserMapper {
    private Database database;

    public UserMapper(Database database) {
        this.database = database;
    }

    public User Login(String email, String password) throws Services.UserException {
        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM user WHERE email=? AND password=?";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, email);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    int userID = rs.getInt("id_user");
                    User user = new User(email, password);
                    user.setId(userID);
                    return user;
                } else {
                    throw new Services.UserException("could not validate user");
                }
            } catch (SQLException e) {
                throw new Services.UserException(e.getMessage());
            }
        } catch (SQLException ex) {
            throw new Services.UserException("Connection to database could not be established");
        }
    }


    public User SignUp(User user) throws Services.UserException {
        try (Connection connection = database.connect()) {
            String sql = "INSERT INTO user (email, password) VALUES (?, ?)";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, user.getEmail());
                ps.setString(2, user.getPassword());
                ps.executeUpdate();
                ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                int id = ids.getInt(1);
                user.setId(id);
                return user;
            } catch (SQLException ex) {
                throw new Services.UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new Services.UserException(ex.getMessage());
        }
    }

}
