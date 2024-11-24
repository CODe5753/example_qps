-- 데이터베이스와 테이블 생성
CREATE DATABASE IF NOT EXISTS shop;

USE shop;

CREATE TABLE IF NOT EXISTS products (
                                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                        name VARCHAR(255) NOT NULL,
    category VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL
    );

-- 초기 데이터 삽입
INSERT INTO products (name, category, price) VALUES
                                                 ('Running Shoes', 'shoes', 79.99),
                                                 ('Basketball Shoes', 'shoes', 99.99),
                                                 ('Casual Sneakers', 'shoes', 59.99),
                                                 ('Formal Shoes', 'shoes', 120.00),
                                                 ('Winter Boots', 'shoes', 140.00),
                                                 ('Yoga Mat', 'fitness', 25.00),
                                                 ('Dumbbells', 'fitness', 50.00),
                                                 ('Treadmill', 'fitness', 499.99),
                                                 ('Mountain Bike', 'sports', 899.99),
                                                 ('Tennis Racket', 'sports', 150.00);
