package top.vabook.demo.model;

import javax.persistence.*;

/**
 * @Author: vabook
 * @Date: 2019/7/9 17:18
 */
@Entity
@Table(name = "app_student")
public class AppStudent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id ;
    private Integer classId;
    private String name;
    private Integer age;

    public AppStudent() {
    }
    public AppStudent(Integer id, Integer classId, String name, Integer age) {
        super();
        this.id = id;
        this.classId = classId;
        this.name = name;
        this.age = age;
    }

    public AppStudent(Integer classId, String name, Integer age) {
        this.classId = classId;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
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
}
