select year(gv.fecha) as anno, month(gv.fecha) as mes, gv.empleado_id, em.nombre, sum(gv.valor) as valor
from gasto_viaje gv
inner join empleado em on gv.empleado_id = em.id
group by anno, mes, empleado_id, nombre
order by nombre