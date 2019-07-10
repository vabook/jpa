package top.vabook.demo.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.vabook.demo.entity.Result;
import top.vabook.demo.model.Student;
import top.vabook.demo.service.IStudentService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @Author: vabook
 * @Date: 2019/7/10 10:56
 */

@Api(tags = "测试接口")
@RestController
@RequestMapping("/test")
public class StudentController {
    private final static Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private IStudentService iStudentService;

    @PostMapping("/list")
    @ApiOperation(value="学生列表")
    public Result list(HttpServletRequest r ){
        LOGGER.info("学生列表");
        List<Object[]> list = iStudentService.listStudent();
        return Result.ok(list);
    }

    @ApiOperation(value = "学生map")
    @PostMapping("/listMap")
    public Result listMap(HttpServletRequest request){
        LOGGER.info("学生Map");
        List<Map<Object,Object>> list = iStudentService.listStudentMap();
        return Result.ok(list);
    }

    @ApiOperation(value = "学生model")
    @PostMapping("/listModel")
    public Result listModel(HttpServletRequest request){
        LOGGER.info("学生model");
        List<Student> list = iStudentService.listStudentModel();
        return Result.ok(list);
    }




}
