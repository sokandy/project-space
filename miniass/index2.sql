-------------------------------------------------------------------
-- CREATE THE SPATIAL INDEX --
-------------------------------------------------------------------
CREATE INDEX est_spatial_idx
ON est(shape)
INDEXTYPE IS MDSYS.SPATIAL_INDEX;
-- Preceding created an R-tree index. 
-- Following line was for an earlier quadtree index:
--    PARAMETERS('SDO_LEVEL = 8');