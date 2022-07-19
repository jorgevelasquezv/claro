package co.com.claro.services;

import co.com.claro.entity.Client;
import co.com.claro.entity.TypeVendor;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Stream;

@ApplicationScoped
@Transactional
public class TypeVendorServiceImpl implements Service<TypeVendor>{

    @PersistenceContext(name = "claro")
    private EntityManager em;

    @Override
    public TypeVendor save(TypeVendor typeVendor) {
        if (typeVendor.getId() != null && typeVendor.getId() > 0){
            em.merge(typeVendor);
        }else{
            em.persist(typeVendor);
        }
        return typeVendor;
    }

    @Override
    public TypeVendor find(TypeVendor typeVendor) {
        String sql = "SELECT t FROM TypeVendor t WHERE ";
        List<String> sqlArray = new ArrayList<>();
        StringJoiner sqlJoiner = new StringJoiner(" AND ");
        Field[] fields = TypeVendor.class.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            try {
                if (field.get(typeVendor) != null){
                    if(field.getType().equals(String.class)){
                        sqlArray.add(field.getName() + "='" + field.get(typeVendor) + "'") ;
                    }else{
                        sqlArray.add(field.getName() + "=" + field.get(typeVendor));
                    }
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        sqlArray.forEach(s -> sqlJoiner.add(s));

        sql += sqlJoiner.toString();
        Query query = em.createQuery(sql);
        typeVendor = (TypeVendor) query.setMaxResults(1).getSingleResult();
        return typeVendor;
    }

    @Override
    public List<TypeVendor> findAll() {
        Query q =  em.createQuery("SELECT t FROM TypeVendor t");
        List<TypeVendor> typeVendors = q.getResultList();
        return typeVendors;
    }

    @Override
    public void delete(TypeVendor typeVendor) {
        em.remove(typeVendor);
    }
}
