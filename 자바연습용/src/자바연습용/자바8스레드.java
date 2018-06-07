package 자바연습용;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class 자바8스레드 {
	public static void main(String args[]) throws InterruptedException, ExecutionException {
		System.out.println("너 정체가 뭐냐 " + args.length);
		
		
		// 싱글 스레드이기에, 가용 스레드가 단 하나다.
		// 그래서, ex 실행자를 보내도, ex2는 가용 스레드풀이 없기에, ex가 끝날 때 까지 기다린다.
		System.out.println("자바8의 신규 쓰레드를 알아보자");
		ExecutorService ex = Executors.newSingleThreadExecutor();
		ExecutorService ex2 = Executors.newSingleThreadExecutor();
		ex.submit( () -> {
			for(int i=0; i<5; i++) System.out.println("쓰레드 위에 참새 루프 : " + (i+1)) ;
		});
		System.out.println("야옹야옹");
		ex2.submit( () -> {
			for(int j=11; j<=15; j++) System.out.println("쓰레드 위에 비둘기 루프 : " + (j)) ;
		});
		System.out.println("멍멍멍멍");
		ex.shutdown();
		ex2.shutdown();
		
		// 이번에는, 스레드로 다녀온 놈을 값에 대입해보자 (내가 필요한 부분)
		Callable<Integer> threadTask = () -> {
			System.out.println("콜러블 인터페이스를 구현할 것이고, 100 함수를 호출");
			TimeUnit.SECONDS.sleep(8);
			return 숫자100을_반환();
		};
		
		Callable<Double> threadTask2 = () -> {
			System.out.println("콜러블 인터페이스를 구현할 것이고, 200 함수를 호출");
			TimeUnit.SECONDS.sleep(5);
			return 숫자200을_반환();
		};
		ExecutorService executor = Executors.newFixedThreadPool(2);
		Future<Integer> intFuture = executor.submit(threadTask);
		Future<Double> doubleFuture = executor.submit(threadTask2);
		
		System.out.println("시작 1");
		
		System.out.println("intFuture done? " + intFuture.isDone());
		System.out.println("doubleFuture done? " + doubleFuture.isDone());
		
		Double doubleResult = doubleFuture.get();
		System.out.println("시작 2");
		System.out.println("intFuture done? " + intFuture.isDone());
		System.out.println("doubleFuture done? " + doubleFuture.isDone());
		
		Integer intResult = intFuture.get();
		System.out.println("시작 3");
		System.out.println("intFuture done? " + intFuture.isDone());
		System.out.println("doubleFuture done? " + doubleFuture.isDone());
		
		System.out.println("끄으읕인데, 쓰레드 내려야지 참");
		executor.shutdown();
		
	}
	
	
	public static int 숫자100을_반환() {
		return 100;
	}
	
	public static double 숫자200을_반환() {
		return 200.0;
	}
}
