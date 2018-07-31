package storage;

import exceptions.ExistUuidException;
import exceptions.NotExistUuidException;
import model.Resume;

public abstract class AbstractStorage implements Storage {

    @Override
    public void save(Resume resume) {
        if (checkAndSaveResume(resume)){
            System.out.println("Resume " + resume.getUuid() + " save in storage");
        } else {
            throw new ExistUuidException(resume.getUuid());
        }
    }

    @Override
    public void update(Resume resume) {
        if (checkAndUpdateResume(resume)){
            System.out.println(resume.getUuid() + " is update");
        } else {
            throw new NotExistUuidException(resume.getUuid());
        }
    }

    @Override
    public void delete(String uuid) {
        if (checkAndDeleteResume(uuid)){
            System.out.println("resume '"  + uuid + "'  delete");
        } else {
            throw new NotExistUuidException(uuid);
        }
    }

    @Override
    public Resume get(String uuid) {
        Resume outputResume = getResume(uuid);
        if (outputResume != null){
            System.out.println("resume: " + uuid);
            return outputResume;
        }
        throw new NotExistUuidException(uuid);
    }
    protected abstract boolean checkAndSaveResume(Resume resume);
    protected abstract boolean checkAndUpdateResume(Resume resume);
    protected abstract boolean checkAndDeleteResume(String uuid);
    protected abstract Resume getResume(String uuid);
}
