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

<h2>SERVICIOS Y DEMONIOS LINUX.-</h2>

<h4>Características.-</h4>

Las características principales son:

- Se ejecutan en segundo plano.
- No tienen interfaz, solo se puede interactuar con ellos mediante otra aplicación.
- Suelen ejecutarse en con root.
- "No se pueden matar", de ahí el nombre de demonios.
- Disponibles siempre (no bajo demanda).
- Realizan funciones del sistema.

Los servicios pueden acabar en 'd', un ejemplo es "crond" o "atd", y esto significará que son demonios. Esto también 
se aplica a servidores "httpd".
    
Los servicios dependen unos de los otros, por eso que sean tan dificiles de matar, por lo que en cuanto el servicio que
dependa del otro vea que no responde lo intenta revivir.

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
          restart (servicio)    para reiniciar servicios automáticamente con motivo de hacer cambios en la configuración 
                                del servicio.
          reload (servicio)     para reiniciar servicios automáticamente con motivo de hacer cambios en la configuración
                                del servicio, pero sin pararlo.
          stop (servicio)       para un servicio.
          status (servicio)     nos da informacion sobre el servicio.
          is-active (servicio)  revisa que un servicio esta activo o no.
          is-enable (servicio)  revisa que un servicio esta habilitado para iniciarse cuando la máquina lo hace o no.
          enable (servicio)     habilita un servicio para que se inicie junto a la máquina.
          mask (servicio)       enmascara un servicio, es decir, no deja que el sistema ni otros servicios inicien ese 
                                servicio.
          
systemctl try-reload-or-restart (servicio)      intenta primero recargar el servicio y si no lo reinicia (solo si esta 
                                                activo, si quieres iniciarlo también usa 'reload-or-restart' simplemente).
systemctl list-units --type=service             ve todos los servicios.
systemctl is-active (servicio) ; echo $?        si es 0 está activo y si da superior a 0 está inactivo.

```
> Un servicio "masked" bloquea cualquier intento de iniciar ese servicio.
---
**Niveles de ejecución.-**

Niveles estandar:
- 0  ->  modo apagado.
- 1  ->  monousuario: root,no hay red, no hay entorno gráfico.
- 6  ->  modo reinicio.

Otros niveles:
- 2  ->  multiusuario: root, no hay red, no hay entorno gráfico.
- 3  ->  multiusuario: root, con red, no hay entorno gráfico.
- 4  ->  experimental.
- 5  ->  multiusuario: root, con red y con entorno gráfico.
```
systemctl runlevel(nivel)   inicia la maquina con el nivel que se le asigne
```
---
**Usuarios.-**

La gran mayoría de los usuarios del sistema los crean los servicios. Los servicios normalmente se arrancar con el usuario root, es decir, el usuario real, y en cuanto el servicio está totalmente arrancado se para a otro usuario con permisos limitados, un usuario efectivo.

<h2>SERVICIOS Y DEMONIOS WINDOWS.-</h2>

<h4>TIPO DE INICIO.-</h4>

```
WINDOWS         LINUX       DESCRIPCIÓN
______________  __________  __________________________________________________
auto            enable      se inicia con el arranque del sistema
demand          disabled    no se iniciará con el arranque del sistema
disabled        masked      el sistema ni otro servicio podrán levantarlo
delayed-auto                inicio retardado
```
**Commandos:**

```
sc query                                                lista todos los servicios en "cola" existentes con su información.
sc query | find "NOMBRE_SERVICIO" | find /v "" /c       cantidad de servicios existentes.
sc query | find "NOMBRE_SERVICIO" | find /i "servicio"  encuentra todo servicio que contenga "servicio" en su nombre.
sc query "servicio"                                     muestra la información del servicio.
sc query state="inactive"                               muestra la lista de servicios inactivos.
sc start "servicio"                                     arranca un servicio.
sc pause "servicio"                                     pausa un servicio.
sc qfailure "servicio"                                  protocolo que realiza el servicio en caso de error.
sc qc "servicio"                                        información de arranque del servicio.
sc qdescrition "servicio"                               descripción del servicio.
sc config "servicio"                                    muestra las opciones de configuración del servicio.
```

**Ejecución de tareas programadas en Windows**

```
schtasks                                                muestra las tareas programadas del sistema
schtasks /Create /?                                     muestra las opciones de creación de tareas

schtasks /create /tn Prueba /tr "rutaPrograma" /st 21:15 /sc once  ➡️  realiza una tarea "Prueba" que está en "rutaPrograma" una sola vez a las 21:15
```
