CREATE TABLE users (
                       id BIGINT PRIMARY KEY AUTO_INCREMENT,
                       email VARCHAR(255) NOT NULL,
                       password VARCHAR(255) NOT NULL
);

CREATE TABLE user_roles (
                            user_id BIGINT NOT NULL,
                            roles VARCHAR(255)
);

CREATE TABLE invoice (
                         id BIGINT PRIMARY KEY AUTO_INCREMENT,
                         description VARCHAR(255),
                         amount DECIMAL(10,2),
                         date DATE,
                         user_id BIGINT,
                         FOREIGN KEY (user_id) REFERENCES users(id)
);
