import java.util.*;
import java.io.*;
public class prob_3_6{
	public static void main(String[] args){
		AnimalQueue q = new AnimalQueue();
		q.enqueue(new Cat("Sophie"));
		q.enqueue(new Dog("Dolly"));
		q.enqueue(new Cat("Nikki"));
		System.out.println(q.dequeAny());
		System.out.println(q.dequeCat());
		System.out.println(q.dequeAny());
	}
}
class Animal{
	String name;
	int time;
	public static int order = 0;
	public Animal(String name){
		this.name = name;
		this.time = order ++;
	}
}

class Dog extends Animal{
	public Dog(String name){
		super(name);
	}
	public String toString(){
		return this.name;
	}
}

class Cat extends Animal{
	public Cat(String name){
		super(name);
	}
	public String toString(){
		return this.name;
	}
}

class AnimalQueue{
	ArrayList<Dog> dogs;
	ArrayList<Cat> cats;
	AnimalQueue(){
		dogs = new ArrayList<Dog>();
		cats = new ArrayList<Cat>();
	}

	public void enqueue(Animal animal){
		if(animal instanceof Cat){
			cats.add((Cat)animal);
		}
		else{
			dogs.add((Dog)animal);
		}
	}

	public Animal dequeCat(){
		if(cats.size() == 0){
			return null;
		}
		Animal a = cats.get(0);
		cats.remove(0);
		return a;
	}

	public Animal dequeDog(){
		if(dogs.size() == 0){
			return null;
		}
		Animal a = dogs.get(0);
		dogs.remove(0);
		return a;
	}
	public Animal dequeAny(){
		if((cats.size() == 0) && (dogs.size() == 0)){
			return null;
		}
		if(cats.size() == 0){
			Animal a = dogs.get(0);
			dogs.remove(0);
			return a;
		}
		if(dogs.size() == 0){
			Animal a = cats.get(0);
			cats.remove(0);
			return a;
		}
		if((dogs.get(0).order < cats.get(0).order)){
			Animal a = dogs.get(0);
			dogs.remove(0);
			return a;
		}
		else{
			Animal a = cats.get(0);
			cats.remove(0);
			return a;
		}
		
	}
}
