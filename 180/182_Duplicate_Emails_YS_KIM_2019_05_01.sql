# Write your MySQL query statement below
select temp.Email from 
(select Email, count(Id) as count from Person group by Email) as temp
where temp.count > 1;
