SELECT 
    company.car_id AS CAR_ID, 
    company.car_type AS CAR_TYPE,
    FLOOR((company.daily_fee - (discount_plan.discount_rate / 100 * company.daily_fee )) * 30) AS FEE
FROM CAR_RENTAL_COMPANY_CAR AS company
INNER JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN AS discount_plan 
    ON company.car_type = discount_plan.car_type 
    AND discount_plan.duration_type = "30일 이상"
WHERE 
    NOT EXISTS (
        SELECT 1 
        FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY history 
        WHERE history.car_id = company.car_id
        AND history.start_date <= '2022-11-30' 
        AND history.end_date >= '2022-11-01'
    ) 
    AND company.car_type IN ("세단", "SUV") 
    AND (company.daily_fee - (discount_plan.discount_rate / 100 * company.daily_fee )) * 30 BETWEEN 500000 AND 2000000
order by FEE DESC ,CAR_TYPE ,CAR_ID DESC;