package designpatterns.creational.singleton;

enum SingletonEnum {
	INSTANCE;
}

public class SingletonUsingEnum {

	public static void main(String[] args) {
		System.out.println("Singleton hash code = " + SingletonEnum.INSTANCE.hashCode());
	}
}
