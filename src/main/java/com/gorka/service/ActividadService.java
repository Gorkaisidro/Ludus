/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gorka.service;

import com.gorka.data.iActividadDao;
import com.gorka.dominio.Actividad;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Gorka
 */
@Stateless
public class ActividadService implements iActividadService {

    @Inject
    private iActividadDao actividadDao;

    @Override
    public List<Actividad> listarActividad() {
        return actividadDao.findAllActividad();
    }

    @Override
    public List<Actividad> listarActividadDate() {
        return actividadDao.findByDate();
    }

    @Override
    public void registrarActividad(Actividad actividad) {
        actividadDao.insertarActividad(actividad);
    }

    @Override
    public void actualizarActividad(Actividad actividad) {
        actividadDao.actualizarActividad(actividad);
    }

    @Override
    public void borrarActividad(Actividad actividad) {
        actividadDao.borrarActividad(actividad);
    }

    @Override
    public List<Actividad> encontrarActividadesPorUsuario(int idUsuario) {
        return actividadDao.findActividadesByUsuario(idUsuario);
    }

    @Override
    public Date obtenerFechaHoraInicio(int anio, int mes, int dia, int hora, int minuto) {
        // Crear un objeto LocalDateTime con los valores de los campos
        LocalDateTime fechaHora = LocalDateTime.of(anio, mes, dia, hora, minuto);

        // Obtener la zona horaria de España
        ZoneId zonaHorariaEspana = ZoneId.of("Europe/Madrid");

        // Convertir LocalDateTime a Date utilizando la zona horaria de España
        Date fechaHoraDate = Date.from(fechaHora.atZone(zonaHorariaEspana).toInstant());

        return fechaHoraDate;
    }

    // Función que me pasa la duracion a segundos
    @Override
    public int obtenerDuracionSegundos(int hora, int minuto, int segundo) {
        return hora * 36000 + minuto * 60 + segundo;
    }

    // Función que me devuelve el ritmo en segundos
    @Override
    public int obtenerRitmo(double distancia, int duracion) {
        // Asegúrate de que la distancia sea mayor que cero para evitar divisiones por cero
        if (distancia > 0) {
            // Calcula el ritmo por kilómetro en segundos
            double ritmoPorKilometro = duracion / distancia;

            // Convierte el ritmo a segundos
            return (int) ritmoPorKilometro;
        } else {
            // Manejo de error o valor predeterminado si la distancia es cero o negativa
            return 0; // Puedes ajustar esto según tus necesidades
        }
    }

    @Override
    public List<Actividad> encontrarActividadesPorSeguidores(int idUsuario) {
        return actividadDao.findActividadBySeguidores(idUsuario);
    }

    @Override
    public int contarActividadesPorIdUSuario(int idUsuario) {
        return actividadDao.countActividadByIdUsuario(idUsuario);
    }

    @Override
    public Actividad encontrarActividadPorIdActividad(int idActividad) {
        return actividadDao.findActividadByIdActividad(idActividad);
    }

    @Override
    public Object[] resultadosMetricasPorAnio(int idUsuario, int anio) {
        return actividadDao.resultadosMetricasPorAnio(idUsuario, anio);
    }

    @Override
    public Object[] resultadosMetricasPorAnioYDeporte(int idUsuario, int anio, String tipoDeporte) {
        return actividadDao.resultadosMetricasPorAnioYDeporte(idUsuario, anio, tipoDeporte);
    }

    @Override
    public int obtenerPrimerAnioRegistrado(int idUsuario) {
        return actividadDao.findPrimerAnioRegistrado(idUsuario);
    }

}
