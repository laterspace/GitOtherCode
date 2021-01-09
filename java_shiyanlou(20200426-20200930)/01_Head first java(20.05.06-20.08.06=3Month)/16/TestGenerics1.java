import java.util.*;

public class TestGenerics1 {
	


	public static void main(String[] args){

		new TestGenerics1().go();

	}	//	Close main

	public void go(){
		
		Animal[] animals ={new Dog(), new Cat(), new Dog()};
		Dog[] dogs ={new Dog(), new Dog(), new Dog()};
		takeAnimals(animals);
		takeAnimals(dogs);
		
		
	}
	
	public void takeAnimals(Animal[] animals){
		animals[0]=new Cat();
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







