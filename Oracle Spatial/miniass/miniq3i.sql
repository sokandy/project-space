-- Union two following select statement can accomplish to find all the
-- buildings/ establishments that are having overlaps with the roads, or 
-- walkway or the bus stop.

SELECT A.name, B.name FROM estab A, roads B
WHERE sdo_relate(A.shape, B.shape, 'mask=anyinteract querytype=join') = 'TRUE'
union
SELECT C.name, B.name FROM building C, roads B
WHERE sdo_relate(C.shape, B.shape, 'mask=anyinteract querytype=join') = 'TRUE';