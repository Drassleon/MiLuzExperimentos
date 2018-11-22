package pe.com.core.test.unit.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.marcelo.miluz.models.entity.Proveedor;
import com.marcelo.miluz.models.repository.ProveedorRepository;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.spy;

@SuppressWarnings("deprecation")
@RunWith(MockitoJUnitRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProveedorTest {
	
	@Mock
	private ProveedorRepository proveedorDao;
	@Mock
	private Proveedor proveedor;
	
	@BeforeClass
	public  static void inicioClase() {
		System.out.println("Inicio de la Clase");
	}
	
	@AfterClass
	public  static void finClase() {
		System.out.println("Fin de la clase");
	}
	
	@Before
	public  void antesMetodo() {
		System.out.println("Antes del Método");
	}
	
	@After
	public  void despuesMetodo() {
		System.out.println("Despues del Método");
	}
	
	@Test
	public void a_insertar() {
		try {
			System.out.println("Método Insertar");
			proveedor = new Proveedor();
			proveedor.setNombre("Coca Cola Company");
			proveedor.setId((long) 1);
			proveedor.setNumeroTelefonico("123465");
			proveedor.setExisteDeuda(false);
			proveedor.setTipoPago("Dolares");
			when(proveedorDao.save(Matchers.any())).thenReturn(proveedor);
			proveedorDao.save(proveedor);
			Assert.assertTrue(proveedor.getId()>0);
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Fallo la prueba: " + e.getMessage());
		}
	}
	
	@Test
	public void b_actualizar() {
		try {
			System.out.println("Método Actualizar");
			Proveedor proveedorBuscado;
			proveedor = new Proveedor();
			proveedor.setNombre("Sony");
			proveedor.setId((long) 1);
			when(proveedorDao.getOne(Matchers.any())).thenReturn(proveedor);
			proveedorBuscado = proveedorDao.getOne(proveedor.getId());
			proveedorBuscado.setNombre("Samsung");
			when(proveedorDao.save(Matchers.any())).thenReturn(proveedorBuscado);
			proveedor = proveedorDao.save(proveedor);
			System.out.println("Nombre: " + proveedor.getNombre());
			Assert.assertTrue(true);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Fallo la prueba: " + e.getMessage());
		}
	}
	
	@Test
	public void c_listar() {
		try {
			System.out.println("Método Listar");
			List<Proveedor> listaProveedores = spy(new ArrayList<>());
			when(listaProveedores.add(Matchers.any())).thenReturn(true);
			when(proveedorDao.findAll()).thenReturn(listaProveedores);
			List<Proveedor> lista = proveedorDao.findAll();
			Assert.assertTrue(lista.size()>0);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Fallo la prueba: " + e.getMessage());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

