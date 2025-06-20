package dev.sye.mcpfinanzas;

public class Contstantes {
    
    public static final String API_KEY = "de4059aabd2ef593597b40d936205f";
    public static final String URL_BASE = "https://api.databursatil.com/v1";
    public static final String NEWS_URL = URL_BASE + "/noticias?token=" + API_KEY;
    public static final String DIVISAS_URL = URL_BASE + "/divisas?token=" + API_KEY;
    public static final String COTIZACIONES_URL = URL_BASE + "/cotizaciones?token=" + API_KEY + "&";
    public static final String EMISORAS_URL = URL_BASE + "/emisoras?token=" + API_KEY + "&letra=";

    public static final String ESTRUCTURA_COTIZACIONES = "" +
    "La estructura de la respuesta es la siguiente:\n" +
    "Emisora: Nombre de la emisora\n" +
    "Bolsa: Bolsa en la que se encuentra la emisora\n" +
    "Detalle: Detalles de la cotización\n" +
    "UltimoHecho: Precio del último hecho\n" +
    "PrecioPromedioPonderado: Precio promedio ponderado\n" +
    "PrecioAnteriorDeLaEmisora: Precio anterior de la emisora\n" +
    "PrecioMaximo: Precio máximo\n" +
    "PrecioMinimo: Precio mínimo\n" +
    "CambioPorcentual: Cambio porcentual\n" +
    "CambioMonetario: Cambio monetario\n" +
    "AccionesNegociadas: Acciones negociadas\n" +
    "NumeroDeOperaciones: Número de operaciones\n" +
    "ImporteOperado: Importe operado\n" +
    "FechaDeLaCotizacion: Fecha de la cotización\n\n";
}
