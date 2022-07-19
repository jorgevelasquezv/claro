package co.com.claro.services;

import co.com.claro.entity.Client;
import co.com.claro.entity.Vendor;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

@ApplicationScoped
@Transactional
public class VendorServiceImpl implements Service<Vendor> {

    @PersistenceContext(name = "claro")
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
                if (field.get(vendor) != null){
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
        em.remove(vendor);
    }
}
