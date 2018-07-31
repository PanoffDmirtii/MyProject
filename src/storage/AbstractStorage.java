package storage;

import exceptions.ExistUuidException;
import exceptions.NotExistUuidException;
import model.Resume;

public abstract class AbstractStorage implements Storage {

    @Override
    public void save(Resume resume) {
        if (getIndex(resume.getUuid()) >= 0){
            throw new ExistUuidException(resume.getUuid());
        } else {
            saveResume(resume);
            System.out.println("Resume " + resume.getUuid() + " save in storage");
        }
    }

    @Override
    public void delete(String uuid) {
        if (getKeyIfExist(uuid) >= 0 ){
            deleteResume(uuid);
            System.out.println("Resume " + uuid + " delete from storage");
        }
    }

    @Override
    public void update(Resume resume) {
        if (getKeyIfExist(resume.getUuid()) >= 0){
            updateResume(resume);
            System.out.println("Resume " + resume.getUuid() + " update in storage");
        }
    }

    @Override
    public Resume get(String uuid) {
        getKeyIfExist(uuid);
        System.out.println("Resume " + uuid);
        return getResume(uuid);
    }

    protected int getKeyIfExist(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0){
            return index;
        }
        throw new NotExistUuidException(uuid);
    }

    protected abstract void saveResume(Resume resume);
    protected abstract void updateResume(Resume resume);
    protected abstract int getIndex(String uuid);
    protected abstract void deleteResume(String uuid);
    protected abstract Resume getResume(String uuid);
}
