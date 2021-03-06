package storage;

import model.Resume;

public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected void deleteFromStorage(int index) {
        storage[index] = storage[size - 1];
    }

    /**
     * Check resume in storage
     * @return i if storage contain resume
     *        -1 if not found
     */
    protected Integer getKey(String uuidFound) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuidFound)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void putInStorage(int index, Resume resume) {
        storage[size] = resume;
    }
}
