Feature: Mantenimiento de Proveedores
	Como Jefe de Almacen necesito realizar la gestion de Proveedores
	
Scenario: Registrar Proveedor
	Given despues de iniciar sesion en la aplicacion
	When hago clic en el enlace de Proveedores
	And 	luego hago clic en el boton de Crear Proveedor
	And 	en la nueva pantalla escribo en el campo Nombre el valor de "Samsung"
	And   en la nueva pantalla escribo en el campo Numero Telefonico el valor de "123456789"
	And   en la nueva pantalla selecciono "Bolivianos" en el campo tipo de Pago
	And   en la nueva pantalla hago clic en el checbox Tiene Deuda
	And 	presiono el boton de Guardar
	Then 	el sistema me mostrara el mensaje de "Proveedor creado con éxito!"
Scenario: Eliminar Proveedor
Given despues de iniciar sesion en la aplicacion
When hago clic en el enlace de Proveedores
And busco el proveedor "Samsung" para seleccionarlo de la tabla de Proveedores
And hago clic en el boton de Eliminar
Then el sistema me mostrara el mensaje "Proveedor eliminado con éxito"	
Scenario: Actualizar Proveedor
	Given despues de iniciar sesion en la aplicacion
	When hago clic en el enlace de Proveedores
	And 	busco el proveedor "Samsung" para seleccionarla de la tabla de Proveedores
	And 	hago clic en el boton de Editar
	And 	en la nueva pantalla escribo el nombre de "Coca Cola"
	And 	presiono el boton de Guardar
	Then 	el sistema me mostrara el mensaje de "Proveedor creado con éxito!"