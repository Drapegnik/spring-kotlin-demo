DROP INDEX IF EXISTS idx_res_date;
DROP TABLE IF EXISTS reservations;
DROP TABLE IF EXISTS guests;
DROP TABLE IF EXISTS rooms;

CREATE TABLE rooms (
    room_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    room_number VARCHAR(255) NOT NULL UNIQUE,
    bed_info VARCHAR(255) NOT NULL
);

CREATE TABLE guests (
    guest_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    address VARCHAR(255),
    country VARCHAR(255),
    state VARCHAR(255),
    phone_number VARCHAR(255)
);

CREATE TABLE reservations (
    reservation_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    room_id BIGINT NOT NULL,
    guest_id BIGINT NOT NULL,
    res_date DATE NOT NULL,
    FOREIGN KEY (room_id) REFERENCES rooms(room_id),
    FOREIGN KEY (guest_id) REFERENCES guests(guest_id)
);

CREATE INDEX idx_res_date ON reservations(res_date);
