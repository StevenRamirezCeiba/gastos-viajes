package com.ceiba.gastoviaje.modelo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.YearMonth;

@Getter
@ToString
public class DtoEmpleadoDetalleGasto {
    private Long empleadoId;
    private String empleadoNombre;
    private YearMonth fechaDetalle;
    private BigDecimal valor;
    @Setter
    private String responsablePago;

    public DtoEmpleadoDetalleGasto(Long empleadoId, String empleadoNombre, YearMonth fechaDetalle, BigDecimal valor) {
        this.empleadoId = empleadoId;
        this.empleadoNombre = empleadoNombre;
        this.fechaDetalle = fechaDetalle;
        this.valor = valor;
    }
}
