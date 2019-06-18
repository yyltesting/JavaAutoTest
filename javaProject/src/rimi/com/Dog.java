package rimi.com;

import java.util.ArrayList;
import java.util.List;

public class Dog {
	public String name;
	public String color;
	Dog(String name,String color){
		this.name=name;
		this.color=color;
	}
	
	public void run(){
		System.out.println(this.name+"dog is running");
	}
	
	public void catchMouse(Mouse m){
		m.cry();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog smalldog = new Dog("xiaoming","yellow");
		Dog bigdog = new Dog("xiaohua","black");
		Mouse bigmouse = new Mouse("jack",4);
		smalldog.run();
		bigdog.run();
		smalldog.catchMouse(bigmouse);
		
		
		List<String> arr= new ArrayList<String>();
		
		

	}

}
