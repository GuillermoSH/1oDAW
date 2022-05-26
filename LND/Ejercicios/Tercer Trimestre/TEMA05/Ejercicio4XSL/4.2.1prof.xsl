<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output encoding="utf-8" indent="yes" method="html" doctype-system="about:legacy-compat"/>
    <xsl:template match="/">
        <html lang="es">
            <head>
                <meta charset="utf-8"/>
                <title>Países de Habla Hispana</title>
                <link href="countries.css" rel="stylesheet" type="text/css" />
            </head>
            <body>
                <h1>Países de habla española</h1>
                <table>
                    <thead>
                        <tr>
                            <th>Nombre</th>
                            <th>Núm.Lenguas</th>
                            <th>Núm.Hab</th>
                            <th>Densidad</th>
                        </tr>
                    </thead>
                </table>
                <tbody>
                    <xsl:for-each select="countries/country[language='Spanish']">
                        <xsl:sort select="@population" data-type="number" order="descending"/>
                        <tr>
                            <td><xsl:value-of select="@name"/></td>
                            <td class="derecha"><xsl:value-of select="count(language)"/></td>
                            <td class="derecha"><xsl:value-of select="format-number(language[.='Spanish']/@percentage * @population div 100,'#.00')"/></td>
                            <td class="derecha"><xsl:value-of select="format-number(@population div @area,'#.##')"/></td>
                        </tr>
                    </xsl:for-each>
                </tbody>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>