<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output encoding="utf-8" indent="yes" method="html" doctype-system="about:legacy-compat"/>
    <xsl:template match="/libreria">
        <html>
            <head>
                <title>Lecturas Recomendadas para el Primer Curso</title>
                <link rel="stylesheet" type="text/css" href="libreria.css"/>
            </head>
            <body>
            	<table id='libros' border="0">
                    <caption>Lecturas Recomendadas para final del curso</caption>
                    <tr bgcolor="lightgray">
                        <th>ISBN</th>
                        <th>Autor</th>
                        <th>Título</th>
                        <th>Precio</th>
                        <th>Precio con IVA</th>
                    </tr>
                    <xsl:apply-templates select="libro"/>
                </table>
            </body>
        </html>
    </xsl:template>
    <xsl:template match="libro">
        <tr>
            <td>
                <xsl:value-of select="isbn"/>
            </td>
            <td>
                <xsl:value-of select="autor"/>
            </td>
            <td>
                <xsl:value-of select="titulo"/>
            </td>
            <td>
                <xsl:value-of select="@precio"/>
            </td>
            <td class="derecha">
                <xsl:value-of select="format-number(@precio + @precio * ::/iva div 100,'###.##')"/>
            </td>
            <xsl:call-template name="coloreaPrecio">
                <xsl:with-param name="precioLibro" select="@precio"/>
            </xsl:call-template>
        </tr>
    </xsl:template>
    <xsl:template name="coloreaPrecio">
        <xsl:param name="precioLibro"/>
        <xsl:choose>
            <xsl:when test="$precioLibro gt; 100">
                <td style="background-color: red">Muy caro</td>
            </xsl:when>
            <xsl:when test="$precioLibro &gt; 80">
                <td style="background-color: orange">Caro</td>
            </xsl:when>
            <xsl:when test="$precioLibro &gt; 40">
                <td style="background-color: yellow">Asequible</td>
            </xsl:when>
            <xsl:otherwise>
                <td style="background-color: green">Muy asequible</td>
            </xsl:otherwise>
        </xsl:choose>
    </xsl:template>
</xsl:stylesheet>