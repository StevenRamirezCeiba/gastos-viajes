package com.ceiba.gastoviaje.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.constantes.ResponsablePagoConstantes;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.gastoviaje.modelo.dto.DtoEmpleadoDetalleGasto;
import com.ceiba.gastoviaje.modelo.dto.DtoReporteGastosViajes;
import com.ceiba.gastoviaje.puerto.repositorio.RepositorioGastoViaje;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ServicioReportesGastoViajeTest {

    private List<DtoEmpleadoDetalleGasto> empleadoDetalleGastoList;

    @BeforeEach
    void setUp() {
        empleadoDetalleGastoList = Arrays.asList(
                new DtoEmpleadoDetalleGasto(1L, "Steven", YearMonth.of(2021, 1), BigDecimal.valueOf(500000)),
                new DtoEmpleadoDetalleGasto(1L, "Steven", YearMonth.of(2021, 2), BigDecimal.valueOf(900000)),
                new DtoEmpleadoDetalleGasto(2L, "Juana", YearMonth.of(2021, 1), BigDecimal.valueOf(1000000)),
                new DtoEmpleadoDetalleGasto(3L, "Michell", YearMonth.of(2021, 1), BigDecimal.valueOf(850000))
        );
    }

    @Test
    void deberiaLanzarUnaExcepcionCuandoSeValideLaExistenciaDeLosGastoViaje() {
        // arrange
        RepositorioGastoViaje repositorioGastoViaje = Mockito.mock(RepositorioGastoViaje.class);
        Mockito.when(repositorioGastoViaje.existeAlguno()).thenReturn(false);
        ServicioReportesGastoViaje servicioReportesGastoViaje = new ServicioReportesGastoViaje(repositorioGastoViaje);
        // act - assert
        BasePrueba.assertThrows(servicioReportesGastoViaje::generarReporteGastosViajesEmpleados, ExcepcionDuplicidad.class, "No existe ningun gasto de viaje en el sistema");
    }

    @Test
    void deberiaAsignarCorrectamenteLosResponsablesDePago() {
        // arrange
        RepositorioGastoViaje repositorioGastoViaje = Mockito.mock(RepositorioGastoViaje.class);
        Mockito.when(repositorioGastoViaje.existeAlguno()).thenReturn(true);
        Mockito.when(repositorioGastoViaje.obtenerTodosConEmpleadoNombre()).thenReturn(empleadoDetalleGastoList);
        ServicioReportesGastoViaje servicioReportesGastoViaje = new ServicioReportesGastoViaje(repositorioGastoViaje);
        // act
        servicioReportesGastoViaje.generarReporteGastosViajesEmpleados();
        // assert
        assertEquals(ResponsablePagoConstantes.EMPLEADO, empleadoDetalleGastoList.get(0).getResponsablePago());
        assertEquals(ResponsablePagoConstantes.SURA, empleadoDetalleGastoList.get(1).getResponsablePago());
        assertEquals(ResponsablePagoConstantes.SURA, empleadoDetalleGastoList.get(2).getResponsablePago());
        assertEquals(ResponsablePagoConstantes.SURA, empleadoDetalleGastoList.get(3).getResponsablePago());
    }

    @Test
    void deberiaGenerarConExitoElReporteDeGastosDeViajeDeLosEmpleados() {
        // arrange
        RepositorioGastoViaje repositorioGastoViaje = Mockito.mock(RepositorioGastoViaje.class);
        Mockito.when(repositorioGastoViaje.existeAlguno()).thenReturn(true);
        Mockito.when(repositorioGastoViaje.obtenerTodosConEmpleadoNombre()).thenReturn(empleadoDetalleGastoList);
        ServicioReportesGastoViaje servicioReportesGastoViaje = new ServicioReportesGastoViaje(repositorioGastoViaje);
        // act
        DtoReporteGastosViajes dtoReporteGastosViajes = servicioReportesGastoViaje.generarReporteGastosViajesEmpleados();
        // assert
        assertNotNull(dtoReporteGastosViajes);
        assertEquals(new BigDecimal("3250000"), dtoReporteGastosViajes.getValorTotalGastos());
        assertEquals(4, dtoReporteGastosViajes.getEmpleadosDetalleGastos().size());
        Mockito.verify(repositorioGastoViaje, Mockito.times(1)).obtenerTodosConEmpleadoNombre();
    }
}
