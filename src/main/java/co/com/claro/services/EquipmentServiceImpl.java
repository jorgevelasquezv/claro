package co.com.claro.services;

import co.com.claro.entity.Client;
import co.com.claro.entity.Equipment;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
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
public class EquipmentServiceImpl implements Service<Equipment> {

    @PersistenceContext(name = "claro")
    private EntityManager em;

    @Override
    public Equipment save(Equipment equipment) {
        if (equipment.getId() != null && equipment.getId() > 0) {
            em.merge(equipment);
        }else{
            em.persist(equipment);
        }
        return equipment;
    }

    @Override
    public Equipment find(Equipment equipment) {
        String sql = "SELECT e FROM Equipment e WHERE ";
        List<String> sqlArray = new ArrayList<>();
        StringJoiner sqlJoiner = new StringJoiner(" AND ");
        Field[] fields = Equipment.class.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            try {
                if (field.get(equipment) != null){
                    if(field.getType().equals(String.class)){
                        sqlArray.add(field.getName() + "='" + field.get(equipment) + "'") ;
                    }else{
                        sqlArray.add(field.getName() + "=" + field.get(equipment));
                    }
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        sqlArray.forEach(s -> sqlJoiner.add(s));

        sql += sqlJoiner.toString();
        Query query = em.createQuery(sql);
        equipment = (Equipment) query.setMaxResults(1).getSingleResult();
        return equipment;
    }

    @Override
    public List<Equipment> findAll() {
        Query q =  em.createQuery("SELECT e FROM Equipment e");
        List<Equipment> equipments = q.getResultList();
        return equipments;
    }

    @Override
    public void delete(Equipment equipment) {
        em.remove(equipment);
    }
}
