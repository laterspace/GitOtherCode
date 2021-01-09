import java.util.*;

public class TestGenerics2 {
	


	public static void main(String[] args){

		new TestGenerics2().go();

	}	//	Close main

	public void go(){
		
		ArrayList<Animal> animals = new ArrayList<Animal>();
		animals.add(new Dog());
		animals.add(new Cat());
		animals.add(new Dog());
		
		ArrayList<Dog> dogs =new ArrayList<Dog>();
		dogs.add(new Dog());
		dogs.add(new Dog());
		takeAnimals(animals);
		takeAnimals(dogs);
		
		
	}
	
	public void takeAnimals(ArrayList<Animal> animals){
		animals.add(new Cat());
		for (Animal a:animals){
			a.eat();
		}
	}
	
	
	
	
	
	
	
}	//	Close class


abstract class Animal{
	void eat(){
		System.out.println("animal eating");
	}
}

class Dog extends Animal {
	void bark(){}
}
class Cat extends Animal {
	void meow(){}
}







