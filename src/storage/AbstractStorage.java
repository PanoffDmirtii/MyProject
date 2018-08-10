package storage;

import exceptions.ExistUuidException;
import exceptions.NotExistUuidException;
import model.Resume;

import java.util.Collections;
import java.util.List;

public abstract class AbstractStorage implements Storage {
    protected abstract List<Resume> getAll();
    protected abstract boolean isExist(Object key);
    protected abstract void saveResume(Object key, Resume resume);
    protected abstract void updateResume(Object key, Resume resume);
    protected abstract Object getKey(String uuid);
    protected abstract void deleteResume(Object key);
    protected abstract Resume getResume(Object key);

    @Override
    public void save(Resume resume) {
        saveResume(getKeyIfNotExist(resume.getUuid()), resume);
        System.out.println("Resume " + resume.getUuid() + " save in storage");
    }

    @Override
    public void delete(String uuid) {
        deleteResume(getKeyIfExist(uuid));
        System.out.println("Resume " + uuid + " delete from storage");

    }

    @Override
    public void update(Resume resume) {
        updateResume(getKeyIfExist(resume.getUuid()), resume);
        System.out.println("Resume " + resume.getUuid() + " update in storage");
    }

    @Override
    public Resume get(String uuid) {
        return getResume(getKeyIfExist(uuid));
    }

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> resumes = getAll();
        Collections.sort(resumes);
        System.out.println("Return sorted list resumes: " + resumes);
        return resumes;
    }

    private Object getKeyIfExist(String uuid) {
        Object key = getKey(uuid);
        if (isExist(key)){
            return key;
        }
        throw new NotExistUuidException(uuid);
    }

    private Object getKeyIfNotExist(String uuid){
        Object key = getKey(uuid);
        if (!isExist(key) ){
            return key;
        }
        throw new ExistUuidException(uuid);
    }
}
