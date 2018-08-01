package storage;

import model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {
    private Map<String, Resume> storage = new HashMap<>();

    @Override
    protected void saveResume(Resume resume) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected void deleteResume(String uuid) {
        storage.remove(uuid);
    }

    @Override
    protected void updateResume(Resume resume) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected Resume getResume(String uuid) {
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
    protected int getIndex(String uuid) {
        for (Map.Entry<String, Resume> resumeEntry : storage.entrySet()) {
            if (resumeEntry.getKey().equals(uuid)){
                return 1;
            }
        }
        return -1;
    }
}
