package packageMain;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity 
@Table (name="TypeMachine")
public class TypeMachine implements Serializable {
	
        private static final long serialVersionUID = 1L;
       
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idType;
	
	private String name;
	private String descriptionType;
	
	public int getIdType() {
		return idType;
	}

	public void setIdType(int idType) {
		this.idType = idType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescriptionType() {
	    return descriptionType;
	}

	public void setDescriptionType(String descriptionType) {
	    this.descriptionType = descriptionType;
	}

}
