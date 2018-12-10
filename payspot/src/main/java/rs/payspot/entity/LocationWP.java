package rs.payspot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "locationWP")
public class LocationWP {

	@Id
	@GeneratedValue(generator = "ID_GENERATOR")
	private Long id;
	
	@Column(name="wordpressId", unique = true)
	private String wordpressId;
	
	@Column(name="sifra", unique = true)
	private String sifra;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getWordpressId() {
		return wordpressId;
	}

	public void setWordpressId(String wordpressId) {
		this.wordpressId = wordpressId;
	}

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}
}
