SELECT ROUND(SUM(tiv_2016)::numeric, 2) AS tiv_2016
FROM (
    SELECT *,
           COUNT(*) OVER (PARTITION BY tiv_2015) AS tiv_count,
           COUNT(*) OVER (PARTITION BY lat, lon) AS city_count
    FROM Insurance
) AS t
WHERE tiv_count > 1
  AND city_count = 1;