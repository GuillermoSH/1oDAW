# SISTEMAS EN RED

Los laboratorios Bell sobre el 58 inventaron el modem (modulador demodulador) el cuál transforma una señal en codigo binario a una señal sonora enviada por las líneas telefónicas a unos y ceros de nuevo.

Una representación del sonido se puede buscar [aquí.](https://www.youtube.com/watch?v=gsNaR6FRuO0)

En 1981 se definió el protocolo TCP/IP (transfer control protocol/internet protocol) y la palabra "internet".

RFC (request for comment): si tienes una idea no te la guardes, compartela. Es un texto plano que recopila información y se usa desde los 70. Todo internet esta recogido en los RFCs.

En 1991 se anunció publicamente la World Wide Web y en el 1998 nació Google.

**IPs.-**

Después de 30 años de que se decidio hacer el protocolo IPv6 no se ha cambiado todas las antiguas IPs de IPv4 a IPv6.
- IPv4: 4k Millones de IPs (usa 4 Bytes)
- IPv6: 340 sextillones de IPs (usa 6 Bytes)

## INTERNET.-

Internet viene de las palabras INTERconnected NETworks. Las desventajas son la seguridad y la privacidad.

```
TransductorEntrada      Emisor                  Canal                     Receptor      TransductorSalida
                                      - Cable (electricidad)
                                      - Cable (luz,fibra optica)
                                      - Aire
                                      - Radio
                                      - Inflarrojo
```

### Clasificación de redes.-

#### Por área:

  - **LAN** (Local Area Network) desde 10m hasta 1km. Son independientes las unas de las otras. Ethernet.
  - **MAN** (Metropolitan Area Network) desde 10km hasta 100km. Fibra óptica.
  - **WAN** (World Area Network) 1000km.
  - **SAN** (Storage Area Network) son redes de almacenaje. Un ejemplo son los NAS.
  - **PAN** (Personal Area Network) desde 1m hasta 10m. Bluetooth es un ejemplo.
  - **CAN** (Controller Area Network)
  - **HAN** (Home Area Network) casas domotizadas

Cuando contienen W delante de cada tipo de red significará que son "Wireless". 

  - WiFi (Wireless Fidelity).
  - WiMax (Worldwide Interoperability for Microwave Access).

<div align="center">
  <img src="https://github.com/GuillermoSH/1oDAW/blob/main/Imagenes/tipos-de-redes-de-computadoras.jpg" width="50%"/>
</div>

#### Por tipo de conexión:

  - **Cableadas**:
    - Par trensado
    - Fibra óptica
    - Coaxial
  - **No cableadas**:
    - WIFI
    - Radio
    - Inflarrojo
    - Laser

#### Por relación funcional:

  - Cliente-servidor: equipos especiales que solo realizan una acción. (Empresas con servidor centralizado) 
  - P2P (peer-to-peer): todos los equipos son iguales. (Utorrent)

#### Por grado de autentificación:

  - Red de acceso público: Internet (extranet)
  - Red privada: Intranet

La mezcla de ambas redes se denomina DMZ (Zona desmilitarizada).

#### Por topología física de red:

  - Estrella: un equipo es el central y el resto de equipos se conectan al central. Cables usados son n-1 y desventaja que si se rompe el central la red se va con el.
  - Bus: solo un cable y se conectan todos los equipos a ese cable. Desventajas que si uno esta usando la red el resto no podrán acceder.
  - Malla: todos conectados con todos. n * (n-1) cables y desventaja mucho cable.
  - Anillo: se conectan por un cable entre todos pero en circulo no lineal como el bus.
  - Árbol: se conectan de forma jerarquica.

### Por topología lógica de red:

  - Difusión o broadcast: todos los equipos de la red ven el mensaje

  - Token: va pasando por los equipos hasta llegar a su receptor

### Protocolos y estándares:

  - Protocolos de comunicaciones: 
  - Estandares de red:
    - Estándares de facto, de iniciativa propia de la empresa
    - Estándares de iure, de un organismo oficial

#### Organismos reguladores de ambito internacional:

  - ONU - ITU (International Telecommunication Union)
  - ISO (International Organization for Standardization)
  - IEEE (Institute of Electrical and Electronics Engineers)

#### Organismos reguladores de EEUU:

  - ANSI (American National Standards Institute)
  - TIA (Technology Innovation Agency)

#### Organismos reguladores de Europa:

  - CEN (Comité Europeo de Normalización)
  - CENELEC (Comite Europeo de Normalización Electrotécnica)
  - ETSI (Instituto Europeo de Estándares de Telecomunicaciones)

#### Organismos reguladores de España:

  - CTN (Comités Técnicos de Normalización)
  - AENOR (Asociación Española de Normalización y Certificación)

### Arquitecturas de red basadas en capas.-

#### Modelo OSI:

Las diferentes capas trabajan especializadas en una cosa unicamente y se comunicarán con su capa inferior y superior nada más.

Capas OSI:

```
    ENVIA                                         RECIBE
                                                                    --+
7. APLICACIÓN                                 7. APLICACIÓN           |
6. PRESENTACIÓN                               6. PRESENTACIÓN         |-- Esto es la capa de la aplicacion (desarrolador web)
5. SESIÓN                                     5. SESIÓN               |
                                                                    --+
4. TRANSPORTE                                 4. TRANSPORTE           <-- TCP
3. RED (distribucion global)                  3. RED                  <-- IP
2. ENLACE (distribucion local)                2. ENLACE               <-- ACE
1. FISICO                                     1. FISICO               <-- FISICO
```

1. Fisico: 0 y 1 (Bits)
2. Enlace: comunicacion con todos los equipos de area local (Tramas)
3. Red: diseña el camino que debe llevar el mensaje hasta el destinatario (hace su mejor intento) (Paquetes o datagramas)
4. Transporte: divide el mensaje en trozos mas pequeños y controla que llegue a su destinatario. (Segmentos)
5. Sesion: controla que las sesiones esten iniciadas y los niveles de privacidad (DATOS)
6. Presentacion: decide como se lleva el mensaje (PPD)
7. Aplicación: app de comunicación con el cliente (APDU)
