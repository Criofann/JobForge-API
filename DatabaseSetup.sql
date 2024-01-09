CREATE DATABASE IF NOT EXISTS JobForge_OdhranH;
DELIMITER $$
DROP PROCEDURE IF EXISTS CreateDatabse $$
CREATE PROCEDURE CreateDatabse()
BEGIN
  START TRANSACTION;
USE JobForge_OdhranH;


CREATE TABLE IF NOT EXISTS Band(
	BandName VARCHAR(20) PRIMARY KEY,
    BandLevel VARCHAR(10),
    Competencies VARCHAR(100)
);

CREATE TABLE  IF NOT EXISTS Training(
	TrainingName VARCHAR(20) PRIMARY KEY,
    BandName VARCHAR(20),
    TrainingType VARCHAR(20),
    FOREIGN KEY(BandName) REFERENCES Band(BandName)
);

CREATE TABLE IF NOT EXISTS Employee(
	EmployeeID INTEGER PRIMARY KEY,
    EmployeeName VARCHAR(50),
    EmployeePhoto VARCHAR(100),
    EmployeeMessage VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS Capability(
	CapabilityName VARCHAR(30) PRIMARY KEY,
    LeadID INTEGER,
    FOREIGN KEY(LeadID) REFERENCES Employee(EmployeeID)
);

CREATE TABLE IF NOT EXISTS JobFamily(
	JobFamily VARCHAR(30) PRIMARY KEY,
    RoleName VARCHAR(30),
    FOREIGN KEY(RoleName) REFERENCES JobRole(RoleName)
    ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS JobRole(
	RoleName VARCHAR(20) PRIMARY KEY,
    Specification VARCHAR(100),
    CapabilityName VARCHAR(20),
    BandName VARCHAR(20),
    Responsibilities VARCHAR(100),
    SharepointLink VARCHAR(500),
    FOREIGN KEY(BandName) REFERENCES Band(BandName),
    FOREIGN KEY(CapabilityName) REFERENCES Capability(CapabilityName)
);
-- check the number of affected rows
  GET DIAGNOSTICS @rows = ROW_COUNT;
  IF @rows = 0 THEN
    -- if an error occurred,
    ROLLBACK;
    SELECT 'Transaction rolled back due to error.';
  ELSE
    -- If no error occurred, commit the Transaction
    COMMIT;
    SELECT 'Transaction committed successfully.';
END IF;
END $$
DELIMITER ;
CALL CreateDatabse();
