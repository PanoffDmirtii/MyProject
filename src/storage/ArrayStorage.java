package storage;

import model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    public void save(Resume r) {
        if (size != storage.length) {
            int index = indexOfResume(r.getUuid());
            if (index == -1) {
                storage[size++] = r;
                System.out.println(r + " save in storage");
            }
            else {
                System.out.println(r + " has already in storage");
            }
        }
        else {
            System.out.println("Storage overflow");
        }
    }

    public void delete(String uuid) {
        int index = indexOfResume(uuid);
        if (index != -1){
            storage[index] = storage[size-1];
            storage[size-1] = null;
            size--;
            System.out.println("resume '"  + uuid + "'  delete");
        }
        else {
            System.out.println("resume not found");
        }

    }

    /**
     * Check resume in storage
     * @return i if storage contain resume
     *        -1 if not found
     */
    protected int indexOfResume(String uuidFound) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuidFound)) {
                return i;
            }
        }
        return -1;
    }

    public int size() {
        return size;
    }
}
