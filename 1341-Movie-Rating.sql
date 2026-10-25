(
select u.name as results
from users u
join movierating mr
    on u.user_id = mr.user_id
group by u.name
order by count(*) desc, u.name asc
limit 1
)

UNION ALL

(
select m.title as results
from movies m
join movierating mr
    on m.movie_id = mr.movie_id
where mr.created_at >= '2020-02-01' and mr.created_at<'2020-03-01'
group by m.title
order by avg(mr.rating) desc, m.title asc
limit 1
);