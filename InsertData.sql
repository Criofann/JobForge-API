USE JobForge_OdhranH;
INSERT INTO Employee
VALUES(1,'James Scott','https://kainossoftwareltd.sharepoint.com/people/_api/siteiconmanager/getsitelogo?type=%271%27','Hello!')
,(2,'John Smith','https://kainossoftwareltd.sharepoint.com/people/_api/siteiconmanager/getsitelogo?type=%271%27','N/A')
,(3,'John Doe','https://kainossoftwareltd.sharepoint.com/people/_api/siteiconmanager/getsitelogo?type=%271%27','Currently exploring the world of code')
,(4,'James Wayne','https://kainossoftwareltd.sharepoint.com/people/_api/siteiconmanager/getsitelogo?type=%271%27','Senior Software Engineer @ Kainos.')
,(5,'John Doe','https://kainossoftwareltd.sharepoint.com/people/_api/siteiconmanager/getsitelogo?type=%271%27','N/A')
,(6,'Joe Blogs','https://kainossoftwareltd.sharepoint.com/people/_api/siteiconmanager/getsitelogo?type=%271%27','N/A')
,(7,'Philip Stark','https://kainossoftwareltd.sharepoint.com/people/_api/siteiconmanager/getsitelogo?type=%271%27','Phill Stark')
,(8,'Janet Doe','https://kainossoftwareltd.sharepoint.com/people/_api/siteiconmanager/getsitelogo?type=%271%27','N/A')
,(9,'John Doe','https://kainossoftwareltd.sharepoint.com/people/_api/siteiconmanager/getsitelogo?type=%271%27','Hi there, my name is John')
,(10,'Ruth Green','https://kainossoftwareltd.sharepoint.com/people/_api/siteiconmanager/getsitelogo?type=%271%27','Message about Ruth')
,(11,'Clark Kent','https://kainossoftwareltd.sharepoint.com/people/_api/siteiconmanager/getsitelogo?type=%271%27','N/A')
,(12,'Lucy Pensive','https://kainossoftwareltd.sharepoint.com/people/_api/siteiconmanager/getsitelogo?type=%271%27','Passionate about IT.')
,(13,'Mathew White','https://kainossoftwareltd.sharepoint.com/people/_api/siteiconmanager/getsitelogo?type=%271%27','N/A')
,(14,'Jane Gordan','https://kainossoftwareltd.sharepoint.com/people/_api/siteiconmanager/getsitelogo?type=%271%27','Knowledge of HTML, JavaScript and CSS.');

INSERT INTO Capability
VALUES('Engineering',1),
('Platforms',2),('Cyber Security',3),
('Workday',4),('Experience Design',5),
('Data & AI',6),('Product',7),
('Delivey',8),('Operations',9),
('Business Dev & Marketing',10),
('Organisation & Planning',11),
('People',12),
('Commercial & Financial',13),
('Business Support',14);

INSERT INTO Band
VALUES('Apprentice', '7','Ability to learn and develop skills'),
('Trainee', '6','Ability to further learn and develop skills'),
('Associate', '5','Organisation and use of agile development'),
('Senior Associate', '4','Technical skills and use of agile development'),
('Consultant', '3','Leadership and strong technical ability'),
('Manager', '2','Leadership and communication skills'),
('Principal', '1','Leadership, communication and organisation'),
('Executive', '0','Leadership communication, organisation and innovation');

INSERT INTO JobRole
VALUES('Apprentice Software Engineer', 'Engineering', 'EAYL - Study for a degree and gain experience working on real life projects.', 'Engineering', 'Apprentice', 'Attend university and work as a part of a team on real projects', 'https://kainossoftwareltd.sharepoint.com/:b:/r/people/Job%20Specifications/Engineering/Job%20profile%20-%20Apprentice%20Software%20Engineer%20(Apprentice).pdf?csf=1&web=1&e=FCelnr'),
('Trainee Software Engineer', 'Engineering', 'Work on a project team and learn from experienced developers', 'Engineering', 'Trainee', 'Contribute to solutions, work as a part of a team', 'https://kainossoftwareltd.sharepoint.com/:b:/g/people/ERJlfMHOxRVHlMHiUcHDkI8BU2NafboSbetIJ3zNkKwTlw?e=jOY3Vq'),
('Software Engineer',' Engineering', 'Develop high level solutions as a part of a team', 'Engineering', 'Associate', 'Develop high quality solutions', 'https://kainossoftwareltd.sharepoint.com/:b:/g/people/EYTCv1ssl6pOuH59zXtoF9YB8qNaEMNSkZIkCthDAY5Kjg?e=Ht84rW'),
('Support Technician', 'Engineering', 'Analyse and solve complicated technical issues' ,'Engineering', 'Associate', 'Day to day technical support', 'https://kainossoftwareltd.sharepoint.com/:b:/r/people/Job%20Specifications/Engineering/Job%20Profile%20-%20Support%20Technician%20(As).pdf?csf=1&web=1&e=2ZNeHK'),
('Front-End Engineer', 'Engineering', 'Develop high quality user interface solutions', 'Engineering', 'Associate', 'Develop high quality user interface solutions', 'https://kainossoftwareltd.sharepoint.com/:b:/r/people/Job%20Specifications/Engineering/Job%20Profile%20-%20Support%20Technician%20(As).pdf?csf=1&web=1&e=2ZNeHK'),
('Senior Software Engineer', 'Engineering', 'Develop high level solutions as a part of a team',' Engineering',' Senior',' Develop high level solutions as a part of a team', 'https://kainossoftwareltd.sharepoint.com/:b:/g/people/EeS73plMEQ9Fjf-tovttXuYBEo-0tlfT-U3bFMcgryapVw?e=wJFypU'),
('Senior Support Technician', 'Engineering', 'Solve complicated technical issues', 'Engineering', 'Senior', 'Day to day support, apply relevant standards', 'https://kainossoftwareltd.sharepoint.com/:b:/r/people/Job%20Specifications/Engineering/Job%20Profile%20-%20Senior%20Support%20Technician%20(SA).pdf?csf=1&web=1&e=2bIVHA'),
('Senior Front-End Engineer', 'Engineering', 'Develop high quality user interfaces', 'Engineering', 'Senior', 'Develop high quality user interfaces', 'https://kainossoftwareltd.sharepoint.com/:b:/s/PeopleTeam-SharedDrive/Eatbo8zxX6tAtmbP8V1zp40B6IOOUSbmNXegGn_a9ooPVA?e=ozka8V'),
('Lead Software Engineer', 'Engineering', 'Lead teams and develop high ', 'Engineering', 'Consultant', 'lead teams and laisse with customers', 'https://kainossoftwareltd.sharepoint.com/:b:/g/people/EZwjG2_68rZOiWicTIbaM7IBGNimvPpVhz3Z8iyefkmDQw?e=fIh91B'),
('Lead Managed Services engineer', 'Engineering', 'Lead teams and provide support',' Engineering', 'Consultant', 'Lead teams and provide support', 'https://kainossoftwareltd.sharepoint.com/:b:/g/people/EZURQr9PhANKgW_hsp4n47QBmjdD2in8Gz6Qi0R-62U7Bg?e=rGt6xD'),
('Trainee Test Engineer', 'Testing + quality', 'Work in a team to develop and execute test', 'Engineering', 'Trainee', 'Work in a team to develop and execute test', 'https://kainossoftwareltd.sharepoint.com/:b:/r/people/Job%20Specifications/Engineering/Job%20profile%20Trainee%20Test%20Engineer%20(Trainee).pdf?csf=1&web=1&e=YW0Qo6'),
('Test Engineer', 'Testing + quality', 'Work in a team to develop and execute test', 'Engineering', 'Associate', 'Work in a team to develop and execute test', 'https://kainossoftwareltd.sharepoint.com/:b:/r/people/Job%20Specifications/Engineering/Job%20profile%20%20Test%20Engineer%20(Associate).pdf?csf=1&web=1&e=vhB9vK'),
('Senior Test Engineer', 'Testing + quality', 'Work in a team to develop and execute test', 'Engineering', 'Senior', 'Work in a team to develop and execute test', 'https://kainossoftwareltd.sharepoint.com/:b:/r/people/Job%20Specifications/Engineering/Job%20profile%20-%20Senior%20Test%20Engineer%20(SA).pdf?csf=1&web=1&e=fhtv1A'),
('Senior NFT Engineer', 'Testing + quality', 'Develop and execute non-functional tests', 'Engineering', 'Senior', 'Develop and execute non-functional tests', 'https://kainossoftwareltd.sharepoint.com/:b:/g/people/EcXYPU9ji3FGqThWcoPDzUgBMsRkQiRqaTvPoTgIT5VAgw?e=KIgOFw'),
('Lead Test Engineer', 'Testing + quality',' Lead a team to develop and execute test',' Engineering',' Consultant', 'Lead a team to develop and execute test', 'https://kainossoftwareltd.sharepoint.com/:b:/r/people/Job%20Specifications/Engineering/Job%20profile%20-%20Lead%20Test%20Engineer%20(Consultant).pdf?csf=1&web=1&e=uzHzAa'),
('Lead NFT Engineer', 'Testing + quality', 'Technical leader and innovator in NFT', 'Engineering', 'Consultant', 'Technical leader and innovator in NFT', 'https://kainossoftwareltd.sharepoint.com/:b:/g/people/EZb2TmMB0MBLlwWgFg4DLQ4B6gTWJbPbfzQqOqFTiEGWPA?e=lZxf1S'),
('Test Manager', 'Testing + quality', 'Ensure high quality solutions', 'Engineering', 'Consultant', 'Ensure high quality solutions', 'https://kainossoftwareltd.sharepoint.com/:b:/g/people/EWhQmoHJz6lDmruVQbXPukwBdORoWzoD5m-2AqEFkk7sJA?e=3L2xrU'),
('Test Architect', 'Testing + quality', 'Ensure high quality solutions',' engineering', 'Manager', 'Ensure high quality solutions', 'https://kainossoftwareltd.sharepoint.com/:b:/g/people/EaUc6UK0VK9EkoQGonvGc7gBFq5BA44lWgyImt5s-810BA?e=oL7L2S'),
('Principle Test Architect', 'Testing + quality', 'Ensure high quality solutions', 'Engineering', 'Principle', 'Ensure high quality solutions', 'https://kainossoftwareltd.sharepoint.com/:b:/r/people/Job%20Specifications/Engineering/Job%20profile%20-%20Principal%20Test%20Architect%20(P).pdf?csf=1&web=1&e=2J9P9x'),
('Innovation Lead', 'Engineering Strategy + Planning',' Give advice on using new technology',' Engineering',' Consultant',' Give advice on using new technology','https://kainossoftwareltd.sharepoint.com/:b:/g/people/EfDowM36RnBLtOSfM1n7ydsBrEhf4SrE_TGzS9ej432Cew?e=NCBKGp'),
('Technology Leader',' Engineering Strategy + Planning', 'Make executive technology decisions', 'Engineering',' Leadership Community', 'People, strategy, business development',' https://kainossoftwareltd.sharepoint.com/:b:/g/people/EbVmcbCjUW9GnuKIvWQl4ZEBu1OexK_ZLriei8AUoRozCg?e=pkpCiw'),
('Technical Architect', 'Architecture', 'Technical leader', 'Engineering', 'Consultant', 'Lead a team well in order to produce a high quality solution','https://kainossoftwareltd.sharepoint.com/:b:/g/people/ERa52ZFdOhxJuKYbwl5w27YBUGgHxFh6qz9AtTflB2YPGA?e=mMeOWH'),
('Solution Architect', 'Architecture', 'Lead multi skill agile teams', 'Engineering',' Manager',' Work with customer architiects','https://kainossoftwareltd.sharepoint.com/:b:/g/people/ESpp56fZyrhKi6uCuwpshDwB3nmo1BMkbQKYDXbNHCi_sw?e=muiHBJ'),
('Dynamics 365 Solution Architect', 'Architecture', 'Analyse the gap between product offering and customer needs',' Engineering', 'Manager', 'Lead teams and manage and coach','https://kainossoftwareltd.sharepoint.com/:b:/g/people/ESpp56fZyrhKi6uCuwpshDwB3nmo1BMkbQKYDXbNHCi_sw?e=muiHBJ'),
('Principal Architect',' Architecture', 'Responsible for the successful delivery of large-scale solutions',' Engineering',' Principle', 'Delivery of large-scale solutions','https://kainossoftwareltd.sharepoint.com/:b:/g/people/EVF5r86T24NNpDy0weP5HdIBaCNWkL9__IzJXLHLzlpP4w?e=tsnXuj'),
('Product Specialist', 'Product Specialist',' Deliver high quality solutions', 'Engineering',' Associate',' Capturing and mapping customers to product capabilities', 'https://kainossoftwareltd.sharepoint.com/:b:/g/people/EfeMkAfUpYlDuqvBpgndb8EB5o___Gv8q5UKl7eNqDF8Ug?e=zR5zGI'),
('Senior Product Specialist',' Product Specialist',' Deliver high quality solutions' ,'Engineering', 'Senior', 'Capturing and mapping customers to product capabilities', 'https://kainossoftwareltd.sharepoint.com/:b:/r/people/Job%20Specifications/Engineering/Job%20profile%20-%20Senior%20Test%20Engineer%20(SA).pdf?csf=1&web=1&e=fhtv1A'),
('Lead Product Specialist',' Product Specialist', 'Lead teams',' Engineering', 'Consultant',' Capturing and mapping customers to product capabilities', 'https://kainossoftwareltd.sharepoint.com/:b:/r/people/Job%20Specifications/Engineering/Job%20profile%20-%20Lead%20Product%20Specialist%20(C).pdf?csf=1&web=1&e=vfXLck'),
('Intelligent Automation Architect', 'Product Specialist', 'Lead teams to deliver high quality intelligent automation solutions',' Engineering', 'Manager', 'Technical leader, managing and coaching, work with customers', 'https://kainossoftwareltd.sharepoint.com/:b:/r/people/Job%20Specifications/Engineering/Job%20Profile%20-%20Intelligent%20Automation%20Solution%20Architect%20(M).pdf?csf=1&web=1&e=0Nt9EZ'),
('Low Code Engineer',' Low Code', 'Develop high quality solutions', 'Engineering',' Associate', 'Develop high quality solutions', 'https://kainossoftwareltd.sharepoint.com/:b:/r/people/Job%20Specifications/Engineering/Job%20specification%20-%20Low%20Code%20Engineer%20(A)%20-%20Low%20Code.pdf?csf=1&web=1&e=s50yu8'),
('Senior Low Code Engineer',' Low Code', 'Develop high quality solutions', 'Engineering', 'Senior', 'Develop high quality solutions', 'https://kainossoftwareltd.sharepoint.com/:b:/r/people/Job%20Specifications/Engineering/Job%20Profile%20-%20Low%20Code%20Engineer%20(SA)%20-%20Low%20Code.pdf?csf=1&web=1&e=cOi75B'),
('Low Code Technical Architect', 'Low Code',' Lead and develop high quality solutions',' Engineering', 'Consultant', 'Leading and managing and coaching','https://kainossoftwareltd.sharepoint.com/:b:/g/people/Efw2zJ_Tn35Jpws2jsS80dIBUmSNxzwuRu-71nmLmR3lHg?e=4Xv5MI'),
('Low Code Principal Architect', 'Low Code', 'Delivery of large scale high quality solutions',' Engineering', 'Principle', 'Delivery of large scale high quality solutions','https://kainossoftwareltd.sharepoint.com/:b:/g/people/EVF5r86T24NNpDy0weP5HdIBaCNWkL9__IzJXLHLzlpP4w?e=tsnXuj');