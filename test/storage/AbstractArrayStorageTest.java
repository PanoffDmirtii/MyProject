package storage;

import model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AbstractArrayStorageTest {
    private Storage storage;
    private Resume resume = new Resume("uuid_4");

    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    private static final String UUID_1 = "uuid_1";
    private static final String UUID_2 = "uuid_2";
    private static final String UUID_3 = "uuid_3";

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @Test
    public void save() {
        storage.save(resume);
        Assert.assertEquals(4, storage.size());
        //storage.save(resume);
    }

    @Test
    public void delete() {
        storage.save(resume);
        storage.delete(resume.getUuid());
        Assert.assertEquals(3, storage.size());
        //Assert.assertNotEquals(resume, storage.get(resume.getUuid()));
        //Assert.assertEquals(resume, storage.get("TEST"));
    }

    @Test
    public void clear() {
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void update() {
        storage.save(resume);
        storage.update(resume);
        Assert.assertEquals(resume,storage.get("uuid_4"));
    }

    @Test
    public void get() {
        storage.save(resume);
        Assert.assertEquals(resume, storage.get("uuid_4"));
        //Assert.assertEquals(resume, storage.get(UUID_1));
        //Assert.assertEquals(resume, storage.get("TEST"));

    }

    @Test
    public void getAll() {
        Resume[] testStorage = {new Resume(UUID_1),new Resume(UUID_2), new Resume(UUID_3)};
        Assert.assertArrayEquals(testStorage, storage.getAll());
    }

    @Test
    public void size() {
        Assert.assertEquals(3, storage.size());
    }

}