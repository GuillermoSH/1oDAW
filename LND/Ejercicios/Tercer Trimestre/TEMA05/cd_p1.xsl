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
                        <xsl:for-each select="cds/cd">
                            <xsl:sort select="titulo" data-type="text" order="descending"/>
                        </xsl:for-each>
                    </tbody>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>