package 자바연습용;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class 병렬스트림연습 {

	public static void main(String[] args) {
		List<Girl> girlsList = new ArrayList<>();
		girlsList.add(new Girl(1, "태연"));
		girlsList.add(new Girl(2, "유리"));
		girlsList.add(new Girl(3, "윤아"));
		girlsList.add(new Girl(4, "써니"));
		girlsList.add(new Girl(5, "효연"));
		girlsList.add(new Girl(6, "티파니"));
		girlsList.add(new Girl(7, "제시카"));
		
		girlsList.stream().forEach(x -> System.out.println(x.age + " / " + x.name + " -> " + Thread.currentThread().getName()));
		// -> sequential stream .. 순차스트림.
		System.out.println("-------------------------------");
		
		girlsList.parallelStream().forEach(x -> System.out.println(x.age + " / " + x.name + " -> " + Thread.currentThread().getName()));
		// -> parallel .. 병렬.. 뭐에대한? 이 girlsList 를 구성하는 요소들에 대해서, cpu 자원의 스레드를 할당시키겠다. 물론 닫으면, 끝남.
		System.out.println("-------------------------------");
		
		girlsList.parallelStream().forEach(y -> System.out.println(y.age + " / " + y.name + " -> " + Thread.currentThread().getName()));
		
		//-------------------------
		// 순차스트림 (stream) : 콜렉션 내부 엘리먼트들을 하나하나 돌려서 파이프라인을 태운다.
		// 병렬스트림 (parallelStream) : 콜렉션 내부 엘리먼트들에 스레드 자원을 할당하여 파이프라인을 태운다. 순서를 보장할 수 없다.
		//                                        그래서, 단순히 필터링을 하는 것처럼 순서와 상관없는 작업이라면, 병렬처리가 더 빠르다.
		//										  병렬 스트림은, 프리머티브 타입을 래퍼타입으로 박싱하여 계산하기에, 속도가 느리다.. 개수가 많으면 빨라진다.
	}
	
	public long measureSumPerf(Function<Long, Long> adder, long n) {
		  long fastest = Long.MAX_VALUE;
		  
		  for(int i = 0; i < 10; i++) {
		    long start = System.nanoTime();
		    long sum = adder.apply(n);
		    long duration = (System.nanoTime() - start) / 1_000_000;
		    System.out.println("Result: " + sum);
		    
		    if(duration < fastest) fastest = duration;
		  }
		  
		  return fastest;
	}
}




class Girl {
	int age;
	String name;
	public Girl(int age, String name) {
		this.age = age;
		this.name = name;
	}
}