CREATE TABLE Bag (
    id SERIAL PRIMARY KEY,
    max_slots INT NOT NULL
);

CREATE TABLE Player (
    id SERIAL PRIMARY KEY,
    bag_id INT NOT NULL,
    name VARCHAR(255) NOT NULL,
    health_points INT NOT NULL,
    FOREIGN KEY (bag_id) REFERENCES Bag(id)
);

CREATE TABLE Room (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE Room (
    id SERIAL PRIMARY KEY,
    direction VARCHAR(255) NOT NULL
);

CREATE TABLE Item (
    id SERIAL PRIMARY KEY,
    bag_id INT,
    room_id INT,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    weight int NOT NULL,
    FOREIGN KEY (bag_id) REFERENCES Bag(id),
    FOREIGN KEY (room_id) REFERENCES Room(id)
);