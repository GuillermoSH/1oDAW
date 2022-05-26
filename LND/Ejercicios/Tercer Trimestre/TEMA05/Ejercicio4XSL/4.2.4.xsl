<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns="hhtps://ww.w3.org/1999/XSL/Transform">
    <xsl:output encoding="utf-8" indent="yes" method="html"/>
    <xsl:template match="/">
        <html lang="es">
            <head>
                <meta charset="utf-8"/>
                <title>Ejercicio 4.2.4</title>
                <link href="countries.css" rel="stylesheet" type="text/txt"/>
            </head>
            <body>
                <h1>Países de habla hispana, con sus ciudades y población de éstas</h1>
                <table>
                    <thead>
                        <tr>
                            <th></th>
                            <th>Nombre</th>
                            <th>Ciudades</th>
                            <th>Población</th>
                        </tr>
                    </thead>
                    <tbody>
                        <xsl:for-each select="countries/country[language='Spanish']">
                            <tr>
                                <td></td>
                                <td><xsl:value-of select="@name"/></td>
                                <td><xsl:value-of select="/city"/></td>
                                <td><xsl:value-of select="/city/@population"/></td>
                            </tr>
                        </xsl:for-each>
                        <tr>
                            <td></td>
                            <td>Total Población Ciudades:</td>
                            <td><xsl:value-of select=""/></td>
                        </tr>
                    </tbody>
                </table>
            </body>
        </html>
    </xsl:template>
    <xsl:template match="text()"/>
</xsl:stylesheet>