package storage;

import exceptions.ExistUuidException;
import model.Resume;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListStorage extends AbstractStorage{
    protected List<Resume> storage = new ArrayList<>();

    @Override
    public void save(Resume newResume) {
        if (!storage.contains(newResume)){
            storage.add(newResume);
            size++;
            System.out.println("resume '"  + newResume.getUuid() + "'  save in storage");
        } else {
            throw new ExistUuidException(newResume.getUuid());
        }
    }

    @Override
    protected Resume getResume(int index) {
        return storage.get(index);
    }

    @Override
    public Resume[] getAll() {
        return storage.toArray(new Resume[storage.size()]);
    }

    @Override
    public void clearStorage() {
        storage.removeAll(storage);
    }

    @Override
    protected int indexOfResume(String uuid) {
        for (Resume resume : storage) {
            if (Objects.equals(resume.getUuid(), uuid)){
                return storage.indexOf(resume);
            }
        }
        return -1;
    }

    @Override
    protected void deleteFromStorage(int index) {
        storage.remove(index);
    }

    @Override
    protected void updateResume(int index, Resume resume) {
        storage.set(index, resume);
    }
}
