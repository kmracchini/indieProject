package com.stitchable.persistence;

import com.stitchable.entity.Designer;
import com.stitchable.entity.Pattern;
import com.stitchable.testUtils.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for pattern entity using generic dao
 */
public class PatternDaoTest {

    /**
     * The Dao.
     */
    GenericDao dao;

    /**
     * Sets up database.
     */
    @BeforeEach
    void setup() {
        dao = new GenericDao(Pattern.class);

        Database database = Database.getInstance();
        database.runSQL("reset.sql");
    }

    /**
     * Gets all success.
     */
    @Test
    void getAllSuccess() {
        List<Pattern> patterns = dao.getAll();
        assertEquals(2,patterns.size());
    }

    /**
     * Gets by id success.
     */
    @Test
    void getByIdSuccess() {
        Pattern pattern = (Pattern)dao.getById(1);
        assertNotNull(pattern);

        GenericDao designerDao = new GenericDao(Designer.class);
        Designer designer = (Designer)designerDao.getById(2);

        assertEquals(designer, pattern.getDesigner());
    }

    /**
     * Gets by property equals success.
     */
    @Test
    void getByPropertyEqualsSuccess() {
        List<Pattern> patterns = dao.getByPropertyEquals("features","Full Stitches Only");
        assertEquals(2, patterns.size());
    }

    /**
     * Gets by property like success.
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<Pattern> patterns = dao.getByPropertyLike("url","http");
        assertEquals(2, patterns.size());
    }

    /**
     * Insert success.
     */
    @Test
    void insertSuccess() {
        GenericDao designerDao = new GenericDao(Designer.class);
        Designer designer = (Designer)designerDao.getById(1);
        Pattern newPattern = new Pattern("Test Pattern", 50, 50, 2, "cool",
                "Full Stitches Only", "No", "test.jpg", "http://www.google.com", designer, "Small");
        int id = dao.insert(newPattern);
        assertNotEquals(0,id);
        Pattern insertedPattern = (Pattern)dao.getById(id);
        assertEquals(newPattern, insertedPattern);
    }

    /**
     * Delete success.
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(2));
        assertNull(dao.getById(2));
    }

    /**
     * Save or update success.
     */
    @Test
    void saveOrUpdateSuccess() {
        String newPatternName = "Test Pattern";
        Pattern patternToUpdate = (Pattern)dao.getById(1);
        patternToUpdate.setName(newPatternName);
        dao.saveOrUpdate(patternToUpdate);
        Pattern retrievedPattern = (Pattern)dao.getById(1);
        assertEquals(patternToUpdate, retrievedPattern);
    }

    /**
     * Greater than success.
     */
    @Test
    void greaterThanSuccess() {
        List<Pattern> patterns = dao.getByGreaterThan("numberOfColors", 2);
        assertEquals(1, patterns.size());
    }

    /**
     * Less than success.
     */
    @Test
    void lessThanSuccess() {
        List<Pattern> patterns = dao.getByLessThan("numberOfColors", 10);
        assertEquals(2, patterns.size());
    }

}
