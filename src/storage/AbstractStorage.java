package storage;

import exceptions.ExistUuidException;
import exceptions.NotExistUuidException;
import model.Resume;

public abstract class AbstractStorage implements Storage {

    @Override
    public void save(Resume resume) {
        if (checkResume(resume.getUuid()) < 0){
            saveResume(resume);
            System.out.println("Resume " + resume.getUuid() + " save in storage");
        } else {
            throw new ExistUuidException(resume.getUuid());
        }
    }

    @Override
    public void update(Resume resume) {
        if (checkResume(resume.getUuid()) >= 0){
            updateResume(resume);
            System.out.println(resume.getUuid() + " is update");
        } else {
            throw new NotExistUuidException(resume.getUuid());
        }
    }

    @Override
    public void delete(String uuid) {
        if (checkResume(uuid) >= 0){
            deleteFromStorage(uuid);
            System.out.println("resume '"  + uuid + "'  delete");
        } else {
            throw new NotExistUuidException(uuid);
        }
    }

    @Override
    public Resume get(String uuid) {
        if (checkResume(uuid) >= 0){
            System.out.println("resume: " + uuid);
            return getResume(uuid);
        }
        throw new NotExistUuidException(uuid);
    }

    protected abstract void saveResume(Resume resume);
    protected abstract int checkResume(String uuid);
    protected abstract Resume getResume(String uuid);
    protected abstract void deleteFromStorage(String uuid);
    protected abstract void updateResume(Resume resume);

}
