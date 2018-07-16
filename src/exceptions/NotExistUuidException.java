package exceptions;

public class NotExistUuidException extends StorageException {
    public NotExistUuidException(String uuid) {
        super(uuid, "'" + uuid + "'" + " is already in storage");
    }
}
