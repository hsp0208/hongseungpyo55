 package 자바연습용;

public class 팩토리패턴 {
	public static void main(String[] args) {

		RobotFactory rf = new SuperRobotFactory();
		Robot r = rf.createRobot("super");
		Robot r2 = rf.createRobot("power");

		System.out.println(r.getName());
		System.out.println(r2.getName());

		RobotFactory mrf = new ModifiedSuperRobotFactory();
		Robot r3 =  mrf.createRobot("자바연습용.SuperRobot");
		Robot r4 =  mrf.createRobot("자바연습용.PowerRobot");

		System.out.println(r3.getName());
		System.out.println(r4.getName());
	}
}

abstract class RobotFactory {
	abstract Robot createRobot(String name);
}

class SuperRobotFactory extends RobotFactory {
	@Override
	Robot createRobot(String name) {
		switch( name ){
			case "super": return new SuperRobot();
			case "power": return new PowerRobot();
		}
		return null;
	}
}

class ModifiedSuperRobotFactory extends RobotFactory {
	@Override
	Robot createRobot(String name) {
		try {
			Class<?> cls = Class.forName(name);
			Object obj = cls.newInstance();
			return (Robot)obj;
		} catch (Exception e) {
			return null;
		}
	}
}




abstract class Robot {
	public abstract String getName();
}

class SuperRobot extends Robot {
	@Override
	public String getName() {
		return "SuperRobot";
	}
}

class PowerRobot extends Robot {
	@Override
	public String getName() {
		return "PowerRobot";
	}
}




