package storage;

import exceptions.StorageException;
import model.Resume;

import java.io.*;
import java.nio.file.Path;

public class ObjectStreamPathStorage extends AbstractPathStorage {
    public ObjectStreamPathStorage(Path directory){
        super(directory.toString());
    }

    @Override
    protected void write(Resume resume, OutputStream os) throws IOException {
        try(ObjectOutputStream oos = new ObjectOutputStream(os)) {
            oos.writeObject(resume);
        }
    }

    @Override
    protected Resume read(InputStream is) throws IOException {
        try (ObjectInputStream ois = new ObjectInputStream(is)) {
            return  (Resume) ois.readObject();
        } catch (ClassNotFoundException e) {
            throw new StorageException("Error read", null, e);
        }
    }
}