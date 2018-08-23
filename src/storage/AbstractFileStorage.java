package storage;

import model.Resume;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class AbstractFileStorage extends AbstractStorage<File> {
    protected File directory;

    protected abstract void writeToFile(Resume resume, File file);
    protected abstract Resume takeFromFile(File file);

    public AbstractFileStorage(File directory) {
        Objects.requireNonNull(directory, "not null");
        if (!directory.isDirectory()){
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not directory");
        }
        if (!directory.canRead() || !directory.canWrite()){
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is npt readable/writable");
        }
        this.directory = directory;
    }

    @Override
    protected List<Resume> getAll() {
        List<Resume> list = new ArrayList<>();
        for (File file : Objects.requireNonNull(directory.listFiles())) {
            list.add(takeFromFile(file));
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
            writeToFile(resume, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @Override
    protected void updateResume(File file, Resume resume) {
        writeToFile(resume, file);
    }

    @Override
    protected File getKey(String uuid) {
        return new File(directory, uuid);
    }

    @Override
    protected void deleteResume(File file) {
        file.deleteOnExit();
    }

    @Override
    protected Resume getResume(File file) {
        return takeFromFile(file);
    }

    @Override
    public void clear() {
        for (File file : Objects.requireNonNull(directory.listFiles())) {
            file.deleteOnExit();
        }
    }

    @Override
    public int size() {
        int count = 0;
        for (File file : Objects.requireNonNull(directory.listFiles())) {
            if (file.isFile()){
                count++;
            }
        }
        return count;
    }
}