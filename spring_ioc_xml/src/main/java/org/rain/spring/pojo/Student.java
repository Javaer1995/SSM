package org.rain.spring.pojo;

import java.util.Arrays;
import java.util.Map;

/**
 * @author liaojy
 * @date 2023/7/27 - 22:33
 */
public class Student {

    private Integer id;
    private String name;
    private Integer age;
    private String sex;

    private Clazz clazz;

    private String hobby[];

    private Map<String,Teacher> teacherMap;

    public Student() {
    }

    public Student(Integer id, String name, Integer age, String sex, Clazz clazz) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.clazz = clazz;
    }

    public Map<String, Teacher> getTeacherMap() {
        return teacherMap;
    }

    public void setTeacherMap(Map<String, Teacher> teacherMap) {
        this.teacherMap = teacherMap;
    }

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", clazz=" + clazz +
                ", hobby=" + Arrays.toString(hobby) +
                ", teacherMap=" + teacherMap +
                '}';
    }
}
