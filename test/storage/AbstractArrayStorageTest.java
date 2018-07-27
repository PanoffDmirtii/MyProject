package storage;

import exceptions.StorageException;
import model.Resume;
import org.junit.Assert;
import org.junit.Test;

public abstract class  AbstractArrayStorageTest extends AbstractStorageTest {
    public AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

    @Test(expected = StorageException.class)
    public void saveOverFlow() {
        try {
            for (int i = 3; i < AbstractArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume("uuid_" + (i + 1)));
            }
        } catch (Exception e) {
            Assert.fail("OVERFLOW");
        }
        storage.save(TEST_EXCEPTION);
    }

}