package storage;

import model.Resume;
import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void deleteFromStorage(int index) {
        System.arraycopy(storage, index + 1, storage, index, size - 1 - index);
    }

    @Override
    protected void updateResume(int index, Resume resume) {
        storage[index] = resume;
    }

    @Override
    protected int indexOfResume(String uuid) {
        Resume key = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, size, key);
    }

    @Override
    protected void putInStorage(int index, Resume r) {
        index = Math.abs(index) - 1;
        System.arraycopy(storage, index, storage, index + 1, size - index);
        storage[index] = r;
    }
}

