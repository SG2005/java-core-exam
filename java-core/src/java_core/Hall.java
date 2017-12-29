package java_core;

public enum Hall {

    SMALL(10), BIG(20);

    private int size;

    Hall(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
