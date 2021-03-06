USE [master]
GO
/****** Object:  Database [MiniMartManagement]    Script Date: 02-Nov-20 8:25:06 AM ******/
CREATE DATABASE [MiniMartManagement]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'MiniMartManagement', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\MiniMartManagement.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'MiniMartManagement_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\MiniMartManagement_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [MiniMartManagement] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [MiniMartManagement].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [MiniMartManagement] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [MiniMartManagement] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [MiniMartManagement] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [MiniMartManagement] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [MiniMartManagement] SET ARITHABORT OFF 
GO
ALTER DATABASE [MiniMartManagement] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [MiniMartManagement] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [MiniMartManagement] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [MiniMartManagement] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [MiniMartManagement] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [MiniMartManagement] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [MiniMartManagement] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [MiniMartManagement] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [MiniMartManagement] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [MiniMartManagement] SET  DISABLE_BROKER 
GO
ALTER DATABASE [MiniMartManagement] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [MiniMartManagement] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [MiniMartManagement] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [MiniMartManagement] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [MiniMartManagement] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [MiniMartManagement] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [MiniMartManagement] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [MiniMartManagement] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [MiniMartManagement] SET  MULTI_USER 
GO
ALTER DATABASE [MiniMartManagement] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [MiniMartManagement] SET DB_CHAINING OFF 
GO
ALTER DATABASE [MiniMartManagement] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [MiniMartManagement] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [MiniMartManagement] SET DELAYED_DURABILITY = DISABLED 
GO
USE [MiniMartManagement]
GO
/****** Object:  Table [dbo].[tblBill]    Script Date: 02-Nov-20 8:25:06 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblBill](
	[UserID] [int] NOT NULL,
	[BIllID] [int] NOT NULL,
	[Total] [int] NOT NULL,
	[createdDate] [date] NULL,
 CONSTRAINT [PK_tblBill] PRIMARY KEY CLUSTERED 
(
	[BIllID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblBillDetails]    Script Date: 02-Nov-20 8:25:06 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblBillDetails](
	[BillID] [int] NOT NULL,
	[ProduceID] [int] NOT NULL,
	[Amount] [int] NOT NULL,
	[price] [money] NULL,
	[totalPrice] [money] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblCategory]    Script Date: 02-Nov-20 8:25:06 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblCategory](
	[CategoryName] [nchar](50) NOT NULL,
	[CategoryID] [int] NOT NULL,
 CONSTRAINT [PK_tblCategory] PRIMARY KEY CLUSTERED 
(
	[CategoryID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblProduct]    Script Date: 02-Nov-20 8:25:06 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblProduct](
	[ProductID] [int] NOT NULL,
	[ProductName] [nchar](50) NOT NULL,
	[Price] [money] NOT NULL,
	[CategoryID] [int] NOT NULL,
	[Amount] [int] NULL,
 CONSTRAINT [PK_tblProduct] PRIMARY KEY CLUSTERED 
(
	[ProductID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblStockInOut]    Script Date: 02-Nov-20 8:25:06 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblStockInOut](
	[StockInOutID] [int] NOT NULL,
	[UserID] [int] NOT NULL,
	[modifyDay] [date] NULL,
 CONSTRAINT [PK_tblStockInOut] PRIMARY KEY CLUSTERED 
(
	[StockInOutID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblStockInOutDetails]    Script Date: 02-Nov-20 8:25:06 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblStockInOutDetails](
	[StockInOutID] [int] NOT NULL,
	[ProductID] [int] NULL,
	[Amount] [int] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblUser]    Script Date: 02-Nov-20 8:25:06 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblUser](
	[UserID] [int] NOT NULL,
	[UserName] [nchar](50) NOT NULL,
	[UserGroup] [int] NULL,
	[UserLoginName] [nchar](50) NULL,
	[UserLoginPassword] [nchar](50) NULL,
 CONSTRAINT [PK_tblUser] PRIMARY KEY CLUSTERED 
(
	[UserID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
INSERT [dbo].[tblBill] ([UserID], [BIllID], [Total], [createdDate]) VALUES (140968, 0, 532500, CAST(N'2020-05-29' AS Date))
INSERT [dbo].[tblBill] ([UserID], [BIllID], [Total], [createdDate]) VALUES (140968, 1, 89500, CAST(N'2020-05-29' AS Date))
INSERT [dbo].[tblBill] ([UserID], [BIllID], [Total], [createdDate]) VALUES (140968, 2, 19360, CAST(N'2020-05-29' AS Date))
INSERT [dbo].[tblBill] ([UserID], [BIllID], [Total], [createdDate]) VALUES (140968, 3, 285000, CAST(N'2020-05-29' AS Date))
INSERT [dbo].[tblBill] ([UserID], [BIllID], [Total], [createdDate]) VALUES (140969, 4, 20000, CAST(N'2020-06-17' AS Date))
INSERT [dbo].[tblBill] ([UserID], [BIllID], [Total], [createdDate]) VALUES (140969, 5, 89800, CAST(N'2020-06-24' AS Date))
INSERT [dbo].[tblBill] ([UserID], [BIllID], [Total], [createdDate]) VALUES (140970, 6, 1125000, CAST(N'2020-06-26' AS Date))
INSERT [dbo].[tblBillDetails] ([BillID], [ProduceID], [Amount], [price], [totalPrice]) VALUES (1, 10009184, 5, 7000.0000, 35000.0000)
INSERT [dbo].[tblBillDetails] ([BillID], [ProduceID], [Amount], [price], [totalPrice]) VALUES (1, 10250152, 5, 10900.0000, 54500.0000)
INSERT [dbo].[tblBillDetails] ([BillID], [ProduceID], [Amount], [price], [totalPrice]) VALUES (0, 10010065, 5, 49500.0000, 247500.0000)
INSERT [dbo].[tblBillDetails] ([BillID], [ProduceID], [Amount], [price], [totalPrice]) VALUES (0, 10180499, 10, 28500.0000, 285000.0000)
INSERT [dbo].[tblBillDetails] ([BillID], [ProduceID], [Amount], [price], [totalPrice]) VALUES (0, 10014580, 10, 1760.0000, 17600.0000)
INSERT [dbo].[tblBillDetails] ([BillID], [ProduceID], [Amount], [price], [totalPrice]) VALUES (0, 10014580, 10, 1760.0000, 17600.0000)
INSERT [dbo].[tblBillDetails] ([BillID], [ProduceID], [Amount], [price], [totalPrice]) VALUES (0, 10014580, 10, 1760.0000, 17600.0000)
INSERT [dbo].[tblBillDetails] ([BillID], [ProduceID], [Amount], [price], [totalPrice]) VALUES (0, 10014580, 10, 1760.0000, 17600.0000)
INSERT [dbo].[tblBillDetails] ([BillID], [ProduceID], [Amount], [price], [totalPrice]) VALUES (0, 10010065, 5, 49500.0000, 247500.0000)
INSERT [dbo].[tblBillDetails] ([BillID], [ProduceID], [Amount], [price], [totalPrice]) VALUES (0, 10014580, 5, 1760.0000, 8800.0000)
INSERT [dbo].[tblBillDetails] ([BillID], [ProduceID], [Amount], [price], [totalPrice]) VALUES (0, 10010065, 5, 49500.0000, 247500.0000)
INSERT [dbo].[tblBillDetails] ([BillID], [ProduceID], [Amount], [price], [totalPrice]) VALUES (0, 10014580, 9, 1760.0000, 15840.0000)
INSERT [dbo].[tblBillDetails] ([BillID], [ProduceID], [Amount], [price], [totalPrice]) VALUES (3, 10180499, 10, 28500.0000, 285000.0000)
INSERT [dbo].[tblBillDetails] ([BillID], [ProduceID], [Amount], [price], [totalPrice]) VALUES (4, 10010010, 1, 20000.0000, 20000.0000)
INSERT [dbo].[tblBillDetails] ([BillID], [ProduceID], [Amount], [price], [totalPrice]) VALUES (5, 10009165, 2, 37900.0000, 75800.0000)
INSERT [dbo].[tblBillDetails] ([BillID], [ProduceID], [Amount], [price], [totalPrice]) VALUES (5, 10009184, 2, 7000.0000, 14000.0000)
INSERT [dbo].[tblBillDetails] ([BillID], [ProduceID], [Amount], [price], [totalPrice]) VALUES (6, 10010010, 5, 25000.0000, 125000.0000)
INSERT [dbo].[tblBillDetails] ([BillID], [ProduceID], [Amount], [price], [totalPrice]) VALUES (6, 10010020, 5, 100000.0000, 500000.0000)
INSERT [dbo].[tblBillDetails] ([BillID], [ProduceID], [Amount], [price], [totalPrice]) VALUES (0, 10014580, 10, 1760.0000, 17600.0000)
INSERT [dbo].[tblBillDetails] ([BillID], [ProduceID], [Amount], [price], [totalPrice]) VALUES (0, 10014580, 10, 1760.0000, 17600.0000)
INSERT [dbo].[tblBillDetails] ([BillID], [ProduceID], [Amount], [price], [totalPrice]) VALUES (0, 10014580, 10, 1760.0000, 17600.0000)
INSERT [dbo].[tblBillDetails] ([BillID], [ProduceID], [Amount], [price], [totalPrice]) VALUES (0, 10010065, 5, 49500.0000, 247500.0000)
INSERT [dbo].[tblBillDetails] ([BillID], [ProduceID], [Amount], [price], [totalPrice]) VALUES (0, 10250152, 9, 10900.0000, 98100.0000)
INSERT [dbo].[tblBillDetails] ([BillID], [ProduceID], [Amount], [price], [totalPrice]) VALUES (0, 10014580, 5, 1760.0000, 8800.0000)
INSERT [dbo].[tblBillDetails] ([BillID], [ProduceID], [Amount], [price], [totalPrice]) VALUES (0, 10014580, 5, 1760.0000, 8800.0000)
INSERT [dbo].[tblBillDetails] ([BillID], [ProduceID], [Amount], [price], [totalPrice]) VALUES (2, 10014580, 11, 1760.0000, 19360.0000)
INSERT [dbo].[tblCategory] ([CategoryName], [CategoryID]) VALUES (N'Vegetable                                         ', 1)
INSERT [dbo].[tblCategory] ([CategoryName], [CategoryID]) VALUES (N'Meat                                              ', 2)
INSERT [dbo].[tblCategory] ([CategoryName], [CategoryID]) VALUES (N'Spice                                             ', 3)
INSERT [dbo].[tblCategory] ([CategoryName], [CategoryID]) VALUES (N'Dry Food                                          ', 4)
INSERT [dbo].[tblCategory] ([CategoryName], [CategoryID]) VALUES (N'Drink                                             ', 5)
INSERT [dbo].[tblCategory] ([CategoryName], [CategoryID]) VALUES (N'Milk                                              ', 6)
INSERT [dbo].[tblCategory] ([CategoryName], [CategoryID]) VALUES (N'Chemical Product                                  ', 7)
INSERT [dbo].[tblCategory] ([CategoryName], [CategoryID]) VALUES (N'Personal Care                                     ', 8)
INSERT [dbo].[tblProduct] ([ProductID], [ProductName], [Price], [CategoryID], [Amount]) VALUES (10009165, N'Fish Sauce 900ml                                  ', 37900.0000, 3, 98)
INSERT [dbo].[tblProduct] ([ProductID], [ProductName], [Price], [CategoryID], [Amount]) VALUES (10009184, N'Sốt ướp thịt nướng Cholimex gói 70g               ', 7000.0000, 3, 98)
INSERT [dbo].[tblProduct] ([ProductID], [ProductName], [Price], [CategoryID], [Amount]) VALUES (10010010, N'America Apples                                    ', 25000.0000, 1, 274)
INSERT [dbo].[tblProduct] ([ProductID], [ProductName], [Price], [CategoryID], [Amount]) VALUES (10010020, N'Vietnam Durian                                    ', 100000.0000, 1, 15)
INSERT [dbo].[tblProduct] ([ProductID], [ProductName], [Price], [CategoryID], [Amount]) VALUES (10010065, N'Dầu đậu nành Simply chai 1L                       ', 49500.0000, 3, 100)
INSERT [dbo].[tblProduct] ([ProductID], [ProductName], [Price], [CategoryID], [Amount]) VALUES (10014580, N'K?o sô cô la Snickers gói 51g                     ', 1760.0000, 4, 100)
INSERT [dbo].[tblProduct] ([ProductID], [ProductName], [Price], [CategoryID], [Amount]) VALUES (10020030, N'Oyakodon                                          ', 100000.0000, 4, 20)
INSERT [dbo].[tblProduct] ([ProductID], [ProductName], [Price], [CategoryID], [Amount]) VALUES (10123074, N'Vineco Nấm kim châm trắng L1 (150g-200g)          ', 12000.0000, 1, 100)
INSERT [dbo].[tblProduct] ([ProductID], [ProductName], [Price], [CategoryID], [Amount]) VALUES (10180499, N'Phở Bò CHIN-SU (có thịt) hộp 132gr                ', 28500.0000, 4, 90)
INSERT [dbo].[tblProduct] ([ProductID], [ProductName], [Price], [CategoryID], [Amount]) VALUES (10250152, N'Mì ăn liền Omachi 102 Bò Nấu Dưa Chua gói 120gr   ', 10900.0000, 4, 100)
INSERT [dbo].[tblProduct] ([ProductID], [ProductName], [Price], [CategoryID], [Amount]) VALUES (10314436, N'
Tỏi củ Hải Dương 300g                           ', 41900.0000, 1, 100)
INSERT [dbo].[tblProduct] ([ProductID], [ProductName], [Price], [CategoryID], [Amount]) VALUES (10617946, N'MEATDeli Nạc nọng heo (S) (350g)                ', 130865.0000, 2, 100)
INSERT [dbo].[tblProduct] ([ProductID], [ProductName], [Price], [CategoryID], [Amount]) VALUES (10617947, N'MEATDeli Thịt lợn mát Heo xay loại 1 S (350g)     ', 57715.0000, 2, 100)
INSERT [dbo].[tblProduct] ([ProductID], [ProductName], [Price], [CategoryID], [Amount]) VALUES (10624919, N'Ba Ch? Bò M? MVP 350gr                            ', 1290000.0000, 2, 100)
INSERT [dbo].[tblStockInOut] ([StockInOutID], [UserID], [modifyDay]) VALUES (100, 140968, CAST(N'2020-05-28' AS Date))
INSERT [dbo].[tblStockInOut] ([StockInOutID], [UserID], [modifyDay]) VALUES (101, 140968, CAST(N'2020-05-29' AS Date))
INSERT [dbo].[tblStockInOut] ([StockInOutID], [UserID], [modifyDay]) VALUES (102, 140968, CAST(N'2020-05-29' AS Date))
INSERT [dbo].[tblStockInOut] ([StockInOutID], [UserID], [modifyDay]) VALUES (103, 140968, CAST(N'2020-05-29' AS Date))
INSERT [dbo].[tblStockInOut] ([StockInOutID], [UserID], [modifyDay]) VALUES (104, 140968, CAST(N'2020-06-25' AS Date))
INSERT [dbo].[tblStockInOutDetails] ([StockInOutID], [ProductID], [Amount]) VALUES (100, 10009165, 50)
INSERT [dbo].[tblStockInOutDetails] ([StockInOutID], [ProductID], [Amount]) VALUES (100, 10009165, -50)
INSERT [dbo].[tblStockInOutDetails] ([StockInOutID], [ProductID], [Amount]) VALUES (104, 10010010, 100)
INSERT [dbo].[tblStockInOutDetails] ([StockInOutID], [ProductID], [Amount]) VALUES (104, 10010010, -20)
INSERT [dbo].[tblStockInOutDetails] ([StockInOutID], [ProductID], [Amount]) VALUES (101, 10014580, 50)
INSERT [dbo].[tblStockInOutDetails] ([StockInOutID], [ProductID], [Amount]) VALUES (102, 10014580, -50)
INSERT [dbo].[tblStockInOutDetails] ([StockInOutID], [ProductID], [Amount]) VALUES (102, 10014580, 10)
INSERT [dbo].[tblStockInOutDetails] ([StockInOutID], [ProductID], [Amount]) VALUES (103, 10014580, -110)
INSERT [dbo].[tblStockInOutDetails] ([StockInOutID], [ProductID], [Amount]) VALUES (103, 10014580, 100)
INSERT [dbo].[tblUser] ([UserID], [UserName], [UserGroup], [UserLoginName], [UserLoginPassword]) VALUES (140968, N'Doan Nhat Quang                                   ', 1, N'quangdn                                           ', N'123568                                            ')
INSERT [dbo].[tblUser] ([UserID], [UserName], [UserGroup], [UserLoginName], [UserLoginPassword]) VALUES (140969, N'Nguyen Gia Tin                                    ', 2, N'tinng                                             ', N'987654                                            ')
INSERT [dbo].[tblUser] ([UserID], [UserName], [UserGroup], [UserLoginName], [UserLoginPassword]) VALUES (140970, N'Nguyen Tri Truong                                 ', 2, N'truongnt                                          ', N'123456789                                         ')
INSERT [dbo].[tblUser] ([UserID], [UserName], [UserGroup], [UserLoginName], [UserLoginPassword]) VALUES (140971, N'Tran Khanh Duy                                    ', 3, N'duytk                                             ', N'123456789                                         ')
ALTER TABLE [dbo].[tblBill]  WITH CHECK ADD  CONSTRAINT [FK_tblBill_tblUser] FOREIGN KEY([UserID])
REFERENCES [dbo].[tblUser] ([UserID])
GO
ALTER TABLE [dbo].[tblBill] CHECK CONSTRAINT [FK_tblBill_tblUser]
GO
ALTER TABLE [dbo].[tblBillDetails]  WITH CHECK ADD  CONSTRAINT [FK_tblBillDetails_tblBill] FOREIGN KEY([BillID])
REFERENCES [dbo].[tblBill] ([BIllID])
GO
ALTER TABLE [dbo].[tblBillDetails] CHECK CONSTRAINT [FK_tblBillDetails_tblBill]
GO
ALTER TABLE [dbo].[tblBillDetails]  WITH CHECK ADD  CONSTRAINT [FK_tblBillDetails_tblProduct] FOREIGN KEY([ProduceID])
REFERENCES [dbo].[tblProduct] ([ProductID])
GO
ALTER TABLE [dbo].[tblBillDetails] CHECK CONSTRAINT [FK_tblBillDetails_tblProduct]
GO
ALTER TABLE [dbo].[tblProduct]  WITH CHECK ADD  CONSTRAINT [FK_tblProduct_tblCategory] FOREIGN KEY([CategoryID])
REFERENCES [dbo].[tblCategory] ([CategoryID])
GO
ALTER TABLE [dbo].[tblProduct] CHECK CONSTRAINT [FK_tblProduct_tblCategory]
GO
ALTER TABLE [dbo].[tblStockInOut]  WITH CHECK ADD  CONSTRAINT [FK_tblStockInOut_tblUser] FOREIGN KEY([UserID])
REFERENCES [dbo].[tblUser] ([UserID])
GO
ALTER TABLE [dbo].[tblStockInOut] CHECK CONSTRAINT [FK_tblStockInOut_tblUser]
GO
ALTER TABLE [dbo].[tblStockInOutDetails]  WITH CHECK ADD  CONSTRAINT [FK_tblStockInOutDetails_tblStockInOut] FOREIGN KEY([StockInOutID])
REFERENCES [dbo].[tblStockInOut] ([StockInOutID])
GO
ALTER TABLE [dbo].[tblStockInOutDetails] CHECK CONSTRAINT [FK_tblStockInOutDetails_tblStockInOut]
GO
USE [master]
GO
ALTER DATABASE [MiniMartManagement] SET  READ_WRITE 
GO
