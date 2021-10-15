package java1.src.Buoi10.BTVN.Bai1;

import java.util.ArrayList;
import java.util.Scanner;

public class ShapeManager {
    ArrayList<IShape> quanly;

    public ShapeManager(){
        quanly = new ArrayList<IShape>();
    }
    public ShapeManager(ArrayList<IShape> quanly) {
        this.quanly = quanly;
    }
    public void addSq(Square sq){
        quanly.add(sq);
    }
    public void addTri(Triangle tri){
        quanly.add(tri);
    }
    public void addCir(Circle cir){
        quanly.add(cir);
    }
    public void addRec(Rectangle rec){
        quanly.add(rec);
    }
    public void xuat(){
        for(IShape is : quanly ){
            is.xuat();
        }
    }

    public void timLoai(){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("1. Hinh tam giac");
            System.out.println("2. Hinh vuong");
            System.out.println("3. Hinh chu nhat");
            System.out.println("4. Hinh tron");
            System.out.println("Chon loai muon tim: ");
            int choose = Integer.parseInt(sc.nextLine());
            if(choose == 1){
                for(IShape is : quanly){
                    if(is instanceof Triangle){
                        is.xuat();
                    }
                }
                break;
            }else if(choose == 2){
                for(IShape is : quanly){
                    if(is instanceof Square){
                        is.xuat();
                    }
                }
                break;
            }else if(choose == 3){
                for(IShape is : quanly){
                    if(is instanceof Rectangle){
                        is.xuat();
                    }
                }
                break;
            }else if(choose == 4){
                for(IShape is : quanly){
                    if(is instanceof Circle){
                        is.xuat();
                    }
                }
                break;
            }else {
                System.out.println("Nhap khong dung!");
            }
        }sc.close();
    }
    public void xoaLoai(){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("1. Hinh tam giac");
            System.out.println("2. Hinh vuong");
            System.out.println("3. Hinh chu nhat");
            System.out.println("4. Hinh tron");
            System.out.println("Chon loai muon xoa: ");
            int choose = Integer.parseInt(sc.nextLine());
            if(choose == 1){
                for(IShape iS : quanly){
                    if(iS instanceof Triangle){
                        this.quanly.remove(iS);
                        System.out.println("Xoa thanh cong!");
                        break;
                    }
                }break;
            }else if(choose == 2){
                for(IShape is : quanly){
                    if(is instanceof Square){
                        System.out.println("Xoa thanh cong!");
                        break;
                    }
                }break;
            }else if(choose == 3){
                for(IShape is : quanly){
                    if(is instanceof Rectangle){
                        this.quanly.remove(is);
                        System.out.println("Xoa thanh cong!");
                        break;
                    }
                }break;
            }else if(choose == 4){
                for(IShape is : quanly){
                    if(is instanceof Circle){
                        this.quanly.remove(is);
                        System.out.println("Xoa thanh cong!");
                        break;
                    }
                }break;
            }else {
                System.out.println("Nhap khong dung!");
            }
        }sc.close();
    }
    
}
