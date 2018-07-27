package storage;

import exceptions.ExistUuidException;
import exceptions.NotExistUuidException;
import model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage{
    protected List<Resume> storage = new ArrayList<>();


    @Override
    public void clearStorage() {
        storage.removeAll(storage);
    }


    @Override
    public void update(Resume updateResume) {
        if (storage.contains(updateResume)){
            storage.set(storage.indexOf(updateResume), updateResume);
            System.out.println(updateResume.getUuid() + " is update");
        } else {
            throw new NotExistUuidException(updateResume.getUuid());
        }
    }

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
    public Resume get(String uuid) {
        for (Resume resume : storage) {
            if (resume.getUuid().equals(uuid)){
                System.out.println("resume: " + uuid);
                return resume;
            }
        }
        throw new NotExistUuidException(uuid);
    }

    @Override
    public void delete(String uuid) {
        int index = storage.indexOf(new Resume(uuid));
        if (index >= 0){
            storage.remove(index);
            size--;
            System.out.println("resume '"  + uuid + "'  delete");
        } else {
            throw new NotExistUuidException(uuid);
        }
    }

    @Override
    public Resume[] getAll() {
        return storage.toArray(new Resume[storage.size()]);
    }
}
