package storage;

import model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void deleteFromStorage(int index) {
        System.arraycopy(storage, index + 1, storage, index, size - 1 - index);
    }

    @Override
    protected Integer getKey(String uuid) {
        Resume key = new Resume(uuid, "NoName");
        return Arrays.binarySearch(storage, 0, size, key, new Resume.ResumeComarator());
    }

    @Override
    protected void putInStorage(int index, Resume resume) {
        index = Math.abs(index) - 1;
        System.arraycopy(storage, index, storage, index + 1, size - index);
        storage[index] = resume;
    }


}

