package top.vabook.demo.dynamicquery;

import java.util.List;

/**
 * @Author: vabook
 * @Date: 2019/7/9 17:40
 */
public interface DynamicQuery {

    public void save(Object entity);
    public void update(Object entity);

    public <T> void delete(Class<T> entityClass,Object entityid);

    public <T> void delete(Class<T> entityClass,Object[] entityids);

    /**
     * 查询对象列表,返回list
     * @param nativeSql
     * @param params
     * @param <T>
     * @return
     */
    <T> List<T> nativeQueryList(String nativeSql, Object... params);

    /**
     * 查询对象列表，返回List<Map<key,value>>
     * @param nativeSql
     * @param params
     * @param <T>
     * @return
     */
    <T> List<T> nativeQueryListMap(String nativeSql,Object ... params);


    /**
     * 查询对象列表，返回List<组合对象>
     * @param resultClass
     * @param nativceSql
     * @param params
     * @param <T>
     * @return
     */
    <T> List<T> nativeQueryListModel(Class<T> resultClass,String nativceSql,Object... params);


}
