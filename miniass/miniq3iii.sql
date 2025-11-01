SELECT A.name, B.name FROM est A, road B
WHERE SDO_WITHIN_DISTANCE( B.shape, A.shape, 'distance=20') = 'TRUE'
union
SELECT A.name, B.name FROM build A, road B
WHERE SDO_WITHIN_DISTANCE( B.shape, A.shape, 'distance=20') = 'TRUE'
union
SELECT A.name, B.name FROM est A, build B
WHERE SDO_WITHIN_DISTANCE( A.shape, B.shape, 'distance=20') = 'TRUE';





