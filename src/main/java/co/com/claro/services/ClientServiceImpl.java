package co.com.claro.services;

import co.com.claro.entity.Client;
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
public class ClientServiceImpl implements Service<Client> {

    @PersistenceContext(name = "claro")
    private EntityManager em;

    @Override
    public Client save(Client client) {
        if(client.getId() != null && client.getId() > 0 ){
            em.merge(client);
        }else {
            em.persist(client);
        }
        return client;
    }

    @Override
    public Client find(Client client) {
        String sql = "SELECT c FROM Client c WHERE ";
        List<String> sqlArray = new ArrayList<>();
        StringJoiner sqlJoiner = new StringJoiner(" AND ");
        Field[] fields = Client.class.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            try {
                if (field.get(client) != null){
                    if(field.getType().equals(String.class)){
                        sqlArray.add(field.getName() + "='" + field.get(client) + "'") ;
                    }else{
                        sqlArray.add(field.getName() + "=" + field.get(client));
                    }
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        sqlArray.forEach(s -> sqlJoiner.add(s));

        sql += sqlJoiner.toString();
        Query query = em.createQuery(sql);
        client = (Client) query.setMaxResults(1).getSingleResult();
        return client;
    }

    @Override
    public List<Client> findAll() {
        Query q =  em.createQuery("SELECT c FROM Client c");
        List<Client> clients = q.getResultList();
        return clients;
    }

    @Override
    public void delete(Client client) {
        em.remove(client);
    }
}
