package com.concesionaria.crud.service;

import java.util.List;
import java.util.Optional;

import com.concesionaria.crud.model.Vehiculo;

public interface VehiculoService {

    List<Vehiculo> listarVehiculos();
    Optional<Vehiculo> obtenerVehiculoPorId(Long id);
    Vehiculo guardarVehiculo(Vehiculo vehiculo);
    Vehiculo actualizarVehiculo(Long id, Vehiculo vehiculo);
    void eliminarVehiculo(Long id);
    List<Vehiculo> buscarPorModelo(String modelo);
    List<Vehiculo> buscarPorAño(Integer anio);
}