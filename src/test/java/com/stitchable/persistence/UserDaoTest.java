package com.stitchable.persistence;

import com.stitchable.entity.User;
import com.stitchable.testUtils.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

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
        assertEquals(2,users.size());
    }

    @Test
    void getByIdSuccess() {
        User retrievedUser = (User)dao.getById(2);
        assertNotNull(retrievedUser);
        assertEquals("Rey", retrievedUser.getFirstName());
    }

    @Test
    void getByPropertyEqualsSuccess() {
        List<User> users = dao.getByPropertyEquals("lastName", "Racchini");
        assertEquals(2,users.size());
    }

    @Test
    void getByPropertyLikeSuccess() {
        List<User> users = dao.getByPropertyLike("email", "c");
        assertEquals(3,users.size());
    }

    @Test
    void insertSuccess() {
        User newUser = new User("Figaro", "Hinnendael", "figaro@macarthurpark.com","FigaroTheCat","ILoveBlankies");
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
}
