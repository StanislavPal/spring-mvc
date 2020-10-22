package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.model.Service;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

	@GetMapping(value = "/")
	public String printWelcome(ModelMap model) {
		List<String> messages = new ArrayList<>();
		messages.add("Hello!");
		messages.add("I'm Spring MVC application");
		messages.add("5.2.0 version by sep'19 ");
		model.addAttribute("messages", messages);
		return "index";
	}
	
	@GetMapping(value = "/car")
	public String printCarList(@RequestParam(value="count", required = false) Integer count,
							   ModelMap model) {
		List<Car> cars = new Service().getCarList(count);
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