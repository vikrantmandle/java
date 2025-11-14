package com.app.thread.practice;

class Mythread extends Thread{
	// default parameterless constructor for the MyThread class is provided by JVM
	
	public void run() {
		System.out.println("Thread 0 started from My thread class");
	}
	
}

public class ThreadFirstProgramm {

	public static void main(String[] args) {
		
		// way 1 of execution
		Mythread myThread = new Mythread();
		myThread.start();
		
		//way2 of execution
		Thread thread1 = new Thread(()->
		{System.out.println("Thread 1 started the execution");
		});
		thread1.start();
		
		//way3 of execution using runnable interface
		Runnable objRunnable =() ->{
				System.out.println("objRunnable has started its execution");
			};
		
		Thread obj3 = new Thread(objRunnable,"Obj Runnable");
		obj3.start();
	}
}
