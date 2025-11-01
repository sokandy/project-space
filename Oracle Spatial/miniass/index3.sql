-------------------------------------------------------------------
-- CREATE THE SPATIAL INDEX --
-------------------------------------------------------------------
CREATE INDEX roads_spatial_idx
ON roads(shape)
INDEXTYPE IS MDSYS.SPATIAL_INDEX;
-- Preceding created an R-tree index. 
-- Following line was for an earlier quadtree index:
--    PARAMETERS('SDO_LEVEL = 8');