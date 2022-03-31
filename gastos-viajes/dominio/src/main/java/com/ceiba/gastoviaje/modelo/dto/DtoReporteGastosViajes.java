package com.ceiba.gastoviaje.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@AllArgsConstructor
public class DtoReporteGastosViajes {
    private BigDecimal valorTotalGastos;
    private List<DtoEmpleadoDetalleGasto> empleadosDetalleGastos;
}
