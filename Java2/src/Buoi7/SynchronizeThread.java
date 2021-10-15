package Java2.src.Buoi7;

public class SynchronizeThread {
    public static void main(String[] args) {
        Account account = new Account (10000000);
        RutTienThread toi = new RutTienThread(account, "DucAnh");
        toi.start();
        RutTienThread vo = new RutTienThread(account, "Hong");
        vo.start();
        RutTienThread ban = new RutTienThread(account, "Ban");
        ban.start();
        RutTienThread bonhi = new RutTienThread(account, "Bonhi");
        bonhi.start();
        RutTienThread vo3 = new RutTienThread(account, "vo3");
        vo3.start();
    }
    
}
class RutTienThread extends Thread{
    Account account;
    String name;
    public RutTienThread(Account account, String name){
        super();
        this.account = account;
        this.name = name;
    }
    @Override
    public void run() {
       
        for(int i = 0; i < 3; i++){
            synchronized (account){
                account.rutTien(this.name, 1000000);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Account {
    long amount;
    public Account(long amount){
        super();
        this.amount = amount;
    }
    public synchronized void rutTien (String nguRut, long stRut){
        //rut tien
        System.out.println(nguRut + " tai khoan dang co: " + this.amount);
        if(stRut <= this.amount){
            this.amount -= stRut;
            System.out.println(nguRut + " da rut: " + stRut + " va tk con : " + this.amount);
        }
        System.out.println(nguRut + " sau khi rut tien tk con: " + this.amount);
       
    }
}