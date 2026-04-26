-- Pre-load sample products for demo purposes
INSERT INTO products (name, sku, quantity, price, category, created_at) VALUES
('Scanner', 'WDG-001', 50, 9.99, 'Electronics', CURRENT_TIMESTAMP),
('Head-lamp', 'GZM-002', 120, 14.99, 'Gadgets', CURRENT_TIMESTAMP),
('Watch', 'DDD-003', 200, 4.99, 'Accessories', CURRENT_TIMESTAMP),
('Synthesizer', 'THG-004', 15, 29.99, 'Electronics', CURRENT_TIMESTAMP),
('Headphones', 'WTC-005', 3, 49.99, 'Electronics', CURRENT_TIMESTAMP);