# employeesDB_System
You are tasked with designing a simple database system for a company. The system should store information about employees. Implement the following CRUD operations(Rest Api) for each entity :


Create (C): 
Design the database schema to store information about employees.
Create Rest api statements to insert new records for an employee.

Read (R):
Write functional rest api to retrieve the following information:
Retrieve all information about employees.
Return employees whose salary >=70000 and <=76000.
Return employee behalf of name
(Exp. In path variable need to put name and return the specific employee detail)
Return all unique teams name

Update (U):
Implement rest api to update the following information:
Update the Role Of an Employee(e.g., SDE1,SDE2).
Update the salary
Update the teams Name
Update the details of a specific employee.

Delete (D):
Create rest api to delete records from the database:
Remove a employee from the dataBase by their name.
Delete all information.


Json Output: 
[{
  "id": 1,
  "empName": "jack",
  "companyName": Niral Networks,
  "Role": "SDE1",
  "TeamName": "Alpha"
  "salary": "70000"
},
{
  "id": 2,
  "empName": "Alexa",
  "companyName": Niral Networks,
  "Role": "SDE2",
  "TeamName": "Bravo"
   "salary": "80000"
},
{
  "id": 3,
  "empName": "Rayn",
  "companyName": Niral Networks,
  "Role": "SDE1",
  "TeamName": "charli"
   "salary": "65000"
},
{
  "id": 4,
  "empName": "Tom",
  "companyName": Niral Networks,
  "Role": "SDE2",
  "TeamName": "Bravo"
   "salary": "55000"
}
,{
  "id": 5,
  "empName": "Jerry",
  "companyName": Niral Networks,
  "Role": "SDE2",
  "TeamName": "Charli"
   "salary": "75000"
}
]


programming language- java 17
framework- springboot 3.1.5
DB- MySql
BuildTool - Maven
