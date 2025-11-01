-------------------------------------------------------------------
-- CREATE THE SPATIAL INDEX --
-------------------------------------------------------------------
CREATE INDEX road_spatial_idx
ON road(shape)
INDEXTYPE IS MDSYS.SPATIAL_INDEX;
-- Preceding created an R-tree index. 
-- Following line was for an earlier quadtree index:
--    PARAMETERS('SDO_LEVEL = 8');