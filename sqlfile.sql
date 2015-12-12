/* SQL Configuration For Library Manager Reborn */
/* Created By black-dragon74 aka Nick */

/* Drop previous database, Forcibly */

Drop database if exists lib_reborn;

Create database lib_reborn;

Use lib_reborn;

Create table pro_stat(CStat int(03));

Insert into pro_stat values ('401');

Create table logon(alpha varchar(50),bravo varchar(50));

Insert into logon values('niraj','e555f863fb09593119fe2f3459e9783a');

Create table library_users(Uid int(10),Name varchar(200),Mobile varchar(15),Email varchar(200),Doj varchar(40));

Insert into library_users values('2974','Niraj Yadav','8302716971','nickk.2974@gmail.com','2015-12-11 07:56:00');

Create table book_catalogue (Book_Id varchar(20) PRIMARY KEY,Book_Name varchar(300),Author varchar(100),Genre varchar(50),Date_Added varchar(30),Status varchar(10));

create table book_transactions(Mem_Id int(10),Mem_Name varchar(200),Book_Id varchar(30),Book_Name varchar(400),Date_Issued varchar(30));