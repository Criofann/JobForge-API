use JobForge_OdhranH;
insert into Employee
values(1,'name','https://kainossoftwareltd.sharepoint.com/people/_api/siteiconmanager/getsitelogo?type=%271%27','message')
,(2,'John Smith','https://kainossoftwareltd.sharepoint.com/people/_api/siteiconmanager/getsitelogo?type=%271%27','message about John')
,(3,'John Doe','https://kainossoftwareltd.sharepoint.com/people/_api/siteiconmanager/getsitelogo?type=%271%27','message about John')
,(4,'James Wayne','https://kainossoftwareltd.sharepoint.com/people/_api/siteiconmanager/getsitelogo?type=%271%27','message about James')
,(5,'John Doe','https://kainossoftwareltd.sharepoint.com/people/_api/siteiconmanager/getsitelogo?type=%271%27','message about John')
,(6,'Joe Blogs','https://kainossoftwareltd.sharepoint.com/people/_api/siteiconmanager/getsitelogo?type=%271%27','message about Joe')
,(7,'Philip Stark','https://kainossoftwareltd.sharepoint.com/people/_api/siteiconmanager/getsitelogo?type=%271%27','message about John')
,(8,'Janet Doe','https://kainossoftwareltd.sharepoint.com/people/_api/siteiconmanager/getsitelogo?type=%271%27','message about Janet')
,(9,'John Doe','https://kainossoftwareltd.sharepoint.com/people/_api/siteiconmanager/getsitelogo?type=%271%27','message about John')
,(10,'Ruth Green','https://kainossoftwareltd.sharepoint.com/people/_api/siteiconmanager/getsitelogo?type=%271%27','message about Ruth')
,(11,'Clark Kent','https://kainossoftwareltd.sharepoint.com/people/_api/siteiconmanager/getsitelogo?type=%271%27','message about Clark')
,(12,'Lucy Pensive','https://kainossoftwareltd.sharepoint.com/people/_api/siteiconmanager/getsitelogo?type=%271%27','message about Lucy')
,(13,'Mathew White','https://kainossoftwareltd.sharepoint.com/people/_api/siteiconmanager/getsitelogo?type=%271%27','message about Mathew')
,(14,'Jane Gordan','https://kainossoftwareltd.sharepoint.com/people/_api/siteiconmanager/getsitelogo?type=%271%27','message about Jane');
select* from Capability;
insert into Capability
values('engineering',1),
('platforms',2),('Cyber Sercurity',3),
('Workday',4),('Experiance Design',5),
('Data and AI',6),('Product',7),
('Delivey',8),('Operations',9),
('Business Dev + marketing',10),
('Organisation + Planning',11),
('People',12),
('Comericial + Financial',13),
('Business Support',14);
INSERT INTO Band
VALUES('Apprentice', '1','The lowest level of compentencies'),
('Trainee', '2','The second lowest level of compentencies'),
('Associate', '3','The third lowest level of compentencies'),
('Senior', '4','The fourth lowest level of compentencies'),
('Consultant', '5','The fourth higest level of compentencies'),
('Manager', '6','The third higest level of compentencies'),
('Principle', '7','The second higest level of compentencies'),
('Leadership Community', '8','The highest level of compentencies');
insert into JobRole
values('Apprentice Software Engineer','engineering','earn as you learn work as you learn','engineering','Apprentice','work as a part of a team on real projects', 'https://kainossoftwareltd.sharepoint.com/:b:/r/people/Job%20Specifications/Engineering/Job%20profile%20-%20Apprentice%20Software%20Engineer%20(Apprentice).pdf?csf=1&web=1&e=FCelnr'),
('Traine Software Engineer','engineering','work on a project team and learn from more experianced devs','engineering','Trainee','contribute to solutions, work as a part of a team', 'https://kainossoftwareltd.sharepoint.com/:b:/g/people/ERJlfMHOxRVHlMHiUcHDkI8BU2NafboSbetIJ3zNkKwTlw?e=jOY3Vq'),
('Software Engineer','engineering','develop high level solutions as a part of a team','engineering','Associate','develop high quality solutions', 'https://kainossoftwareltd.sharepoint.com/:b:/g/people/EYTCv1ssl6pOuH59zXtoF9YB8qNaEMNSkZIkCthDAY5Kjg?e=Ht84rW'),
('Support Technician','engineering','Anaylise and solve complicated technical issues','engineering','Associate','day to day technical support', 'https://kainossoftwareltd.sharepoint.com/:b:/r/people/Job%20Specifications/Engineering/Job%20Profile%20-%20Support%20Technician%20(As).pdf?csf=1&web=1&e=2ZNeHK'),
('Front-End Engineer','engineering','devolop high quality user interface solutions','engineering','Associate','devolop high quality user interface solutions', 'https://kainossoftwareltd.sharepoint.com/:b:/r/people/Job%20Specifications/Engineering/Job%20Profile%20-%20Support%20Technician%20(As).pdf?csf=1&web=1&e=2ZNeHK'),
('Senior Software Engineer','engineering','develop high level solutions as a part of a team','engineering','Senior','develop high level solutions as a part of a team', 'https://kainossoftwareltd.sharepoint.com/:b:/g/people/EeS73plMEQ9Fjf-tovttXuYBEo-0tlfT-U3bFMcgryapVw?e=wJFypU'),
('Senior Support Technician','engineering','add spec later','engineering','Senior','add res later', 'https://kainossoftwareltd.sharepoint.com/:b:/r/people/Job%20Specifications/Engineering/Job%20Profile%20-%20Senior%20Support%20Technician%20(SA).pdf?csf=1&web=1&e=2bIVHA'),
('Senior Front-End Engineer','engineering','add spec later','engineering','Senior','add res later', 'https://kainossoftwareltd.sharepoint.com/:b:/s/PeopleTeam-SharedDrive/Eatbo8zxX6tAtmbP8V1zp40B6IOOUSbmNXegGn_a9ooPVA?e=ozka8V'),
('Lead Software Engineer','engineering','lead teams and develop high ','engineering','Consultant','lead teams and liases with customers', 'https://kainossoftwareltd.sharepoint.com/:b:/g/people/EZwjG2_68rZOiWicTIbaM7IBGNimvPpVhz3Z8iyefkmDQw?e=fIh91B'),
('Lead Managed Services engineer','engineering','add spec later','engineering','Consultant','add res later', 'https://kainossoftwareltd.sharepoint.com/:b:/g/people/EZURQr9PhANKgW_hsp4n47QBmjdD2in8Gz6Qi0R-62U7Bg?e=rGt6xD'),
('Trainee Test Engineer','Testing + quality','add spec later','engineering','trainee','add res later', 'https://kainossoftwareltd.sharepoint.com/:b:/r/people/Job%20Specifications/Engineering/Job%20profile%20Trainee%20Test%20Engineer%20(Trainee).pdf?csf=1&web=1&e=YW0Qo6'),
('Test Engineer','Testing + quality','add spec later','engineering','Associate','add res later', 'https://kainossoftwareltd.sharepoint.com/:b:/r/people/Job%20Specifications/Engineering/Job%20profile%20%20Test%20Engineer%20(Associate).pdf?csf=1&web=1&e=vhB9vK'),
('Senior Test Engineer','Testing + quality','add spec later','engineering','Senior','add res later', 'https://kainossoftwareltd.sharepoint.com/:b:/r/people/Job%20Specifications/Engineering/Job%20profile%20-%20Senior%20Test%20Engineer%20(SA).pdf?csf=1&web=1&e=fhtv1A'),
('Senior NFT Engineer','Testing + quality','add spec later','engineering','Senior','add res later', 'https://kainossoftwareltd.sharepoint.com/:b:/g/people/EcXYPU9ji3FGqThWcoPDzUgBMsRkQiRqaTvPoTgIT5VAgw?e=KIgOFw'),
('Lead Test Engineer','Testing + quality','add spec later','engineering','Consultant','add res later', 'https://kainossoftwareltd.sharepoint.com/:b:/r/people/Job%20Specifications/Engineering/Job%20profile%20-%20Lead%20Test%20Engineer%20(Consultant).pdf?csf=1&web=1&e=uzHzAa'),
('Lead NFT Engineer','Testing + quality','add spec later','engineering','Consultant','add res later', 'https://kainossoftwareltd.sharepoint.com/:b:/g/people/EZb2TmMB0MBLlwWgFg4DLQ4B6gTWJbPbfzQqOqFTiEGWPA?e=lZxf1S'),
('Test Manager','Testing + quality','add spec later','engineering','Consultant','add res later', 'https://kainossoftwareltd.sharepoint.com/:b:/g/people/EWhQmoHJz6lDmruVQbXPukwBdORoWzoD5m-2AqEFkk7sJA?e=3L2xrU'),
('Test Architect','Testing + quality','add spec later','engineering','Manager','add res later', 'https://kainossoftwareltd.sharepoint.com/:b:/g/people/EaUc6UK0VK9EkoQGonvGc7gBFq5BA44lWgyImt5s-810BA?e=oL7L2S'),
('Principle Test Architect','Testing + quality','add spec later','engineering','Principle','add res later', 'https://kainossoftwareltd.sharepoint.com/:b:/r/people/Job%20Specifications/Engineering/Job%20profile%20-%20Principal%20Test%20Architect%20(P).pdf?csf=1&web=1&e=2J9P9x'),
('Inovation Lead','Engineering ​​​​​​​Strategy + Planning','add spec later','engineering','Consultant','add res later','https://kainossoftwareltd.sharepoint.com/:b:/g/people/EfDowM36RnBLtOSfM1n7ydsBrEhf4SrE_TGzS9ej432Cew?e=NCBKGp'),
('Technology Leader','Engineering ​​​​​​​Strategy + Planning','add spec later','engineering','Leadership Community','add res later','https://kainossoftwareltd.sharepoint.com/:b:/g/people/EbVmcbCjUW9GnuKIvWQl4ZEBu1OexK_ZLriei8AUoRozCg?e=pkpCiw'),
('Technical Architect','Architecture','technical leader','engineering','Consultant','work all','https://kainossoftwareltd.sharepoint.com/:b:/g/people/ERa52ZFdOhxJuKYbwl5w27YBUGgHxFh6qz9AtTflB2YPGA?e=mMeOWH'),
('Solution Architect','Architecture','lead multi skill agile teams','engineering','Manager','work with customer architiects','https://kainossoftwareltd.sharepoint.com/:b:/g/people/ESpp56fZyrhKi6uCuwpshDwB3nmo1BMkbQKYDXbNHCi_sw?e=muiHBJ'),
('Dynamics 365 Solution Architect','Architecture','add spec later','engineering','Manager','add res later','https://kainossoftwareltd.sharepoint.com/:b:/g/people/ESpp56fZyrhKi6uCuwpshDwB3nmo1BMkbQKYDXbNHCi_sw?e=muiHBJ'),
('Principal Architect','Architecture','responsible for the succesful delivery of large-scale solutions','engineering','Principle','delivery of large-scale solutions','https://kainossoftwareltd.sharepoint.com/:b:/g/people/EVF5r86T24NNpDy0weP5HdIBaCNWkL9__IzJXLHLzlpP4w?e=tsnXuj'),
('Product Specialist','Product Specialist','add spec later','engineering','Associate','add res later', 'https://kainossoftwareltd.sharepoint.com/:b:/g/people/EfeMkAfUpYlDuqvBpgndb8EB5o___Gv8q5UKl7eNqDF8Ug?e=zR5zGI'),
('Senior Product Specialist','Product Specialist','add spec later','engineering','Senior','add res later', 'https://kainossoftwareltd.sharepoint.com/:b:/r/people/Job%20Specifications/Engineering/Job%20profile%20-%20Senior%20Test%20Engineer%20(SA).pdf?csf=1&web=1&e=fhtv1A'),
('Lead Product Specialist','Product Specialist','add spec later','engineering','Consultant','add res later', 'https://kainossoftwareltd.sharepoint.com/:b:/r/people/Job%20Specifications/Engineering/Job%20profile%20-%20Lead%20Product%20Specialist%20(C).pdf?csf=1&web=1&e=vfXLck'),
('intelligent automation Architect','Product Specialist','add spec later','engineering','Manager','add res later', 'https://kainossoftwareltd.sharepoint.com/:b:/r/people/Job%20Specifications/Engineering/Job%20Profile%20-%20Intelligent%20Automation%20Solution%20Architect%20(M).pdf?csf=1&web=1&e=0Nt9EZ'),
('Low code Engineer','Low Code','add spec later','engineering','Associate','add res later', 'https://kainossoftwareltd.sharepoint.com/:b:/r/people/Job%20Specifications/Engineering/Job%20specification%20-%20Low%20Code%20Engineer%20(A)%20-%20Low%20Code.pdf?csf=1&web=1&e=s50yu8'),
(' Senior Low code Engineer','Low Code','add spec later','engineering','Senior','add res later', 'https://kainossoftwareltd.sharepoint.com/:b:/r/people/Job%20Specifications/Engineering/Job%20Profile%20-%20Low%20Code%20Engineer%20(SA)%20-%20Low%20Code.pdf?csf=1&web=1&e=cOi75B'),
('Low Code Technical Architect','Low Code','add spec later','engineering','Consultant','add res later','https://kainossoftwareltd.sharepoint.com/:b:/g/people/Efw2zJ_Tn35Jpws2jsS80dIBUmSNxzwuRu-71nmLmR3lHg?e=4Xv5MI'),
('Low Code Principal Architect','Low Code','add spec later','engineering','Principle','add res later','https://kainossoftwareltd.sharepoint.com/:b:/g/people/EVF5r86T24NNpDy0weP5HdIBaCNWkL9__IzJXLHLzlpP4w?e=tsnXuj');








truncate Table JobRole;
drop Database JobForge_OdhranH;

ALTER TABLE JobFamily
ALTER COLUMN 
