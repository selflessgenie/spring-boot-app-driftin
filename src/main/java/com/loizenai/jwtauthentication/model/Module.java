package com.loizenai.jwtauthentication.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "modules", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
            "name"
        })
})
public class Module {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "module_id")
    private Long id;
	
	@NotBlank
    @Size(min=3, max = 50)
	@Column(name = "name")
    private String name;
	
	@NotBlank
    @Size(min=3, max = 300)
	@Column(name = "description")
    private String description;
	
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "module_id", referencedColumnName = "module_id")
	private List<Quiz> quizes;
	
	public Module() {}

	public Module(@NotBlank @Size(min = 3, max = 50) String name,
			@NotBlank @Size(min = 3, max = 300) String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Quiz> getQuizes() {
		return quizes;
	}

	public void setQuizes(List<Quiz> quizes) {
		this.quizes = quizes;
	}
	
}
