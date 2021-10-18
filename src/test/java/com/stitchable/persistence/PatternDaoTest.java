package com.stitchable.persistence;

import com.stitchable.entity.Pattern;
import com.stitchable.testUtils.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PatternDaoTest {

    GenericDao dao;

    @BeforeEach
    void setup() {
        dao = new GenericDao(Pattern.class);

        Database database = Database.getInstance();
        database.runSQL("reset.sql");
    }

}
