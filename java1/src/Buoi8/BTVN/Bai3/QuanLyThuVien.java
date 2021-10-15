package java1.src.Buoi8.BTVN.Bai3;

import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyThuVien {
    ArrayList<TaiLieu> dsThuVien;
    public QuanLyThuVien(){
        dsThuVien = new ArrayList<TaiLieu>();
    }
    public void addTaiLieu(TaiLieu tl){
        dsThuVien.add(tl);
    }
    public void addSach(Sach s){
        dsThuVien.add(s);
    }
    public void addTapChi(TapChi tch){
        dsThuVien.add(tch);
    }
    public void addBao(Bao b){
        dsThuVien.add(b);
    }
    public void removeTaiLieu(){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("1. Tai lieu (Xoa het)");
            System.out.println("2. Sach");
            System.out.println("3. Tap Chi");
            System.out.println("4. Bao");
            System.out.printf("Nhap loai muon xoa: ");
            int choose = Integer.parseInt(sc.nextLine());
            if(choose == 1){
                for(TaiLieu tl : dsThuVien){
                    if(tl instanceof TaiLieu){
                        dsThuVien.remove(tl);
                        System.out.println("Xoa thanh cong");
                        break;
                    }
                }
                break;
            }else if(choose == 2){
                for(TaiLieu tl : dsThuVien){
                    if(tl instanceof Sach){
                        dsThuVien.remove(tl);
                        System.out.println("Xoa thanh cong");
                        break;
                    }
                }
                break;
            }else if(choose == 3){
                for(TaiLieu tl : dsThuVien){
                    if(tl instanceof TapChi){
                        dsThuVien.remove(tl);
                        System.out.println("Xoa thanh cong");
                        break;
                    }
                }break;
            }else if(choose == 4){
                for(TaiLieu tl : dsThuVien){
                    if(tl instanceof Bao){
                        dsThuVien.remove(tl);
                        System.out.println("Xoa thanh cong");
                        break;
                    }
                }
                break;
            }else {
                System.out.println("Nhap khong dung!");
            }
        }sc.close();
    }
    public void kiemtraSach(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ten sach can tim: ");
        
        for(TaiLieu tl : dsThuVien){
            String tenSach = sc.nextLine();
            Sach sach = new Sach();
            TapChi tch = new TapChi();
            Bao bao = new Bao();
            if(tenSach.equals(tl.getTaiLieuName())){
                tl.output();
                break;
            }else if(tenSach.equals(sach.getTaiLieuName())){
                sach.output();
                break;
            }else if(tenSach.equals(tch.getTaiLieuName())){
                tch.output();
                break;
            }else if(tenSach.equals(bao.getTaiLieuName())){
                bao.output();
                break;
            }
        }sc.close();
    }
    public void timLoaiSach(){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("1. Tai lieu");
            System.out.println("2. Sach");
            System.out.println("3. Tap Chi");
            System.out.println("4. Bao");
            System.out.printf("Nhap lua chon: ");
            int choose = Integer.parseInt(sc.nextLine());
            if(choose == 1){
                for(TaiLieu tl : dsThuVien){
                    if(tl instanceof TaiLieu){
                        tl.output();
                    }
                }
                break;
            }else if(choose == 2){
                for(TaiLieu tl : dsThuVien){
                    if(tl instanceof Sach){
                        tl.output();
                    }
                }
                break;
            }else if(choose == 3){
                for(TaiLieu tl : dsThuVien){
                    if(tl instanceof TapChi){
                        tl.output();
                    }
                }
                break;
            }else if(choose == 4){
                for(TaiLieu tl : dsThuVien){
                    if(tl instanceof Bao){
                        tl.output();
                    }
                }
                break;
            }else {
                System.out.println("Nhap khong dung!");
            }
        }sc.close();
    }
    public void input(){
    }
    public void output(){
        for(TaiLieu tl : dsThuVien){
            tl.output();
        }
    }
}
