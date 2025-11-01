SELECT C.name, B.name FROM build C, road B
WHERE sdo_relate(C.shape, B.shape, 'mask=anyinteract querytype=join') = 'TRUE'
union
SELECT A.name, B.name FROM est A, road B
WHERE sdo_relate(A.shape, B.shape, 'mask=anyinteract querytype=join') = 'TRUE';
