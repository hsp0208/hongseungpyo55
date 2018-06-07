package 자바연습용;

public class 임시 {

	public static void main(String args[]) {
		String temp = "#35019990003                   001050423456789   01011112222                                                                1";
		
		temp = temp.replace("#", "");
		System.out.println(temp);
		
		
		
		
		
		
		/*String a = "123";
		System.out.println(a.getBytes().length);
		
		a = "가나다";
		System.out.println(a.getBytes().length);
		
		a = "나다라";
		System.out.println(a.getBytes().length);
		
		a = "     ";
		System.out.println(a.getBytes().length);
		
		a = "9";
		a = String.format("%" + "1" + "0" + "s", a);
		System.out.println(a.getBytes().length);
		System.out.println(a);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");*/
		
		
		
		/*LocalDateTime ldt = LocalDateTime.parse("2018-05-07 12:04:24", formatter);
		LocalDateTime nowLdt = LocalDateTime.now();
		// 2018-03-09 18:04:24
		
		System.out.println(ldt.toLocalDate());
		System.out.println(nowLdt.toLocalDate());
		System.out.println("-----------------");
		System.out.println(nowLdt.toLocalDate().until(ldt.toLocalDate()));
		System.out.println(ldt.toLocalDate().until(nowLdt.toLocalDate(), ChronoUnit.DAYS));
		System.out.println("------------------------");
		System.out.println(Duration.between(ldt, nowLdt).toDays());
		
		System.out.println("********************************");
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		LocalDate ldld = LocalDate.of(ts.getYear(), ts.getMonth(), ts.getDate());
		System.out.println(ts.toString());
		System.out.println(ldld.toString());
		System.out.println(ts.toLocalDateTime().toLocalDate());*/
		
		// 2018-02-09 12:48:58.0  .. 0~10
		
		
		
		/*String temp = "2018-02-09 12:48:58.0";
		LocalDate aa = LocalDate.parse(temp.substring(0,10), formatter);
		System.out.println(aa.toString());
		
		
		System.out.println("\n\n\n");
		
		List<String> list = new ArrayList<>();
		
		list.add("냐하하하");
		list.add("냐호호홍");
		
		System.out.println(list.toString());
		
		
		String bbb = "05041234";
		System.out.println(bbb.substring(0,4));
		
		String ccc = "#1234512345$#2345623456$";
		String[] cccArray = ccc.split("#");
		for(String cccc : cccArray) {
			cccc = cccc.replace("$", "");
			System.out.println(cccc);
			System.out.println(cccc.length());
			System.out.println();
		}
		
		String original = "#25019990003                     1050423456789   01011112222                                                                1$#25029990004                     1050434567890   12345678       01234567                                                    1$";
		String[] originArray = original.split("\\$");
		String[] otherArrray = original.split("#");
		
		
		System.out.println("지금 크기 $ : " + originArray.length);
		
		for(int xxx = 0; xxx < originArray.length; xxx++) {
			System.out.println(originArray[xxx]);
			System.out.println(originArray[xxx].length());
		}
		
		System.out.println("지금 크기 # : " + otherArrray.length);
		for(int xxx = 0; xxx < otherArrray.length; xxx++) {
			System.out.println(otherArrray[xxx]);
			System.out.println(otherArrray[xxx].length());
		}*/
	}
	
}
