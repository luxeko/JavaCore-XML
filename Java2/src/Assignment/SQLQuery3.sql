create table KhachHang(
	id numeric identity(1,1) primary key not null,
	maKH varchar(20) unique  not null,
	tenKH nvarchar(100)  not null,
	CMT varchar(20) unique  not null,
	soDT varchar(20) unique  not null,
	email varchar(50) unique  not null,
	ngaySinh date,
	gioiTinh varchar(20)  not null,
	adRess nvarchar(100)  not null,
	loaiKH varchar(20)  not null,
)

create table TaiKhoan(
	id numeric identity(1, 1) primary key not null,
	kh_id numeric,
	soTK varchar(6),
	loaiTK varchar(20),
	trangThai varchar(20),
	ngayTao date,
	soTien numeric,
	hanMuc numeric,
	FOREIGN KEY (kh_id)
	REFERENCES KhachHang(id),
)
create table GiaoDich(
	id numeric identity(1,1) primary key not null,
	soTK varchar(6),
	loaiThaoTac varchar(10),
	soTien numeric,
	ngayGiaoDich date,
	noiThucHien nvarchar(100)
)

insert into TaiKhoan (kh_id, soTK, loaiTK, trangThai, ngayTao, soTien, hanMuc) values (1, 0123456, , ?, ?, ?, ?)
insert into TaiKhoan (kh_id, soTK, loaiTK, trangThai, ngayTao, soTien, hanMuc) values (?, ?, ?, ?, ?, ?, ?)


insert into KhachHang (maKH, tenKH, CMT, soDT, email, ngaySinh, gioiTinh, adRess, loaiKH) values ('aa1d', 'ducanh', '012312', '0123123', 'locds1', '1999/02/28', 'nam', 'k1' , 'vip' )
insert into KhachHang (maKH, tenKH, CMT, soDT, email, ngaySinh, gioiTinh, adRess, loaiKH) values ('bb1', 'Linh', '43423123', '0123123', 'cis@gmail', convert(date, '28/02/1999', 103), 'nam', 'k2', 'vip');
insert into KhachHang (maKH, tenKH, CMT, soDT, email, ngaySinh, gioiTinh, adRess, loaiKH) values ('003', 'Thai', '001002005', '0123123126', 'thai3@gmail.com', convert(date, '18/07/1992', 103), 'nam', 'ha noi', 'vip');

select id, kh_id, soTK, loaiTK, trangThai, ngayTao, soTien, hanMuc from TaiKhoan
select id, maKH, tenKH, CMT, soDT, email, CONVERT(date, ngaySinh, 105) , gioiTinh, adRess, loaiKH from KhachHang;
select * from KhachHang
select * from TaiKhoan
select * from GiaoDich
select soTK, trangThai from TaiKhoan where soTK = 123456
Go
create proc CustomerUpdate(
	@maKH varchar(20),
	@tenKH nvarchar(100) ,
	@CMT varchar(20) ,
	@soDT varchar(20),
	@email varchar(50),
	@ngaySinh date,
	@gioiTinh varchar(20),
	@adRess nvarchar(100),
	@loaiKH varchar(20),
	@code_response int out,
	@message_response nvarchar(100) out
) as
begin
	/*
		- Check code t?n t?i hay chua?
		- Chua: không update -> d?ng hàm và tr? v? mã l?i, thông tin l?i
		- Ðã t?n t?i: update
	*/
	declare @tontai int;
	set @tontai = (select count(*) from KhachHang where maKH = @maKH);
	if @tontai > 0
		begin
			update KhachHang set maKH = @maKH, tenKH = @tenKH, CMT = @CMT, soDT = @soDT, email = @email, ngaySinh = @ngaySinh, gioiTinh = @gioiTinh, adRess = @adRess, loaiKH = @loaiKH where maKH = @maKH;
			set @code_response = 1;
			set @message_response = 'Update successed';
		end;
	else
		begin
			set @code_response = 0;
			set @message_response = 'Update failed';
		end;
end;

Go
create proc TaiKhoanUpdate(
	@soTK varchar(6),
	@soTien numeric,
	@code_response int out,
	@message_response nvarchar(100) out
) as
begin
	declare @checkTK int;
	set @checkTK = (select count(@soTien) from TaiKhoan where soTK = @soTK);
	if @checkTK > 0
		begin
			update TaiKhoan set soTien = @soTien  where soTK = @soTK;
			set @code_response = 1;
			set @message_response = 'Thao tac thanh cong';
		end;
	else
		begin
			set @code_response = 0;
			set @message_response = 'Thao tac that bai';
		end;
end;
create proc HanMucUpdate(
	@soTK varchar(6),
	@soTien numeric,
	@hanMuc numeric,
	@code_response int out,
	@message_response nvarchar(100) out
) as
begin
	declare @checkHanMuc int;
	set @checkHanMuc = (select count(*) from TaiKhoan where soTK = @soTK);
	if @checkHanMuc > 0
		begin
			update TaiKhoan set soTien = @soTien, hanMuc = @hanMuc  where soTK = @soTK;
			set @code_response = 1;
			set @message_response = 'Thao tác thanh cong';
		end;
	else
		begin
			set @code_response = 0;
			set @message_response = 'Thao tác that bai';
		end;
end;

create proc TrangThaiUpdate(
	@soTK varchar(6),
	@loaiTK varchar(20),
	@trangThai varchar(20),
	@code_response int out,
	@message_response nvarchar(100) out
) as
begin
	declare @checkTK int;
	set @checkTK = (select count(@trangThai) from TaiKhoan where soTK = @soTK);
	if @checkTK > 0
		begin
			update TaiKhoan set trangThai = @trangThai  where soTK = @soTK;
			set @code_response = 1;
			set @message_response = 'Doi trang thai thanh Active thanh cong';
		end;
	else
		begin
			set @code_response = 0;
			set @message_response = 'Thao tac that bai';
		end;
end;




drop table GiaoDich
drop table TaiKhoan
drop table KhachHang

drop proc CustomerUpdate
drop proc TaiKhoanUpdate
drop proc HanMucUpdate

delete from TaiKhoan where id = 6;
select * from TaiKhoan