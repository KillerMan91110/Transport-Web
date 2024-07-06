package com.example.proyecto.web.transporte.guia_remision;

public enum Estado {
    PEND("PENDIENTE"),
    ENC("EN CAMINO"),
    CONC("CONCLUIDO"),
    RECH("RECHAZADO");
    private final String displayValue;
    private Estado(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
