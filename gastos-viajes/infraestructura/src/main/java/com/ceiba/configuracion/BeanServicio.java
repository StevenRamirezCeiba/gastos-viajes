package com.ceiba.configuracion;

import com.ceiba.gastoviaje.puerto.repositorio.RepositorioGastoViaje;
import com.ceiba.gastoviaje.servicio.ServicioReportesGastoViaje;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {
	
    @Bean
    public ServicioReportesGastoViaje servicioReportesGastoViaje(RepositorioGastoViaje repositorioGastoViaje) {
        return new ServicioReportesGastoViaje(repositorioGastoViaje);
    }
}
