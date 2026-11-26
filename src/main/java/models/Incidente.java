package models;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Incidente implements Comparable<Incidente> {

    private final String codigo;
    private final int severidad;
    private final int minutosRestantes;
    private final List<ServicioAfectado> servicios;
    private final LocalDateTime registradoEn;

    public Incidente(String codigo, int severidad, int minutosRestantes,
            List<ServicioAfectado> servicios, LocalDateTime registradoEn) {
        // Objects.requireNonNull(codigo, "codigo");
        // if (!codigo.matches("[A-Za-z0-9-]+") || severidad < 1 || severidad > 4) {
        // throw new IllegalArgumentException("Código o severidad inválidos");
        // }
        this.codigo = codigo;
        this.severidad = severidad;
        this.minutosRestantes = minutosRestantes;
        this.servicios = List.copyOf(servicios);
        // this.registradoEn = Objects.requireNonNull(registradoEn, "registradoEn");
        this.registradoEn = registradoEn;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getSeveridad() {
        return severidad;
    }

    public int getMinutosRestantes() {
        return minutosRestantes;
    }

    public List<ServicioAfectado> getServicios() {
        return servicios;
    }

    public LocalDateTime getRegistradoEn() {
        return registradoEn;
    }

    @Override
    public int compareTo(Incidente otro) {
        Objects.requireNonNull(otro);
        Comparator<Incidente> comp = Comparator
                .comparingInt(Incidente::getSeveridad)
                .thenComparingInt(Incidente::getMinutosRestantes)
                .thenComparing(i -> i.getServicios().size(), Comparator.reverseOrder())
                .thenComparing(i -> {
                    long numUsuarios = 0;
                    for (ServicioAfectado s : i.getServicios()) {
                        numUsuarios = numUsuarios + s.usuariosAfectados();
                    }
                    return numUsuarios;
                }, Comparator.reverseOrder())
                .thenComparing(Incidente::getRegistradoEn)
                .thenComparing(Incidente::getCodigo, String.CASE_INSENSITIVE_ORDER);
        return comp.compare(this, otro);
    }

    @Override
    public String toString() {
        return "%s | severidad=%d | minutos=%d | servicios=%d | fecha=%s"
                .formatted(codigo, severidad, minutosRestantes, servicios.size(), registradoEn);
    }
}
