package com.wgsh.example;

public class CopyTest {
	public static void main(String[] args){
		A a1 = new A(1);
		A a2 = new A(2);
		B b1 = new B(a1);
		B b2 = new B(a2);
		
		a1 = a2.copy();
		System.out.println(a1);
		System.out.println(a2);
		
		System.out.println(b1);
		System.out.println(b2);
		
		b1 = b2.copy();
		b1.setAObj(new A(3));
		System.out.println(b1);
		System.out.println(b2);
		b1.setAObj(4);
		System.out.println(b1);
		System.out.println(b2);
	}
}


class A{
	private int _a;
	public A(int a){
		_a = a;
	}
	public void setA(int a){
		_a = a;
	}
	public int getA(){
		return _a;
	}
	public A copy(){
		return new A(_a);
	}
	
	@Override
	public String toString(){
		return "A::int -> " + _a;
	}
}

class B{
	private A aObj;
	public B(A ao){
		aObj = ao;
	}
	public B(int a){
		aObj = new A(a);
	}
	
	public void setAObj(A ao){
		aObj = ao;
	}
	public void setAObj(int a){
		aObj.setA(a);
	}
	public A getAObj(){
		return aObj;
	}
	public B copy(){
		return new B(aObj);
	}
	
	@Override
	public String toString(){
		
		return "B::A -> " + aObj;
	}
}