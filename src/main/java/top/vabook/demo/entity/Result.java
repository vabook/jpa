package top.vabook.demo.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: vabook
 * @Date: 2019/7/9 17:28
 * 页面响应
 */
public class Result extends HashMap<String,Object> {

    public Result(){
        put("code",0);
    }

    public static Result error(){
        return error(500,"未知异常");
    }

    public static Result error(String msg){
        return error(500,msg);
    }

    private static Result error(int code, String msg) {
        Result r = new Result();
        r.put("code",code);
        r.put("msg",msg);
        return r;
    }

    public static Result ok(Object msg){
        Result r = new Result();
        r.put("msg",msg);
        return r;
    }

    public static Result ok(Map<String,Object> map){
        Result r = new Result();
        r.putAll(map);
        return r;
    }

    public Result put(String key, Object value){
        super.put(key,value);
        return this;
    }
}
