create TABLE track_points (
	track_point_id BIGINT AUTO_INCREMENT,
	point_time TIMESTAMP,
	lat DOUBLE(10, 7) CHECK (lat >= -90 AND lat <=90),
	lon DOUBLE(10,7) CHECK (lon >= -180 AND lon <=180),
	id BIGINT,
	PRIMARY KEY (track_point_id),
	FOREIGN KEY (id) REFERENCES activities(id)
);
