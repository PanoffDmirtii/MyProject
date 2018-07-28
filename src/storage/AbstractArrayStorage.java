package storage;

import exceptions.ExistUuidException;
import exceptions.StorageException;
import model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];

    @Override
    public void save(Resume newResume) {
        if (size != storage.length) {
            int index = indexOfResume(newResume.getUuid());
            if (index < 0) {
                putInStorage(index, newResume);
                System.out.println("resume '"  + newResume.getUuid() + "'  save in storage");
                size++;
            } else {
                throw new ExistUuidException(newResume.getUuid());
            }
        } else {
            throw new StorageException(newResume.getUuid(), "Storage overflow");
        }
    }

    @Override
    protected Resume getResume(int index) {
        return storage[index];
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    @Override
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    @Override
    public void clear() {
        clearStorage();
        Arrays.fill(storage, 0, size, null);
        size = 0;
        System.out.println("storage empty");
    }

    public void clearStorage(){
        Arrays.fill(storage, 0, size, null);
    }

    protected abstract int indexOfResume(String uuid);
    protected abstract void deleteFromStorage(int index);
    protected abstract void putInStorage(int index, Resume resume);
}
