package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {
	private List<Car> cars = new ArrayList<>();

	HelloController() {
		cars.add(new Car("ВАЗ", 1, "Красный"));
		cars.add(new Car("ЗАЗ", 1, "Зеленый"));
		cars.add(new Car("УАЗ", 1, "Черный"));
		cars.add(new Car("ЛиАЗ", 1, "Желтый"));
		cars.add(new Car("ВАЗ", 2, "Брызги шампанского"));
		cars.add(new Car("ЗАЗ", 2, "Красный"));
	}

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
	public String printCarList(ModelMap model) {
		List<String> messages = new ArrayList<>();
		messages.add("Hello!");
		messages.add("I'm a car list");
		messages.add("А ты что думал?");
		model.addAttribute("messages", messages);
		return "index";
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