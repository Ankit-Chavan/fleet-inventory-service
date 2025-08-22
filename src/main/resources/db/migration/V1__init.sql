CREATE TABLE vehicles (
    id SERIAL PRIMARY KEY,
    model VARCHAR(255) NOT NULL,
    status VARCHAR(50) NOT NULL
);

CREATE TABLE inventory_items (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    quantity INT NOT NULL
);

CREATE TABLE allocations (
    id SERIAL PRIMARY KEY,
    vehicle_id INT NOT NULL,
    inventory_item_id INT NOT NULL,
    allocated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (vehicle_id) REFERENCES vehicles(id),
    FOREIGN KEY (inventory_item_id) REFERENCES inventory_items(id)
);