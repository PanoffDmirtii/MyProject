package storage;

import model.Resume;
import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void save(Resume r) {
        if (size != storage.length) {
            int index = indexOfResume(r.getUuid());
            if (index < 0) {
                index = Math.abs(index) - 1;
                System.arraycopy(storage, index, storage, index + 1, size - index);
                storage[index] = r;
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
        if (index == 0) {
            System.arraycopy(storage, index + 1, storage, index, size - 1 - index);
            size--;
        }
        else {
            System.out.println("Resume not found");
        }

    }

    @Override
    protected int indexOfResume(String uuid) {
        Resume key = new Resume();
        key.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, key);
    }
}

