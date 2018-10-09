package tpBigdata.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="internetUse")
public class InternetUseView implements Serializable {
	private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "internetUseId")
    private String internetUseId;

    @Basic(optional = false)
    @Column(name = "max")
    private Double unitsMax;

    @Basic(optional = false)
    @Column(name = "min")
    private Double unitsMin;

    @Basic(optional = false)
    @Column(name = "count")
    private Long count;

    @Basic(optional = false)
    @Column(name = "sum")
    private Long sum;

    public InternetUseView() {
    	
    }

    public String getInternetUseId() {
        return internetUseId;
    }

    public void setInternetUseId(String internetUseId) {
        this.internetUseId = internetUseId;
    }

    public Double getUnitsMax() {
        return unitsMax;
    }

    public void setUnitsMax(Double unitsMax) {
        this.unitsMax = unitsMax;
    }

    public Double getUnitsMin() {
        return unitsMin;
    }

    public void setUnitsMin(Double unitsMin) {
        this.unitsMin = unitsMin;
    }

    @Transient
    public Double getUnitsAvg() {
        if (this.count != 0)
            return (double) (this.sum / this.count);
        else
            return 0.0;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getSum() {
        return sum;
    }

    public void setSum(Long sum) {
        this.sum = sum;
    }
}

