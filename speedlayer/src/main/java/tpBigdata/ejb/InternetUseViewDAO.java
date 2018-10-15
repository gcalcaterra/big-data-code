package tpBigdata.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tpBigdata.model.InternetUseView;

@Stateless
public class InternetUseViewDAO {

    @PersistenceContext(unitName="speedLayer1")
    private EntityManager em1;
    
    //@PersistenceContext(unitName="speedLayer2")
    //private EntityManager em2;

	public EntityManager getEm() {
		return em1;
	}

	public void setEm(EntityManager em1) {
		this.em1 = em1;
	}

	  public InternetUseView get(String id) {
  		InternetUseView p =getEm().find(InternetUseView.class, id);
      return p;
  }    
  
  public void persist(InternetUseView entity){
      getEm().persist(entity);
  }

  public InternetUseView merge(InternetUseView entity){
      return (InternetUseView) getEm().merge(entity);
  }

  public void delete(String id){
      InternetUseView entity = this.get(id);
      this.getEm().remove(entity);
  }

  public void delete(InternetUseView entity){
  		this.delete(entity.getInternetUseId());
  }

    
}
