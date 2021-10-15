-- tao thu tuc update 1 book
create proc updateBook(
	@code nvarchar(6),
	@name nvarchar(100),
	@price numeric,
	@code_response int out,
	@message_response nvarchar(200) out
) as
begin
	/*
	- check code ton tai hay chua?
	- chua: khong update -> dung ham va tra ma loi, thong bao loi
	- ton tai code: update 
	*/
	declare @tontai int;
	set @tontai = (select count(*) from book where code = @code);
	if @tontai > 0 
	begin
		update book set name = @name, price = @price where code = @code;
		set @code_response = 1;
		set @message_response = 'success';
	end;
	else 
	begin
		set @code_response = 0;
		set @message_response = 'no data found';
	end;
end;

-- goi thu tuc
begin
declare @code_res int;
declare @code_mes nvarchar(100);
exec updateBook '111', 'Rain', 1100, @code_res out, @code_mes out;
print @code_res;
print @code_mes;
end;