use XMLDemo
create table sinhvien(
	id int identity primary key,
	description xml
);
--insert
insert into sinhvien(description) values ('<danhsachsinhvien tenlop="T2103E">
 	<lophoc phonghoc="C5" khoahoc="lap trinh vien fullstack" namhoc="2020" giangvien="Phạm Thị Dung"/>
 	<sinhvien masv="sv001">
 		<hoten>Trần Phương Nam</hoten>
 		<ngaysinh>12/12/2000</ngaysinh>
 		<gioitinh>Nam</gioitinh>
 		<diachi>
 			<tinh>Hà Nội</tinh>
 			<huyen>Cầu Giấy</huyen>
 			<xa>Dịch Vọng Hậu</xa>
 			<diachicuthe>Số 8 - Tôn Thất Thuyết</diachicuthe>
 		</diachi>
 		<sodt>097396485</sodt>
 		<email>namtp@fpt.edu.vn</email>
 	</sinhvien>
 	<sinhvien masv="sv002">
 		<hoten>Đỗ Đức Thắng</hoten>
 		<ngaysinh>03/04/1996</ngaysinh>
 		<gioitinh>Nam</gioitinh>
 		<diachi>
 			<tinh>Hà Nội</tinh>
 			<huyen>Cầu Giấy</huyen>
 			<xa>Dịch Vọng Hậu</xa>
 			<diachicuthe>Số 8 - Tôn Thất Thuyết</diachicuthe>
 		</diachi>
 		<sodt>097396485</sodt>
 		<email>namtp@fpt.edu.vn</email>
 	</sinhvien>
 	<sinhvien masv="sv003">
 		<hoten>Trần Ngọc Thiện</hoten>
 		<ngaysinh>10/12/1998</ngaysinh>
 		<gioitinh>Nam</gioitinh>
 		<diachi>
 			<tinh>Hà Nội</tinh>
 			<huyen>Cầu Giấy</huyen>
 			<xa>Dịch Vọng Hậu</xa>
 			<diachicuthe>Số 8 - Tôn Thất Thuyết</diachicuthe>
 		</diachi>
 		<sodt>097396485</sodt>
 		<email>namtp@fpt.edu.vn</email>
 	</sinhvien>
 </danhsachsinhvien>');

 --query:
 select * from sinhvien

 select T2.Loc.query('.')
 From sinhvien
 CROSS APPLY description.nodes('/danhsachsinhvien/sinhvien') AS T2(Loc);

 select T2.SV.query('.'),
 SV.value ('@masv', 'varchar(10)') AS masv,
 SV.value ('hoten[1]', 'nvarchar(50)') hoten
 From sinhvien
 CROSS APPLY description.nodes('/danhsachsinhvien/sinhvien') AS T2(SV);

