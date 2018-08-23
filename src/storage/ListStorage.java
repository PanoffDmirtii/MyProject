package storage;

import model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage<Integer> {
    private List<Resume> storage = new ArrayList<>();

    @Override
    protected void saveResume(Integer index, Resume resume) {
        storage.add(resume);
    }

    @Override
    protected void deleteResume(Integer index) {
        storage.remove((int)index);
    }

    @Override
    protected void updateResume(Integer index, Resume resume) {
        storage.set(index, resume);
    }

    @Override
    protected Resume getResume(Integer index) {
        return storage.get(index);
    }

    @Override
    protected List<Resume> getAll() {
        return new ArrayList<>(storage).subList(0,storage.size());
    }

    @Override
    public void clear() {
        storage.clear();
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
    protected boolean isExist(Integer key) {
        return key >= 0;
    }
}