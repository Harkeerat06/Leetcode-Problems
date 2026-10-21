WITH trans as(
    select TO_CHAR(trans_date, 'YYYY-MM') as month, country, amount,
        case state 
            when 'approved' then amount 
            else 0
        end as "approvedT",
        case state 
            when 'approved' then 1 
            else 0
        end as "appCount"
    from transactions
)

select month, country, count(*) as "trans_count", sum("appCount") as "approved_count", sum(amount) as "trans_total_amount", sum("approvedT") as "approved_total_amount"
from trans
group by month, country;