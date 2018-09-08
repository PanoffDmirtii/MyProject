package storage;

import exceptions.StorageException;
import model.Resume;

import java.io.*;

public class ObjectStreamStorage extends AbstractFileStorage{
    public ObjectStreamStorage(File directory) {
        super(directory);
    }

    @Override
    protected void write(Resume resume, OutputStream file) throws IOException {
        try (ObjectOutputStream obs = new ObjectOutputStream(file)){
            obs.writeObject(resume);
        }
    }

    @Override
    protected Resume read(InputStream file) throws IOException {
        try (ObjectInputStream ois = new ObjectInputStream(file)) {
            return (Resume) ois.readObject();
        } catch (ClassNotFoundException e) {
            throw new StorageException("Error read resume", null, e);
        }
    }
}
