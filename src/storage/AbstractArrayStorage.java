package storage;

import exceptions.StorageException;
import model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    @Override
    protected void saveResume(Object index, Resume resume) {
        if (size != storage.length){
            putInStorage((Integer) index, resume);
            size++;
        } else {
            throw new StorageException("OverFlow", resume.getUuid());
        }
    }

    @Override
    protected void deleteResume(Object index) {
        deleteFromStorage((Integer)index);
        storage[size - 1] = null;
        size--;
    }

    @Override
    protected void updateResume(Object index, Resume resume) {
        storage[(Integer) index] = resume;
    }

    @Override
    protected Resume getResume(Object index) {
        return storage[(Integer) index];
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



    @Override
    protected boolean isExist(Object key) {
        return (Integer)key >= 0;
    }



    protected abstract Integer getKey(String uuid);
    protected abstract void putInStorage(int index, Resume resume);
    protected abstract void deleteFromStorage(int index);
}
