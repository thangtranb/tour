Create database DB_Tourism
GO

Use DB_Tourism
GO

Create table Tourism
(
	IdTour int primary key identity,
	LocationName nvarchar(100),
	Description nvarchar(200),
	Image varchar(150),
	Location nvarchar(150),
	Price float,
	Created_at datetime,
	Update_at datetime
)
GO

Create table Tour
(
	Id int primary key identity,
	TourName nvarchar(150),
	Description nvarchar(200),
	Schedule nvarchar(200),
	Price float,
	DepartureDay date,
	NumberoOfParticipants int,
	Created_at datetime,
	Update_at datetime
)
GO

Insert into Tour Values (N'Đà nẵng', N'2 ngày 1 đêm', N'Sáng đi Đà Nẵng, trưa ăn tại khách sạn..', 2500000, '2024-05-20', 24,'2024-05-8', '2024-05-9' )
GO

Create table Customer
(
	CustomerId int primary key identity,
	Name nvarchar(100),
	Address nvarchar(225),
	Email varchar(150),
	Phone varchar(12),
	Payment nvarchar(100),
	Created_at datetime,
	Update_at datetime
)
GO

Insert into Customer Values (N'Nguyễn Văn Anh', N'Hà Nội', 'anh@gmail.com', '0123474174', N'Chuyển khoản', '2024-03-05', '2024-03-06')
GO

Select * from Customer
GO

Create table BookingRoom
(
	Id int primary key identity,
	BookingId nvarchar(20),
	CustomerId int foreign key references Customer(CustomerId),
	TourId int foreign key references Tour(Id),
	DepartureDay date,
	NumberOfParticipants int,
	Price float,
	Created_at datetime,
	Update_at datetime
)
GO

Insert into BookingRoom values (N'B01', 1, 1, '2024-05-18', 15, 2500000,  '2024-03-05', '2024-03-06')
GO
