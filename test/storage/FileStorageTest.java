package storage;

public class FileStorageTest extends AbstractStorageTest {

    public FileStorageTest() {
        super(new FileStorage(DIR_STORAGE_RESUME));
    }
}