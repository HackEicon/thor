USE todo;
CREATE TABLE Task (
 id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 title VARCHAR(100) NOT NULL,
 labelTitle VARCHAR(200),
 completed BOOLEAN,
 labelColor VARCHAR(20)
);

CREATE TABLE Categorys (
 id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
 categoryname VARCHAR(50),
 description VARCHAR(200),
 active BOOLEAN,
 labelColor VARCHAR(20)
);

CREATE TABLE Products (
 id INT NOT NULL  PRIMARY KEY AUTO_INCREMENT,
 productname VARCHAR(50),
 description VARCHAR(200),
 imagepath VARCHAR(50) NOT NULL,
 categoryid INT(11) NOT NULL,
 active BOOLEAN,
 price double default '0',
 FOREIGN KEY fk_categorys(categoryid) 
 REFERENCES Categorys(id)
);

INSERT INTO `todo`.`Categorys`(`categoryname`,`description`,`active`,`labelColor`)VALUES('categoria 1','desc categoria',true,'blue');
INSERT INTO `todo`.`Products`(`productname`,`description`,`categoryid`,`active`,`price`)VALUES('produto 1','desc produto 1',1,true,33);

