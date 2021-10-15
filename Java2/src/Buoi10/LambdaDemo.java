package Java2.src.Buoi10;

public class LambdaDemo {
    /**
     * Class anonumous
     * Interfacefunction
     * Bieu thuc lambda
     * Stream
     */
    public static void main(String[] args) {
        //Comparator
        //Runable
        ICal cong1 = new Caculator();
        cong1.execute(10, 20);
        //class anonymous -> class không tên, sinh ra vào thời điểm runtime -> abstract
        //button -
        ICal tru1 = new ICal(){
            @Override
            public void execute(int num1, int num2){
                System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
            }
            public void show(){
                
            }
        };
        tru1.execute(20, 10);
        //button *
        new ICal(){
            @Override
            public void execute(int num1, int num2){
                System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
            }
            public void show(){

            }
        }.execute(11,12);
        //Biểu thức lambda: biểu thức rút gọn định nghĩa code
        //(danh sách tham số) -> {nội dung thân hàm}
        //class vô danh
        iCalFunctional multi2 = new iCalFunctional(){
            @Override
            public void execute(int num1, int num2) {
                System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
            }
        };multi2.execute(10, 20);
        //lambda
        iCalFunctional multi3 = (int n1, int n2) ->{
            System.out.println(n1 + " * " + n2 + " = " + (n1 * n2));
        };multi3.execute(2, 3);

        iCalFunctional devide = (int n1, int n2) ->{
            System.out.println(n1 + " / " + n2 + " = " + (n1 / n2));
        };devide.execute(20, 10);
    }
}
//interface functional : 1 Interface chỉ có duy nhất 1 hàm abstract
interface iCalFunctional{
    //abstract
    void execute(int num1, int num2);
    static void show(){
        System.out.println("Đây là interface functional");

    }
    default String toStr(){
        return "ICalfunctional";
    }
}
interface ICal{
    void execute(int num1, int num2);
    void show();
}
class Caculator implements ICal{

    @Override
    public void execute(int num1, int num2) {
        System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
        
    }
    @Override
    public void show(){
                
    }
    
}