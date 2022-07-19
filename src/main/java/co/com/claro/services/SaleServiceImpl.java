package co.com.claro.services;

import co.com.claro.entity.Client;
import co.com.claro.entity.Equipment;
import co.com.claro.entity.Sale;
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
public class SaleServiceImpl implements Service<Sale>{

    @PersistenceContext(name = "claro")
    private EntityManager em;

    @Override
    public Sale save(Sale sale) {
        if (sale.getId() != null && sale.getId() > 0){
            em.merge(sale);
        }else{
            em.persist(sale);
        }
        return sale;
    }

    @Override
    public Sale find(Sale sale) {
        String sql = "SELECT s FROM Sale s WHERE ";
        List<String> sqlArray = new ArrayList<>();
        StringJoiner sqlJoiner = new StringJoiner(" AND ");
        Field[] fields = Sale.class.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            try {
                if (field.get(sale) != null){
                    if(field.getType().equals(Long.class)){
                        sqlArray.add(field.getName() + "=" + field.get(sale)) ;
                    }
                    if(field.getType().equals(Vendor.class) && sale.getVendor().getId() != null){
                        sqlArray.add("vendor_id=" + sale.getVendor().getId()) ;
                    }
                    if(field.getType().equals(Equipment.class) && sale.getEquipment().getId() != null){
                        sqlArray.add("equipment_id=" + sale.getEquipment().getId()) ;
                    }
                    if(field.getType().equals(Client.class) && sale.getClient().getId() != null ){
                        sqlArray.add("client_id=" + sale.getClient().getId()) ;
                    }
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        sqlArray.forEach(s -> sqlJoiner.add(s));

        sql += sqlJoiner.toString();
        Query query = em.createQuery(sql);
        sale = (Sale) query.setMaxResults(1).getSingleResult();
        return sale;
    }

    @Override
    public List<Sale> findAll() {
        Query q =  em.createQuery("SELECT s FROM Sale s");
        List<Sale> sales =  q.getResultList();
        return sales;
    }

    @Override
    public void delete(Sale sale) {
        em.remove(sale);
    }
}
