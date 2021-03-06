package Java2.src.Assignment.Obj;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import Java2.src.Assignment.Manager.QuanLyKhachHang;
import Java2.src.Assignment.Manager.QuanLyTaiKhoan;

import java.text.SimpleDateFormat;

public class TaiKhoan {
    private int id;
    private int kh_id;
    private String soTK;
    private String loaiTK;
    private String trangThai;
    private Date ngayTao;
    private Double soTien;  
    private int hanMuc;   
    final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Scanner sc = new Scanner(System.in);
    public TaiKhoan() {
    }
    public TaiKhoan(int kh_id) {
        this.kh_id = kh_id;
    }

    public TaiKhoan(String soTK, String loaiTK, String trangThai) {
        this.soTK = soTK;
        this.loaiTK = loaiTK;
        this.trangThai = trangThai;
    }
    public TaiKhoan(String soTK, Double soTien) {
      this.soTK = soTK;
      this.soTien = soTien;
    }
    public TaiKhoan(String soTK, int hanMuc) {
        this.soTK = soTK;
        this.hanMuc = hanMuc;
    }
    
    public TaiKhoan(int id, int kh_id, String soTK, String loaiTK, String trangThai, Date ngayTao, Double soTien,
            int hanMuc) {
        this.id = id;
        this.kh_id = kh_id;
        this.soTK = soTK;
        this.loaiTK = loaiTK;
        this.trangThai = trangThai;
        this.ngayTao = ngayTao;
        this.soTien = soTien;
        this.hanMuc = hanMuc;
    }
    public TaiKhoan(String soTK) {
        this.soTK = soTK;
	}
	public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getKh_id() {
        return kh_id;
    }
    public void setKh_id(int kh_id) {
        this.kh_id = kh_id;
    }
    public String getSoTK() {
        return soTK;
    }
    public void setSoTK(String soTK) {
        this.soTK = soTK;
    }
    public String getLoaiTK() { 
        return loaiTK;
    }
    public void setLoaiTK(String loaiTK) {
        this.loaiTK = loaiTK;
    }
    public String getTrangThai() {
        return trangThai;
    }
    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    public Date getNgayTao() {
        return ngayTao;
    }
    public String getNgayTao2(){
        return sdf.format(this.ngayTao);
    }
    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }
    public Double getSoTien() {
        return soTien;
    }
    public void setSoTien(Double soTien) {
        this.soTien = soTien;
    }    
    public int getHanMuc() {
        return hanMuc;
    }
    public void setHanMuc(int hanMuc) {
        this.hanMuc = hanMuc;
    }
    public void input(){
        QuanLyKhachHang qlkh = new QuanLyKhachHang();
        QuanLyTaiKhoan qltk = new QuanLyTaiKhoan();
        List<KhachHang> listKhachHang = qlkh.displayListKhachHang();
        List<TaiKhoan> listTaiKhoan = qltk.displayListTaiKhoan();
        String maKH;
        Boolean flag1;
        while (true) {   
            flag1 = false;     
            System.out.println("Nh???p m?? kh??ch h??ng: ");
            maKH = sc.nextLine();
            for(KhachHang kh : listKhachHang){
                //Ki???m tra c?? t???n t???i m?? kh??ch h??ng
                if(maKH.equals(kh.getMaKH())){
                    this.kh_id = kh.getId();
                    flag1 = true;
                }
            }
            if(flag1 == true){
                int type;
                int checkTK = 0;
                //check kh_id ???? t???n t???i ch??a
                for(TaiKhoan tk : listTaiKhoan){
                    if(this.kh_id == tk.getKh_id()){
                        checkTK++; 
                    }
                }
                //Ch??a c?? tk
                if(checkTK == 0){
                    inputGeneral();
                    this.loaiTK = "TraTruoc";
                    type = 0;
                    if(type == 0){
                        this.soTien = 0d;
                        this.hanMuc = 1000000;
                    }
                }else if(checkTK == 1){
                    String chonVisa;
                    System.out.println("B???n ???? c?? t??i kho???n tr??? tr?????c");
                    System.out.println("T???o t??i kho???n tr??? sau (ViSA)");
                    System.out.println("?????ng ??. Ch???n 'y' ");   
                    chonVisa = sc.nextLine();
                    if(chonVisa.equals("y")){
                        inputGeneral();
                        this.loaiTK = "TraSau (VISA)";
                        type = 1;
                        if(type == 1){
                            this.hanMuc = 30000000;
                            this.soTien =  30000000d;
                        }   
                    }else{
                        System.out.println("T???o th???t b???i");
                        System.exit(1);
                        break;
                    }
                }
                else{
                    System.out.println("B???n ???? c?? 2 t??i kho???n! Kh??ng th??? t???o th??m");
                }break;
            }               
            if(flag1 == false){
                System.out.println("M?? kh??ch h??ng kh??ng t???n t???i!");
            } 
        }
    }
    public void inputGeneral() {
        QuanLyTaiKhoan qltk = new QuanLyTaiKhoan();
        List<TaiKhoan> listTaiKhoan = qltk.displayListTaiKhoan();
		// ACCOUNT ID
		while (true) {
            int count = 0;
			System.out.print("Nh???p s??? t??i kho???n: ");
			this.soTK = sc.nextLine();
            if (this.soTK.length() == 6 && !this.soTK.trim().equals("")){
                for(TaiKhoan tk : listTaiKhoan){
                    if(this.soTK.equals(tk.getSoTK())){
                        System.out.println("S??? t??i kho???n ???? t???n t???i");
                        count++;
                        break;
                    }
                }if(count == 0){
                   break;
                }
            }else{
                System.out.println("S??? t??i kho???n b???t bu???c c?? 6 ch??? s???");
            }
		}
		while (true) {
            int status;
            System.out.println("Tr???ng th??i");
            System.out.println("0. Disable");
            System.out.println("1. Active");
            try {
                status = Integer.parseInt(sc.nextLine());
                if(status == 0){
                    this.trangThai = "Disable";
                    break;
                }
                else if(status == 1){
                    this.trangThai = "Active";
                    break;
                }else{
                    System.out.println("Ch???n sai! Vui l??ng ch???n l???i");
                }   
            } catch (NumberFormatException e) {
                System.out.println("B???n ph???i ch???n s???!");
            }
        }
		while (true) {
            System.out.println("Nh???p ng??y t???o: ");
            String sdate = sc.nextLine();
            try {
                if(sdate.trim().equals("")){
                    System.out.println("B???n ch??a nh???p ng??y t???o!");
                }else{
                    this.ngayTao = sdf.parse(sdate);
                    break;
                }
            } catch (Exception e) {
                System.out.println("Ng??y t???o ko h???p l???!");;
            }
        }
	}
    public void output(){
        System.out.format("%-10s %-10s %-10s %-15s %-15s %-20s %-20s %-20s\n",  
                            this.id,
                            this.kh_id,
                            this.soTK,
                            this.loaiTK,
                            this.trangThai,
                            this.ngayTao,
                            this.soTien,
                            this.hanMuc);
    }    
}

