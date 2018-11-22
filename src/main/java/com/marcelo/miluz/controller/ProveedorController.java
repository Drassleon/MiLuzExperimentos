package com.marcelo.miluz.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.marcelo.miluz.models.entity.Proveedor;
import com.marcelo.miluz.models.service.inter.IProveedorService;

@Controller
@SessionAttributes("proveedor")
public class ProveedorController {

	@Autowired
	private IProveedorService proveedorService;
	
	@GetMapping(value = "/proveedor/listar")
	public String listar(Model model) {
		
		model.addAttribute("titulo", "Listado de Proveedores");
		model.addAttribute("proveedores", proveedorService.findAll());
		
		return "proveedor/listar";
	}
	
    @RequestMapping(value = "/proveedor/form")
	public String crear(Model model) {
    	
		Proveedor proveedor = new Proveedor();
		model.addAttribute("proveedor", proveedor);
		model.addAttribute("titulo", "Crear Proveedor");
		
		return "proveedor/form";
	}
    
    @GetMapping(value = "/proveedor/form/{id}")
    public String editar(@PathVariable(value = "id") Long id, Model model) {
    	
    	Proveedor proveedor = proveedorService.findById(id);
    	model.addAttribute("proveedor", proveedor);
		model.addAttribute("titulo", "Editar Proveedor " + proveedor.getId());
		
    	return "proveedor/form";
    }
    
    @PostMapping(value="/proveedor/form")
    public String guardar(@Valid Proveedor proveedor, BindingResult result, Model model, SessionStatus status, RedirectAttributes flash) {

    	if (proveedor.getNombre().length() == 0) {
    		flash.addFlashAttribute("error", "El nombre de proveedor no puede ser vacío");
    		
    		if(proveedor.getId() != null) {
    			return "redirect:/proveedor/form/" + proveedor.getId();
    		} else {
    			return "redirect:/proveedor/form";
    		}
    	}
    	
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Proveedor");
			return "proveedor/form";
		}
		
		String mensajeFlash = (proveedor.getId() != null) ? "Proveedor editado con éxito!": "Proveedor creado con éxito!" ;
		
		proveedorService.save(proveedor);
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlash);
		
		return "redirect:/proveedor/listar";
		
    }
    
    @GetMapping(value = "/proveedor/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash) {
		if (id > 0) {
			proveedorService.deleteById(id);
			flash.addFlashAttribute("success", "Proveedor eliminado con éxito");
		}
		return "redirect:/proveedor/listar";
	}
}
