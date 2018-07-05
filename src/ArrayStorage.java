
import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10_000];

    private int size;

    void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    void save(Resume resume) {
        if (size != storage.length) {
            int index = indexOfResume(resume.uuid);
            if (index == -1) {
                storage[size++] = resume;
                System.out.println(resume + " save in storage");
            }
            else {
                System.out.println(resume + " has already in storage");
            }
        }
        else {
            System.out.println("Storage overflow");
        }
    }

    void update(Resume resume){
        int index = indexOfResume(resume.uuid);
        if (index != -1){
            storage[index] = resume;
            System.out.println(storage[index].toString() + " is update");
        }
        else {
            System.out.println("resume not found");
        }
    }

    Resume get(String uuid) {
        int index = indexOfResume(uuid);
        if (index != -1){
            System.out.println("resume: " + uuid);
            return storage[index];
        }
        System.out.println("resume not found");
        return null;
    }

    void delete(String uuid) {
        int index = indexOfResume(uuid);
        if (index != -1){
            storage[index] = storage[size-1];
            storage[size-1] = null;
           // System.arraycopy(storage, index+1, storage, index, size-1-index);
            size--;
            System.out.println("resume '"  + uuid + "'  delete");
        }
        else {
            System.out.println("resume not found");
        }

    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        System.out.println("storage empty");
        return Arrays.copyOfRange(storage, 0, size);
    }

    /**
     * Check resume in storage
     * @return i if storage contain resume
     *        -1 if not found
     */
    private int indexOfResume(String uuidFound) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuidFound)) {
                return i;
            }
        }
        return -1;
    }

    int size() {
        return size;
    }
}
