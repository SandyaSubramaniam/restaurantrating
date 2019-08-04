package co.grandcircus.restaurantrating.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import co.grandcircus.restaurantrating.entities.Restaurant;

@Repository
@Transactional
public class RestaurantDao {

	@PersistenceContext
	private EntityManager em;

	public List<Restaurant> findAll() {

		return em.createQuery("FROM Restaurant", Restaurant.class).getResultList();
	}

	public void update(Restaurant restaurant) {

		em.merge(restaurant);
	}

	public void incrementRating(Integer restaurantId) {

		Query updateQuery = em.createQuery("UPDATE Restaurant SET rating = rating + 1 where id = :id");
		updateQuery.setParameter("id", restaurantId);
		updateQuery.executeUpdate();
	}

	public void decrementRating(Integer restaurantId) {

		Query updateQuery = em.createQuery("UPDATE Restaurant SET rating = rating - 1 where id = :id");
		updateQuery.setParameter("id", restaurantId);
		updateQuery.executeUpdate();
	}

	public List<Restaurant> sortByRating() {

		return em.createQuery("FROM Restaurant r ORDER BY r.rating", Restaurant.class).getResultList();
	}

	public List<Restaurant> sortByName() {

		return em.createQuery("FROM Restaurant r ORDER BY r.name", Restaurant.class).getResultList();
	}
}
