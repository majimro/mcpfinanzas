package dev.sye.mcpfinanzas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FinanzasService {

    Logger logger = LoggerFactory.getLogger(FinanzasService.class);
    RestTemplate restTemplate = new RestTemplate();

    @Tool(name = "mcp_get_news", description = "Obtiene las noticias financieras del día")
    public String getNews() {
        logger.info("Obteniendo noticias financieras");
        String fooResourceUrl = Contstantes.NEWS_URL;
        String response = restTemplate.getForObject(fooResourceUrl, String.class);
        return response;
    }

    @Tool(name = "mcp_get_divisas", description = "Obtiene las divisas")
    public String getDivisas() {
        logger.info("Obteniendo divisas");
        String fooResourceUrl = Contstantes.DIVISAS_URL;
        String response = restTemplate.getForObject(fooResourceUrl, String.class);
        return response;
    }

    @SuppressWarnings("null")
    @Tool(name = "mcp_get_cotizaciones", description = "Obtiene las cotizaciones de una emisora")
    public String getCotizaciones(String emisora) {
        logger.info("Obteniendo cotizaciones de {}", emisora);
        String fooResourceUrl = Contstantes.COTIZACIONES_URL + "emisora_serie=" + emisora + "&bolsa=BMV&concepto=U,P,A,X,N,C,M,V,O,I,F";
        String cotizaciones = restTemplate.getForObject(fooResourceUrl, String.class);
        return Contstantes.ESTRUCTURA_COTIZACIONES + cotizaciones;
    }

    @SuppressWarnings("null")
    @Tool(name = "mcp_get_emisoras", description = "Obtiene las emisoras del mercado de valores")
    public String getEmisoras(String letra, String mercado) {
        if (mercado == null) {
            mercado = "local";
        }
        logger.info("Obteniendo emisoras de {}", letra);
        String fooResourceUrl = Contstantes.EMISORAS_URL + letra + "&mercado=" + mercado;
        String emisoras = restTemplate.getForObject(fooResourceUrl, String.class);
        return emisoras;
    }

    public static void main(String[] args) {
        FinanzasService finanzasService = new FinanzasService();
        System.out.println(finanzasService.getNews());
        // ystem.out.println(finanzasService.getCotizaciones("AAPL*"));
        // System.out.println(finanzasService.getEmisoras("AA", "local"));
        // System.out.println(finanzasService.getEmisoras("AA", "global"));
        //System.out.println(finanzasService.getDivisas());
    }

}
