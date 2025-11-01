-------------------------------------------------------------------
-- CREATE THE SPATIAL INDEX --
-------------------------------------------------------------------
CREATE INDEX estab_spatial_idx
ON estab(shape)
INDEXTYPE IS MDSYS.SPATIAL_INDEX;
-- Preceding created an R-tree index. 
-- Following line was for an earlier quadtree index:
--    PARAMETERS('SDO_LEVEL = 8');