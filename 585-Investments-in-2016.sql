WITH city AS (
    SELECT lat, lon
    FROM Insurance
    GROUP BY lat, lon
    HAVING COUNT(*) = 1
),
investment AS (
    SELECT tiv_2015
    FROM Insurance
    GROUP BY tiv_2015
    HAVING COUNT(*) > 1
)
SELECT ROUND(SUM(i.tiv_2016)::numeric, 2) AS tiv_2016
FROM Insurance i
JOIN city c
    ON i.lat = c.lat AND i.lon = c.lon
JOIN investment t
    ON i.tiv_2015 = t.tiv_2015;