This is a submission for telus assignment as given.

1.
   1.1: cURL for API
   curl --location 'http://localhost:8080/api/rewards/2'

    1.2: Response for API
    {
    "custId": "2",
    "monthlyRewards": {
        "MAY": 0,
        "MARCH": 0,
        "APRIL": 290
    },
    "totalRewards": 290
}




   --------------------------------------------------------------------------------------------------

2.  Mentioning SQL scripts for tables/Entities used -:

CREATE TABLE users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    phone INT,
    address VARCHAR(255)
);


CREATE TABLE transactions (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    customer_id VARCHAR(100) NOT NULL,
    amount DOUBLE NOT NULL,
    transaction_date DATE NOT NULL,
    meta_data VARCHAR(255)
);



INSERT INTO users(name, phone, address)
VALUES
('Pradeep ', 987654321, 'Delhi'),
('Ankur', 912345678, 'Mumbai');


INSERT INTO transactions(customer_id, amount, transaction_date, meta_data)
VALUES
('1', 120, '2026-03-10', 'Electronics'),
('1', 75, '2026-03-15', 'Groceries'),
('2', 220, '2026-04-01', 'Furniture');


