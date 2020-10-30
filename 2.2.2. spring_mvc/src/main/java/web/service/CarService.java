package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    private List<Car> cars = new ArrayList<>();

    public CarService() {
        cars.add(new Car("ВАЗ", 1, "Красный"));
        cars.add(new Car("ЗАЗ", 2, "Зеленый"));
        cars.add(new Car("УАЗ", 3, "Черный"));
        cars.add(new Car("ЛиАЗ", 4, "Желтый"));
        cars.add(new Car("ВАЗ", 5, "Брызги шампанского"));
        cars.add(new Car("ЗАЗ", 6, "Красный"));
    }

    public List<Car> getCarList(Integer count) {
        if((count == null) || ( count > cars.size() )) {
            count = cars.size();
        }
        return cars.subList(0, count);
    }
}
