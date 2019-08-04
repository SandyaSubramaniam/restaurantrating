package co.grandcircus.restaurantrating.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "restaurant")
public class Restaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	private Integer rating;

	public Restaurant() {

		super();
	}

	public Integer getId() {

		return id;
	}

	public void setId(Integer id) {

		this.id = id;
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public int getRating() {

		return rating;
	}

	public void setRating(Integer rating) {

		this.rating = rating;
	}

	@Override
	public String toString() {

		return "Restaurant [id=" + id + ", name=" + name + ", rating=" + rating + "]";
	}
}
