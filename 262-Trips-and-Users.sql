WITH cte AS(
    SELECT tr.*, u1.*, u2.*
    FROM trips tr
    JOIN users u1
        ON tr.client_id = u1.users_id
    JOIN users u2
        ON tr.driver_id = u2.users_id
    WHERE tr.request_at>='2013-10-01' and tr.request_at<'2013-10-04' AND u1.banned!='Yes' AND u2.banned!='Yes'
)

SELECT request_at AS "Day", 
    ROUND(
        SUM(CASE status when 'completed' then 0 else 1 END) * 1.0 
        / COUNT(*),
        2
    ) AS "Cancellation Rate"
FROM cte
GROUP BY request_at;