package com.stitchable.persistence;

import com.stitchable.entity.Pattern;
import com.stitchable.entity.User;
import com.stitchable.testUtils.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class UserDaoTest {

    GenericDao dao;

    @BeforeEach
    void setUp() {
        dao = new GenericDao(User.class);

        Database database = Database.getInstance();
        database.runSQL("reset.sql");
    }

    @Test
    void getAllUsersSuccess() {
        List<User> users = dao.getAll();
        assertEquals(3,users.size());
    }

    @Test
    void getByIdSuccess() {
        User retrievedUser = (User)dao.getById(2);
        assertNotNull(retrievedUser);
        assertEquals("Rey Hinnendael", retrievedUser.getName());
    }

    @Test
    void getByPropertyEqualsSuccess() {
        List<User> users = dao.getByPropertyEquals("name", "Maleficent Racchini");
        assertEquals(1,users.size());
    }

    @Test
    void getByPropertyLikeSuccess() {
        List<User> users = dao.getByPropertyLike("email", "c");
        assertEquals(3,users.size());
    }

    @Test
    void insertSuccess() {
        User newUser = new User("figaro@macarthurpark.com","FigaroTheCat","Figaro Hinnendael", false);
        int id = dao.insert(newUser);
        assertNotEquals(0,id);
        User insertedUser = (User)dao.getById(id);
        assertEquals(newUser,insertedUser);
    }

    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(1));
        assertNull(dao.getById(1));
    }

    @Test
    void saveOrUpdateSuccess() {
        String newUsername = "Murderpaws";
        User userToUpdate = (User)dao.getById(2);
        userToUpdate.setUserName(newUsername);
        dao.saveOrUpdate(userToUpdate);
        User retrievedUser = (User)dao.getById(2);
        assertEquals(userToUpdate, retrievedUser);
    }

    @Test
    void userExistsSuccess() {
        String username = "queenofmean";
        User user = (User) dao.getByPropertyEqualsUnique("userName", username);
        boolean userExists;
        if (user != null) {
            userExists = true;
        } else {
            userExists = false;
        }
        assertTrue(userExists);
        System.out.println(user.toString());
        assertEquals("Maleficent Racchini", user.getName());
    }

    @Test
    void userFavoritePatternsSuccess() {
        String username = "kmracchini";
        User user = (User) dao.getByPropertyEqualsUnique("userName", username);
        assertEquals("Kristin Racchini", user.getName());
        Set<Pattern> favorites = user.getFavoritePatterns();
        assertEquals(2, favorites.size());
    }
}
