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
insert into JobRole
values('Apprentice Software Engineer','add spec later','engineering','Apprentice','add res later', 'https://kainossoftwareltd.sharepoint.com/people/Job%20Specifications/Forms/AllItems.aspx?id=%2Fpeople%2FJob%20Specifications%2FEngineering%2FJob%20profile%20%2D%20Apprentice%20Software%20Engineer%20%28Apprentice%29%2Epdf&parent=%2Fpeople%2FJob%20Specifications%2FEngineering&p=true&ga=1'),
('Traine Software Engineer','add spec later','engineering','Trainee','add res later', 'https://kainossoftwareltd.sharepoint.com/:b:/g/people/ERJlfMHOxRVHlMHiUcHDkI8BU2NafboSbetIJ3zNkKwTlw?e=jOY3Vq'),
('Software Engineer','add spec later','engineering','Associate','add res later', 'https://kainossoftwareltd.sharepoint.com/:b:/g/people/EYTCv1ssl6pOuH59zXtoF9YB8qNaEMNSkZIkCthDAY5Kjg?e=Ht84rW'),
('Support Technician','add spec later','engineering','Associate','add res later', 'https://kainossoftwareltd.sharepoint.com/:b:/r/people/Job%20Specifications/Engineering/Job%20Profile%20-%20Support%20Technician%20(As).pdf?csf=1&web=1&e=2ZNeHK'),
('Front-End Engineer','add spec later','engineering','Associate','add res later', 'https://kainossoftwareltd.sharepoint.com/:b:/r/people/Job%20Specifications/Engineering/Job%20Profile%20-%20Support%20Technician%20(As).pdf?csf=1&web=1&e=2ZNeHK'),
INSERT INTO JobFamily
values('test', engineering);
select * from JobFamily;
truncate Table JobRole;
drop Database JobForge_OdhranH;
