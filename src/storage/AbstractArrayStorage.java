package storage;

import exceptions.StorageException;
import model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    @Override
    protected void saveResume(Object key, Resume resume) {
        int index = (Integer) key;
        if (size != storage.length){
            putInStorage(index, resume);
            size++;
        } else {
            throw new StorageException("OverFlow", resume.getUuid());
        }
    }

    @Override
    protected void deleteResume(Object key) {
        int index = (Integer) key;
        deleteFromStorage(index);
        storage[size - 1] = null;
        size--;
    }

    @Override
    protected void updateResume(Object key, Resume resume) {
        int index = (Integer) key;
        storage[index] = resume;
    }

    @Override
    protected Resume getResume(Object key) {
        int index = (Integer) key;
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
        Arrays.fill(storage, 0, size, null);
        size = 0;
        System.out.println("storage empty");
    }

    @Override
    public int size() {
        return size;
    }

    protected abstract Integer getKey(String uuid);
    protected abstract void putInStorage(int index, Resume resume);
    protected abstract void deleteFromStorage(int index);
}
