create database `booking`;

create table `booking`.`user` (
        `id` bigint not null auto_increment,
         `name` VARCHAR(150) NULL,
		  `mobile` VARCHAR(15) NULL,
		  `email` VARCHAR(150) NULL,
		  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
		  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
		  PRIMARY KEY (`id`),
		  UNIQUE KEY `user`(`name`, `mobile`)
    );

create table `booking`.`movie` (
		id bigint not null auto_increment,
        name VARCHAR(150),
        genre varchar(255),
        capacity bigint,
        created_at timestamp DEFAULT CURRENT_TIMESTAMP,
        updated_at timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
        primary key (`id`)
    );

create table `booking`.`booking` (
		id bigint not null auto_increment,
        user_id bigint,
        movie_id bigint,
        booking_id VARCHAR(50),
        amount decimal(18,2),
        status VARCHAR(50),
        created_at timestamp DEFAULT CURRENT_TIMESTAMP,
        updated_at timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
        primary key (`id`),
        FOREIGN KEY (`user_id`) REFERENCES `booking`.`user`(`id`),
        FOREIGN KEY (`movie_id`) REFERENCES `booking`.`movie`(`id`)
    );