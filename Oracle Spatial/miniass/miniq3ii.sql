-- There are 13 different establishments in our table estab,
-- 13 different building in table building and 5 different roads or walkway in table roads.
--
-- the 3rd select statement wanted to find any establishment interact each other from same table.
-- so that if the count(*) equal to 12,that mean this establishment disjoint 
-- each other in table estab but it is not include itself.
--
-- the 4th select statement wanted to find any establishment interact each other from table building.
-- so that if the count(*) equal to 13,that mean this establishment disjoint 
-- each other in table building.
--
-- Finally intersect this two result that can find out any disjoint object between table building
-- and estab.
--
-- Because each academic building would be interact with other building. Then the 1st select
-- statement retrieve zero row. So that it intersect any result to produce zero row.    


SELECT A.name FROM building A, building B
where sdo_relate(A.shape, B.shape, 'mask=disjoint querytype=window') = 'TRUE'
group by A.name having count(*) = 12
intersect
SELECT C.name FROM estab B, building C
where sdo_relate(C.shape, B.shape, 'mask=disjoint querytype=window') = 'TRUE'
group by C.name having count(*) = 13
union
SELECT A.name FROM estab A, estab B
where sdo_relate(A.shape, B.shape, 'mask=disjoint querytype=window') = 'TRUE'
group by A.name having count(*) = 12
intersect
SELECT C.name FROM estab C, building B
where sdo_relate(C.shape, B.shape, 'mask=disjoint querytype=window') = 'TRUE'
group by C.name having count(*) = 13;


