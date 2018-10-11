package web20181001;

public class A {
	B b;
	
/*	A(B b){
		this.b = b;
	}*/
	
	void setB(B b) {
		this.b = b;
	}
	
	void print() {
		b.print();
	}
}

class B {
	void print() {
		System.out.println("b");
	}
}
