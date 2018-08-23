package storage;

import model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapStorage extends AbstractStorage<Resume> {
    private Map<String, Resume> storage = new HashMap<>();

    @Override
    protected void saveResume(Resume keyResume, Resume resume) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected void deleteResume(Resume keyResume) {
        storage.remove(keyResume.getUuid());
    }

    @Override
    protected void updateResume(Resume keyResume, Resume resume) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected Resume getResume(Resume keyResume) {
        return storage.get(keyResume.getUuid());
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


    protected Resume getKey(String uuid) {
        return storage.get(uuid);
    }

    @Override
    protected boolean isExist(Resume key) {
        return key != null;
    }
}
