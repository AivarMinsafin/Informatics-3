package ru.kpfu.itis.minsafin.aivar.task2;

public class Test {

    public static void main(String[] args) {
        Group group = new Group("11-903", 30);
        System.out.println(Group.serialize(group));
        System.out.println(Group.deserialize(Group.serialize(group)));
        Student student = new Student(
                "Aivar",
                "Minsafin",
                19,
                group
        );
        System.out.println(Student.serialize(student));
        System.out.println(Student.deserialize(Student.serialize(student)));
    }

}
