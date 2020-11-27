CREATE TABLE matrix (
  row INT,
  col INT,
  value INT,
  source VARCHAR,
  PRIMARY KEY(row, col)
);


INSERT INTO matrix
("row", col, value, "source")
VALUES
(1, 2, 1, 'a'),
(1, 5, 9, 'a'),
(2, 3, 3, 'a'),
(3, 4, 2, 'a'),
(1, 1, 1, 'b'),
(3, 2, 7, 'b'),
(4, 3, 2, 'b');


SELECT a.row, b.col, SUM(a.value * b.value)
FROM matrix a
inner join matrix b on a.col = b.row
where a."source" ='a' and b."source" ='b'
GROUP BY a.row, b.col;
