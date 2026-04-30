	CREATE DATABASE IF NOT EXISTS SalesDB_in5bv;
USE SalesDB_in5bv;

-- ==========================================
-- 1. Create Tables
-- ==========================================

-- Table: Customers (translated from Clientes)
CREATE TABLE Customers (
    customer_dpi INT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    address VARCHAR(100),
    status INT
);

-- Table: Users (translated from Usuarios)
CREATE TABLE Users (
    user_id INT PRIMARY KEY,
    username VARCHAR(45) NOT NULL,
    password VARCHAR(45) NOT NULL,
    email VARCHAR(60),
    role VARCHAR(45),
    status INT
);

-- Table: Products (translated from Productos)
CREATE TABLE Products (
    product_id INT PRIMARY KEY,
    product_name VARCHAR(60) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    stock INT NOT NULL,
    status INT
);

-- Table: Sales (translated from Ventas)
CREATE TABLE Sales (
    sale_id INT PRIMARY KEY,
    sale_date DATE NOT NULL,
    total DECIMAL(10,2),
    status INT,
    customer_dpi INT,
    user_id INT,
    FOREIGN KEY (customer_dpi) REFERENCES Customers(customer_dpi),
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

-- Table: SaleDetails (translated from DetalleVenta)
CREATE TABLE SaleDetails (
    sale_detail_id INT PRIMARY KEY,
    quantity INT NOT NULL,
    unit_price DECIMAL(10,2) NOT NULL,
    subtotal DECIMAL(10,2) NOT NULL,
    product_id INT,
    sale_id INT,
    FOREIGN KEY (product_id) REFERENCES Products(product_id),
    FOREIGN KEY (sale_id) REFERENCES Sales(sale_id)
);

-- ==========================================
-- 2. Insert Sample Data
-- ==========================================

-- Insert Customers
INSERT INTO Customers (customer_dpi, first_name, last_name, address, status) VALUES 
(10101, 'John', 'Doe', '123 Elm Street, NY', 1),
(20202, 'Jane', 'Smith', '456 Oak Avenue, CA', 1),
(30303, 'Michael', 'Johnson', '789 Pine Road, TX', 1);

-- Insert Users
INSERT INTO Users (user_id, username, password, email, role, status) VALUES 
(1, 'admin_user', 'admin123', 'admin@store.com', 'Administrator', 1),
(2, 'cashier_01', 'pass1234', 'cashier1@store.com', 'Cashier', 1);

-- Insert Products
INSERT INTO Products (product_id, product_name, price, stock, status) VALUES 
(100, 'Wireless Mouse', 25.50, 50, 1),
(101, 'Mechanical Keyboard', 75.00, 30, 1),
(102, '24-inch HD Monitor', 150.00, 20, 1),
(103, 'USB-C Cable', 15.00, 100, 1);

-- Insert Sales
-- Note: Totals here reflect the sum of the subtotals in the SaleDetails table below
INSERT INTO Sales (sale_id, sale_date, total, status, customer_dpi, user_id) VALUES 
(1000, '2023-10-25', 126.00, 1, 10101, 2),
(1001, '2023-10-26', 300.00, 1, 20202, 2);

-- Insert SaleDetails
-- Sale 1000 Details (Total: 126.00)
INSERT INTO SaleDetails (sale_detail_id, quantity, unit_price, subtotal, product_id, sale_id) VALUES 
(1, 2, 25.50, 51.00, 100, 1000), -- 2 Wireless Mice
(2, 1, 75.00, 75.00, 101, 1000); -- 1 Mechanical Keyboard

-- Sale 1001 Details (Total: 300.00)
INSERT INTO SaleDetails (sale_detail_id, quantity, unit_price, subtotal, product_id, sale_id) VALUES 
(3, 2, 150.00, 300.00, 102, 1001); -- 2 HD Monitors