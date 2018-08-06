package storage;


import exceptions.ExistUuidException;
import exceptions.NotExistUuidException;
import model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractStorageTest {
    protected Storage storage;

    public AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    private static final String UUID_1 = "uuid_1";
    private static final String UUID_2 = "uuid_2";
    private static final String UUID_3 = "uuid_3";
    private static final String UUID_4 = "uuid_4";
    private static final String FULL_NAME_1 = "DmitriiPanov";
    private static final String FULL_NAME_2 = "NikolayAprelev";
    private static final String FULL_NAME_3 = "IrinaPuzanova";
    private static final String FULL_NAME_4 = "EvgeniiPupkin";
    private static final Resume resume_1 = new Resume(UUID_1, FULL_NAME_1);
    private static final Resume resume_2 = new Resume(UUID_2, FULL_NAME_2);
    private static final Resume resume_3 = new Resume(UUID_3, FULL_NAME_3);
    private static final Resume UPDATE_RESUME = new Resume(UUID_3);
    protected static final Resume TEST_EXCEPTION = new Resume("TEST", "EXCEPTION");


    @Before
    public void setUp() {
        storage.clear();
        storage.save(resume_1);
        storage.save(resume_2);
        storage.save(resume_3);
    }

    @Test
    public void saveNewResume() {
        storage.save(new Resume(UUID_4, FULL_NAME_4));
        Assert.assertEquals(4, storage.size());
    }

    @Test(expected = ExistUuidException.class)
    public void saveExistResume() {
        storage.save(UPDATE_RESUME);
    }

    @Test(expected = NotExistUuidException.class)
    public void deleteNotExistResume() {
        storage.delete(TEST_EXCEPTION.getUuid());
    }

    @Test
    public void deleteExistResume() {
        storage.delete(UUID_2);
        Assert.assertEquals(2, storage.size());
    }

    @Test
    public void clear() {
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void updateExistResume() {
        storage.update(UPDATE_RESUME);
        Assert.assertEquals(UPDATE_RESUME, storage.get(UUID_3));
    }

    @Test(expected = NotExistUuidException.class)
    public void updateNotExistResume() {
        storage.update(TEST_EXCEPTION);
    }

    @Test(expected = NotExistUuidException.class)
    public void getNotExistResume() {
        storage.get(TEST_EXCEPTION.getUuid());
    }

    @Test
    public void getExistResume() {
        Assert.assertEquals(UPDATE_RESUME, storage.get(UUID_3));
    }

    @Test
    public void getAllSorted() {
        List<Resume> sortedResume = new ArrayList<Resume>(Arrays.asList(resume_1,resume_2,resume_3));
        sortedResume.sort(new Resume.ResumeFullNameComarator());
        Assert.assertArrayEquals(sortedResume.toArray(), storage.getAllSorted().toArray());
    }


    @Test
    public void size() {
        Assert.assertEquals(3,storage.size());
    }
}