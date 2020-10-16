package com.hellokoding.auth.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;


@Entity
@Table(name = "poissonFavoris")
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")

public class PoissonFavoris {

	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "abonne_poissonFavoris",
      joinColumns = @JoinColumn(name = "PoissonFavoris_id" ),
      inverseJoinColumns = @JoinColumn(name = "User_id"))
    private List <User> lesabonnes;
   


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public List<User> getLesabonnes() {
		return lesabonnes;
	}


	public void setLesabonnes(List<User> lesabonnes) {
		this.lesabonnes = lesabonnes;
	}


	public void setName(String name) {
		this.name = name;
	}



   

	
	

}

