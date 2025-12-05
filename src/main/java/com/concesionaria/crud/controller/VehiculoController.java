package com.concesionaria.crud.controller;

import com.concesionaria.crud.model.Vehiculo;
import com.concesionaria.crud.service.VehiculoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {

    private final VehiculoService vehiculoService;

    @Autowired
    public VehiculoController(VehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    @GetMapping
    public List<Vehiculo> listar() {
        return vehiculoService.listarVehiculos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehiculo> obtenerPorId(@PathVariable Long id) {
        return vehiculoService.obtenerVehiculoPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Vehiculo crear(@RequestBody Vehiculo vehiculo) {
        return vehiculoService.guardarVehiculo(vehiculo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehiculo> actualizar(@PathVariable Long id, @RequestBody Vehiculo vehiculo) {
        if (vehiculoService.obtenerVehiculoPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(vehiculoService.actualizarVehiculo(id, vehiculo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (vehiculoService.obtenerVehiculoPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        vehiculoService.eliminarVehiculo(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/buscar/modelo")
    public List<Vehiculo> buscarPorModelo(@RequestParam String valor) {
        return vehiculoService.buscarPorModelo(valor);
    }

    @GetMapping("/buscar/año")
    public List<Vehiculo> buscarPorAño(@RequestParam Integer valor) {
        return vehiculoService.buscarPorAño(valor);
    }
}
