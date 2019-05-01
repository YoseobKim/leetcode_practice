# Write your MySQL query statement below
select temp.Name as Customers from 
(select Customers.Name, Orders.Id from Customers left join Orders on Customers.Id = Orders.CustomerId) as temp
where temp.Id is null;
