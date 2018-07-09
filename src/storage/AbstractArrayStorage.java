package storage;

import model.Resume;
import java.util.Arrays;

public abstract class AbstractArrayStorage implements IStorage {
    protected static final int STORAGE_LIMIT = 3;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
        System.out.println("storage empty");
    }

    @Override
    public void update(Resume r) {
        int index = indexOfResume(r.getUuid());
        if (index != -1){
            storage[index] = r;
            System.out.println(storage[index].toString() + " is update");
        }
        else {
            System.out.println("resume not found");
        }
    }

    @Override
    public Resume get(String uuid) {
        int index = indexOfResume(uuid);
        if (index != -1){
            System.out.println("resume: " + uuid);
            return storage[index];
        }
        System.out.println("resume not found");
        return null;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    @Override
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    @Override
    public int size() {
        return size;
    }



    protected abstract int indexOfResume(String uuid);

}
