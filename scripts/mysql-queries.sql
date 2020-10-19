create table account_balance (account_id int(10),account_name varchar(150), account_type varchar(100), last_updated timestamp,
balance float, primary key(account_id));

insert into account_balance values(523456776,"Drew Stan","Current",current_timestamp(),2540.00);

insert into account_balance values(523456777,"Stan Lee","Current",current_timestamp(),1240.50);

commit;

select * from account_balance;
