USE JobForge_OdhranH;

CREATE TABLE `Role`(
	RoleID TINYINT NOT NULL,
    Name VARCHAR(64) NOT NULL,
    PRIMARY KEY(RoleID)
);

INSERT INTO Role(RoleID, Name) VALUES(1, 'Admin');
INSERT INTO Role(RoleID, Name) VALUES(2, 'Employee');

CREATE TABLE `User`(
	Email VARCHAR(64) NOT NULL,
    Password VARCHAR(64) NOT NULL,
    RoleID TINYINT NOT NULL,
    PRIMARY KEY(Email),
    FOREIGN KEY(RoleID) REFERENCES Role(RoleID)
);

INSERT INTO User(Email, Password, RoleID) VALUES('admin', 'admin', 1);
INSERT INTO User(Email, Password, RoleID) VALUES('employee', 'employee', 2);

CREATE TABLE Token(
	Email VARCHAR(64) NOT NULL,
    Token VARCHAR(64) NOT NULL,
    Expiry DATETIME NOT NULL,
    FOREIGN KEY(Email) REFERENCES User(Email)
)