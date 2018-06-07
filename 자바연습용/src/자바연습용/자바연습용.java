package 자바연습용;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;

public class 자바연습용 {
	public static void main(String args[]) throws InterruptedException, ExecutionException {

		/*LocalDateTime a = LocalDateTime.now();
		LocalDateTime b = LocalDateTime.now().toLocalDate().atTime(0, 0, 0);

		LocalDateTime todayAt6 = LocalDate.now().atTime(6, 0);

		// System.out.println("날짜를 구해보자 : " + a.getYear() + "/"+a.getMonthValue() + "/"
		// + a.getDayOfMonth());
		
		 * System.out.println("현재 시간 : " + a.toString());
		 * System.out.println("날짜를 구해보자 : " + b.getYear() + "-"+b.getMonthValue() + "-"
		 * + b.getDayOfMonth()); System.out.println("0시 0분 0초로 변환된 LocalDateTime : " +
		 * b.toString());
		 * 
		 * System.out.println("ld 형식의 스트링으로 변환된 ldt = " + b.toLocalDate().toString());
		 

		String x = "2018-03-09";
		String y = "2018-03-08";
		String z = "2018-03-09";

		System.out.println("x는 y보다 크므로, 1이 나옴 " + x.compareTo(y));
		System.out.println("y는 x보다 작으므로, -1이 나옴 " + y.compareTo(x));
		System.out.println("x는 z과 같으므로, 0이 나옴 " + x.compareTo(z));*/

		
		
		
		
		
		
		
		
		/*class A {
			String name;
			int age;

			A(String name, int age) {
				this.name = name;
				this.age = age;
			}

		}

		class B {
			String address;
			int birthday;

			B(String address, int birthday) {
				this.address = address;
				this.birthday = birthday;
			}
		}

		List<A> alist = new ArrayList<A>();
		alist.add(new A("홍승표", 29));
		alist.add(new A("김승표", 30));

		List<A> alist2 = new ArrayList<A>();
		alist2.add(new A("목동", 19900304));
		alist2.add(new A("중구", 19910304));

		List<B> blist = new ArrayList<B>();
		blist.add(new B("목동", 19900304));
		blist.add(new B("중구", 19910304));

		// flatMap vs map 메서드 간 차이...
		System.out
				.println(Stream.of(alist, alist2).flatMap(xx -> xx.stream()).collect(Collectors.toList()).get(0).name);
		System.out.println(Stream.of(alist, blist).flatMap(xx -> xx.stream()).collect(Collectors.toList()).get(3)
				.getClass().equals(A.class));*/

		
		
		
		
		
		
		
		//---------------------------- 쓰레드 completableFuture .. 시험용
		//ExecutorService e = Executors.newCachedThreadPool();
		/*long startTime = System.currentTimeMillis();
		CompletableFuture cf1 = CompletableFuture.supplyAsync(() -> {
			try {Thread.sleep(5000);} catch (Exception ex) {};
			System.out.println("cf1 supplyAsync on thread " + Thread.currentThread().getId() + " now="
					+ (System.currentTimeMillis() - startTime));
			return 100;
		});
		CompletableFuture cf2 = CompletableFuture.supplyAsync(() -> {
			try {Thread.sleep(1000);} catch (Exception ex) {};
			System.out.println("cf2 supplyAsync on thread " + Thread.currentThread().getId() + " now="
					+ (System.currentTimeMillis() - startTime));
			return 200;
		});
		CompletableFuture cf3 = CompletableFuture.supplyAsync(() -> {
			try {Thread.sleep(3000);} catch (Exception ex) {};
			System.out.println("cf3 supplyAsync on thread " + Thread.currentThread().getId() + " now="
					+ (System.currentTimeMillis() - startTime));
			return 300;
		});

		System.out.println("Task execution requested on thread " + Thread.currentThread().getId());
		cf3.thenComposeAsync((data1) -> cf2).thenComposeAsync((data2) -> cf1).join();
		System.out.println("final cf1.get() = " + cf1.get() + " cf2.get()=" + cf2.get() + " cf3.get()=" + cf3.get()
				+ " now=" + (System.currentTimeMillis() - startTime));*/
		/*LocalDateTime aaa = LocalDateTime.now();
		LocalDateTime bbb = LocalDateTime.now().toLocalDate().atTime(0, 0, 0);
		LocalDateTime ccc = LocalDateTime.of(2018, 3, 1, 0, 0, 0);
		Period period = Period.between(ccc.toLocalDate(), bbb.toLocalDate());
		
		System.out.println("시간차 : " + period.getDays());*/
		
		
		
		
		
		
		/*ExecutorService e = Executors.newCachedThreadPool();

	      CompletableFuture cf1= CompletableFuture.supplyAsync(()->{

	          try{Thread.sleep(3000);} catch(Exception ex){};

	          System.out.println("cf1 supplyAsync on thread "+Thread.currentThread().getId());

	          return 500;

	        });

	      



	      CompletableFuture<Integer> cf2= CompletableFuture.supplyAsync(() -> {

	          try{Thread.sleep(1000);} catch(Exception ex){};

	          System.out.println("cf2 supplyAsync on thread "+Thread.currentThread().getId());

	          return 10;

	        },e).thenCombineAsync(cf1,(Integer xxxx,Integer yyyy)-> { System.out.println(xxxx + " ... " + yyyy); return xxxx*yyyy; });
	      System.out.println("Task execution requested on thread " + Thread.currentThread().getId());

	      System.out.println("final result = " + cf2.get());
	      
	      System.out.println("Task execution requested on thread " + Thread.currentThread().getId());

	      System.out.println("final result = " + cf2.get());*/
		
		
		System.out.println("enum 테스트를 시작해봅시다");
		
		System.out.println(Type.valueOf("WALKING"));	// -> WALKING
		// 이건 에러.. System.out.println(Type.valueOf("워킹화"));
		System.out.println(Type.WALKING.getName());	// -> 워킹화
		
		if(OrderEnum.RLOR.getStatCd().equals("30")) {
			System.out.println("Enum의 코드 : " + OrderEnum.RLOR.getStatCd());
			
			System.out.println("출고지시를 해보장 이름 : " + OrderEnum.RLOR.getText());
		}
		
		A a = new A();
		B b = new B();
		System.out.println("A의 a값 " + a.a);
		System.out.println("B의 b값" + b.b);
		A aa = b;
		System.out.println("aa의 a값 "+aa.a);
		System.out.println(aa.toString());
		
		List<xxx> plusList = new ArrayList<>();
		List<xxx> minusList = new ArrayList<>();
		
		for(int i=0; i<100; i++) {
			plusList.add(new xxx(i));
			minusList.add(new xxx(-i));
		}
		
		
		Set<Integer> set = new HashSet<>();
		set.add(1);
		set.add(2);
		set.add(0);
		set.add(1);
		
		System.out.println("세트 : " + set.size() + " ... " + set.toArray());
		
		
	}
	
}

class A {
	int a;
	public A() {
		a = 111;
	}
}

class B extends A{
	int b;
	public B() {
		b = 222;
	}
}

class xxx {
	String name;
	int age;
	
	public xxx(int age) {
		this.name = "문자열의"+Integer.toString(age);
		this.age = age;
	}
}

enum Type {
    // 상수("연결할 문자")
    WALKING("워킹화"), RUNNING("러닝화")
    , TRACKING("트래킹화"), HIKING("등산화");
     
    final private String name;
     
    private Type(String name) { //enum에서 생성자 같은 역할
        this.name = name;
    }
    public String getName() { // 문자를 받아오는 함수
        return name;
    }
}

enum OrderEnum {
	ORD_ACCP("10", "접수")
	,	ORD_CMPLT("20", "주문완료")
	,	RLOR("30", "출고지시")
	,	GOODS_PREP("40", "상품준비")
	,	OWH_CMPLT("50", "출고완료")
	,	DLV_COMPLT("60", "배송완료");
	
	private final String statCd;
	private final String text;
	
	private OrderEnum(String statCd, String text) {
		this.statCd = statCd;
		this.text = text;
	}
	
	public String getStatCd() {
		return statCd;
	}
	
	public String getText() {
		return text;
	}
}
