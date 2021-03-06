package com.ceiba.gastoviaje.consulta;

import com.ceiba.gastoviaje.modelo.dto.DtoReporteGastosViajes;
import com.ceiba.gastoviaje.servicio.ServicioReportesGastoViaje;
import org.springframework.stereotype.Component;


@Component
public class ManejadorReportesGastoViaje {

    private final ServicioReportesGastoViaje servicioReportesGastoViaje;

    public ManejadorReportesGastoViaje(ServicioReportesGastoViaje servicioReportesGastoViaje) {
        this.servicioReportesGastoViaje = servicioReportesGastoViaje;
    }

    public DtoReporteGastosViajes obtenerReporteGastosViajes() {
        return this.servicioReportesGastoViaje.generarReporteGastosViajesEmpleados();
    }
}
