package storage;

import exceptions.ExistUuidException;
import exceptions.NotExistUuidException;
import model.Resume;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public abstract class AbstractStorage<T> implements Storage {
    protected abstract List<Resume> getAll() throws IOException;
    protected abstract boolean isExist(T key);
    protected abstract void saveResume(T key, Resume resume);
    protected abstract void updateResume(T key, Resume resume);
    protected abstract T getKey(String uuid);
    protected abstract void deleteResume(T key);
    protected abstract Resume getResume(T key);

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
    public List<Resume> getAllSorted(){
        List<Resume> resumes = null;
        try {
            resumes = getAll();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.sort(resumes);
        System.out.println("Return sorted list resumes: " + resumes);
        return resumes;
    }

    private T getKeyIfExist(String uuid) {
        T key = getKey(uuid);
        if (isExist(key)){
            return key;
        }
        throw new NotExistUuidException(uuid);
    }

    private T getKeyIfNotExist(String uuid){
        T key = getKey(uuid);
        if (!isExist(key) ){
            return key;
        }
        throw new ExistUuidException(uuid);
    }
}
