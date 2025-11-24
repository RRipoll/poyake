select 
	p.productoId
	,p.nombre 
	,p.ref as Referencia
	,p.descripcion 
	,caracteristicas
from 
	Producto p 
	join 
		(
			select 
				Group_Concat(c.nombre) caracteristicas , cars.productId 
			from 
				Caracteristica c 
				join 
					Caracteristicas cars on c.caracteristicaId =cars.caracteristicaId 
			group by cars.productId 
		) as C2 on C2.productId=p.productoId 
