package web.dao;


import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import web.models.User;

import java.util.List;

@Component
public class UserDAOImp implements UserDAO {

    private static int USERS_CONT=1;

    private final JdbcTemplate jdbcTemplate;

    public UserDAOImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> getListUser() {
        return jdbcTemplate.query("SELECT * FROM users", new BeanPropertyRowMapper<>(User.class));
    }

    public User getUserById(int id) {
        return jdbcTemplate.query("SELECT * FROM users WHERE id = ?", new Object[]{id},
                new BeanPropertyRowMapper<>(User.class)).stream().findAny().orElse(null);
    }

    @Override
    public void addUser(User user) {
        jdbcTemplate.update("INSERT INTO users VALUES(?, ?, ?, ?)",
                USERS_CONT++, user.getFirstName(), user.getLastName(), user.getGender());
    }

    @Override
    public void update(int id, User user) {
        jdbcTemplate.update("UPDATE  users SET firstName=?, lastName=?, gender=? WHERE id=?",
                user.getFirstName(), user.getLastName(), user.getGender(), user.getId());
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM users WHERE id=?", id);
    }
}
