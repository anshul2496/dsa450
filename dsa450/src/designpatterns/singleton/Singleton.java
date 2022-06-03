package designpatterns.singleton;

// Singleton using lazy initialization and double check locking

/*
Double-checked locking is the practice of checking a lazy-initialized object's state both before and after a synchronized block is entered to determine whether or not to initialize the object.

It does not work reliably in a platform-independent manner without additional synchronization for mutable instances of anything other than float or int. 
Using double-checked locking for the lazy initialization of any other type of primitive or mutable object risks a second thread using an uninitialized or partially initialized member 
while the first thread is still creating it, and crashing the program.

There are multiple ways to fix this. The simplest one is to simply not use double checked locking at all, and synchronize the whole method instead. With early versions of the JVM, 
synchronizing the whole method was generally advised against for performance reasons. But synchronized performance has improved a lot in newer JVMs, so this is now a preferred solution. 
If you prefer to avoid using synchronized altogether, you can use an inner static class to hold the reference instead. Inner static classes are guaranteed to load lazily.
 */
public class Singleton {
	private static volatile Singleton soleInstance;

	private Singleton() {
		// To protect ourselves from reflection
		if (soleInstance != null) {
			throw new RuntimeException("Use getInstance");
		}
	}

	// Non Compliant, Non Thread safe - can give partially baked object to one
	// thread
	public static Singleton getInstance() {
		if (soleInstance == null) {
			synchronized (Singleton.class) {
				if (soleInstance == null) {
					soleInstance = new Singleton();
				}
			}
		}
		return soleInstance;
	}

	// Compliant 1 - Either synchronize the whole method
	public static synchronized Singleton getInstance1() {
		if (soleInstance == null) {
			soleInstance = new Singleton();
		}
		return soleInstance;
	}

	// Compliant 2 - Holder pattern(using static inner class)
	private static class SingletonHolder {
		private static Singleton singleton = new Singleton();
	}

	public static Singleton getInstance3() {
		return SingletonHolder.singleton;
	}
}
