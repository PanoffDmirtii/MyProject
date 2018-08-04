package storage;

import model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {
    private Map<String, Resume> storage = new HashMap<>();



    @Override
    protected void saveResume(Object uuid, Resume resume) {
        storage.put((String) uuid, resume);
    }

    @Override
    protected void deleteResume(Object uuid) {
        storage.remove(uuid);
    }

    @Override
    protected void updateResume(Object uuid, Resume resume) {
        storage.put((String) uuid, resume);
    }

    @Override
    protected Resume getResume(Object uuid) {
        return storage.get(uuid);
    }

    @Override
    public Resume[] getAll() {
        return storage.values().toArray(new Resume[0]);
    }

    @Override
    public void clear() {
        storage.clear();
        System.out.println("Storage empty");
    }

    @Override
    public int size() {
        return storage.size();
    }

    /**
     * Check resume in storage
     * @return i if storage contain resume
     *        -1 if not found
     */
    protected String getKey(String uuid) {
        return uuid;
    }

    @Override
    protected boolean isExist(Object key) {
        return storage.containsKey(key);
    }
}
