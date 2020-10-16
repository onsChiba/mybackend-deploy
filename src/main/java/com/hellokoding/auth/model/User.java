package com.hellokoding.auth.model;

import javax.persistence.*;


import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
  ;
	private String firstname;
	private String lastname;
	private String numeroTelephone;
	private String addressPostal;
	private String email;
    private String password;
    private String dateDeNaissance;
   

    @Transient
    private String passwordConfirm;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "abonne_poissonFavoris",
      joinColumns = @JoinColumn(name = "User_id"),
      inverseJoinColumns = @JoinColumn(name = "PoissonFavoris_id"))
  private List <PoissonFavoris> poissons;
    
    @ManyToMany
    private Set<Role> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    
    public void removePoissons(PoissonFavoris poisson) {
		//poisson.setAbonne(null);
		poisson.setLesabonnes(null);
		
		this.poissons.remove(poissons);
	}
	
    
	

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getNumeroTelephone() {
		return numeroTelephone;
	}

	public void setNumeroTelephone(String numeroTelephone) {
		this.numeroTelephone = numeroTelephone;
	}

	public String getAddressPostal() {
		return addressPostal;
	}

	public void setAddressPostal(String addressPostal) {
		this.addressPostal = addressPostal;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(String dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public List<PoissonFavoris> getPoissons() {
		return poissons;
	}

	public void setPoissons(List<PoissonFavoris> poissons) {
		this.poissons = poissons;
	}

	public void addPoissons(PoissonFavoris poisson) {
		//poisson.setAbonne(this);
		poisson.getLesabonnes().add(this);
		
		//this.poissons.add(poisson);
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	
}
