create view VProductInfo as

select 
	p.productoId 
	,p.nombre 
	,ref as referencia
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
		

