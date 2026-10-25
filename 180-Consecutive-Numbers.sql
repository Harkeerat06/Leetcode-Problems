with CTE as(
    SELECT DISTINCT id, num,
        LAG(num, 1) OVER (ORDER BY id) AS prev_num,
        LEAD(num, 1) OVER (ORDER BY id) AS next_num
    FROM Logs
    order by id
)
select distinct num as "ConsecutiveNums"
from cte
where prev_num = next_num and prev_num = num;