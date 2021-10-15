package Java2.src.Buoi7;

public class ThreadDemo {
    public static void main(String[] args) {
        System.out.println("Main start");
        //lấy ra thread đang chạy hiện tại
        Thread mainThread = Thread.currentThread();
        System.out.println("Thông tin luồng hiện tại: " + mainThread.getId()
         + "; name = " + mainThread.getName()
         + "; priority = " + mainThread.getPriority()
         + "; status = " + mainThread.getState());

        //tạo thread
        //		MyThread thread1 = new MyThread("Thread 1");
        //		// running/ chay luong:
        //		thread1.start();// luong se duoc chay dong thoi voi main
        //		
        //		thread1.run(); //ready
        //		MyThread thread2 = new MyThread("Thread 2");
        //		thread2.start();
		
		//tao thread tu Runnable
		MyRunable myRunable = new MyRunable("Thread 1");
		Thread t1 = new Thread(myRunable);
		t1.start();
		MyRunable myRun2 = new MyRunable("Thread 2");
		myRun2.other = t1;
		Thread t2 = new Thread(myRun2);
		t2.start();
        
		//t1 ket thuc truoc main ket thuc
        try {
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//t2 xong truoc main
		//t2 xong truoc t1

        System.out.println("Main end");

        
    }
    
}
  //C1: tạo 1 class kế thừa class thread
class MyThread extends Thread{
    private String nameThread;
    public MyThread(String nameThread) {
        this.nameThread = nameThread;
    }

    @Override
    public void run() {
        System.out.println("Thread start");
        for(int i = 0; i < 20; i++){
            System.out.println(nameThread + ": " + i);
        }
        System.out.println("Thread end");
    }
}
//c2: tao 1 class implemant Runable
class MyRunable implements Runnable{
	String name;
	Thread other;
	public MyRunable(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println(this.name + " start");
		if (other != null) {
			//other xong truoc khi luon xong
			try {
				other.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (int i = 0 ; i< 100 ; i++) {
			System.out.println(this.name+": "+i);
		}
		System.out.println(this.name + " end");
	}
	
}
