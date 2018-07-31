package storage;

import exceptions.StorageException;
import model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    @Override
    protected void saveResume(Resume resume) {
        if (size != storage.length){
            int index = getIndex(resume.getUuid());
            putInStorage(index, resume);
            size++;
        } else {
            throw new StorageException("OverFlow", resume.getUuid());
        }
    }

    @Override
    protected void deleteResume(String uuid) {
        int index = getIndex(uuid);
        deleteFromStorage(index);
        storage[size - 1] = null;
        size--;
    }

    @Override
    protected void updateResume(Resume resume) {
        int index = getIndex(resume.getUuid());
        storage[index] = resume;
    }

    @Override
    protected Resume getResume(String uuid) {
        int index = getIndex(uuid);
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

    protected abstract int getIndex(String uuid);
    protected abstract void putInStorage(int index, Resume resume);
    protected abstract void deleteFromStorage(int index);
}
