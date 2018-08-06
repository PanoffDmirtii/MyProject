package storage;

import exceptions.ExistUuidException;
import exceptions.NotExistUuidException;
import model.Resume;

import java.util.Comparator;

public abstract class AbstractStorage implements Storage {

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
        System.out.println("Resume " + uuid);
        return getResume(getKeyIfExist(uuid));
    }

    protected Object getKeyIfExist(String uuid) {
        Object key = getKey(uuid);
        if (isExist(key)){
            return key;
        }
        throw new NotExistUuidException(uuid);
    }

    protected Object getKeyIfNotExist(String uuid){
        Object key = getKey(uuid);
        if (!isExist(key) ){
            return key;
        }
        throw new ExistUuidException(uuid);
    }

    protected static class ResumeFullNameComarator implements Comparator<Resume> {

        @Override
        public int compare(Resume o1, Resume o2) {
            int value = o1.getFullName().compareTo(o2.getFullName());
            if (value > 0) {
                return 1;
            } else if (value == 0){
                return o1.getUuid().compareTo(o2.getUuid());
            }
            return -1;
        }
    }

    protected abstract boolean isExist(Object key);
    protected abstract void saveResume(Object key, Resume resume);
    protected abstract void updateResume(Object key, Resume resume);
    protected abstract Object getKey(String uuid);
    protected abstract void deleteResume(Object key);
    protected abstract Resume getResume(Object key);
}
