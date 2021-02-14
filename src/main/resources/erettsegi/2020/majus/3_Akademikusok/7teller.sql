select nev, ev, elhunyt
from tag, tagsag
where tag.id=tagid
and ev<=( ... )
AND (elhunyt>=( ... ) OR ... )
AND tipus='t'; 
