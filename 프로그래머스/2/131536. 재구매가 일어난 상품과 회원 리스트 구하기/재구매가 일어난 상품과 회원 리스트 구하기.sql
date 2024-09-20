# -- 코드를 입력하세요
# SELECT USER_ID, 
#     PRODUCT_ID
#     from ONLINE_SALE 
#     group by USER_ID 
#     having count(PRODUCT_ID) > 1
#     order by USER_ID asc ,PRODUCT_ID asc;

select USER_ID, PRODUCT_ID from online_sale group by User_id ,PRODUCT_ID
having count(PRODUCT_ID) >=2
order by USER_ID asc , PRODUCT_ID desc  ;
