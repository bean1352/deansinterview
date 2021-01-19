package corp.dean.fruits.boundary;

import java.util.Arrays;
import java.util.ArrayList;

import javax.enterprise.context.ApplicationScoped;

import corp.dean.fruits.model.Fruit;

@ApplicationScoped
public class FruitService{

	ArrayList<Fruit> initList = new ArrayList<Fruit>();


	FruitService(){
		initList.add(new Fruit("Banana","Yellow"));
	}
	

	public ArrayList<Fruit> getFruits() {
		//return Arrays.asList(new Fruit("Banana", "Yellow"));
		
		return initList;
	}
	public ArrayList<Fruit> addFruit(String name, String colour){
		initList.add(new Fruit(name, colour));
		return initList;
	}
	public ArrayList<Fruit> deleteFruit(String name){
		
		initList.removeIf(fruit -> fruit.getFruitName().equals(name));

		return initList;
	}

    
}
