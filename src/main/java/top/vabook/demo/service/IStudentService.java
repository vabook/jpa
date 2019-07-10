package top.vabook.demo.service;

import top.vabook.demo.model.Student;

import java.util.List;
import java.util.Map;

/**
 * @Author: vabook
 * @Date: 2019/7/10 9:27
 */
public interface IStudentService {

    List<Object[]> listStudent();

    List<Student> listStudentModel();

    List<Map<Object,Object>> listStudentMap();

    void batchSave();


    void statsDemo() throws InterruptedException;
}
