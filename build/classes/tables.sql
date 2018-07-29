CREATE TABLE IF NOT EXISTS CustomerProducts (
  id int(11) NOT NULL AUTO_INCREMENT,
  cid int(11) NOT NULL,
  pid int(11) NOT NULL,
  purchaseDate varchar(45) NOT NULL,
  purchasePrice int(10) NOT NULL,
  vendor varchar(45) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1;
/
CREATE TABLE IF NOT EXISTS ExecutiveMaster (
id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(20) NOT NULL,
  loginId varchar(50) NOT NULL,
  password varchar(20) NOT NULL,
  acStatus varchar(10) NOT NULL,
  acOpeningDate varchar(30) NOT NULL,
  target int(10) NOT NULL,
  level int(10) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/
CREATE TABLE IF NOT EXISTS loginhistory (
  id int(5) NOT NULL AUTO_INCREMENT,
  loginDate varchar(30) NOT NULL,
  loginTime varchar(30) NOT NULL,
  logoutTime varchar(30) DEFAULT NULL,
  userType int(2) NOT NULL,
  userId int(5) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/
CREATE TABLE IF NOT EXISTS MailMaster (
  id int(11) NOT NULL AUTO_INCREMENT,
  cId int(11) NOT NULL,
  pId int(11) NOT NULL,
  message varchar(1000) NOT NULL,
  replyOn int(11) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1;
/
CREATE TABLE IF NOT EXISTS ProductMaster (
  pid int(11) NOT NULL AUTO_INCREMENT,
  name varchar(45) NOT NULL,
  warranty varchar(45) NOT NULL,
  w_type varchar(45) NOT NULL,
  w_coverage varchar(45) NOT NULL,
  exclusion varchar(150) NOT NULL,
  PRIMARY KEY (pid)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1;
/
INSERT INTO ProductMaster (pid, name, warranty, w_type, w_coverage, exclusion) VALUES
(1, 'Moto g', '12', 'OnSite', 'Full', 'Nothing'),
(4, 'Moto X', '12', 'OnSite', 'Full', 'Nothing'),
(5, 'Wave 525', '12', 'OnSite', 'Full', 'Nothing'),
(6, 'S Duos', '15', 'OnSite', 'Full', 'Nothing'),
(7, 'Smart TV', '6', 'OnSite', 'part', 'Hardware Damage Not Covered'),
(9, 'Curved TV', '15', 'OnSite', 'part', 'Hardware Damage Not Covered'),
(10, 'Power Bank', '8', 'OffSite', 'part', 'Hardware Damage Not Covered'),
(11, 'EarPhone', '6', 'OnSite', 'Full', 'Nothing');
/
CREATE TABLE IF NOT EXISTS TicketAttachments (
  attachmentId int(10) NOT NULL AUTO_INCREMENT,
  ticketId int(10) NOT NULL,
  filePath varchar(500) NOT NULL,
  PRIMARY KEY (attachmentId),
  UNIQUE KEY attachmentId (attachmentId)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1;
/
CREATE TABLE IF NOT EXISTS TicketMaster (
  id int(11) NOT NULL AUTO_INCREMENT,
  customerId int(11) NOT NULL,
  pId int(11) NOT NULL,
  ticketDate varchar(30) NOT NULL,
  title varchar(20) NOT NULL,
  priority int(2) NOT NULL,
  description varchar(100) NOT NULL,
  status varchar(10) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/
CREATE TABLE IF NOT EXISTS TicketReplies (
  id int(11) NOT NULL AUTO_INCREMENT,
  ticketId int(11) NOT NULL,
  execId int(11) NOT NULL,
  processTime varchar(100) NOT NULL,
  replyDate varchar(30) NOT NULL,
  replyText varchar(500) NOT NULL,
  customerReplyText varchar(500) DEFAULT NULL,
  replyBy varchar(20) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/
CREATE TABLE IF NOT EXISTS UserMaster (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(45) NOT NULL,
  mailId varchar(45) NOT NULL,
  password varchar(45) NOT NULL,
  role int(11) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1;
/
INSERT INTO UserMaster (id, name, mailId, password, role) VALUES
(1, 'Ritesh', 'r@p.com', '1234', 1),
(2, 'Administrator', 'admin@p.com', '1234', 3);