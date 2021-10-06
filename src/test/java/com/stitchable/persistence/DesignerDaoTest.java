package com.stitchable.persistence;

import com.stitchable.entity.Designer;
import com.stitchable.testUtils.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DesignerDaoTest {

    GenericDao dao;

    @BeforeEach
    void setUp() {
        dao = new GenericDao(Designer.class);

        Database database = Database.getInstance();
        database.runSQL("reset.sql");
    }

    @Test
    void getAllSuccess() {
        List<Designer> designers = dao.getAll();
        assertEquals(2,designers.size());
    }

    @Test
    void getByIdSuccess() {
        Designer designer = (Designer)dao.getById(1);
        assertNotNull(designer);
        assertEquals("Subversive Cross Stitch", designer.getName());
    }

    @Test
    void getByPropertyEqualsSuccess() {
        List<Designer> designers = dao.getByPropertyEquals("name","The Witchy Stitcher");
        assertEquals(1,designers.size());
    }

    @Test
    void getByPropertyLikeSuccess() {
        List<Designer> designers = dao.getByPropertyLike("website","http");
        assertEquals(2,designers.size());
    }

    @Test
    void insertSuccess() {
        Designer newDesigner = new Designer("Satsuma Street","https://satsumastreet.com/");
        int id = dao.insert(newDesigner);
        assertNotEquals(0,id);
        Designer insertedDesigner = (Designer)dao.getById(id);
        assertEquals(newDesigner,insertedDesigner);
    }
}
