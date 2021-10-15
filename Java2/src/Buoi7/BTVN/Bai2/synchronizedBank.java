package Java2.src.Buoi7.BTVN.Bai2;

public class synchronizedBank {
    public static void main(String[] args) {
        Account account = new Account (10000000);
        RutTienThread toi = new RutTienThread(account, "Duc Anh");
        toi.start();
        NhapTienThread vo = new NhapTienThread(account, "Vo toi");
        vo.start();
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
                account.rutTien(this.name, 500000);
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class NhapTienThread extends Thread{
    Account account;
    String name;
    public NhapTienThread(Account account, String name){
        super();
        this.account = account;
        this.name = name;
    }
    @Override
    public void run() {
        for(int i = 0; i < 1; i++){
            synchronized (account){
                account.nhaptien(this.name, 1000000);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Account{
    private long amount;
    
    public long getAmount() {
        return amount;
    }
    public void setAmount(long amount) {
        this.amount = amount;
    }
    public Account(long amount){
        super();
        this.amount = amount;
    }
    public synchronized void rutTien(String ngRut, long stRut){
        //rut tien
        System.out.println(ngRut + " tai khoan dang co: " + this.amount);
        if(stRut <= this.amount){
            this.amount -= stRut;
            System.out.println(ngRut + " da rut: " + stRut + " va tk con : " + this.amount);
        }else{
            System.out.println("Tk khong du");
        }
    }
    public synchronized void nhaptien(String ngNhap, long stNhap){
        //nhap tien
        System.out.println(ngNhap + " tai khoan dang co: " + this.amount);
        this.amount += stNhap;
        System.out.println(ngNhap + " da them: " + stNhap + " va tk con : " + this.amount);
    }
}
