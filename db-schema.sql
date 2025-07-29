– Create article table
CREATE TABLE article (
id BIGINT AUTO_INCREMENT PRIMARY KEY,
title VARCHAR(255) NOT NULL,
content TEXT
);

– Create article_tags table for the many-to-many relationship with tags
CREATE TABLE article_tags (
article_id BIGINT NOT NULL,
tag VARCHAR(255),
FOREIGN KEY (article_id) REFERENCES article(id) ON DELETE CASCADE
);
