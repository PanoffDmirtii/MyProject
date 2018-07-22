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
    private static final Resume TEST_UUID_3 = new Resume(UUID_3);
    private static final Resume UUID_EXCEP = new Resume("EXCEPTION");


    @Before
    public void setUp() {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @Test ()
    public void save_NewResume() {
        for (int i = storage.size(); i <AbstractArrayStorage.STORAGE_LIMIT ; i++) {
            storage.save(new Resume("uuid_" + (i+1)));
        }
    }

    @Test (expected = ExistUuidException.class)
    public void save_ExistResume() {
        storage.save(TEST_UUID_3);
    }

    @Test (expected = StorageException.class)
    public void save_OverFlow() {
        for (int i = storage.size(); i <AbstractArrayStorage.STORAGE_LIMIT ; i++) {
            storage.save(new Resume("uuid_" + (i+1)));
        }
        storage.save(UUID_EXCEP);
    }


    @Test (expected = NotExistUuidException.class)
    public void delete_NotExistResume() {
        storage.delete(UUID_EXCEP.getUuid());
    }

    @Test ()
    public void delete_ExistResume() {
        storage.delete(UUID_2);
        Assert.assertEquals(2, storage.size());
    }

    @Test
    public void clear() {
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

    @Test ()
    public void update_ExistResume() {
        storage.update(TEST_UUID_3);
        Assert.assertEquals(TEST_UUID_3, storage.get(UUID_3));
    }

    @Test (expected = NotExistUuidException.class)
    public void update_NotExistResume() {
        storage.update(UUID_EXCEP);
    }

    @Test (expected = NotExistUuidException.class)
    public void get_NotExistResume() {
        storage.get(UUID_EXCEP.getUuid());
    }

    @Test ()
    public void get_ExistResume() {
        Assert.assertEquals(TEST_UUID_3, storage.get(UUID_3));
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