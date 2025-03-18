select  company.car_id as CAR_ID , company.car_type as CAR_TYPE ,
TRUNCATE((company.daily_fee - (discount_plan.discount_rate / 100 * company.daily_fee ))* 30 , 0) as FEE

from CAR_RENTAL_COMPANY_CAR as company
inner join CAR_RENTAL_COMPANY_DISCOUNT_PLAN as discount_plan 
on company.car_type = discount_plan.car_type and (discount_plan.duration_type like "30일 이상")
where 
NOT EXISTS(
    select * from CAR_RENTAL_COMPANY_RENTAL_HISTORY history where
    history.car_id = company.car_id
    AND
    start_date <= '2022-11-30' AND end_date >= '2022-11-01'
) AND
(company.car_type like "세단" or company.car_type like "SUV" )  
and (company.daily_fee - (discount_plan.discount_rate / 100 * company.daily_fee ) )* 30 >= 500000 
and (company.daily_fee - (discount_plan.discount_rate / 100 * company.daily_fee ) )* 30 <2000000
group by company.car_id
order by FEE DESC ,CAR_TYPE ,CAR_ID DESC;