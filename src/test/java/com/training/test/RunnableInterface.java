package com.training.test;

public class RunnableInterface implements Runnable
{
	@Override
    public void run()
    {
        
    }

	public static void main(String[] args) 
	{
		Thread t1 = new Thread("Hello1");
		Thread t2 = new Thread("Hello2");
		t1.start();
		t2.start();

		System.out.println(t1.getName());
		System.out.println(t1.currentThread());
		System.out.println(t2.getName());
		System.out.println(t2.currentThread());
	}

}
