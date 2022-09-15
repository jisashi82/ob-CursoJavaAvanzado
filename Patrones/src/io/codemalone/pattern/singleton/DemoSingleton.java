package io.codemalone.pattern.singleton;

public class DemoSingleton {

	public static void main(String[] args) {
		System.out.println("Si ves el mismo valor, entonces el singleton fue reutilizado");
		
		Singleton s1 = Singleton.getInstance("FOO");
		Singleton s2 = Singleton.getInstance("BAR");
		System.out.println(s1.value);
		System.out.println(s2.value);
		
		
		System.out.println("En un entorno Multihilo se comporta de forma incorrecta");
		Thread threadFoo = new Thread(new ThreadFoo());
		Thread threadBar = new Thread(new ThreadBar());
		threadFoo.start();
		threadBar.start();
		
	}
	
	static class ThreadFoo implements Runnable {

		@Override
		public void run() {
			Singleton singleton = Singleton.getInstance("FOO");
			System.out.println(singleton.value);
		}		
	}
	
	static class ThreadBar implements Runnable {

		@Override
		public void run() {
			Singleton singleton = Singleton.getInstance("BAR");
			System.out.println(singleton.value);
		}		
	}

}
