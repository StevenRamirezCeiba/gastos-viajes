package com.ceiba.gastoviaje.puerto.repositorio;

import com.ceiba.gastoviaje.modelo.dto.DtoEmpleadoDetalleGasto;

import java.util.List;

public interface RepositorioGastoViaje {

    List<DtoEmpleadoDetalleGasto> obtenerTodosConEmpleadoNombre();

    boolean existeAlguno();
}
