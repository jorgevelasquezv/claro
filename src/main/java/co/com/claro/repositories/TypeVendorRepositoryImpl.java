package co.com.claro.repositories;

import co.com.claro.entity.TypeVendor;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

@RequestScoped
public class TypeVendorRepositoryImpl implements CrudRepository<TypeVendor> {

    @Inject
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
