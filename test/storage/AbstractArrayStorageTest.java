package storage;

import exceptions.NotExistUuidException;
import exceptions.StorageException;
import model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AbstractArrayStorageTest {
    private Storage storage;

    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    private static final String UUID_1 = "uuid_1";
    private static final String UUID_2 = "uuid_2";
    private static final String UUID_3 = "uuid_3";
    private static final String UUID_EXCEP = "EXCEPTION";
    private static final Resume TEST_UUID_3 = new Resume(UUID_3);


    @Before
    public void setUp() {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @Test (expected = StorageException.class)
    public void save() {
        try {
            for (int i = storage.size(); i <AbstractArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume("uuid_" + (i+1)));
            }
        } catch (StorageException e) {
            Assert.fail("StorageException");
        }
        storage.save(new Resume("OVERFLOW"));
    }


    @Test (expected = NotExistUuidException.class)
    public void delete() {
        storage.delete(UUID_2);
        Assert.assertEquals(2, storage.size());
        storage.delete(UUID_EXCEP);
    }

    @Test
    public void clear() {
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

    @Test (expected = NotExistUuidException.class)
    public void update() {
        storage.update(TEST_UUID_3);
        Assert.assertEquals(TEST_UUID_3, storage.get(UUID_3));
        storage.update(new Resume(UUID_EXCEP));
    }

    @Test (expected = NotExistUuidException.class)
    public void get() {
        Assert.assertEquals(new Resume(UUID_3), storage.get(UUID_3));
        storage.get(UUID_EXCEP);
    }

    @Test
    public void getAll() {
        Resume[] testStorage = {storage.get(UUID_1),storage.get(UUID_2), storage.get(UUID_3)};
        Assert.assertArrayEquals(testStorage, storage.getAll());
    }

    @Test
    public void size() {
        Assert.assertEquals(3, storage.size());
    }
}