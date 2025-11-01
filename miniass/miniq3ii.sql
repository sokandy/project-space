SELECT A.name FROM build A, build B
where sdo_relate(A.shape, B.shape, 'mask=disjoint querytype=window') = 'TRUE'
group by A.name having count(*) = 12
intersect
SELECT C.name FROM est B, build C
where sdo_relate(C.shape, B.shape, 'mask=disjoint querytype=window') = 'TRUE'
group by C.name having count(*) = 13
union
SELECT A.name FROM est A, est B
where sdo_relate(A.shape, B.shape, 'mask=disjoint querytype=window') = 'TRUE'
group by A.name having count(*) = 12
intersect
SELECT C.name FROM est C, build B
where sdo_relate(C.shape, B.shape, 'mask=disjoint querytype=window') = 'TRUE'
group by C.name having count(*) = 13;


