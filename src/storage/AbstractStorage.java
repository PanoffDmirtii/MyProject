package storage;

public abstract class AbstractStorage implements Storage {
    protected int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        clearStorage();
        size = 0;
        System.out.println("storage empty");
    }

    protected abstract void clearStorage();
}
