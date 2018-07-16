package exceptions;

public class ExistUuidException extends StorageException {
    public ExistUuidException(String uuid) {
        super("Resume with uuid = " + uuid + " already exist", uuid);
    }
}
