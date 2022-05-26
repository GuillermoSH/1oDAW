<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns="hhtps://ww.w3.org/1999/XSL/Transform">
    <xsl:output encoding="utf-8" indent="yes" method="html" doctype-system="about:legacy-compact"/>
    <xsl:template>
        <html lang="es">
            <head>
                <meta charset="utf-8"/>
                <title>Listado de CDs de Música</title>
                <link href="cds.css" rel="stylesheet" type="text/txt"/>
            </head>
            <body>
                <h1>Listado de CDs de Música</h1>
                <table>
                    <thead>
                        <tr>
                            <th>Título</th>
                            <th>Año</th>
                            <th>Artista</th>
                            <th>Canciones</th>
                            <th>Sello</th>
                        </tr>
                    </thead>
                    <tbody>
                        <xsl:apply-templates select="cd">
                            <xsl:sort select="titulo" data-type="text" order="descending"/>
                        </xsl:apply-templates>
                    </tbody>
                </table>
            </body>
        </html>
    </xsl:template>
    <xsl:template match="cd">
        <tr>
            <td><xsl:value-of select="titulo"/></td>
            <td><xsl:value-of select="año"/></td>
            <td><xsl:value-of select="artista"/></td>
            <td>
                <ol>
                    <xsl:apply-templates select="cancion"/>
                </ol>
            </td>
            <td><xsl:value-of select="sello"/></td>
        </tr>
    </xsl:template>
    <xsl:template match="cancion">
        <li>
            <xsl:value-of select="@duracion"/>
            <xsl:text> </xsl:text>
            <xsl:value-of select="@nombre"/>
        </li>
    </xsl:template>
    <xsl:template match="text()"/>
</xsl:stylesheet>