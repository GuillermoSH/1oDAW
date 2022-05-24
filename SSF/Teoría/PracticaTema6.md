1) Con ifconfig (o ip a) muestra la configuración de red en tu máquina virtual (añade captura). Localiza cada interfaz de red, explicando cuál es cada una.

2) Para la interfaz de red que te da conexión a Internet, indica:

    - Tipo (ethernet, wifi, etc).
    - MAC
    - IP
    - Máscara
    - CIDR
    - Clase
    - Velocidad
    - MTU

 
3) La IP que tienes asignada, ¿es pública o privada? ¿por qué es así?

> Privada, porque pertenece al rango de redes privada de la clase a 10.0.0.0

4) Comprueba tu IP con los compañeros/as de clase, ¿sería posible que hubiera alguna IP repetida? ¿Sería posible conectarse remotamente a tu equipo usando esa IP?

> La IP esta repetida, con lo cual sabemos a ciencia cierta que todos estamos en redes diferentes.

5) ¿La ID de red de la IP de tu máquina virtual es la misma que la ID de red de los equipos de clase? ¿Por qué crees que es así? ¿Qué clase de red es cada una?

> Maquina Real: 172.18.9.0, mascara 255.255.0.0
> Maquina real y virtual estan en diferentes 

6) En la configuración de VirtualBox, vete a la máquina virtual y cambia ahora el adaptador de red de la máquina virtual a “Adaptador puente” (o bridge). Muestra ahora los datos de tu conexión (no es necesario reiniciar). ¿Qué ha cambiado? ¿Por qué?

![Captura de pantalla_2022-05-24_19-00-24](https://user-images.githubusercontent.com/92543128/170102133-b16a2c69-6dbc-41f8-8505-32b73fa7f1a7.png)
> Cambio la ip a la red local de la maquina real.

7) ¿La IP que tienes asignada es dinámica o estática? ¿Quién la asignó?

> IP dinamica asignada por el DHCP del router de las aulas de informatica

8) Libera la IP asignada y vuelve a solicitar una. Comprueba la nueva IP asignada. ¿Es distinta o la misma? ¿Por qué? Después de cada comando, utiliza ifconfig para comprobar qué IP tienes.

sudo dhclient -r => sudo dhclient

Es distinta: 172.18.9.42

![Captura de pantalla_2022-05-24_19-06-17](https://user-images.githubusercontent.com/92543128/170102933-d9ee13ff-f921-4c6d-b394-6c8ee3bc07d9.png)

9) Asigna una IP estática a tu máquina virtual, acabada en .100. Por ejemplo, si estás en la red 172.20.0.0 y tu equipo es el 25, entonces asigna a tu máquina virtual la IP 172.20.25.100. Conserva la máscara y puerta de enlace. Antes de cambiar, haz un ping a la nueva IP para comprobar si está siendo usada ya.
Este apartado se podría hacer por la interfaz gráfica, utilidad mntui, etc. ( https://linuxhint.com/configure-static-ip-address-linux/) Pero nosotros lo haremos por comandos:

a) Para cambiar la IP debes ejecutar el siguiente comando (debes sustituir los <valores> por los datos correctos para tu caso):

sudo ifconfig <interfaz> <IP> netmask <máscara>

sudo ifconfig enp0s3 172.18.9.100 netmask 255.255.0.0


Usaremos como ejemplo (adáptalo a tu caso):

    interfaz: enp0s3
    IP: 172.20.25.100
    máscara: 255.255.0.0

sudo ifconfig enp0s3 172.20.25.100 netmask 255.255.0.0

Ahora prueba con ifconfig a ver si realmente ha cambiado la IP


b) Sin embargo, este cambio NO es permanente, si reiniciamos el equipo, o simplemente la red, el cambio no se conserva:

sudo ifconfig <interfaz> down
sudo ifconfig <interfaz> up

Prueba ahora ifconfig a ver qué IP tienes.

Para que el cambio sea permanente, debemos escribirlo en el fichero /etc/network/interfaces (TEN CUIDADO ES UN FICHERO DEL SISTEMA). No borres el contenido, sino escribe AL FINAL:

auto <interfaz>
    iface <interfaz> inet static
    address <IP>
    netmask <máscara>
    gateway <puerta de enlace>
    dns-nameservers <dns>

    ¿Qué es el gateway y para qué se usa?
    Para el gateway, puedes mirar con el comando route (o route -n) que vimos en clase. Captura la salida del comando route y explica qué significa cada línea.
    Si se ha seguido el convenio, si estás en la red 172.20.0.0, entonces lo más probable es que esté en la primera IP útil: 172.20.0.1

    ¿Qué es el DNS y para qué se usa?
    Para el DNS, puedes coger el que ya tenías, o bien los DNS públicos de Google ( https://developers.google.com/speed/public-dns/): 8.8.8.8 y/o 8.8.4.4

Por ejemplo (adapta a tu caso):

auto enp0s3
    iface enp0s3 inet static
    address 172.20.25.100
    netmask 255.255.0.0
    gateway 172.20.0.1
    dns-nameservers 8.8.8.8
    dns-nameservers 8.8.4.4

Una vez editado el fichero, ¿ha cambiado la IP? Seguramente no, porque el servicio de red no lo habrá leído. Recuerda que cuando cambies la configuración de un servicio, hay que reiniciar el demonio:

systemctl restart networking

Prueba que tienes la IP asignada correctamente, y que se conserva incluso aunque reinicies la red o el equipo.


c) Prueba a abrir un navegador (firefox, por ejemplo) e intenta visitar alguna web... ¿funciona? ¿sabrías por qué?

Ahora haz un ping a google:

ping www.google.com

¿funciona? ¿Y si pruebas con su IP? (puedes usar el ping en tu máquina real para averiguar la IP de google).

ping 172.217.17.4

¿Cómo es posible que no funcione por la URL, pero sí por la IP?

Para resolver este problema, añade los nuevos DNS al fichero /etc/resolv.conf (IMPORTANTE, es un fichero del sistema, AÑADE AL FINAL SIN TOCAR NADA MÁS):

nameserver 8.8.8.8
nameserver 8.8.4.4

Prueba ahora que sí puedes navegar por Internet, así como hacer ping a la URL o buscar por nombre:

nslookup www.google.com
