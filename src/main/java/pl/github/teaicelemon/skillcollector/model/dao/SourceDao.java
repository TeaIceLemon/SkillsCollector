package pl.github.teaicelemon.skillcollector.model.dao;

import org.hibernate.SessionFactory;
import pl.github.teaicelemon.skillcollector.model.entity.Source;

import java.util.List;

public class SourceDao extends BaseDao {
    protected SourceDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
    public Source get(Long id){
        return super.produceInTransaction(session -> session.get(Source.class, id));
    }
    public void save(Source source){
        super.executeInTransaction(session -> session.save(source));
    }
    public void update(Source source){
        super.executeInTransaction(session -> session.update(source));
    }
    public void delete(Source source){
        super.executeInTransaction(session -> session.delete(source));
    }
    public List<Source> getAll(){
        return super.produceInTransaction(session -> session.createQuery("SELECT s FROM Source s")
                .getResultList());
    }
    public List<Source> getAllByName(String name){
        return super.produceInTransaction(session -> session.createQuery("SELECT s FROM Source s WHERE s.name = :name"))
                .setParameter("name", name)
                .getResultList();
    }

}
