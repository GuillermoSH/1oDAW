<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns="hhtps://ww.w3.org/1999/XSL/Transform">
    <xsl:output encoding="utf-8" indent="yes" method="html"/>
    <xsl:template match="/">
        <html lang="es">
            <head>
                <meta charset="utf-8"/>
                <title>Ejercicio 4.2.3</title>
                <link href="countries.css" rel="stylesheet" type="text/txt"/>
            </head>
            <body>
                <h1>Países más poblados de la Tierra</h1>
                <table>
                    <thead>
                        <tr>
                            <th></th>
                            <th>Nombre</th>
                            <th>Población</th>
                            <th>% Respecto Tierra</th>
                        </tr>
                    </thead>
                    <tbody>
                        <xsl:for-each select="countries/country">
                            <tr>
                                <td></td>
                                <td><xsl:value-of select="@name"/></td>
                                <td><xsl:value-of select="@population"/></td>
                                <td><xsl:value-of select=""/></td>
                            </tr>
                        </xsl:for-each>
                        <tr>
                            <td></td>
                            <td>Suma</td>
                            <td><xsl:value-of select=""/></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>Población Global Tierra</td>
                            <td><xsl:value-of select=""/></td>
                            <td></td>
                        </tr>
                    </tbody>
                </table>

                <h1>Países Menos poblados de la Tierra</h1>
                <table>
                    <thead>
                        <tr>
                            <th></th>
                            <th>Nombre</th>
                            <th>Población</th>
                            <th>% Respecto Tierra</th>
                        </tr>
                    </thead>
                    <tbody>
                        <xsl:for-each select="countries/country">
                            <tr>
                                <td></td>
                                <td><xsl:value-of select="@name"/></td>
                                <td><xsl:value-of select="@population"/></td>
                                <td><xsl:value-of select=""/></td>
                            </tr>
                        </xsl:for-each>
                        <tr>
                            <td></td>
                            <td>Suma</td>
                            <td><xsl:value-of select=""/></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>Población Global Tierra</td>
                            <td><xsl:value-of select=""/></td>
                            <td></td>
                        </tr>
                    </tbody>
                </table>
            </body>
        </html>
    </xsl:template>
    <xsl:template match="text()"/>
</xsl:stylesheet>