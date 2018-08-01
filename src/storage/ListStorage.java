package storage;

import model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage{
    private List<Resume> storage = new ArrayList<>();

    @Override
    protected void saveResume(Resume resume) {
        storage.add(resume);
    }

    @Override
    protected void deleteResume(String uuid) {
        int index = getKeyIfExist(uuid);
        storage.remove(index);
    }

    @Override
    protected void updateResume(Resume resume) {
        int index = getKeyIfExist(resume.getUuid());
        storage.set(index, resume);
    }

    @Override
    protected Resume getResume(String uuid) {
        int index = getKeyIfExist(uuid);
        return storage.get(index);
    }

    @Override
    public Resume[] getAll() {
        return storage.toArray(new Resume[0]);
    }

    @Override
    public void clear() {
        storage.removeAll(storage);
        System.out.println("storage empty");
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    protected int getIndex(String uuid) {
        for (Resume resume : storage){
            if (resume.getUuid().equals(uuid)){
                return storage.indexOf(resume);
            }
        }
        return -1;
    }
}
