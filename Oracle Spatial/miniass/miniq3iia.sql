SELECT A.name FROM estab A, estab B
where sdo_relate(A.shape, B.shape, 'mask=disjoint querytype=window') = 'TRUE'
group by A.name having count(*) = 12
intersect
SELECT C.name FROM estab C, building B
where sdo_relate(C.shape, B.shape, 'mask=disjoint querytype=window') = 'TRUE'
group by C.name having count(*) = 13
intersect
SELECT B.name FROM estab B, roads C
where sdo_relate(B.shape, C.shape, 'mask=disjoint querytype=window') = 'TRUE'
group by B.name having count(*) = 5;


