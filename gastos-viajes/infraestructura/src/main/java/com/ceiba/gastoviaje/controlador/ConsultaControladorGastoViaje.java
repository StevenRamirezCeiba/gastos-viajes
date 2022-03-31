package com.ceiba.gastoviaje.controlador;

import com.ceiba.gastoviaje.consulta.ManejadorReportesGastoViaje;
import com.ceiba.gastoviaje.modelo.dto.DtoReporteGastosViajes;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reporte-gasto-viaje")
@Api(tags={"Controlador consulta reporte gasto viaje"})
public class ConsultaControladorGastoViaje {
    private final ManejadorReportesGastoViaje manejadorReportesGastoViaje;

    public ConsultaControladorGastoViaje(ManejadorReportesGastoViaje manejadorReportesGastoViaje) {
        this.manejadorReportesGastoViaje = manejadorReportesGastoViaje;
    }

    @GetMapping
    @ApiOperation("Obtener reporte de gastos de viaje de empleados")
    public DtoReporteGastosViajes obtenerReporteGastosViajeEmpleados() {
        return this.manejadorReportesGastoViaje.obtenerReporteGastosViajes();
    }
}