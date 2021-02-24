CREATE TABLE images (
	image_id BIGINT AUTO_INCREMENT,
	file_name VARCHAR(255),
	content BLOB,
	id BIGINT,
	PRIMARY KEY (image_id),
	FOREIGN KEY (id) REFERENCES activities(id)
);