/*CREATE DATABASE quiz_db;*/
use quiz_db;

CREATE TABLE IF NOT EXISTS questionare(
id INTEGER NOT NULL,
name VARCHAR(100) NOT NULL,
active BIT,
PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS question(
id INTEGER NOT NULL,
name VARCHAR(150) NOT NULL,
type VARCHAR(50),
questionare_id INTEGER,
PRIMARY KEY (id),
FOREIGN KEY (questionare_id) REFERENCES questionare(id)
);

CREATE TABLE IF NOT EXISTS answer(
id INTEGER NOT NULL,
value VARCHAR(100) NOT NULL,
type VARCHAR(50),
question_id INTEGER,
PRIMARY KEY (id),
FOREIGN KEY (question_id) REFERENCES question(id)
);