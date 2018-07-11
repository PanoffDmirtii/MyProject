package storage;

import model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10_000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    @Override
    public void save(Resume r) {
        if (size != storage.length) {
            int index = indexOfResume(r.getUuid());
            if (index < 0) {
                putInStorage(index, r);
                size++;
            }
            else {
                System.out.println(r + " has already in storage");
            }
        }
        else {
            System.out.println("Storage overflow");
        }
    }

    @Override
    public void delete(String uuid) {
        int index = indexOfResume(uuid);
        if (index >= 0){
            deleteFromStorage(index);
            size--;
            System.out.println("resume '"  + uuid + "'  delete");
        }
        else {
            System.out.println("resume not found");
        }
    }

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
        System.out.println("storage empty");
    }

    @Override
    public void update(Resume r) {
        int index = indexOfResume(r.getUuid());
        if (index >= 0){
            storage[index] = r;
            System.out.println(storage[index].toString() + " is update");
        }
        else {
            System.out.println("resume not found");
        }
    }

    @Override
    public Resume get(String uuid) {
        int index = indexOfResume(uuid);
        if (index != -1){
            System.out.println("resume: " + uuid);
            return storage[index];
        }
        System.out.println("resume not found");
        return null;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    @Override
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    @Override
    public int size() {
        return size;
    }

    protected abstract int indexOfResume(String uuid);
    protected abstract void deleteFromStorage(int index);
    protected abstract void putInStorage(int index, Resume r);
}
