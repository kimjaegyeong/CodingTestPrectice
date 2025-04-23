-- 코드를 입력하세요
SELECT JULY.FLAVOR from FIRST_HALF
inner join JULY on JULY.FLAVOR = FIRST_HALF.FLAVOR group by FLAVOR order by sum(JULY.TOTAL_ORDER) + SUM(FIRST_HALF.TOTAL_ORDER)/count(JULY.FLAVOR) desc limit 3 ;




