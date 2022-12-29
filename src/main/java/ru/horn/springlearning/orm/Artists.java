package ru.horn.springlearning.orm;

public class Artists {

    static int id;
    static String name;
    static int age;
    static String type;

    public Artists(int id, String name, int age, String type) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.type = type;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Artists.id = id;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Artists.name = name;
    }

    public static int getAge() {
        return age;
    }

    public static void setAge(int age) {
        Artists.age = age;
    }

    public static String getType() {
        return type;
    }

    public static void setType(String type) {
        Artists.type = type;
    }

    @Override
    public String toString() {
        return "Artists{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", type='" + type + '\'' +
                '}';
    }
}
