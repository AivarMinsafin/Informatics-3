package ru.kpfu.itis.minsafin.aivar.task2;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.Objects;

public class Group implements Serializable {

    private String name;
    private int capacity;

    public Group(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return capacity == group.capacity &&
                Objects.equals(name, group.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, capacity);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public static byte[] serialize(Group group){
        byte[] name = group.getName().getBytes();
        int nameLength = name.length;
        int capacity = group.getCapacity();
        int bytesLength = 4 + 4 + nameLength;
        return ByteBuffer.allocate(bytesLength)
                .putInt(nameLength)
                .put(name)
                .putInt(capacity).array();
    }

    public static Group deserialize(byte[] bytes){
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        int nameLength = buffer.getInt();
        ByteBuffer nameBuffer = ByteBuffer.allocate(nameLength);
        for (int i = 0; i < nameLength; i++) {
            nameBuffer.put(buffer.get());
        }
        int capacity = buffer.getInt();
        return new Group(
                new String(nameBuffer.array()),
                capacity
        );
    }
}
