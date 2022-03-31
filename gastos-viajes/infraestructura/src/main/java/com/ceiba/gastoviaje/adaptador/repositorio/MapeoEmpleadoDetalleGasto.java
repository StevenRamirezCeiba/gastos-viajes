package com.ceiba.gastoviaje.adaptador.repositorio;

import com.ceiba.gastoviaje.modelo.dto.DtoEmpleadoDetalleGasto;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.YearMonth;

public class MapeoEmpleadoDetalleGasto implements RowMapper<DtoEmpleadoDetalleGasto>, MapperResult {

    @Override
    public DtoEmpleadoDetalleGasto mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long empleadoId = resultSet.getLong("empleado_id");
        String empleadoNombre = resultSet.getString("nombre");
        int anno = resultSet.getInt("anno");
        int mes = resultSet.getInt("mes");
        BigDecimal valor = resultSet.getBigDecimal("valor");

        return new DtoEmpleadoDetalleGasto(empleadoId,empleadoNombre,YearMonth.of(anno, mes),valor);
    }
}
