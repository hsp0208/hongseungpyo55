package 자바연습용;

@FunctionalInterface
interface 함수형인터페이스 {
	int 삼성증권원주뻥튀기(int 원, double 비율);
	default void 구현가능한_디폴트_메서드(int a) {
		System.out.println("오오 이젠 인터페이스 조차 구현이 가능하옵니다 " + a);
	}
}

class 나는클래스 implements 함수형인터페이스 {
	@Override
	public int 삼성증권원주뻥튀기(int 배당_원, double 배당_비율) {
		System.out.println("(2)행위를 지정 : " + 배당_원);
		return (int) (배당_원*배당_비율);
	}
	@Override
	public void 구현가능한_디폴트_메서드(int a) {
		System.out.println("하하하하하하 니놈 정체가 뭐냐");
	}
}

abstract class 나는추상클래스 implements 함수형인터페이스 { }

public class 람다기초 {
	
	static int 뻥튀기(int i, double rate, 함수형인터페이스 ii) {
		System.out.println("(a)뻥튀기 실행 " + i);
		i = ii.삼성증권원주뻥튀기(i, rate);
		System.out.println("(b)아니 " + rate + "배 뻥튀기라니? " + i);
		return i;
	}
	
	public static void main(String[] args) {
		나는클래스 p = new 나는클래스();
		
		System.out.println("--------------------------------------");
		// 람다식
		int 갓성증권 = 뻥튀기(1000, 5.5
				, (xy,yz) -> { System.out.println("(1)행위를 지정 : " + xy); return (int) (xy*yz);} );
		System.out.println("[A] 갓성증권  " + 갓성증권);
		
		System.out.println("--------------------------------------");
		// 인터페이스 직접 구현 (인터페이스를 구현한 익명클래스)
		int 갓성증권2 = 뻥튀기(1000, 5.5
						, new 함수형인터페이스() { 
							public int 삼성증권원주뻥튀기(int 배당_원, double 배당_비율) {
									System.out.println("(2)행위를 지정 222222 : " + 배당_원);
									return (int) (배당_원*배당_비율);
							}});
		System.out.println("[B] 갓성증권2  " + 갓성증권2);
		
		System.out.println("--------------------------------------");
		// 다형성을 이용한, 인터페이스에 구현한 클래스를 바인딩시켜 실행
		함수형인터페이스 아규먼트인터페이스 = p;
		int 갓성증권3 = 뻥튀기(2222, 100.0
				, 아규먼트인터페이스);
		System.out.println("[B] 갓성증권3  " + 갓성증권3);
		
		System.out.println("--------------------------------------"); 
		// 구현한 클래스 자체를 아규먼트로 대입시켜 실행
		int 갓성증권4 = 뻥튀기(1000, 5.5
				, p);
		System.out.println("[B] 갓성증권4  " + 갓성증권4);
		
		System.out.println("--------------------------------------"); 
		// 인터페이스를 상속받는 추상클래스를 익명클래스로 직접 구현하여 실행
		int 갓성증권5 = 뻥튀기(1000, 5.5
				, new 나는추상클래스() {
					public int 삼성증권원주뻥튀기(int 원, double 비율) {
						System.out.println("(2)행위를 지정 555555 : " + 원);
						return (int) (원*비율);
					}
				});
		System.out.println("[B] 갓성증권5  " + 갓성증권5);
		
		System.out.println("--------------------------------------"); 
		// 이미 구체화한 클래스를 다시 재정의(오버라이드) 하여 실행 (우선순위는 하위에서 구현한 애들이 우선권을 가짐)
		int 갓성증권6 = 뻥튀기(1000, 5.5
				, new 나는클래스() {
					public int 삼성증권원주뻥튀기(int 원, double 비율) {
						System.out.println("(2)행위를 지정 666666 : " + 원);
						return (int) (원*비율);
					}
				});
		System.out.println("[B] 갓성증권6  " + 갓성증권6);
		
		System.out.println("--------------------------------------"); 
		// 이미 구체화한 클래스를 바로 인스턴스로 만들어서 실행
		int 갓성증권7 = 뻥튀기(1000, 5.5
				, new 나는클래스());
		System.out.println("[B] 갓성증권7  " + 갓성증권7);
	}
	
}

