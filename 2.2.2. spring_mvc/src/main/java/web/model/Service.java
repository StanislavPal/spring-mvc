package web.model;

import java.util.ArrayList;
import java.util.List;

public class Service {
    private List<Car> cars = new ArrayList<>();

    public Service() {
        cars.add(new Car("ВАЗ", 1, "Красный"));
        cars.add(new Car("ЗАЗ", 1, "Зеленый"));
        cars.add(new Car("УАЗ", 1, "Черный"));
        cars.add(new Car("ЛиАЗ", 1, "Желтый"));
        cars.add(new Car("ВАЗ", 2, "Брызги шампанского"));
        cars.add(new Car("ЗАЗ", 2, "Красный"));
    }

    public List<Car> getCarList(Integer count) {
        if((count == null) || ( count > cars.size() )) {
            count = cars.size();
        }
        return cars.subList(0, count);
    }
}
