-- 코드를 입력하세요

select ID, NAme, HOST_ID from places where HOST_ID IN(
SELECT HOST_ID from places group by HOST_ID having count(HOST_ID) > 1 
) order by ID