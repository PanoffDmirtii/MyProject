package storage;

import model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {
    private Map<String, Resume> storage = new HashMap<>();

    @Override
    protected boolean checkAndUpdateResume(Resume updateResume) {
        if (checkResume(updateResume.getUuid())){
            storage.put(updateResume.getUuid(), updateResume);
            return true;
        }
        return false;
    }

    @Override
    protected boolean checkAndSaveResume(Resume newResume) {
        if (!checkResume(newResume.getUuid())){
            storage.put(newResume.getUuid(), newResume);
            return true;
        }
        return false;
    }

    @Override
    protected boolean checkAndDeleteResume(String uuid) {
        if (checkResume(uuid)){
            storage.remove(uuid);
            return true;
        }
        return false;
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

    private boolean checkResume(String uuid) {
        for (Map.Entry<String, Resume> resumeEntry : storage.entrySet()) {
            if (resumeEntry.getKey().equals(uuid)){
                return true;
            }
        }
        return false;
    }
}
