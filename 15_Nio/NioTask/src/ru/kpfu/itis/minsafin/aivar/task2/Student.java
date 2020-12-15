package ru.kpfu.itis.minsafin.aivar.task2;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.Objects;

public class Student implements Serializable {

    private String firstName;
    private String lastName;
    private int age;
    private Group group;

    public Student(String firstName, String lastName, int age, Group group) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.group = group;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(firstName, student.firstName) &&
                Objects.equals(lastName, student.lastName) &&
                Objects.equals(group, student.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age, group);
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", group=" + group +
                '}';
    }

    public static byte[] serialize(Student student) {
        byte[] firstName = student.getFirstName().getBytes();
        int firstNameLength = firstName.length;
        byte[] lastName = student.getLastName().getBytes();
        int lastNameLength = lastName.length;
        int age = student.getAge();
        byte[] group = Group.serialize(student.getGroup());
        int groupLength = group.length;
        int bytesLength = 4 + firstNameLength + 4 + lastNameLength + 4 + 4 + groupLength;
        return ByteBuffer.allocate(bytesLength)
                .putInt(firstNameLength)
                .put(firstName)
                .putInt(lastNameLength)
                .put(lastName)
                .putInt(age)
                .putInt(groupLength)
                .put(group)
                .array();
    }

    public static Student deserialize(byte[] bytes){
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        int firstNameLength = buffer.getInt();
        ByteBuffer firstNameBuffer = ByteBuffer.allocate(firstNameLength);
        for (int i = 0; i < firstNameLength; i++) {
            firstNameBuffer.put(buffer.get());
        }
        int lastNameLength = buffer.getInt();
        ByteBuffer lastNameBuffer = ByteBuffer.allocate(lastNameLength);
        for (int i = 0; i < lastNameLength; i++) {
            lastNameBuffer.put(buffer.get());
        }
        int age = buffer.getInt();
        int groupLength = buffer.getInt();
        ByteBuffer groupBuffer = ByteBuffer.allocate(groupLength);
        for (int i = 0; i < groupLength; i++) {
            groupBuffer.put(buffer.get());
        }
        return new Student(
                new String(firstNameBuffer.array()),
                new String(lastNameBuffer.array()),
                age,
                Group.deserialize(groupBuffer.array())
        );
    }
}
