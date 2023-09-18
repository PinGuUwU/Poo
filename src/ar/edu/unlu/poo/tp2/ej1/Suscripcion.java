package ar.edu.unlu.poo.tp2.ej1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Suscripcion {
    private final HashMap<String, ArrayList<String>> tipos = new HashMap<>();

    public Suscripcion(){
        ArrayList<String> actividades = new ArrayList<>(Arrays.asList("cardio", "Levantamiento de pesas", "Clases grupales", "Deportes"));
        tipos.put("basico", actividades);
        ArrayList<String> actividades1 = new ArrayList<>(Arrays.asList("cardio", "Levantamiento de pesas", "Clases grupales", "Deportes"));
        actividades1.addAll(Arrays.asList("Entrenamiento personal", "Sauna y baño de vapor", "Masajes"));
        tipos.put("intermedio", actividades1);
        ArrayList<String> actividades2 = new ArrayList<>(Arrays.asList("cardio", "Levantamiento de pesas", "Clases grupales", "Deportes"));
        actividades2.addAll(Arrays.asList("Entrenamiento personal", "Sauna y baño de vapor", "Masajes"));
        actividades2.addAll(Arrays.asList("Cuidado de niños", "Tienda de artículos deportivos exclusivos", "Restaurante y cafetería"));
        tipos.put("destacado", actividades2);
    }
    public String toString(){//Muestra las suscripciones con sus actividades
        String cadena = "\tTipos de suscripciones:\n";
        for(Map.Entry tipo : tipos.entrySet()){
            cadena += "-"+ tipo.getKey() +".\n\tActividades: "+ tipo.getValue()+".\n";
        }
        return cadena;
    }
}
