package storage;

import exceptions.StorageException;
import model.Resume;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileStorage extends AbstractStorage<File>{
    protected File directory;
    protected Strategy strategy = new ObjectStreamPathStorage();

    public FileStorage(File directory) {
        Objects.requireNonNull(directory, "not null");
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not directory");
        }
        if (!directory.canRead() || !directory.canWrite()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is npt readable/writable");
        }
        this.directory = directory;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    @Override
    protected List<Resume> getAll() {
        List<Resume> list = new ArrayList<>();
        checkDirectory(directory);
        for (File file : directory.listFiles()) {
            list.add(getResume(file));
        }
        return list;
    }

    @Override
    protected boolean isExist(File file) {
        return file.exists();
    }

    @Override
    protected void saveResume(File file, Resume resume) {
        try {
            file.createNewFile();
            updateResume(file, resume);
        } catch (IOException e) {
            throw new StorageException("IO Exception", file.getName(), e);
        }
    }

    @Override
    protected void updateResume(File file, Resume resume) {
        try {
            strategy.write(resume,new BufferedOutputStream(new FileOutputStream(file)));
        } catch (IOException e) {
            throw new StorageException("IO Exception", file.getName(), e);
        }
    }

    @Override
    protected File getKey(String uuid) {
        return new File(directory, uuid);
    }

    @Override
    protected void deleteResume(File file) {
        if (file.delete()) {
            System.out.println("File delete");
        } else {
            System.out.println("File not found");
        }
    }

    @Override
    protected Resume getResume(File file) {
        try {
            return strategy.read(new BufferedInputStream(new FileInputStream(file)));
        } catch (IOException e) {
            throw new StorageException("IO Exception", file.getName(), e);
        }
    }

    @Override
    public void clear() {
        checkDirectory(directory);
        for (File file : directory.listFiles()) {
            deleteResume(file);
        }
    }

    @Override
    public int size() {
        checkDirectory(directory);
        return  directory.listFiles().length;
    }

    private boolean checkDirectory (File directory){
        if (directory != null){
            return true;
        } else {
            throw new StorageException("IO Exception", directory.getName());
        }
    }
}