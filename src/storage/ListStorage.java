package storage;

import model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage{
    private List<Resume> storage = new ArrayList<>();

    @Override
    protected void saveResume(Resume resume) {
        storage.add(resume);
    }

    @Override
    protected Resume getResume(String uuid) {
        int index = checkResume(uuid);
        return storage.get(index);
    }

    @Override
    public Resume[] getAll() {
        return storage.toArray(new Resume[storage.size()]);
    }

    @Override
    public void clear() {
        storage.removeAll(storage);
    }

    @Override
    protected void deleteFromStorage(String uuid) {
        int index = checkResume(uuid);
        storage.remove(index);
    }

    @Override
    protected int checkResume(String uuid) {
        for (Resume resume : storage){
            if (resume.getUuid().equals(uuid)){
                return storage.indexOf(resume);
            }
        }
        return -1;
    }

    @Override
    protected void updateResume(Resume resume) {
        storage.set(storage.indexOf(resume), resume);
    }

    @Override
    public int size() {
        return storage.size();
    }
}
