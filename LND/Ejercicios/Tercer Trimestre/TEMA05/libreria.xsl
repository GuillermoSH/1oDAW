<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output encoding="utf-8" indent="yes" method="html" 
        doctype-system="about_legacy-compact"/>
    <xsl:template match="/">
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
                    <xsl:for-each select="libreria/libro[@precio &gt; 10 and autor='Gabriel García Márquez']">
                        <xsl:sort select="@precio" data-type="number" order="descending">
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
                            <td class="derecha">
                                <xsl:value-of select="@precio"/>
                            </td>
                            <td class="derecha">
                                <xsl:value-of select="format-numbre(@precio + @precio * ../iva div 100,'###.##')"/>
                            </td>
                            <xsl:choose>
                                <xsl:when test="@precio gt; 100">
                                    <td style="background-color: red">Muy caro</td>
                                </xsl:when>
                                <xsl:when test="@precio &gt; 80">
                                    <td style="background-color: orange">Caro</td>
                                </xsl:when>
                                <xsl:when test="@precio &gt; 40">
                                    <td style="background-color: yellow">Asequible</td>
                                </xsl:when>
                                <xsl:otherwise>
                                    <td style="background-color: green">Muy asequible</td>
                                </xsl:otherwise>
                            </xsl:choose>
                        </tr>
                        </xsl:sort>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>