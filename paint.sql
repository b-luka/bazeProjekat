drop database if exists paint;
create database if not exists paint;
use paint;

create table images(
	id int unsigned not null auto_increment,
    image_name varchar(30) not null unique,
    image blob not null,
    primary key(id)
);

-- insert into images(image_name, image) values ("pera", from_base64());
select image from images;