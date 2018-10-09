package tpBigdata.ejb;

import tpBigdata.model.InternetUse;
import tpBigdata.model.InternetUseView;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.List;

@Stateless
public class InternetUseDAO {
    @PersistenceContext(unitName="speedLayer1")
    private EntityManager em1;

    //@PersistenceContext(unitName="speedLayer2")
    //private EntityManager em2;

    public InternetUseDAO(){

    }

	protected EntityManager getEm() {
		return em1;
	}	
	
    public InternetUse get(String id) {
    		InternetUse p=getEm().find(InternetUse.class, id);
        return p;
    }    
    
    public void persist(InternetUse entity){
        getEm().persist(entity);
    }

    public InternetUse merge(InternetUse entity){
        return (InternetUse) getEm().merge(entity);
    }

    public void delete(String id){
        InternetUse entity = this.get(id);
        this.getEm().remove(entity);
    }

    public void delete(InternetUse entity){
    		this.delete(entity.getInternetUseId());
    }

    @SuppressWarnings("unchecked")
	public List<InternetUseView> lista() {
    		Query q = getEm().createQuery(
    			"SELECT v FROM InternetUseView v");
    		return (List<InternetUseView>) q.getResultList();
    }

    public Long total() {
    		Query q = getEm().createQuery(
    			"Select Count(v) from InternetUseView v");
    		return (Long) q.getSingleResult();
    }
}