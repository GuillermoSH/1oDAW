public class HtmlUtil {
    public static String cabecera(String titulo) {
        return String.format("<!DOCTYPE html>\n" +
                "<html>\n" +
                "   <head>\n" +
                "       <meta charset='utf-8'/>\n" +
                "       <title>%s</title>\n" +
                "   </head>\n" +
                "   <body>", titulo);
    }

    public static String pieHtml() {
        return String.format("  </body>\n" +
                "</html>");
    }
}
