package storage;

import model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapStorage extends AbstractStorage {
    private Map<Resume, Resume> storage = new HashMap<>();

    @Override
    protected void saveResume(Object keyResume, Resume resume) {
        storage.put(resume, resume);
    }

    @Override
    protected void deleteResume(Object keyResume) {
        storage.remove(keyResume);
    }

    @Override
    protected void updateResume(Object keyResume, Resume resume) {
        storage.put(resume, resume);
    }

    @Override
    protected Resume getResume(Object keyResume) {
        return storage.get(keyResume);
    }

    @Override
    protected List<Resume> getAll() {
        return new ArrayList<>(storage.values()).subList(0, storage.size());
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
    protected Resume getKey(String uuid) {
        for (Resume resume : storage.keySet()) {
            if (resume.getUuid().equals(uuid)){
                return resume;
            }
        }
        return null;
    }

    @Override
    protected boolean isExist(Object key) {
        return key != null;
    }
}
