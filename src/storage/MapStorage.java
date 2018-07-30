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
    protected int checkResume(String uuid) {
        for (Map.Entry<String, Resume> resumeEntry : storage.entrySet()) {
            if (resumeEntry.getKey().equals(uuid)){
                return 1;
            }
        }
        return -1;
    }

    @Override
    protected void updateResume(Resume resume) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected void deleteFromStorage(String uuid) {
        storage.remove(uuid);
    }

    @Override
    protected Resume getResume(String uuid) {
        return storage.get(uuid);
    }

    @Override
    public Resume[] getAll() {
        int index = 0;
        Resume[] resumeStorage = new Resume[storage.size()];
        for (Map.Entry<String, Resume> resumeEntry : storage.entrySet()){
            resumeStorage[index] = resumeEntry.getValue();
            index++;
        }
        return resumeStorage;
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
}
