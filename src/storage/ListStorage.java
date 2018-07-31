package storage;

import model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage{
    private List<Resume> storage = new ArrayList<>();

    @Override
    protected boolean checkAndUpdateResume(Resume updateResume) {
        int index = indexOfResume(updateResume.getUuid());
        if (index >= 0){
            storage.set(index, updateResume);
            return true;
        }
        return false;
    }

    @Override
    protected boolean checkAndSaveResume(Resume newResume) {
        int index = indexOfResume(newResume.getUuid());
        if (index < 0){
            storage.add(newResume);
            return true;
        }
        return false;
    }

    @Override
    protected boolean checkAndDeleteResume(String uuid) {
        int index = indexOfResume(uuid);
        if (index >= 0){
            storage.remove(index);
            return true;
        }
        return false;
    }

    @Override
    protected Resume getResume(String uuid) {
        int index = indexOfResume(uuid);
        if (index >= 0){
            return storage.get(index);
        }
        return null;
    }

    @Override
    public Resume[] getAll() {
        return storage.toArray(new Resume[0]);
    }

    @Override
    public void clear() {
        storage.removeAll(storage);
    }

    @Override
    public int size() {
        return storage.size();
    }

    private int indexOfResume(String uuid) {
        for (Resume resume : storage) {
            if (resume.getUuid().equals(uuid)) {
                return storage.indexOf(resume);
            }
        }
        return -1;
    }
}
