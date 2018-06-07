package 자바연습용;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class 제네릭과_리플렉션 {

	public class Info {
		int age = 10;
		String name = "이름";
		
		public int getAge() {
			return this.age;
		}
		
		public String getName() {
			return this.name;
		}
		
		public Info() {
			System.out.println("호호호홍");
		}
	}
	
	public static void main(String[] args) {
		Field[] f;					//어떤 클래스의 필드들을 얻는다.
		Method[] m;			//어떤 클래스의 메서드들을 얻는다.
		Constructor[] cs;		//어떤 클래스의 생성자들을 얻는다.
		Class[] interfaces;	//어떤 클래스의 내부 인터페이스들을 얻는다.
		Class sClass;			//어떤 클래스의 슈퍼클래스를 얻는다.
		
		Class c = Info.class;
		
		f = c.getFields();
		m = c.getMethods();
		cs = c.getConstructors();
		interfaces = c.getInterfaces();
		sClass = c.getSuperclass();
		
		for(int i=0; i<m.length; i++) {
			System.out.println(m[i].getName());
			System.out.println(m[i].getParameterTypes());
		}
	}
	
}
