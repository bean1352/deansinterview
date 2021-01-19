package corp.dean.fruits.boundary;

import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import corp.dean.fruits.model.Fruit;

@ApplicationScoped
public class FruitService {

	public List<Fruit> getFruits() {
		return Arrays.asList(new Fruit("Banana", "Yellow"));
	}
    
}
