# Write your MySQL query statement below
select Department.Name as Department, Employee.Name as Employee, Employee.Salary
from Employee inner join Department on Employee.DepartmentId = Department.Id 
where (Department.Id, Salary) IN (select distinct departmentId, MAX(Salary) as Salary from Employee group by departmentId);
