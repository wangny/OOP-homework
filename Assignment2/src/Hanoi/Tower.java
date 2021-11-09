package Hanoi;

import java.util.Stack;

public class Tower{
	Stack<Integer> tower;
	public String name;
	
	Tower(String str){
		this.tower = new Stack<Integer>();
		this.name = new String();
		this.name = str;
	}
	int pop(){
		return this.tower.pop();
	}
	void push(int i){
		this.tower.push(i);
	}
	
}
