package javaexp.a07_access;

public class A01_Product {
/*
 필드(저장소)는 일반적으로 외부에서 직접적으로 접근하지 못하게 하고
 간접적으로 기능 메서드에 의해 저장 처리 (생성자,메서드를 통해사)
 직접접근 pro.name="사과"; X
 간접접근 pro.setName("사과"); O
 */ //다시 작성하기 아이패드에 캡쳐본 
private String name;
private int price;
private int cnt;
//생성자도 일반적으로 public 
public A01_Product(String name, int price, int cnt) {
	super();
	// TODO Auto-generated method stub
	this.name = name;
	this.price = price;
	this.cnt = cnt;
} 
//A01_Product(String name){}
//public A01_Product(String name, int price, int cnt) {
	//super();
	//this.name = name;
}
