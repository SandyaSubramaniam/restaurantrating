package co.grandcircus.restaurantrating;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.restaurantrating.dao.RestaurantDao;
import co.grandcircus.restaurantrating.entities.Restaurant;

@Controller
public class RestaurantratingController {

	@Autowired
	private RestaurantDao dao;

	@RequestMapping("/")
	public ModelAndView showRestaurantRatingPage() {

		List<Restaurant> restaurants = dao.findAll();
		return new ModelAndView("home", "restaurants", restaurants);
	}

	@RequestMapping("/incrementRating")
	public ModelAndView incrementRating(@RequestParam("id") Integer restaurantId) {

		dao.incrementRating(restaurantId);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping("/decrementRating")
	public ModelAndView decrementRating(@RequestParam("id") Integer restaurantId) {

		dao.decrementRating(restaurantId);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping("/sortByRating")
	public ModelAndView sortByRating() {

		List<Restaurant> restaurants = dao.sortByRating();
		return new ModelAndView("home", "restaurants", restaurants);
	}

	@RequestMapping("/sortByName")
	public ModelAndView sortByName() {

		List<Restaurant> restaurants = dao.sortByName();
		return new ModelAndView("home", "restaurants", restaurants);
	}
}
