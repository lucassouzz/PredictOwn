package packageMain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity 
@Table (name="TypeMachine")
public class TypeMachine {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idType;
	
	private String name;
	
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

}
