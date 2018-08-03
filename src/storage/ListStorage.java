package storage;

import model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage{
    private List<Resume> storage = new ArrayList<>();

    @Override
    protected void saveResume(Object key, Resume resume) {
        storage.add(resume);
    }

    @Override
    protected void deleteResume(Object key) {
        int index = (Integer) key;
        storage.remove(index);
    }

    @Override
    protected void updateResume(Object key, Resume resume) {
        int index = (Integer) key;
        storage.set(index, resume);
    }

    @Override
    protected Resume getResume(Object key) {
        int index = (Integer) key;
        return storage.get(index);
    }

    @Override
    public Resume[] getAll() {
        return storage.toArray(new Resume[0]);
    }

    @Override
    public void clear() {
        storage.removeAll(storage);
        System.out.println("storage empty");
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    protected Integer getKey(String uuid) {
        for (Resume resume : storage){
            if (resume.getUuid().equals(uuid)){
                return storage.indexOf(resume);
            }
        }
        return -1;
    }
}
