package controllers;

import java.util.List;
import java.util.Objects;

import models.Incidente;

public class IncidenteController {
    public List<Incidente> sort(List<Incidente> incidentes) {
        Objects.requireNonNull(incidentes);
        incidentes.sort(null);
        return incidentes;
    }

    public int busquedaBinaria(List<Incidente> incidentes, Incidente objetivo) {
        Objects.requireNonNull(incidentes);
        Objects.requireNonNull(objetivo);
        int low = 0;
        int high = incidentes.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comp = incidentes.get(mid).compareTo(objetivo);
            if (comp == 0) {
                return mid;
            }
            if (comp > 0) {
                high = mid - 1;
            }
            if (comp < 0) {
                low = mid + 1;
            }
        }
        return -1;
    }
}
