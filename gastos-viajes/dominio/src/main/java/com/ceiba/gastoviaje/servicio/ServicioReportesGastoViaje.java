package com.ceiba.gastoviaje.servicio;

import com.ceiba.constantes.ResponsablePagoConstantes;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.gastoviaje.modelo.dto.DtoEmpleadoDetalleGasto;
import com.ceiba.gastoviaje.modelo.dto.DtoReporteGastosViajes;
import com.ceiba.gastoviaje.puerto.repositorio.RepositorioGastoViaje;

import java.math.BigDecimal;
import java.util.List;

public class ServicioReportesGastoViaje {

    private static final String NO_EXISTE_NINGUN_GASTO_DE_VIAJE_EN_EL_SISTEMA = "No existe ningun gasto de viaje en el sistema";

    private static final BigDecimal VALOR_IVA = BigDecimal.valueOf(0.19);
    private static final double VALOR_LIMITE_RESPONSABILIDAD_PAGO_EMPLEADO = 1000000;

    private final RepositorioGastoViaje repositorioGastoViaje;

    public ServicioReportesGastoViaje(RepositorioGastoViaje repositorioGastoViaje) {
        this.repositorioGastoViaje = repositorioGastoViaje;
    }

    public DtoReporteGastosViajes generarReporteGastosViajesEmpleados() {
        validarExistenciaPrevia();
        List<DtoEmpleadoDetalleGasto> empleadoDetalleGastoList = repositorioGastoViaje.obtenerTodosConEmpleadoNombre();
        asignarResponsablePago(empleadoDetalleGastoList);

        return fabricaDtoReporteGastosViajes(empleadoDetalleGastoList);
    }

    private void validarExistenciaPrevia() {
        boolean existe = this.repositorioGastoViaje.existeAlguno();
        if(!existe) {
            throw new ExcepcionDuplicidad(NO_EXISTE_NINGUN_GASTO_DE_VIAJE_EN_EL_SISTEMA);
        }
    }

    private void asignarResponsablePago(List<DtoEmpleadoDetalleGasto> empleadoDetalleGastoList) {
        for (DtoEmpleadoDetalleGasto empleadoDetalle : empleadoDetalleGastoList) {
            if (obtenerValorConIva(empleadoDetalle.getValor()).doubleValue() > VALOR_LIMITE_RESPONSABILIDAD_PAGO_EMPLEADO) {
                empleadoDetalle.setResponsablePago(ResponsablePagoConstantes.SURA);
            } else {
                empleadoDetalle.setResponsablePago(ResponsablePagoConstantes.EMPLEADO);
            }
        }
    }

    private BigDecimal obtenerValorConIva(BigDecimal valor) {
        BigDecimal valorIva = valor.multiply(VALOR_IVA);

        return valor.add(valorIva);
    }

    private DtoReporteGastosViajes fabricaDtoReporteGastosViajes(List<DtoEmpleadoDetalleGasto> empleadoDetalleGastoList) {
        BigDecimal valorTotalGastos = BigDecimal.valueOf(0);

        for (DtoEmpleadoDetalleGasto empleadoDetalle : empleadoDetalleGastoList) {
            valorTotalGastos = valorTotalGastos.add(empleadoDetalle.getValor());
        }

        return new DtoReporteGastosViajes(valorTotalGastos, empleadoDetalleGastoList);
    }
}
