
CREATE TABLE IF NOT EXISTS users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    date_added TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    contact_information VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS orders (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    date_added TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    description TEXT,
    user_id BIGINT REFERENCES users(id) ON DELETE CASCADE
);

CREATE ROLE role_UserService WITH LOGIN PASSWORD 'password_for_user_service';
CREATE ROLE role_OrderService WITH LOGIN PASSWORD 'password_for_order_service';

GRANT ALL ON TABLE users TO role_UserService;
GRANT ALL ON TABLE orders TO role_OrderService;