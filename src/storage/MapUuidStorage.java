package storage;

import model.Resume;

import java.util.List;

public class MapUuidStorage extends AbstractStorage {
    @Override
    protected List<Resume> getAll() {
        return null;
    }

    @Override
    protected boolean isExist(Object key) {
        return false;
    }

    @Override
    protected void saveResume(Object key, Resume resume) {

    }

    @Override
    protected void updateResume(Object key, Resume resume) {

    }

    @Override
    protected Object getKey(String uuid) {
        return null;
    }

    @Override
    protected void deleteResume(Object key) {

    }

    @Override
    protected Resume getResume(Object key) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return 0;
    }
}
