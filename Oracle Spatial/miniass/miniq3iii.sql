SELECT A.name, B.name FROM estab A, building B
WHERE SDO_WITHIN_DISTANCE( A.shape, B.shape, 'distance=20') = 'TRUE'
union
SELECT A.name, B.name FROM estab A, roads B
WHERE SDO_WITHIN_DISTANCE( B.shape, A.shape, 'distance=20') = 'TRUE'
union
SELECT A.name, B.name FROM building A, roads B
WHERE SDO_WITHIN_DISTANCE( B.shape, A.shape, 'distance=20') = 'TRUE';




