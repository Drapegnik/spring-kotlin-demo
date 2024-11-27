CREATE TABLE IF NOT EXISTS rooms (
    room_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(16) NOT NULL,
    room_number VARCHAR(16) NOT NULL UNIQUE,
    bed_info VARCHAR(16) NOT NULL
);

CREATE TABLE IF NOT EXISTS guests (
    guest_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(16) NOT NULL,
    last_name VARCHAR(16) NOT NULL,
    email VARCHAR(32) NOT NULL,
    address VARCHAR(32),
    country VARCHAR(16),
    state VARCHAR(16),
    phone_number VARCHAR(24)
);

CREATE TABLE IF NOT EXISTS reservations (
    reservation_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    room_id BIGINT NOT NULL,
    guest_id BIGINT NOT NULL,
    res_date DATE NOT NULL,
    FOREIGN KEY (room_id) REFERENCES rooms(room_id),
    FOREIGN KEY (guest_id) REFERENCES guests(guest_id)
);

CREATE INDEX idx_res_date ON reservations(res_date);
