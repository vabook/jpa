package top.vabook.demo.dynamicquery;

import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * @Author: vabook
 * @Date: 2019/7/9 17:48
 */

@Repository
public class DynamicQueryImpl implements DynamicQuery {

    Logger logger = LoggerFactory.getLogger(DynamicQuery.class);

    @PersistenceContext
    private EntityManager em;

    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public void save(Object entity) {
        em.persist(entity);
    }

    @Override
    public void update(Object entity) {
        em.merge(entity);
    }

    @Override
    public <T> void delete(Class<T> entityClass, Object entityid) {
        delete(entityClass,entityid);
    }

    @Override
    public <T> void delete(Class<T> entityClass, Object[] entityids) {
        for (Object id : entityids){
            delete(entityClass,id);
        }
    }

    @Override
    public <T> List<T> nativeQueryList(String nativeSql, Object... params) {
        //调用自定义的方法
        Query q = (Query) createNativeQuery(nativeSql, params);
        q.unwrap(SQLQuery.class).setResultTransformer(Transformers.TO_LIST);
        return q.getResultList();

    }

    @Override
    public <T> List<T> nativeQueryListMap(String nativeSql, Object... params) {
        Query q = (Query) createNativeQuery(nativeSql,params);
        q.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);

        return q.getResultList();
    }

    @Override
    public <T> List<T> nativeQueryListModel(Class<T> resultClass, String nativceSql, Object... params) {
        Query q = (Query) createNativeQuery(nativceSql,params);
        q.unwrap(SQLQuery.class).setResultTransformer(Transformers.aliasToBean(resultClass.getClass()));
        return q.getResultList();
    }

    private Query createNativeQuery(String sql, Object... params) {
        Query q = em.createNativeQuery(sql);
        if (params != null && params.length > 0) {
            for (int i = 0; i < params.length; i++) {
                q.setParameter(i + 1, params[i]); // 与Hiberante不同,jpa
                // query从位置1开始
            }
        }
        return q;
    }


}
