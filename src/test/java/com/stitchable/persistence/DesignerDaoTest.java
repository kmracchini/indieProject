package com.stitchable.persistence;

import com.stitchable.entity.Designer;
import com.stitchable.entity.Pattern;
import com.stitchable.testUtils.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Designer entity using generic dao
 */
public class DesignerDaoTest {

    /**
     * The Dao.
     */
    GenericDao dao;

    /**
     * Sets up database before tests.
     */
    @BeforeEach
    void setUp() {
        dao = new GenericDao(Designer.class);

        Database database = Database.getInstance();
        database.runSQL("reset.sql");
    }

    /**
     * Gets all designers.
     */
    @Test
    void getAllSuccess() {
        List<Designer> designers = dao.getAll();
        assertEquals(2,designers.size());
    }

    /**
     * Gets by id success.
     */
    @Test
    void getByIdSuccess() {
        Designer designer = (Designer)dao.getById(1);
        assertNotNull(designer);
        assertEquals("Subversive Cross Stitch", designer.getName());
    }

    /**
     * Gets by property equals success.
     */
    @Test
    void getByPropertyEqualsSuccess() {
        List<Designer> designers = dao.getByPropertyEquals("name","The Witchy Stitcher");
        assertEquals(1,designers.size());
    }

    /**
     * Gets by property like success.
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<Designer> designers = dao.getByPropertyLike("website","http");
        assertEquals(2,designers.size());
    }

    /**
     * Insert success.
     */
    @Test
    void insertSuccess() {
        Designer newDesigner = new Designer("Satsuma Street","https://satsumastreet.com/");
        int id = dao.insert(newDesigner);
        assertNotEquals(0,id);
        Designer insertedDesigner = (Designer)dao.getById(id);
        assertEquals(newDesigner,insertedDesigner);
    }

    /**
     * Delete success.
     */
    @Test
    void deleteSuccess() {

        dao.delete(dao.getById(1));
        assertNull(dao.getById(1));

        GenericDao patternDao = new GenericDao(Pattern.class);
        assertNull(patternDao.getById(2));

    }

    /**
     * Save or update success.
     */
    @Test
    void saveOrUpdateSuccess() {
        String newDesignerName = "Made Up Designer";
        Designer designerToUpdate = (Designer)dao.getById(2);
        designerToUpdate.setName(newDesignerName);
        dao.saveOrUpdate(designerToUpdate);
        Designer retrievedDesigner = (Designer)dao.getById(2);
        assertEquals(designerToUpdate,retrievedDesigner);
    }
}
