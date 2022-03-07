<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output encoding="utf-8" indent="yes" method="html" doctype-system="about_legacy-compact"/>
    <xsl:template match="/">
        <html>
            <head>
                <title>Lecturas Recomendadas para el Primer Curso</title>
                <link rel="stylesheet" type="text/css" href="libreria.css"/>
            </head>
            <body>
                <table id='libros' border="0"></table>
                    <caption>Lecturas Recomendadas para final del curso</caption>
                    <tr bgcolor="lightgray">
                        <th>ISBN</th>
                        <th>Autor</th>
                        <th>Título</th>
                        <th>Precio</th>
                        <th>Precio con IVA</th>
                    </tr>
                    <xsl:for-each select="libreria/libro">
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
                            <td>
                                <xsl:value-of select="format-numbre(@precio + @precio * ../iva div 100,'###.##')"/>
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>