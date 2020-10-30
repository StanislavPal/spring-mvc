package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {
	private final int MAX_COUNT_ON_PAGE = 5;

	@Autowired
	private CarService carService;

	@GetMapping(value = "/car")
	public String printCarList(@RequestParam(value="count", required = false, defaultValue = "5") int count,
							   ModelMap model) {
		System.out.println(count);
		List<Car> cars = carService.getCarList(count > MAX_COUNT_ON_PAGE ? MAX_COUNT_ON_PAGE : count);
		model.addAttribute("cars", cars);
		return "cars";
	}

	@GetMapping(value = "/calculator")
	public String AlishevCalculator(@RequestParam(value="number1") int number1,
									@RequestParam(value="number2") int number2,
									@RequestParam(value="action") String action,
									ModelMap model) {
		List<String> messages = new ArrayList<>();
		double result = 0;
		String act = "";
		switch (action) {
			case "mult": {
				result = number1 * number2;
				act = " x ";
				break;
			}
			case "div": {
				result = (double) number1 / number2;
				act = " / ";
				break;
			}
			case "add": {
				result = number1 + number2;
				act = " + ";
				break;
			}
			case "sub": {
				result = number1 - number2;
				act = " - ";
				break;
			}
		}
		messages.add(number1 + act + number2 + " = " + result);
		model.addAttribute("messages", messages);
		return "index";
	}
}