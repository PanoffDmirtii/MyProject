package storage;

import model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {
    private Map<String, Resume> storage = new HashMap<>();



    @Override
    protected void saveResume(Object key, Resume resume) {
        String uuid = (String) key;
        storage.put(uuid, resume);
    }

    @Override
    protected void deleteResume(Object key) {
        String uuid = (String) key;
        storage.remove(uuid);
    }

    @Override
    protected void updateResume(Object key, Resume resume) {
        String uuid = (String) key;
        storage.put(uuid, resume);
    }

    @Override
    protected Resume getResume(Object key) {
        String uuid = (String) key;
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
        if (storage.containsKey(uuid)){
            return uuid;
        }
        return null;
    }

    @Override
    protected boolean isExist(Object key) {
        return storage.containsKey(key);
    }
}
