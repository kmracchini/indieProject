package com.stitchable.persistence;

import com.stitchable.entity.Pattern;
import com.stitchable.entity.User;
import com.stitchable.testUtils.Database;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type User dao test.
 */
@Log4j2
/**
 * Unit tests for user entity using generic dao
 */
public class UserDaoTest {

    /**
     * The Dao.
     */
    GenericDao dao;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        dao = new GenericDao(User.class);

        Database database = Database.getInstance();
        database.runSQL("reset.sql");
    }

    /**
     * Gets all users success.
     */
    @Test
    void getAllUsersSuccess() {
        List<User> users = dao.getAll();
        assertEquals(3,users.size());
    }

    /**
     * Gets by id success.
     */
    @Test
    void getByIdSuccess() {
        User retrievedUser = (User)dao.getById(2);
        assertNotNull(retrievedUser);
        assertEquals("Rey Hinnendael", retrievedUser.getName());
    }

    /**
     * Gets by property equals success.
     */
    @Test
    void getByPropertyEqualsSuccess() {
        List<User> users = dao.getByPropertyEquals("name", "Maleficent Racchini");
        assertEquals(1,users.size());
    }

    /**
     * Gets by property like success.
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<User> users = dao.getByPropertyLike("email", "c");
        assertEquals(3,users.size());
    }

    /**
     * Insert success.
     */
    @Test
    void insertSuccess() {
        User newUser = new User("figaro@macarthurpark.com","FigaroTheCat","Figaro Hinnendael", 0);
        int id = dao.insert(newUser);
        assertNotEquals(0,id);
        User insertedUser = (User)dao.getById(id);
        assertEquals(newUser,insertedUser);
    }

    /**
     * Delete success.
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(1));
        assertNull(dao.getById(1));
    }

    /**
     * Save or update success.
     */
    @Test
    void saveOrUpdateSuccess() {
        String newUsername = "Murderpaws";
        User userToUpdate = (User)dao.getById(2);
        userToUpdate.setUserName(newUsername);
        dao.saveOrUpdate(userToUpdate);
        User retrievedUser = (User)dao.getById(2);
        assertEquals(userToUpdate, retrievedUser);
    }

    /**
     * User exists success.
     */
    @Test
    void userExistsSuccess() {
        String username = "queenofmean";
        User user = (User) dao.getByPropertyEqualsUnique("userName", username);
        boolean userExists;
        userExists = user != null;
        assertTrue(userExists);
        assertEquals("Maleficent Racchini", user.getName());
    }

    /**
     * User favorite patterns success.
     */
    @Test
    void userFavoritePatternsSuccess() {
        String username = "kmracchini";
        User user = (User) dao.getByPropertyEqualsUnique("userName", username);
        assertEquals("Kristin Racchini", user.getName());
        Set<Pattern> favorites = user.getFavoritePatterns();
        assertEquals(1, favorites.size());
    }

    /**
     * Add favorite success.
     */
    @Test
    void addFavoriteSuccess() {
        GenericDao patternDao = new GenericDao(Pattern.class);
        Pattern pattern = (Pattern)patternDao.getById(1);
        User user = (User)dao.getById(1);
        user.addFavorite(pattern);
        Set<Pattern> favorites = user.getFavoritePatterns();
        assertEquals(2, favorites.size());
    }
}
