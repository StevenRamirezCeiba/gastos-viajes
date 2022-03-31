package com.ceiba.gastoviaje.adaptador.repositorio;

import com.ceiba.gastoviaje.modelo.dto.DtoEmpleadoDetalleGasto;
import com.ceiba.gastoviaje.puerto.repositorio.RepositorioGastoViaje;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioGastoViajeMysql implements RepositorioGastoViaje {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="gastoviaje", value="obtenerTodosConNombreEmpleado")
    private static String sqlObtenerTodosConNombreEmpleado;

    @SqlStatement(namespace="gastoviaje", value="existeAlguno")
    private static String sqlExisteAlguno;

    public RepositorioGastoViajeMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoEmpleadoDetalleGasto> obtenerTodosConEmpleadoNombre() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlObtenerTodosConNombreEmpleado, new MapeoEmpleadoDetalleGasto());
    }

    @Override
    public boolean existeAlguno() {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteAlguno, paramSource, Boolean.class);
    }
}
