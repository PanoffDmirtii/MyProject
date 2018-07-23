package storage;

import exceptions.ExistUuidException;
import exceptions.NotExistUuidException;
import exceptions.StorageException;
import model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public abstract class  AbstractArrayStorageTest {
    private Storage storage;

    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    private static final String UUID_1 = "uuid_1";
    private static final String UUID_2 = "uuid_2";
    private static final String UUID_3 = "uuid_3";
    private static final String UUID_4 = "uuid_4";
    private static final Resume UPDATE_UUID_3 = new Resume(UUID_3);
    private static final Resume UUID_EXCEPTION = new Resume("EXCEPTION");


    @Before
    public void setUp() {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @Test
    public void saveNewResume() {
        storage.save(new Resume(UUID_4));
        Assert.assertEquals(4, storage.size());
    }

    @Test (expected = ExistUuidException.class)
    public void saveExistResume() {
        storage.save(UPDATE_UUID_3);
    }

    @Test (expected = StorageException.class)
    public void saveOverFlow() {
        for (int i = storage.size() + 1; i <= AbstractArrayStorage.STORAGE_LIMIT; i++) {
            storage.save(new Resume("uuid_" + i));
            if (storage.size() > AbstractArrayStorage.STORAGE_LIMIT) {
                Assert.fail("OVERFLOW");
            }
        }
        storage.save(UUID_EXCEPTION);
    }

    @Test (expected = NotExistUuidException.class)
    public void deleteNotExistResume() {
        storage.delete(UUID_EXCEPTION.getUuid());
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
        storage.update(UPDATE_UUID_3);
        Assert.assertEquals(UPDATE_UUID_3, storage.get(UUID_3));
    }

    @Test (expected = NotExistUuidException.class)
    public void updateNotExistResume() {
        storage.update(UUID_EXCEPTION);
    }

    @Test (expected = NotExistUuidException.class)
    public void getNotExistResume() {
        storage.get(UUID_EXCEPTION.getUuid());
    }

    @Test
    public void getExistResume() {
        Assert.assertEquals(UPDATE_UUID_3, storage.get(UUID_3));
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