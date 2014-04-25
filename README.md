	"Proyecto del Segundo Bimestre, Consultoria de Redes de Mercadeo (Uninivel)" 

	Este programa simula una red de Mercadeo.
	
	En modo administrador podras agregar,eliminar,editar miembros y administradores.
	Agregar/eliminar/editar ,tambien, productos para que tus miembros puedan comprarlos.
	Ver historial de compras y cantidad de compras realizadas por miembros a cuantos han
	agregado a tu red de mercadeo.
	
	En modo miembro tu podras comprar productos puestos en venta.
	agregar a tu lista de socios y obtener ganancias por ellos.
	
	Comandos que puede usar el Administrador
	list products - Muestra un listado de los productos
	SINTAXIS: list products
	
	show product - Muestra informacion detallada de un producto.
	SINTAXIS: show product[nombre del producto]
	
	list downlines - Muestra una lista de tus downlines o del downline especificado
	SINTAXIS: list downlines [idDownline]
	
	show downline - Muestra informacion detallada del downline especificado, si se agrega [money] mostrara solo la informacion de volumen monetario
	SINTAXIS: show downline [idDownline] [Money]
	
	show history - Muestra el historial de downlines agregados, si se agrega buy mostrara el historial de compras de mi perfil, si se agrega downline y el id del  downline se mostrara o bien el historial de downlines agregados o de compras dependiendo de la combinacon (si se le agrega buy o no)
	SINTAXIS: show history [buy] [downline] [idDownline]
	
	show me - Muestra la informacion de mi perfil, si se coloca money mostrara solo la informacion de volumen monetario
	SINTAXIS: show me [money]
	
	logout - Este comando sirve para cerrar sesion
	SINTAXIS: logout
	
	search downline - Muestra la información detallada del downline si coincide con la busqueda
	SINTAXIS: search downline [Datos]
	
	exit - Sale totalmente del programa
	SINTAXIS: exit
	
	add product - Agrega un producto del stock
	SINTAXIS: add product nombre=[nombre del nuevo producto] categoria=[categoria del nuevo producto]  precio=[precio del nuevo producto]
	
	add offert - Agrega un producto del stock
	SINTAXIS: add affert nombre=[nombre del producto] tipo=[tipo de oferta]  precio=[cantidad de pago del producto] cantidad=[cantidad de pago del producto] descuento=[descuento del producto si hay]
	
	remove product - Elimina un producto del stock
	SINTAXIS: remove product nombre=[nombre del nuevo producto] categoria=[categoria del nuevo producto]  precio=[precio del nuevo producto]
	
	edit product - Modifica un producto del stock
	SINTAXIS: edit product nombre=[nombre del nuevo producto] categoria=[categoria del nuevo producto]  precio=[precio del nuevo producto]
	
	show sales - Muestra informacion de venta de un producto si se especifica, o de todos si no se especifica.
	SINTAXIS: show sales [product [nombre del producto] ]
	
	add user - Agrega un Administrador
	SINTAXIS: add user nombre=[nombre que desea ponerle al admnistrador] password=[contrasenha del administrador] nick=[nombre de usuario del nuevo administrador]
	
	add member - Agrega un Miembro a la red
	SINTAXIS: add member nombre=[nombre que desea ponerle al admnistrador] password=[contrasenha del administrador] nick=[nombre de usuario del nuevo administrador] tarjeta=[tarjeta de credito] pin=[pin de la tarjeta de credito]
	
	remove member - Elimina un Miembro a la red
	SINTAXIS: remove member nick=[nombre de usuario del miembro]
	
	
	Comandos que puede usar el Miembro
	
	list products - Muestra un listado de los productos
	SINTAXIS: list products
	
	show product - Muestra informacion detallada de un producto.
	SINTAXIS: show product[nombre del producto
	
	list downlines - Muestra una lista de tus downlines o del downline especificado
	SINTAXIS: list downlines [idDownline]
	
	show downline - Muestra informacion detallada del downline especificado, si se agrega [money] mostrara solo la informacion de volumen monetario
	SINTAXIS: show downline [idDownline] [Money]
	
	show history - Muestra el historial de downlines agregados, si se agrega buy mostrara el historial de compras de mi perfil, si se agrega downline y el id del  downline se mostrara o bien el historial de downlines agregados o de compras dependiendo de la combinacion. (si se le agrega buy o no)
	SINTAXIS: show history [buy] [downline] [idDownline]
	
	show me - Muestra la informacion de mi perfil, si se coloca money mostrara solo la informacion de volumen monetario
	SINTAXIS: show me [money]
	
	logout - Este comando sirve para cerrar sesion
	SINTAXIS: logout
	
	edit me - Este comando modifica datos del usuario
	SINTAXIS: edit me [Parametro]=[Nuevo Valor]
	
	add downline - Agregar un downline a tu perfil, o a downline especificado
	SINTAXIS: add downline [Datos] [down] [idDownline] [Producto]
	
	search downline - Muestra la informacion detallada del downline si coincide con la busqueda
	SINTAXIS: search downline [Datos]
	
	buy product - Comprar un producto del Stock
	SINTAXIS: buy product [Nombre del Producto] [Numero de Tarjeta
	
	exit - Sale totalmente del programa
	SINTAXIS: exit
	
	
	
	
	
	
	
	
	
	
	
	
	