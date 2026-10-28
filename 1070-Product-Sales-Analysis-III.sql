WITH cte AS (
    SELECT product_id, MIN(year) AS first_year
    FROM Sales
    GROUP BY product_id
)
SELECT
    s.product_id,
    c.first_year,
    s.quantity,
    s.price
FROM Sales s
JOIN cte c
    ON s.product_id = c.product_id
WHERE s.year = c.first_year;