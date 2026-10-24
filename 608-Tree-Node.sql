WITH cte as (
    select t1.id, t1.p_id, count(t2.id) as "child_count"
    from tree as t1
    left join tree as t2
        on t1.id = t2.p_id
    group by t1.id, t1.p_id
)
select id, 
    case 
        when p_id is null then 'Root'
        when child_count = 0 then 'Leaf'
        else 'Inner'
    end as "type"
from cte;