package storage;

import exceptions.StorageException;
import model.Resume;

import java.io.*;

public class ObjectStreamPathStorage implements Strategy {
//    public ObjectStreamPathStorage(Path directory){
//        super(directory.toString());
//    }

    @Override
    public void write(Resume resume, OutputStream os) throws IOException {
        try(ObjectOutputStream oos = new ObjectOutputStream(os)) {
            oos.writeObject(resume);
        }
    }

    @Override
    public Resume read(InputStream is) throws IOException {
        try (ObjectInputStream ois = new ObjectInputStream(is)) {
            return  (Resume) ois.readObject();
        } catch (ClassNotFoundException e) {
            throw new StorageException("Error read", null, e);
        }
    }
}