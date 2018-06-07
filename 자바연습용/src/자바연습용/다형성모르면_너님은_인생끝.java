package 자바연습용;


interface 인터페이스1번 {
	void 메서드1번();
}

interface 인터페이스2번 extends 인터페이스1번 {
	void 메서드2번();
}


abstract class 추상클래스 {
	int age;
	String name;
	String level;
	
	public 추상클래스() {
		age = 0;
		name = "익명";
		level = "";
	}
	
	void setName(String name) {
		this.name = name;
	}
	void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	abstract void setLevel(String level);
}

public class 다형성모르면_너님은_인생끝 {
	
	public static void main(String[] args) {
		추상클래스 temp = new 추상클래스() {
			void setLevel(String level) {
				System.out.println("추상클래스를 익명클래스로 바로..");
			}
		};
		
		인터페이스2번 인터페이스 = new 인터페이스2번() {
			public void 메서드1번() {
			}
			public void 메서드2번() {
			}
		};
		
		인터페이스 = new 인터페이스2번() {
			public void 메서드1번() {
			}
			public void 메서드2번() {
			}
		};
		
		인터페이스.메서드1번();
		
		//////////////////////////////////////////
		
		부모 a = new 부모();
		부모 b = new 자식1();
		부모 c = new 자식2();
		
		//////////////////////////////////////////
		System.out.println("부모 a : " + a.a);
		a.부모메서드();
		
		///////////////////////////////////////
		System.out.println("부모 b : " + b.a);
		b.부모메서드();
		
		///////////////////////////////////////
		System.out.println("부모 c : " + c.a);
		c.부모메서드();
				
		///////////////////////////////////////
		자식2 d = (자식2) c;
		System.out.println("자식2 d : " + d.a + " ... " + d.b);
		d.부모메서드();
		d.자식메서드();
		
		////////////////////////////////////
		d.b = -1;
		d.a = -1;
		c = (부모) d;
		System.out.println("부모 c : " + c.a );
		c.부모메서드();
		
		////////////////////////////////////
		자식2 e = (자식2) c;
		System.out.println("자식2 e : " + e.a + " ... " + e.b);
		e.부모메서드();
		e.자식메서드();
		
	}
}

class 부모 {
	int a;
	public 부모() { a = 0;}
	public void 부모메서드() { System.out.println("부모 메서드 호출"); }
}

class 자식1 extends 부모 {
	int b;
	public 자식1() { a = 1; b = 1;}
	public void 자식메서드() { System.out.println("자식1 메서드 호출"); }
}
class 자식2 extends 부모 {
	int b;
	public 자식2() { a = 2; b = 2;}
	public void 부모메서드() { System.out.println("부모 메서드 오버라이드 및 호출"); }
	public void 자식메서드() { System.out.println("자식2 메서드 호출"); }
}
class 자식3 extends 부모 {
	int b;
	public 자식3() { a = 3; b = 3;}
	public void 자식메서드() { System.out.println("자식3 메서드 호출"); }
}

