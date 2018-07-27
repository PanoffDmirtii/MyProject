package storage;

import exceptions.ExistUuidException;
import exceptions.NotExistUuidException;
import exceptions.StorageException;
import model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];

    @Override
    public void save(Resume resume) {
        if (size != storage.length) {
            int index = indexOfResume(resume.getUuid());
            if (index < 0) {
                putInStorage(index, resume);
                System.out.println("resume '"  + resume.getUuid() + "'  save in storage");
                size++;
            } else {
                throw new ExistUuidException(resume.getUuid());
            }
        } else {
            throw new StorageException(resume.getUuid(), "Storage overflow");
        }
    }

    @Override
    public void delete(String uuid) {
        int index = indexOfResume(uuid);
        if (index >= 0){
            deleteFromStorage(index);
            storage[size - 1] = null;
            size--;
            System.out.println("resume '"  + uuid + "'  delete");
        } else {
            throw new NotExistUuidException(uuid);
        }
    }

    @Override
    public void update(Resume resume) {
        int index = indexOfResume(resume.getUuid());
        if (index >= 0){
            storage[index] = resume;
            System.out.println(storage[index].getUuid() + " is update");
        } else {
            throw new NotExistUuidException(resume.getUuid());
        }
    }

    @Override
    public Resume get(String uuid) {
        int index = indexOfResume(uuid);
        if (index >= 0){
            System.out.println("resume: " + uuid);
            return storage[index];
        }
        throw new NotExistUuidException(uuid);
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
