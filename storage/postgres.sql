CREATE TABLE Bag (
    id SERIAL PRIMARY KEY,
    max_slots INT NOT NULL
);

CREATE TABLE Player (
    id SERIAL PRIMARY KEY,
    bag_id INT NOT NULL,
    name VARCHAR NOT NULL,
    health_points INT NOT NULL,
    FOREIGN KEY (bag_id) REFERENCES Bag(id)
);


CREATE TABLE Room (
    id SERIAL PRIMARY KEY,
    name VARCHAR NOT NULL
);

CREATE TABLE Direction(
    id SERIAL PRIMARY KEY,
    name VARCHAR NOT NULL
)

INSERT INTO Direction (name) VALUES ('North'), ('South'), ('West'), ('East');

CREATE TABLE Door (
    id SERIAL PRIMARY KEY,
    direction_id_id INT NOT NULL,
    FOREIGN KEY (direction_id) REFERENCES Direction(id)
);

CREATE TABLE Item (
    id SERIAL PRIMARY KEY,
    bag_id INT REFERENCES Bag(id),
    room_id INT REFERENCES Room(id),
    name VARCHAR NOT NULL,
    description VARCHAR NOT NULL,
    weight int NOT NULL,
);

CREATE TABLE Species (
    id SERIAL PRIMARY KEY,
    name VARCHAR NOT NULL
);

INSERT INTO species (name) VALUES ('Lion'), ('Tiger'), ('Eagle');


CREATE TABLE Animal (
    id SERIAL PRIMARY KEY,
    name VARCHAR NOT NULL,
    age INT,
    arrival_date DATE,
    weight DOUBLE PRECISION,
    height DOUBLE PRECISION,
    room_id INT REFERENCES room(id),
    species_id INT REFERENCES species(id),
    wingspan DOUBLE PRECISION,
    tail_length DOUBLE PRECISION 
);