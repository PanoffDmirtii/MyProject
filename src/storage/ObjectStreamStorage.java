//package storage;
//
//import Strategy.Strategy;
//import exceptions.StorageException;
//import model.Resume;
//
//import java.io.*;
//
//public class ObjectStreamStorage implements Strategy {
////    public ObjectStreamStorage(File directory) {
////        super(directory);
////    }
//
//    @Override
//    public void write(Resume resume, OutputStream file) throws IOException {
//        try (ObjectOutputStream obs = new ObjectOutputStream(file)){
//            obs.writeObject(resume);
//        }
//    }
//
//    @Override
//    public Resume read(InputStream file) throws IOException {
//        try (ObjectInputStream ois = new ObjectInputStream(file)) {
//            return (Resume) ois.readObject();
//        } catch (ClassNotFoundException e) {
//            throw new StorageException("Error read resume", null, e);
//        }
//    }
//}
