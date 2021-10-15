package Java2.src.Buoi7.BTVN.Bai4;

public class Taoso {
    public static void main(String[] args) {
        test toi = new test();
        toi.start();
        binhPhuong gapDoi = new binhPhuong();
        gapDoi.start();
    }
}
class createNum {
    int max = 10;
    int min = 0;
    int random_double;
    public createNum (){
    }
    public int getRandom_double() {
        return random_double;
    }

    public void setRandom_double(int random_double) {
        this.random_double = random_double;
    }

    public void taoSo(int n){
        System.out.println("Tạo 1 số");
        random_double = (int)(Math.random() * (max - min + 1) + min);
    }   

}
class test extends Thread{
    createNum createNum;
    @Override
    public void run() {
        System.out.println("Tạo 1 số ngẫu nhiên");
        createNum.getRandom_double();
        System.out.println(createNum.getRandom_double());
    }
    
}

class binhPhuong extends Thread{
    createNum createNum;
    int n = createNum.getRandom_double();
    @Override
    public void run() {
        System.out.println("Số " + createNum.getRandom_double() + " sau khi bình phương: ");
        n = n * n;
    }
    
}
