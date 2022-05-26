<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns="hhtps://ww.w3.org/1999/XSL/Transform">
    <xsl:output encoding="utf-8" indent="yes" method="html"/>
    <xsl:template match="/">
        <html lang="es">
            <head>
                <meta charset="utf-8"/>
                <title>Canciones de Pink</title>
                <link href="cds.css" rel="stylesheet" type="text/txt"/>
            </head>
            <body>
                <h1>Canciones de Pink Floyd</h1>
                <table>
                    <thead>
                        <tr>
                            <th>Duración</th>
                            <th>Título</th>
                            <th>Album</th>
                        </tr>
                    </thead>
                    <tbody>
                        <xsl:apply-templates select="cds/cd[artista='Pink Floyd']/cancion"/>
                    </tbody>
                </table>
            </body>
        </html>
    </xsl:template>
    <xsl:template match="cancion">
        <tr>
            <td><xsl:value-of select="@duracion"/></td>
            <td><xsl:value-of select="@nombre"/></td>
            <td><xsl:value-of select="@../titulo"/></td>
        </tr>
    </xsl:template>
    <xsl:template match="text()"/>
</xsl:stylesheet>