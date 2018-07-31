package storage;

import exceptions.StorageException;
import model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    @Override
    protected boolean checkAndUpdateResume(Resume updateResume) {
        int index = indexOfResume(updateResume.getUuid());
        if (index >= 0){
            storage[index] = updateResume;
            return true;
        }
        return false;
    }

    @Override
    protected boolean checkAndSaveResume(Resume resume) {
        int index = indexOfResume(resume.getUuid());
        if (index < 0){
            if (storage.length != size){
                putInStorage(index, resume);
                size++;
                return true;
            } else {
                throw new StorageException("OverFlow", resume.getUuid());
            }
        }
        return false;
    }

    @Override
    protected boolean checkAndDeleteResume(String uuid) {
        int index = indexOfResume(uuid);
        if (index >= 0){
            deleteResume(index);
            storage[size - 1] = null;
            size--;
            return true;
        }
        return false;
    }

    @Override
    protected Resume getResume(String uuid) {
        int index = indexOfResume(uuid);
        if (index >= 0) {
            return storage[index];
        }
        return null;
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

    protected abstract void deleteResume(int index);
    protected abstract int indexOfResume(String uuid);
    protected abstract void putInStorage(int index, Resume resume);
}
