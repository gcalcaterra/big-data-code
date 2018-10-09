package tpBigdata.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="internetUse_detalle")
public class InternetUse implements Serializable {
	private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "internetUseId")
    private String internetUseId;

    @Basic(optional = false)
    @Column(name = "individualTypeId")
    private String individualTypeId;

    @Basic(optional = false)
    @Column(name = "geographyId")
    private String geographyId;

    @Basic(optional = false)
    @Column(name = "year")
    private Integer year;

    @Basic(optional = false)
    @Column(name = "units")
    private Integer units;

    public InternetUse() {
    	
    }

    public String getInternetUseId() {
        return internetUseId;
    }

    public void setInternetUseId(String internetUseId) {
        this.internetUseId = internetUseId;
    }

    public String getIndividualTypeId() {
        return individualTypeId;
    }

    public void setIndividualTypeId(String individualTypeId) {
        this.individualTypeId = individualTypeId;
    }

    public String getGeographyId() {
        return geographyId;
    }

    public void setGeographyId(String geographyId) {
        this.geographyId = geographyId;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getUnits() {
        return units;
    }

    public void setUnits(Integer units) {
        this.units = units;
    }
}

