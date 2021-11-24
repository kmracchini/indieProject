package com.stitchable.persistence;

import com.stitchable.entity.Designer;
import com.stitchable.entity.Pattern;
import com.stitchable.testUtils.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.constraintvalidation.SupportedValidationTarget;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PatternDaoTest {

    GenericDao dao;

    @BeforeEach
    void setup() {
        dao = new GenericDao(Pattern.class);

        Database database = Database.getInstance();
        database.runSQL("reset.sql");
    }

    @Test
    void getAllSuccess() {
        List<Pattern> patterns = dao.getAll();
        assertEquals(2,patterns.size());
    }

    @Test
    void getByIdSuccess() {
        Pattern pattern = (Pattern)dao.getById(1);
        assertNotNull(pattern);

        GenericDao designerDao = new GenericDao(Designer.class);
        Designer designer = (Designer)designerDao.getById(2);

        assertEquals(designer, pattern.getDesigner());
    }

    @Test
    void getByPropertyEqualsSuccess() {
        List<Pattern> patterns = dao.getByPropertyEquals("features","Full Stitches Only");
        assertEquals(2, patterns.size());
    }

    @Test
    void getByPropertyLikeSuccess() {
        List<Pattern> patterns = dao.getByPropertyLike("url","http");
        assertEquals(2, patterns.size());
    }

    @Test
    void insertSuccess() {
        GenericDao designerDao = new GenericDao(Designer.class);
        Designer designer = (Designer)designerDao.getById(1);
        Pattern newPattern = new Pattern("Test Pattern", 50, 50, 2, "cool",
                "Full Stitches Only", "No", "test.jpg", "http://www.google.com", designer);
        int id = dao.insert(newPattern);
        assertNotEquals(0,id);
        Pattern insertedPattern = (Pattern)dao.getById(id);
        assertEquals(newPattern, insertedPattern);
    }

    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(2));
        assertNull(dao.getById(2));
    }

    @Test
    void saveOrUpdateSuccess() {
        String newPatternName = "Test Pattern";
        Pattern patternToUpdate = (Pattern)dao.getById(1);
        patternToUpdate.setName(newPatternName);
        dao.saveOrUpdate(patternToUpdate);
        Pattern retrievedPattern = (Pattern)dao.getById(1);
        assertEquals(patternToUpdate, retrievedPattern);
    }

    @Test
    void greaterThanSuccess() {
        List<Pattern> patterns = dao.getByGreaterThan("numberOfColors", 2);
        assertEquals(1, patterns.size());
    }

    @Test
    void lessThanSuccess() {
        List<Pattern> patterns = dao.getByLessThan("numberOfColors", 10);
        assertEquals(2, patterns.size());
    }
}
