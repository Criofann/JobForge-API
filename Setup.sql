CREATE DATABASE JobForge_OdhranH;

USE JobForge_OdhranH;


CREATE TABLE Band(
	BandName VARCHAR(20) PRIMARY KEY,
    BandLevel VARCHAR(10),
    Competencies VARCHAR(100)
);

CREATE TABLE Training(
	TrainingName VARCHAR(20) PRIMARY KEY,
    BandName VARCHAR(20),
    TrainingType VARCHAR(20),
    FOREIGN KEY(BandName) REFERENCES Band(BandName)
);

CREATE TABLE Employee(
	EmployeeID INTEGER PRIMARY KEY,
    EmployeeName VARCHAR(50),
    EmployeePhoto VARCHAR(100),
    EmployeeMessage VARCHAR(100)
);

CREATE TABLE Capability(
	CapabilityName VARCHAR(30) PRIMARY KEY,
    LeadID INTEGER,
    FOREIGN KEY(LeadID) REFERENCES Employee(EmployeeID)
);

CREATE TABLE JobFamily(
	JobFamily VARCHAR(30) PRIMARY KEY,
    CapabilityName VARCHAR(30),
    FOREIGN KEY(CapabilityName) REFERENCES Capability(CapabilityName)
);

CREATE TABLE JobRole(
	RoleName VARCHAR(20) PRIMARY KEY,
    Specification VARCHAR(100),
    CapabilityName VARCHAR(20),
    BandName VARCHAR(20),
    Responsibilities VARCHAR(100),
    SharepointLink VARCHAR(100),
    FOREIGN KEY(BandName) REFERENCES Band(BandName),
    FOREIGN KEY(CapabilityName) REFERENCES Capability(CapabilityName)
);


GRANT ALL privileges on `JobForge_OdhranH`.* to JosephM, CriofanMc, ConorT;