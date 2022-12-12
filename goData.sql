/*
	Filename			:			goData
	Author				:			Aysham Ali Hameed
	Created				:			12 January 2019
	Operating System	:			Windows 10
	Version				:			MSSMS v17.8.1
	Description			:			Creating the database & tables.
*/


			--CREATING DATABASE======================================================
			use master
			go

			--DROPPING EXISTING DATABASE
			if exists(select name from master.dbo.sysdatabases where name='fDatabase')
			begin
				drop database fDatabase
			end
			go

			create database fDatabase
				on primary(
					name = 'fDatabase_data',
					filename = 'C:\DB\fDatabase_data.mdf',
					size = 5mb,
					filegrowth = 10%
				)

				log on(
					name = 'fDatabase_log',
					filename = 'C:\DB\fDatabase_log.ldf',
					size = 5mb,
					filegrowth = 10%
				)
			go



			--CREATING TABLES=========================================================
			use fDatabase
			go

			--DROPPING EXISTING TABLES
			drop table if exists dbo.Replies
			go

			drop table if exists dbo.Comments
			go

			drop table if exists dbo.Posts
			go

			drop table if exists dbo.Users
			go

			drop table if exists dbo.Topics
			go


			--CREATING TABLES
			create table Users(
				userID int not null primary key identity,
				userName varchar(50) not null unique,
				userEmail varchar(70) not null,
				userPassword varchar(50) not null,
				userSQuestion varchar(100) not null,
				userSAnswer varchar(100) not null
			)
			go

			--INSERTING 1 DEFAULT USER
			insert into Users
			values ('ryan','ryan@gmail.com','password123','Where were your parents born?','East London')
			go

			create table Topics(
				topicID int not null primary key identity,
				topicName varchar(50) not null,
				topicDesc varchar(max) not null
			)
			go

			--INSERTING A NUMBER OF FIX TOPICS/CATEGORIES FOR DISCUSSIONS
			insert into Topics
			values	('Social','Lets talk about things.'), 
					('Apple','Discussions on Apple matters.'), 
					('Software','Download and review softwares.'), 
					('Movies','Lets talk about the lates movies'), 
					('Books','Do you like reading?'), 
					('Events','Keep track of the events in your town!'), 
					('Gaming','What type of game do you like?'), 
					('Hacking','Hacking is the art of exploitation.'), 
					('Coding','Get help from other people in programming.'), 
					('Science', 'Science is a fascinating subject')
			go

			create table Posts(
				postID int not null primary key identity,
				postSubject varchar(255) not null,
				postDescription varchar(max) null,
				postTime varchar(50) not null,
				postAuthor varchar(50) not null references Users(userName) on delete cascade,
				topicID int not null references Topics(topicID) on delete cascade
	
			)
			go


			create table Comments(
				commentIdentity int not null primary key identity,
				commentID int not null,
				commentAuthor varchar(50) not null,
				commentTime varchar(50) not null,
				commentDesc varchar(max) not null,
				unique (commentID, commentAuthor),
				postID int not null  references Posts(postID) on delete cascade
			)
			go

			create table Replies(
				replyID int not null primary key identity,
				replyDescription varchar(max) not null,
				replyTime varchar(50) not null,
				replyAuthor varchar(50) not null,
				commentIdentity int not null references Comments(commentIdentity) on delete cascade
				--postID int not null  references Posts(postID) 
			)







--QUERY EXAMPLE 1
--select userEmail, topicName from Posts join Users on Posts.postAuthor= Users.userName join Topics on Posts.topicID = Topics.topicID   

--QUERY EXAMPLE 2
--select postSubject, postDescription, commentDesc from Posts join Comments on Posts.postID = Comments.postID

