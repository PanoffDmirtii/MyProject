package exceptions;

public class NotExistUuidException extends StorageException {
    public NotExistUuidException(String uuid) {
        super("Resume with uuid = " + uuid + " not exist", uuid);
    }
}
