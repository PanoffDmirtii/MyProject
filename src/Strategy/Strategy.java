package Strategy;

import model.Resume;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface Strategy {

    void write(Resume resume, OutputStream file) throws IOException;

    Resume read(InputStream file) throws IOException;
}
