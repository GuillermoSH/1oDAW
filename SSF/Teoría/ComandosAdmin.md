<h1>COMANDOS LINUX ADMINISTRACION</h1>

<h2>APT.-</h2>

```
apt search                  buscar entre los repositorios en línea
    version                 version del paquete instalada
    list                    todos los repositorios en general
    list --installed        todos los repositorios instalados
    list --all--versions    todos los repositorios con sus diferentes versiones
    list --upgradeable      todos los repositorios que se pueden actualizar
    remove                  desinstala sin borrar la configuración                      
    autoremove              desinstala todas las dependencias que no se estan usando
    purge                   desinstala todo
    update                  actualiza la lista de paquetes disponibles para instalar
    upgrade                 actualiza todos los paquetes instalados
    full-upgrade            quita, actualiza e instala cualquier paquete
    dist-upgrade            igual que upgrade, pero consultando sobre la configuración
    hold                    no se va a actualizar si haces una actualizacion
    unhold                  quitar la retención
    show                    dará información sobre la instalación del paquete
    check                   
```

<h3>Ejemplos:</h3>

```
  apt search vlc            buscar repositorios que contengan "vlc"
            p               se puede instalar
            i               instalado
            c               se desinstalo pero se quedo la configuración
            v               paquete virtual (reune caracteristicas de varios paquetes)

  apt install mysql-server  instalar el repositorio mysql

  apt remove vlc            quita solo el repositorio de vlc sin quitar todas las dependencias
```
<h2>APTITUDE.-</h2>

```
aptitude                    igual que el apt pero con una interfaz gráfica
```
