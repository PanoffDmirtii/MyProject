package storage;

import exceptions.StorageException;
import model.Resume;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractArrayStorage extends AbstractStorage<Integer> {
    protected static final int STORAGE_LIMIT = 10_000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    protected abstract void putInStorage(int index, Resume resume);
    protected abstract void deleteFromStorage(int index);

    @Override
    protected void saveResume(Integer index, Resume resume) {
        if (size != storage.length){
            putInStorage(index, resume);
            size++;
        } else {
            throw new StorageException("OverFlow", resume.getUuid());
        }
    }

    @Override
    protected void deleteResume(Integer index) {
        deleteFromStorage(index);
        storage[size - 1] = null;
        size--;
    }

    @Override
    protected void updateResume(Integer index, Resume resume) {
        storage[index] = resume;
    }

    @Override
    protected Resume getResume(Integer index) {
        return storage[index];
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    @Override
    protected List<Resume> getAll() {
        return Arrays.asList(storage).subList(0, size);
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
    protected boolean isExist(Integer key) {
        return key >= 0;
    }
}
