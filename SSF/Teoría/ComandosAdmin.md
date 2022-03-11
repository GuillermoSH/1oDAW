<h1>COMANDOS LINUX ADMINISTRACION</h1>

<h2>APT.-</h2>

```
apt search                      buscar entre los repositorios en línea
    version                     version del paquete instalada
    list                        todos los repositorios en general
    list --installed            todos los repositorios instalados
    list --all--versions        todos los repositorios con sus diferentes versiones
    list --upgradeable          todos los repositorios que se pueden actualizar
    remove                      desinstala sin borrar la configuración                      
    autoremove                  desinstala todas las dependencias que no se estan usando
    purge                       desinstala todo
    update                      actualiza la lista de paquetes disponibles para instalar
    upgrade                     actualiza todos los paquetes instalados
    full-upgrade                quita, actualiza e instala cualquier paquete
    dist-upgrade                igual que upgrade, pero consultando sobre la configuración
    hold                        no se va a actualizar si haces una actualizacion
    unhold                      quitar la retención
    show                        dará información sobre la instalación del paquete
    check                   
```

<h4>Ejemplos:</h4>

```
apt search vlc                  buscar repositorios que contengan "vlc"
            p                   se puede instalar
            i                   instalado
            c                   se desinstalo pero se quedo la configuración
            v                   paquete virtual (reune caracteristicas de varios paquetes)

apt install mysql-server        instalar el repositorio mysql

apt remove vlc                  quita solo el repositorio de vlc sin quitar todas las dependencias
```
<h2>APTITUDE.-</h2>

```
aptitude                        igual que el apt pero con una interfaz gráfica
```

<h2>SERVICIOS Y DEMONIOS.-</h2>

<h4>Características.-</h4>

Las características principales son:

- Se ejecutan en segundo plano.
- No tienen interfaz, solo se puede interactuar con ellos mediante otra aplicación.
- Suelen ejecutarse en con root.
- "No se pueden matar", de ahí el nombre de demonios.
- Disponibles siempre (no bajo demanda).
- Realizan funciones del sistema.

Los servicios pueden acabar en 'd', un ejemplo es "crond" o "atd", y esto significará que son demonios. Esto también se aplica a servidores "httpd".
    
Los servicios dependen unos de los otros, por eso que sean tan dificiles de matar, por lo que en cuanto el servicio que dependa del otro vea que no responde lo intenta revivir.

```
at                              programar ejecuciones de comando
cron
ll /etc/init.d                  carpeta contenedora de los demonios del sistema
```
--- 
<h4>Sys V.-</h4>

Modo de uso:        service (nombre) (accion)

Ejemplos:
    
```
service --status-all            ver el estado de todos los servicios.
        (servicio) status       nos da información sobre el servicio.
```
---
<h4>systemd.-</h4>

systemctl controla todo el systemd.
    
Modo de uso:        systemctl (accion) (servicio)
    
Ejemplos:
    
```
systemctl list init
          start (servicio)      inicia un servicio.
          unmask (servicio)     desenmascara el servicio.
          restart (servicio)    para reiniciar servicios automáticamente con motivo de hacer cambios en la configuración del servicio.
          reload (servicio)     para reiniciar servicios automáticamente con motivo de hacer cambios en la configuración del servicio, pero sin pararlo.
          stop (servicio)       para un servicio.
          status (servicio)     nos da informacion sobre el servicio.
          
systemctl try-reload-or-restart (servicio)
          
```
