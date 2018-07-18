package storage;

import exceptions.ExistUuidException;
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
    private static Resume resumeUpdate = new Resume(UUID_1);

    @Before
    public void setUp() {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @Test
    public void save() {
        try {
            storage.save(new Resume(UUID_3));
            Assert.assertEquals(4, storage.size());
        } catch (ExistUuidException e){
            System.out.println(e);
        } catch (StorageException e){
            System.out.println("Storage overflow");
        }
    }

    @Test
    public void delete() {
        try {
            storage.delete("TEST");
            Assert.assertEquals(2, storage.size());
        } catch (NotExistUuidException e){
            System.out.println(e);
        }

    }

    @Test
    public void clear() {
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void update() {
        try {
            storage.update(resumeUpdate);
            Assert.assertEquals(resumeUpdate ,storage.get(UUID_1));
        }catch (NotExistUuidException e){
            System.out.println(e);
        }
    }

    @Test
    public void get() {
        try {
            Assert.assertEquals(new Resume(UUID_1),storage.get(UUID_1));
        } catch (NotExistUuidException e){
            System.out.println(e);
        }
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