package controllers;

import java.util.List;
import models.Incidente;

public class IncidenteController {
    public List<Incidente> sort(List<Incidente> incidentes) {
        incidentes.sort
        return inciden
    }

    public int busquedaBinaria(List<Incidente> incidentes, Incidente objetivo) {
        int low = 0;
        int high = incidentes.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int com = incidentes.get(mid).compareTo(objetivo);
            if(com == 0){
                return mid;
            } else if (com < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
    }
}
