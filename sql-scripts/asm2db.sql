drop database asm2db;
create database asm2db;
use asm2db;

CREATE TABLE role (
  id INT auto_increment PRIMARY KEY,
  role_name VARCHAR(255)
);

CREATE TABLE category (
  id INT auto_increment PRIMARY KEY,
  name VARCHAR(255),
  number_choose INT
);

CREATE TABLE user (
  id INT auto_increment PRIMARY KEY,
  address VARCHAR(255),
  description VARCHAR(255),
  email VARCHAR(255),
  full_name VARCHAR(255),
  image VARCHAR(255),
  password VARCHAR(255),
  phone_number VARCHAR(255),
  status VARCHAR(255),
  role_id INT,
  cv_id INT,
  FOREIGN KEY (role_id) REFERENCES role(id)
);

CREATE TABLE company (
  id INT auto_increment PRIMARY KEY,
  description VARCHAR(255),
  address VARCHAR(255),
  email VARCHAR(255),
  logo VARCHAR(255),
  name_company VARCHAR(255),
  phone_number VARCHAR(255),
  status VARCHAR(255),
  user_id INT,
  FOREIGN KEY (user_id) REFERENCES user(id)
);

CREATE TABLE cv (
  id INT PRIMARY KEY AUTO_INCREMENT,
  file_name VARCHAR(255),
  introduction varchar(255),
  user_id INT,
  FOREIGN KEY (user_id) REFERENCES user(id)
);

CREATE TABLE recruitment (
  id INT auto_increment PRIMARY KEY,
  address VARCHAR(255),
  created_at DATETIME,
  description VARCHAR(255),
  experience varchar(255),
  quantity INT,
  rank_value VARCHAR(255),
  salary VARCHAR(255),
  status VARCHAR(255),
  title VARCHAR(255),
  type VARCHAR(255),
  view INT,
  category_id INT,
  company_id INT,
  deadline DATE,
  FOREIGN KEY (category_id) REFERENCES category(id),
  FOREIGN KEY (company_id) REFERENCES company(id)
);
CREATE TABLE save_job (
  id INT auto_increment PRIMARY KEY,
  recruitment_id INT,
  user_id INT,
  FOREIGN KEY (recruitment_id) REFERENCES recruitment(id),
  FOREIGN KEY (user_id) REFERENCES user(id)
);

CREATE TABLE follow_company (
  id INT auto_increment PRIMARY KEY,
  company_id INT,
  user_id INT,
  FOREIGN KEY (company_id) REFERENCES company(id),
  FOREIGN KEY (user_id) REFERENCES user(id)
);
CREATE TABLE apply_post (
  id INT auto_increment PRIMARY KEY,
  created_at DATETIME,
  recruitment_id INT,
  user_id INT,
  name_cv VARCHAR(255),
  status VARCHAR(255),
  text VARCHAR(255),
  FOREIGN KEY (recruitment_id) REFERENCES recruitment(id),
  FOREIGN KEY (user_id) REFERENCES user(id)
);

INSERT INTO role (id, role_name)
VALUES
(1, 'ROLE_EMPLOYEE'),
(2, 'ROLE_MANAGER');

INSERT INTO category (id, name, number_choose)
VALUES
(1, 'JAVA', 10),
(2, 'PHP', 8),
(3, 'ASP. NET', 6),
(4, 'NODEJS', 5);

/* password = 123 */
INSERT INTO user (id, address, description, email, full_name, image, password, phone_number, status, role_id, cv_id)
VALUES
(1, 'User A Address', 'Description for User A', 'usera@example.com', 'User A', 'person_1.jpg.jpg', '$2a$10$hXI1HrDJtUuDwREHvezPy.DqW9XA3WiSC/ooSwvRQc7XhGpIE0g/.', '111111111', '1', 1, 1),
(2, 'User B Address', 'Description for User B', 'userb@example.com', 'User B', 'person_1.jpg.jpg', '$2a$10$hXI1HrDJtUuDwREHvezPy.DqW9XA3WiSC/ooSwvRQc7XhGpIE0g/.', '222222222', '1', 2, 2);


INSERT INTO company (id, description, address, email, logo, name_company, phone_number, status, user_id)
VALUES (1, 'description 1', 'Company A Address', 'companya@example.com', 'company-1.jpg', 'Company A', '123456789', '1', 1),
       (2, 'description 2', 'Company B Address', 'companyb@example.com', 'company-2.jpg', 'Company B', '987654321', '2', 2);
       
INSERT INTO cv (id, file_name, user_id)
VALUES
(1, 'cv1.pdf', 1),
(2, 'cv2.pdf', 2);

INSERT INTO recruitment (id, address, created_at, description,experience, quantity, rank_value , salary, status, title, type, view, category_id,company_id , deadline)
VALUES
(1, 'Recruitment A Address', '2023-06-01 08:00:00', 'Description for Recruitment A','2 nam', 5, 'Rank A', '10000', '1', 'Position A', 'Full-time', 100, 1, 1, '2023-06-15'),
(2, 'Recruitment B Address', '2023-06-02 13:30:00', 'Description for Recruitment B','1 nam', 3, 'Rank B', '8000', '1', 'Position B', 'Part-time', 50, 2, 2, '2023-06-20');

INSERT INTO save_job (id, recruitment_id, user_id)
VALUES
(1, 1, 1),
(2, 2, 2);


INSERT INTO follow_company (id, company_id, user_id)
VALUES
(1, 1, 1),
(2, 2, 1),
(3, 1, 2);

INSERT INTO apply_post (id, created_at, recruitment_id, user_id, name_cv, status, text)
VALUES
(1, '2023-06-01 09:00:00', 1, 1, 'cv1.pdf', 'Pending', 'Cover letter for the position'),
(2, '2023-06-02 14:30:00', 2, 1, 'cv1.pdf', 'Accepted', 'Additional information for the application'),
(3, '2023-06-03 11:45:00', 1, 2, 'cv2.pdf', 'Pending', 'Cover letter for the position');





