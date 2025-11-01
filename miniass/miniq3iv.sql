SELECT A.name FROM build A, est B WHERE
SDO_NN(A.shape, B.shape, 'sdo_num_res=1', 1) = 'TRUE'
AND B.name = 'Li Ka Shing Tower';

