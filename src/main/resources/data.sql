INSERT INTO rooms (name, room_number, bed_info) VALUES
    ('King', '100', 'King Size Bed'),
    ('Double', '200', 'Double Size Bed'),
    ('Suite', '300', 'King Size Bed + Sofa');

INSERT INTO guests (last_name, first_name, email, address, country, state, phone_number) VALUES
    ('Adams', 'Roy', 'radams1v@xinhuanet.com', 'United States', '2872 Marquette Street', 'NY', '1-(235)314-9823'),
    ('Brooks', 'Samuel', 'sbrooks4@google.co.uk', 'United States', '9857 Hollow Ridge Park', 'PA', '5-(517)250-0437'),
    ('Ferguson', 'Russell', 'rferguson1b@uol.com.br', 'United States', '9143 Hudson Terrace', 'OH', '7-(498)208-8970');

INSERT INTO reservations (room_id, guest_id, res_date) VALUES
    (
        (SELECT room_id FROM rooms WHERE room_number = '200'),
        (SELECT guest_id FROM guests WHERE last_name = 'Ferguson'),
        '2024-11-28'
    );
