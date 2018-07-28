package storage;

import exceptions.NotExistUuidException;
import model.Resume;

public abstract class AbstractStorage implements Storage {
    protected int size = 0;

    @Override
    public void update(Resume resume) {
        int index = indexOfResume(resume.getUuid());
        if (index >= 0){
            updateResume(index, resume);
            System.out.println(resume.getUuid() + " is update");
        } else {
            throw new NotExistUuidException(resume.getUuid());
        }
    }

    @Override
    public void delete(String uuid) {
        int index = indexOfResume(uuid);
        if (index >= 0){
            deleteFromStorage(index);
            size--;
            System.out.println("resume '"  + uuid + "'  delete");
        } else {
            throw new NotExistUuidException(uuid);
        }
    }

    @Override
    public Resume get(String uuid) {
        int index = indexOfResume(uuid);
        if (index >= 0){
            System.out.println("resume: " + uuid);
            return getResume(index);
        }
        throw new NotExistUuidException(uuid);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        clearStorage();
        size = 0;
        System.out.println("storage empty");
    }

    protected abstract void clearStorage();
    protected abstract Resume getResume(int index);
    protected abstract void deleteFromStorage(int index);
    protected abstract void updateResume(int index, Resume resume);
    protected abstract int indexOfResume(String uuid);
}
