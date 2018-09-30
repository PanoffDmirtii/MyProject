package storage;

import Strategy.Strategy;
import Strategy.WorkWithFiles;
import exceptions.StorageException;
import model.Resume;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PathStorage extends AbstractStorage<Path>{
    protected Path directory;
    protected Strategy strategy;

    public PathStorage(String dir) {
        Objects.requireNonNull(dir, "not null");
        this.directory = Paths.get(dir);
        if (!Files.isDirectory(directory)) {
            throw new IllegalArgumentException(directory.getFileName() + " is not directory");
        }
        if (!Files.isReadable(directory) || !Files.isWritable(directory)) {
            throw new IllegalArgumentException(directory.getFileName() + " is npt readable/writable");
        }
        this.strategy = new WorkWithFiles();
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    @Override
    protected List<Resume> getAll(){
//        List<Resume> list = new ArrayList<>();
//        try {
//            Files.list(directory).forEach(path -> list.add(getResume(path)));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        //return list


        try {
            return Files.list(directory).map(this::getResume).collect(Collectors.toList());
        } catch (IOException e) {
            throw new StorageException("IO Exeption", null, e);
        }

    }



    @Override
    protected boolean isExist(Path path) {
        return Files.exists(path);
    }

    @Override
    protected void saveResume(Path path, Resume resume) {
        try {
            Files.createFile(path);
            updateResume(path, resume);
        } catch (IOException e) {
            throw new StorageException("IO Exeption", path.getFileName().toString(), e);
        }
    }

    @Override
    protected void updateResume(Path path, Resume resume) {
        try {
            strategy.write(resume,new BufferedOutputStream(new FileOutputStream(path.toString())));
        } catch (IOException e) {
            throw new StorageException("IO Exeption", path.getFileName().toString(), e);
        }
    }

    @Override
    protected Path getKey(String uuid) {
        return Paths.get(directory.toString(), uuid);
    }

    @Override
    protected void deleteResume(Path path) {
        try {
            Files.deleteIfExists(path);
        } catch (IOException e) {
            throw new StorageException("File not found ",path.toString(), e);
        }
    }

    @Override
    protected Resume getResume(Path path) {
        try {
            return strategy.read(new BufferedInputStream(new FileInputStream(path.toString())));
        } catch (IOException e) {
            throw new StorageException("Resume not found", path.getFileName().toString(), e);
        }
    }

    @Override
    public void clear() {
        try {
            Files.list(directory).forEach(this::deleteResume);
            System.out.println("Direcrory: '" + directory + "' is empty");
        } catch (IOException e) {
            throw new StorageException("Read Error", null, e);
        }
    }

    @Override
    public int size() {
        try {
            return (int)Files.list(directory).count();
        } catch (IOException e) {
            throw new StorageException("Error read", null, e);
        }
    }
}