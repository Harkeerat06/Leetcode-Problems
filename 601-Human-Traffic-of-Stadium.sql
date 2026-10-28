WITH cte AS (
    SELECT *,
           LAG(id, 1) OVER (ORDER BY id) AS prev1,
           LAG(id, 2) OVER (ORDER BY id) AS prev2,
           LEAD(id, 1) OVER (ORDER BY id) AS next1,
           LEAD(id, 2) OVER (ORDER BY id) AS next2,
           LAG(people, 1) OVER (ORDER BY id) AS people_prev1,
           LAG(people, 2) OVER (ORDER BY id) AS people_prev2,
           LEAD(people, 1) OVER (ORDER BY id) AS people_next1,
           LEAD(people, 2) OVER (ORDER BY id) AS people_next2
    FROM Stadium
)
SELECT id, visit_date, people
FROM cte
WHERE people >= 100
  AND (
       (prev1 = id - 1 AND prev2 = id - 2
        AND people_prev1 >= 100 AND people_prev2 >= 100)
    OR (next1 = id + 1 AND next2 = id + 2
        AND people_next1 >= 100 AND people_next2 >= 100)
    OR (prev1 = id - 1 AND next1 = id + 1
        AND people_prev1 >= 100 AND people_next1 >= 100)
  )
ORDER BY visit_date;