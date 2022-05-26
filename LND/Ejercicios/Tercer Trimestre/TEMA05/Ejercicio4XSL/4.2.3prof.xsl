<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output encoding="utf-8" indent="yes" method="html" doctype-system="about:legacy-compat"/>
<xsl:variable name="poblacionTierra" select="sum(//country/@population)"/>
<xsl:variable name="max10"/>
    <xsl:template match="/">
        <html lang="es">
            <head>
                <meta charset="utf-8"/>
                <title>10 países más y menos poblados de la Tierra</title>
                <link href="countries.css" rel="stylesheet" type="text/css" />
            </head>
            <body>
                <h1>10 países más poblados de la Tierra</h1>
                <xsl:call-template name="tablaPaises">
                    <xsl:with-param name="orden" select="'descending'"/>
                </xsl:call-template>
                <h1>10 países más poblados de la Tierra</h1>
                <xsl:call-template name="tablaPaises">
                    <xsl:with-param name="orden" select="'ascending'"/>
                </xsl:call-template>
                <table>
                    <thead>
                        <tr>
                            <th>Nombre</th>
                            <th>Población</th>
                            <th>% Resp.Tierra</th>
                        </tr>
                    </thead>
                </table>
                <tbody>
                    <xsl:for-each select="countries/country">
                        <xsl:sort select="@population" data-type="number" order="{$orden}"/>
                        <xsl:if test="position() &lt;= 10">
                            <tr>
                                <td><xsl:value-of select="position()"/></td>
                                <td><xsl:value-of select="@name"/></td>
                                <td><xsl:value-of class="derecha" select="@population"/></td>
                                <td><xsl:value-of class="derecha" select="format-number(@population * 100)"/></td>
                            </tr>
                        </xsl:if>
                    </xsl:for-each>
                </tbody>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>