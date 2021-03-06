package Java2.src.Assignment.Obj;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import Java2.src.Assignment.Manager.QuanLyKhachHang;

public class KhachHang {
    private int id;
    private String maKH;
    private String tenKH;
    private String cmt;
    private String soDT;
    private String email;
    private Date ngaySinh;
    private String gioiTinh;   //1.Nam 0.NU 2.Khac
    private String address; 
    private String loaikh;     //0.thuong 1.VIP
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private Scanner sc = new Scanner(System.in);
    public KhachHang() {
    }
    public KhachHang(int id) {
        this.id = id;
    }
    public KhachHang(int id, String maKH, String tenKH, String cmt, String soDT, String email, Date ngaySinh,
            String gioiTinh, String address, String loaikh) {
        this.id = id;
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.cmt = cmt;
        this.soDT = soDT;
        this.email = email;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.address = address;
        this.loaikh = loaikh;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getMaKH() {
        return maKH;
    }
    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }
    public String getTenKH() {
        return tenKH;
    }
    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }
    public String getCmt() {
        return cmt;
    }
    public void setCmt(String cmt) {
        this.cmt = cmt;
    }
    public String getSoDT() {
        return soDT;
    }
    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Date getNgaySinh() {
        return ngaySinh;
    }
    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }    
    public String getGioiTinh() {
        return gioiTinh;
    }
    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
    public String getLoaikh() {
        return loaikh;
    }
    public void setLoaikh(String loaikh) {
        this.loaikh = loaikh;
    }
    public void input(){
        QuanLyKhachHang qlkh = new QuanLyKhachHang();
        List<KhachHang> listKhachHang = qlkh.displayListKhachHang();
        //M?? kh??ch h??ng
        while(true){
            int count = 0;
            System.out.println("Nh???p m?? kh??ch h??ng: ");
            this.maKH = sc.nextLine();
            if(this.maKH.trim().equals("")){
                System.out.println("B???n ch??a nh???p m?? kh??ch h??ng!");
            }else{
                for(KhachHang o : listKhachHang){
                    if(this.maKH.equals(o.getMaKH())){
                        System.out.println("M?? kh??ch h??ng ???? t???n t???i!");
                        count++;
                    }
                }if(count == 0){
                    break;
                }
            }
        }   
        while (true) {
            System.out.println("Nh???p t??n kh??ch h??ng: ");
            this.tenKH = sc.nextLine();
            if(this.tenKH.trim().equals("")){
                System.out.println("B???n ch??a nh???p t??n kh??ch h??ng!");
            }else{
                break;
            }
        }
        while (true) {
            int count = 0;
            System.out.println("Nh???p CMT: ");
            this.cmt = sc.nextLine();
            if(this.cmt.trim().equals("")){
                System.out.println("B???n ch??a nh???p CMT!");
            }else{
                for(KhachHang o : listKhachHang){
                    if(this.cmt.equals(o.getCmt())){
                        System.out.println("Ch???ng minh th?? ???? t???n t???i!");
                        count++;
                    }
                }if(count == 0){
                    break;
                }
            }
        }
        while (true) {
            int count = 0;
            System.out.println("Nh???p s??? ??i???n tho???i: ");
            this.soDT = sc.nextLine();
            if(this.soDT.trim().equals("")){
                System.out.println("B???n ch??a nh???p SDT!");
            }else{
                for(KhachHang o : listKhachHang){
                    if(this.soDT.equals(o.getSoDT())){
                        System.out.println("SDT ???? t???n t???i!");
                        count++;
                    }
                }if(count == 0){
                    break;
                }
            }
        }
        while (true) {
            int count = 0;
            System.out.println("Nh???p email: ");
            this.email = sc.nextLine();
            if (this.email.contains("@") && !this.email.trim().equals("")) {
                for (KhachHang o : listKhachHang) {
                    if (this.email.equalsIgnoreCase(o.getEmail())
                            && !this.maKH.equalsIgnoreCase(o.getMaKH()))
                        count++;
                }
                if (count > 0)
                    System.out.println("Email ???? t???n t???i");
                else
                    break;
            } else{
                System.out.println("B???n ch??a nh???p email! ho???c email kh??ng ????ng format: example@domain.com");
            }
        }
        while (true) {
            System.out.println("Nh???p ng??y sinh: ");
            String sdate = sc.nextLine();
            try {
                if(sdate.trim().equals("")){
                    System.out.println("B???n ch??a nh???p ng??y sinh!");
                }else{
                    this.ngaySinh = sdf.parse(sdate);
                    break;
                }
            } catch (Exception e) {
                System.out.println("Ng??y sinh ko h???p l???!");;
            }
        }
        while(true) {
            int sex;
            System.out.println("Gi???i t??nh");
            System.out.println("1. Nam");
            System.out.println("0. Nu");
            System.out.println("2. Khac");
            System.out.printf("Ch???n: ");
            try {
                sex = Integer.parseInt(sc.nextLine());
                if(sex == 1){
                   this.gioiTinh = "Nam";
                   break;
                }else if(sex == 0){
                    this.gioiTinh = "Nu";
                    break;
                }else if(sex == 2){
                    this.gioiTinh = "Khac";
                    break;
                }else{
                    System.out.println("L???a ch???n kh??ng h???p l???!");
                }
            } catch (NumberFormatException e) {
                System.out.println("B???n ph???i ch???n s???!");
            }
        }

        while (true) {
            System.out.println("Nh???p ?????a ch???: ");
            this.address = sc.nextLine();
            if(this.address.trim().equals("")){
                System.out.println("B???n ch??a nh???p ?????a ch???");
            }else{
                break;
            }
        }
        while(true) {
            int type;
            System.out.println("Lo???i kh??ch h??ng");
            System.out.println("0. Th?????ng");
            System.out.println("1. VIP");
            System.out.printf("Ch???n: ");
            try {
                type = Integer.parseInt(sc.nextLine());
                if(type == 0){
                    this.loaikh = "Thuong";
                    break;
                }else if(type == 1){
                    this.loaikh = "VIP";
                    break;
                }else{
                    System.out.println("L???a ch???n kh??ng h???p l???!");
                }
            } catch (NumberFormatException e) {
                System.out.println("B???n ph???i ch???n s???!");
            }
        }
    }
    public void inputUpdate() {
        QuanLyKhachHang qlkh = new QuanLyKhachHang();
        List<KhachHang> listKhachHang = qlkh.displayListKhachHang();
		String sCustomerId;
        while (true) {
            int count = 0;
            System.out.print("Nh???p m?? kh??ch h??ng mu???n update: ");
            sCustomerId = sc.nextLine();
            for (KhachHang o : listKhachHang) {
                if (sCustomerId.equalsIgnoreCase(o.getMaKH())) {
                    o.output();;
                    this.maKH = sCustomerId;
                    count++;
                }
            }	
            if (count > 0) {
                // NAME
                while (true) {
                    System.out.print("Nh???p t??n m???i: ");
                    this.tenKH = sc.nextLine();
                    if (this.tenKH.length() >= 2)
                        break;
                    else
                        System.out.println("T??n kh??ch h??ng kh??ng h???p l???!");
                }
                // CMT
                
                while (true) {
                    count = 0;
                    System.out.print("Nh???p s??? CMT m???i: ");
                    this.cmt = sc.nextLine();
                    if (!this.cmt.trim().equals("")) {
                        for (KhachHang o : listKhachHang) {
                            if (this.cmt.equalsIgnoreCase(o.getCmt())
                                    && !this.maKH.equalsIgnoreCase(o.getMaKH()))
                                count++;
                        }
                        if (count > 0)
                            System.out.println("S??? CMT ???? t???n t???i!");
                        else
                            break;
                    } else
                        System.out.println("B???n ch??a nh???p s??? CMT!");
                }
                // PHONE NUMBER
                while (true) {
                    count = 0;
                    System.out.print("Nh???p s??? ??t m???i: ");
                    this.soDT = sc.nextLine();
                    if (!this.soDT.trim().equals("")){
                        for (KhachHang o : listKhachHang) {
                            if (this.soDT.equalsIgnoreCase(o.getSoDT())
                                    && !this.maKH.equalsIgnoreCase(o.getMaKH()))
                                count++;
                        }
                        if (count > 0)
                            System.out.println("S??? ??i???n tho???i ???? t???n t???i!");
                        else
                            break;
                    } else{
                        System.out.println("B???n ch??a nh???p s??? ??T!");
                    }
                }
                // EMAIL
                while (true) {
                    count = 0;
                    System.out.print("Nh???p email m???i: ");
                    this.email = sc.nextLine();
                    if (this.email.contains("@") && !this.email.trim().equals("")) {
                        for (KhachHang o : listKhachHang) {
                            if (this.email.equalsIgnoreCase(o.getEmail())
                                    && !this.maKH.equalsIgnoreCase(o.getMaKH()))
                                count++;
                        }
                        if (count > 0)
                            System.out.println("Email ???? t???n t???i");
                        else
                            break;
                    } else{
                        System.out.println("B???n ch??a nh???p email! ho???c email kh??ng ????ng format: example@domain.com");
                    }
                        
                }
                // BIRTHDAY
                while (true) {
                    System.out.println("Nh???p ng??y sinh m???i: ");
                    String sdate = sc.nextLine();
                    try {
                        if(sdate.trim().equals("")){
                            System.out.println("B???n ch??a nh???p ng??y sinh!");
                        }else{
                            this.ngaySinh = sdf.parse(sdate);
                            break;
                        }
                    } catch (Exception e) {
                        System.out.println("Ng??y sinh ko h???p l???!");;
                    }
                }
                // GENDER
                while(true) {
                    int sex;
                    System.out.println("Gi???i t??nh");
                    System.out.println("1. Nam");
                    System.out.println("0. Nu");
                    System.out.println("2. Khac");
                    System.out.printf("Ch???n: ");
                    try {
                        sex = Integer.parseInt(sc.nextLine());
                        if(sex == 1){
                        this.gioiTinh = "Nam";
                        break;
                        }else if(sex == 0){
                            this.gioiTinh = "Nu";
                            break;
                        }else if(sex == 2){
                            this.gioiTinh = "Khac";
                            break;
                        }else{
                            System.out.println("L???a ch???n kh??ng h???p l???!");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("B???n ph???i ch???n s???!");
                    }
                }
        
                while (true) {
                    System.out.println("Nh???p ?????a ch???: ");
                    this.address = sc.nextLine();
                    if(this.address.trim().equals("")){
                        System.out.println("B???n ch??a nh???p ?????a ch???");
                    }else{
                        break;
                    }
                }
                while(true) {
                    int type;
                    System.out.println("Lo???i kh??ch h??ng");
                    System.out.println("0. Th?????ng");
                    System.out.println("1. VIP");
                    System.out.printf("Ch???n: ");
                    try {
                        type = Integer.parseInt(sc.nextLine());
                        if(type == 0){
                            this.loaikh = "Thuong";
                            break;
                        }else if(type == 1){
                            this.loaikh = "VIP";
                            break;
                        }else{
                            System.out.println("L???a ch???n kh??ng h???p l???!");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("B???n ph???i ch???n s???!");
                    }
                }break;
            } else{
                System.out.println("Kh??ng t??m th???y m?? kh??ch h??ng!");
            }
        }
		
			
	}
    @Override
    public String toString() {
        return "KhachHang ID: " + this.id + "   " + "MaKH: " + this.maKH + "   " + "TenKH: " + this.tenKH + "   " + "CMT: " + this.cmt + "   "
                + "SDT: " + this.soDT + "   " + "Email: " + this.email + "   " + "Ngay sinh: " + sdf.format(ngaySinh) + "   " + "Gioi tinh: "  + this.gioiTinh + "   " + "Address: " + this.address + "   " + "LoaiKH: " + this.loaikh + "\n";
    }
    public void output(){
        System.out.format("%-10s %-10s %-20s %-20s %-20s %-20s %-20s %-15s %-20s %-20s\n",  
                            this.id,
                            this.maKH,
                            this.tenKH,
                            this.cmt,
                            this.soDT,
                            this.email,
                            sdf.format(this.ngaySinh),
                            this.gioiTinh,
                            this.address,
                            this.loaikh);
    }
    
}
