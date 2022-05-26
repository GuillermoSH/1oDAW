<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns="hhtps://ww.w3.org/1999/XSL/Transform">
    <xsl:output encoding="utf-8" indent="yes" method="html"/>
    <xsl:template match="/">
        <html lang="es">
            <head>
                <meta charset="utf-8"/>
                <title>Ejercicio 4.2.1</title>
                <link href="countries.css" rel="stylesheet" type="text/txt"/>
            </head>
            <body>
                <h1>Países de habla española</h1>
                <table>
                    <thead>
                        <tr>
                            <th>Nombre</th>
                            <th>Núm.Lenguas</th>
                            <th>Num.Hab</th>
                            <th>Densidad</th>
                        </tr>
                    </thead>
                    <tbody>
                        <xsl:for-each select="countries/country[language='Spanish']">
                            <tr>
                                <td><xsl:value-of select="@name"/></td>
                                <td><xsl:value-of select="count(countries/country/language)"/></td>
                                <td><xsl:value-of select="@population"/></td>
                                <td><xsl:value-of select="@population / @area"/></td>
                            </tr>
                        </xsl:for-each>
                    </tbody>
                </table>
            </body>
        </html>
    </xsl:template>
    <xsl:template match="text()"/>
</xsl:stylesheet>