package top.vabook.demo.model;

import javax.persistence.*;

/**
 * @Author: vabook
 * @Date: 2019/7/9 17:14
 * 班级表
 */

@Entity
@Table(name = "app_class")
public class AppClass {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false)
    private Integer id;
    private String className;
    private String teacherName;


    public AppClass() {
    }

    public AppClass(Integer id, String className, String teacherName) {
        super();
        this.id = id;
        this.className = className;
        this.teacherName = teacherName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
