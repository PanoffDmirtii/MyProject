package storage;

import exceptions.StorageException;
import model.Resume;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class AbstractFileStorage extends AbstractStorage<File> {
    protected File directory;

    protected abstract void write(Resume resume, File file) throws IOException;
    protected abstract Resume read(File file) throws IOException;

    public AbstractFileStorage(File directory) {
        Objects.requireNonNull(directory, "not null");
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not directory");
        }
        if (!directory.canRead() || !directory.canWrite()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is npt readable/writable");
        }
        this.directory = directory;
    }

    @Override
    protected List<Resume> getAll() {
        List<Resume> list = new ArrayList<>();
        if (checkDirectory(directory)) {
            for (File file : directory.listFiles()) {
                list.add(getResume(file));
            }
        } else {
            throw new StorageException("IO Exeption", directory.getName());
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
            throw new StorageException("IO Exeption", file.getName(), e);
        }
    }

    @Override
    protected void updateResume(File file, Resume resume) {
        try {
            write(resume, file);
        } catch (IOException e) {
            throw new StorageException("IO Exeption", file.getName(), e);
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
            return read(file);
        } catch (IOException e) {
            throw new StorageException("IO Exeption", file.getName(), e);
        }
    }

    @Override
    public void clear() {
        if (checkDirectory(directory)){
            for (File file : directory.listFiles()) {
                deleteResume(file);
            }
        } else {
            throw new StorageException("IO Exeption", directory.getName());
        }
    }

    @Override
    public int size() {
        int count = 0;
        if (checkDirectory(directory)){
            count = directory.listFiles().length;
        } else {
            throw new StorageException("IO Exeption", directory.getName());
        }
        return  count;
    }

    private boolean checkDirectory (File directory){
        return directory.listFiles() != null;
    }
}