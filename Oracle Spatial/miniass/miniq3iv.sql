SELECT A.name, sdo_nn_distance(1)distance FROM building A, estab B WHERE
SDO_NN(A.shape, B.shape, 'sdo_num_res=1', 1) = 'TRUE'
AND B.name = 'Li Ka Shing Tower' order by distance;

