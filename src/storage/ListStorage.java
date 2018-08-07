package storage;

import model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    private List<Resume> storage = new ArrayList<>();

    @Override
    protected void saveResume(Object index, Resume resume) {
        storage.add(resume);
    }

    @Override
    protected void deleteResume(Object index) {
        storage.remove((int) index);
    }

    @Override
    protected void updateResume(Object index, Resume resume) {
        storage.set((int) index, resume);
    }

    @Override
    protected Resume getResume(Object index) {
        return storage.get((int) index);
    }

    @Override
    protected List<Resume> getAll() {
        return new ArrayList<>(storage).subList(0,storage.size());
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
        for (Resume resume : storage) {
            if (resume.getUuid().equals(uuid)) {
                return storage.indexOf(resume);
            }
        }
        return -1;
    }

    @Override
    protected boolean isExist(Object key) {
        return (Integer) key >= 0;
    }
}