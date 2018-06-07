package 자바연습용;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@FunctionalInterface
interface AAA {
	int 니놈은_반드시_구현해야하는_추상메서드();
	default void 디폴드인터페이스메서드() {System.out.println("오호호호호호호호호호홍");}
}
class 나는널구현할거야 implements AAA {
	public int 니놈은_반드시_구현해야하는_추상메서드() {나는널구현할거야 이놈 = new 나는널구현할거야(); return 123;}
	//public void 디폴드인터페이스메서드() {System.out.println("무림의 고수들");  println("냐호");}
	
	/*public void println(String 파라미터) {
		int i = 파라미터.length();
	}*/
	
}

//---------------------------------------------------------------------------------------
//익명함수 .. 자바스크립트의... 행위 자체를 하나에 객체 혹은 변수에 대입해서 사용하는데, 이름이 없는 함수이다.
//익명클래스 .. 이름이 없는 클래스. 실행 도중, 클래스의 선언과 생성을 동시에 해버려서 일회성으로 사용되는 놈.

//---------------------------------------------------------------------------------------
//함수형 인터페이스?
//인터페이스긴 한데.. 함수형? 뭐냐 니놈은
// 함수? 인풋 -> 아웃풋 나온다.
// 메서드? 클래스 안에 들어있는 함수.
// 함수 vs 메서드 ? 단순히, 함수가 클래스 안에 들어간게 메서드?
// 함수는 바깥에도 있을 수 있다는 건데.
// 이 말 다시 풀면. 함수는 독립적이다. 혼자서도 기능이 된다.
// 메서드는 클래스 안에서 그 클래스, 객체, 인스턴스의 상태를 조작해주는 놈.
// 좀 더 추상화시킨 답변 : 메서드는 클래스에 종속적이다.
// 심지어, 자바에는 함수 개념이 존재하지 않는다.

// 이러한 함수의 개념을 도입하기 위해서 나온게 바로 함수형 인터페이스다. 그게 자바 8부터 거의 확립이 되었다.
// 그렇다면 이 함수형 인터페이스가, 함수로서 어떻게 동작하나?
// 인터페이스의 추상메서드를 하나만 정의한다.

//---------------------------------------------------------------------------------------
//이제 준비가 갖추어졌다.
//진짜 람다식을 들어가보자.
//람다식이 나온 배경은? 코드 길이 줄어든다. 맞소.
// 지금까지 아규먼트를 넘길 때, 상태값만 넘겼다. 싫다..
// 행위 자체를 압축해서 아규먼트로 넘길 수 없을까?
// 인터페이스 또한, 파라미터 타입으로 지정하여 넘길 수 있다.

// 그러면, 저런 인터페이스를 어딘가에서 구현해가지고, 그걸 넘겨도 된다.
// 그러나, 익명클래스처럼 그 자리에서 만들어가지고도 넘길 수 있다.
// 근데, 저렇게 그 자리에서 다 만들면 너무 코드가 지저분해진다.
// 그래서 나온게 람다식이다. 저 일회성으로 만들어서 바로 넘기는게 지저분하기에 압축시킨 코드가 바로 람다식이다.






// 함수 vs 메서드
// 인터페이스와 함수형 인터페이스  @FunctionalInterface
//   (자바 8..디폴트 추상메서드.. 인터페이스 내에서 구현되며, 구현하는 클래스가 이 메서드까진 구현안해도 됨. 오버라이드도 가능.)
//  Supplier<T> - 파라미터는 없으면서, 리턴타입만 있는 메서드다.
//  Consumer<T> - 서플라이어 인터페이스랑 달리, 리턴은 없고 (void) 인풋만 받는 메서드를 가진다.
//  Function<T,R> - 전형적인 함수를 지원하는 함수형 인터페이스다.
//  Predicate<T> - 하나의 인자와 리턴타입을 가진다. 근데, 이거는 리턴타입이 boolean 으로 고정되어 있다.
// 파라미터는 인터페이스도 받을 수 있다. (아규먼트는 행위를 직접 구현해서 들어간다.)
// 저 아규먼트는 익명클래스를 생성하는 것과 동일한 원리이다.
// 람다식은 저 아규먼트의 행위를 일일이 구현하기 코드가 기니까, 줄인 것 뿐이다.





// 함수형 인터페이스 + 람다식 -> 스트림 API (람다식의 완성판이자 종점 .. 이거 정복하면 람다 마스터임 너님 ㅇㅈ)
// 스트림이란 뭐냐? 함수형 인터페이스와 람다식을 구현하여, 코드를 파이프라인 (자바의 메서드체이닝) 형태로 짜는 형태
// 이 스트림을 가능하게 하기 위해서 존재하는게 스트림 API

// 스트림은 크게 3가지의 연산 형태를 가진다.
// (1) 스트림 open .. 콜렉션에서 직접 메서드 호출도 가능하며, 스트림 객체에 할당/대입도 가능
// (2) 중개연산 .. 매핑, 필터링, 제거 등등
// (3) 최종연산 (closure 연산) .. 스트림을 끝내며, 스트림 객체를 다시 콜렉션, 그룹핑, 서머리, 최대-최소값 연산, 루프.. 리턴 (void도 있음); 
// 

public class 람다마스터가되기위해 {
	
	//aaa
	public static int temp123(AAA 나는함수형인터페이스) {
		return 나는함수형인터페이스.니놈은_반드시_구현해야하는_추상메서드();
	}
	
	public static void temptemp( ) {
		int 답장 = temp123(new 나는널구현할거야());
		
		System.out.println("난 답장을 받았어 - " + 답장);
		
		int 답장2 = temp123(new AAA() { 
			public int 니놈은_반드시_구현해야하는_추상메서드() { 
				return 456;
			}
		});
		
		System.out.println("나도 답장을 받았어 - " + 답장2);
	}
	
	// Predicate 함수형 인터페이스를 받아서, 이를 실행함
		// 인터페이스가 여러개의 행위를 한번에 통합한다.
		// 한번에 통합 가능한 이유는, 어차피 구현해야 할 추상메서드는 하나다.
		// 즉 하나의 메서드 안에서 모든게 통합된다.
		// 인터페이스의 구현체는, 이 한 메서드 안에 들어간 애들만 실행한다.
		// 즉, 인터페이스 자체는 하나의 파사드가 되는 것이다.
		static List<Fruit> extractFruitList(List<Fruit> fruits, Predicate<Fruit> predicate){
		    //List<Fruit> resultList2 = new ArrayList<>();
		    //resultList2 = fruits.stream().filter(x -> x.getName().equals("apples")).collect(Collectors.toList());
		    
		    List<Fruit> resultList = new ArrayList<>();
		    for(Fruit x : fruits){
		        if(predicate.test(x)){
		            resultList.add(x);
		        }
		    }
		    return resultList;
		}
	
	public static void main(String[] args) {
		Object iv = new Object(){ int i=0; void method(){System.out.println("냐냐냐냐냐냥 호");} };	
		
		temptemp( );
		
		int a = 0;
		Profile x = new Profile();
		List<Profile> testList = new LinkedList<>();
		x.age = 10;
		x.name = "10살";
		testList.add(x);
		x = new Profile();
		x.age = 20;
		x.name = "20살";
		testList.add(x);
		x = new Profile();
		x.age = 2;
		x.name = "2짤!";
		testList.add(x);
		
		Stream<Profile> stst = testList.stream();
		
		List<Integer> ageList = testList.stream().map(xxx -> xxx.getAge()).collect(Collectors.toList());
		List<String> nameList = testList.stream().map(xxx -> xxx.getName()).collect(Collectors.toList());
		
		testList.stream().forEach(xxx -> xxx.setAge(100 * xxx.getAge()));

		
		List<Fruit> fruits = Arrays.asList(new Fruit("apple", "red"), new Fruit("melon", "green"), new Fruit("banana", "yellow"));
		List<Fruit> appleList1 = extractFruitList(fruits, new Predicate<Fruit>() {
			public boolean test(Fruit x) {
				return "apple".equals(x.getName());
			}
		});
		List<Fruit> redList1 = extractFruitList(fruits, new Predicate<Fruit>() {
			public boolean test(Fruit x) {
				return "red".equals(x.getColor());
			}
		});
		
		List<Fruit> appleList2 = extractFruitList(fruits, xx -> "apple".equals( (xx.getName() ) ) );
		List<Fruit> redList2 = extractFruitList(fruits, xx -> "red".equals( (xx.getColor() ) ) );
		
		
		Supplier<String> s = () -> "hello supplier";
		String result = s.get();
		System.out.println("서플라이어 테스트 : " + s.get());

		Consumer<String> c = str -> System.out.print(str + " .... ");
		Consumer<String> c1 = str -> System.out.println(str + "111");
		Consumer<Integer> cc = str -> System.out.println(str + "222");
		Consumer<String> ccc = c.andThen(c1);
		c.accept("hello consumer");
		System.out.println();
		System.out.println("-------");
		ccc.accept("냐호냐호 ");
		System.out.println("-------");
		
		Function<String, Integer> f = str -> Integer.parseInt(str);
		Function<String, Integer> f1 = str -> Integer.parseInt( str);
		Function<String, Integer> f2 = str -> Integer.parseInt("2");
		Function<Integer, Integer> f3 = aaa -> 2*aaa;
		Function<Integer,String> f4 = bbb -> String.valueOf(bbb);
		Integer resultIf = f.apply("1");
		Function<String, String> ff = f.andThen(f3).andThen(f4);
		Function<String, Integer> fff = f.andThen(f3);
		Function<String, String> ffff = f.andThen(f3).andThen(f4);
		System.out.println("함수 인터페이스 테스트 : " + fff.apply("333") + " ... 니놈의 타입은 " + fff.apply("333").getClass());
		System.out.println("함수 인터페이스 테스트 2차 : " + ffff.apply("500") + " ... 타입은 " + ffff.apply("500").getClass());
		
		
		Predicate<String> p = str -> !str.isEmpty();
		Predicate<String> p1 = str -> str.length() < 10;
		Predicate<String> p2 = str -> str.isEmpty();
		Predicate<String> p3 = str -> str.isEmpty();
		Predicate<String> pp;
		pp = p.and(p1).or(p);
		
		boolean result123 = p.test("나 아직 살아있어");
		boolean result234 = pp.test("열글자가????????????????????");
		System.out.println("으음 : " + result123);
		System.out.println("predicate 조합하기 : " + result234);
		
	}
}



class Fruit{
    private String name;
    private String color;

    Fruit(String name, String color){
        this.name = name;
        this.color = color;
    }

    String getName(){
        return this.name;
    }

    String getColor(){
        return this.color;
    }
}


class Profile {
	int age;
	String name;

	int getAge() { return this.age; }
	String getName() { return this.name; }
	void setAge(int age) { this.age = age; }
	void setName(String name) { this.name = name; }
}
