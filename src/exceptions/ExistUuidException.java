package exceptions;

public class ExistUuidException extends StorageException {
    public ExistUuidException(String uuid) {
        super(uuid, "'" + uuid + "'" + " is already in storage");
    }
}
