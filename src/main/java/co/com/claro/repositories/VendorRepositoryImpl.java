package co.com.claro.repositories;

import co.com.claro.entity.TypeVendor;
import co.com.claro.entity.Vendor;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

@RequestScoped
public class VendorRepositoryImpl implements CrudRepository<Vendor> {

    @Inject
    private EntityManager em;

    @Override
    public Vendor save(Vendor vendor) {
        if (vendor.getId() != null && vendor.getId() > 0){
            em.merge(vendor);
        }else {
            em.persist(vendor);
        }
        return vendor;
    }

    @Override
    public Vendor find(Vendor vendor) {
        String sql = "SELECT v FROM Vendor v WHERE ";
        List<String> sqlArray = new ArrayList<>();
        StringJoiner sqlJoiner = new StringJoiner(" AND ");
        Field[] fields = Vendor.class.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            try {
                if (field.get(vendor) != null && field.get(vendor).getClass() != TypeVendor.class){
                    if(field.getType().equals(String.class)){
                        sqlArray.add(field.getName() + "='" + field.get(vendor) + "'") ;
                    }else{
                        sqlArray.add(field.getName() + "=" + field.get(vendor));
                    }
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        sqlArray.forEach(s -> sqlJoiner.add(s));

        sql += sqlJoiner.toString();
        Query query = em.createQuery(sql);
        vendor = (Vendor) query.setMaxResults(1).getSingleResult();
        return vendor;
    }

    @Override
    public List<Vendor> findAll() {
        Query q =  em.createQuery("SELECT v FROM Vendor v");
        List<Vendor> vendors = q.getResultList();
        return vendors;
    }

    @Override
    public void delete(Vendor vendor) {
        em.remove(em.contains(vendor) ? vendor : em.merge(vendor));
    }
}
