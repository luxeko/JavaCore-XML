package java1.src.Buoi6;

import java.util.Scanner;

public class Bai2 {
    Scanner sc = new Scanner(System.in);
    int n = 0;
    int arr[] = new int[100];

    public Bai2(){

    }
    public Bai2(int n, int[] arr) {
        this.n = n;
        this.arr = arr;
    }
    public int getN() {
        return n;
    }
    public void setN(int n) {
        this.n = n;
    }
    public int[] getArr() {
        return arr;
    }
    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public void khaiBaoMang(){
        do {
            System.out.printf("Nhập vào số phần tử của mảng: ");
            this.n = sc.nextInt();
            if((this.n-1) >= 0){
                for(int i=0; i<this.n; i++){
                    System.out.printf("arr[" + i + "] ");
                }
                System.out.println("");
                
            }else{
                System.out.println("So luong phan tu trong mang phai > 0");
            }
            
        } while ((this.n-1) < 0);
    }

    public void nhapMang(){
        int i = 0;
            System.out.println("Nhap cac phan tu cho mang: ");
            do{
                System.out.printf("arr[%d] = ", i);
                this.arr[i++] = sc.nextInt();
            }while (i < this.n);
    }
    public void minMax(){
        int min = arr[0];
        int max = arr[0];
        for(int i = 0; i < this.n; i++){
            if(arr[i]<min){
                min = arr[i];
            }
            if(arr[i]>max){
                max = arr[i];
            }
        }
        System.out.println("Phan tu nho nhat: " + min);
        System.out.println("Phan tu lon nhat: " + max);
    }
    public void demSo(){
        int count = 0;
        System.out.printf("Nhap phan tu: ");
        int numb = sc.nextInt();
        for(int i = 0; i < this.n; i++){
            if(arr[i] == numb){
                count++;
            }
        }
        System.out.println("So phan tu " + numb + " co trong mang = " + count );
    }
    public void sortArr(){
        int temp ; 
        for(int i=0; i<this.n-1; i++){
            for(int j=i+1; j <this.n; j++){
                if(arr[i] < arr[j]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for(int i = 0; i < this.n; i++){
            System.out.printf("%d ",this.arr[i]);
        }
        System.out.println("");
    }
  

}
