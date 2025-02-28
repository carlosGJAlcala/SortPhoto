
# SortPhoto

**Descripción:**
SortPhoto es una herramienta desarrollada en Java que organiza tus fotografías en carpetas según el año y el mes en que fueron tomadas. Esta aplicación facilita la gestión y clasificación de imágenes al estructurarlas cronológicamente en tu sistema de archivos.

## Características

- **Organización Automática:** Clasifica y mueve las fotos desde un directorio de origen a una estructura de carpetas basada en la fecha de captura.
- **Soporte de Formatos Comunes:** Compatible con formatos de imagen estándar que contienen metadatos EXIF.
- **Interfaz de Línea de Comandos:** Permite una integración sencilla en scripts y flujos de trabajo automatizados.

## Requisitos Previos

- **Java Development Kit (JDK):** Versión 8 o superior instalada en tu sistema.

## Instalación

1. **Clonar el repositorio:**

   ```bash
   git clone https://github.com/carlosGJAlcala/SortPhoto.git
   cd SortPhoto
   ```

2. **Compilar el proyecto:**
   - Si utilizas Maven como herramienta de construcción:

     ```bash
     mvn clean install
     ```

   - Si prefieres compilar manualmente:

     ```bash
     javac -d bin src/com/yourpackage/*.java
     ```

3. **Ejecutar la aplicación:**
   - Con Maven:

     ```bash
     mvn exec:java -Dexec.mainClass="com.yourpackage.Main"
     ```

   - Sin Maven:

     ```bash
     java -cp bin com.yourpackage.Main
     ```

## Uso

Para ejecutar SortPhoto, debes proporcionar dos argumentos en la línea de comandos:

1. **Directorio de origen:** Ruta al directorio que contiene las fotos desordenadas.
2. **Directorio de destino:** Ruta al directorio donde se crearán las carpetas organizadas.

Ejemplo de uso:

```bash
java -jar SortPhoto.jar /ruta/al/directorio/origen /ruta/al/directorio/destino
```

El programa procesará las imágenes en el directorio de origen y las moverá al directorio de destino, organizándolas en subcarpetas con el formato `Año/Mes` (por ejemplo, `2025/Enero`).

## Contribuciones

Las contribuciones son bienvenidas. Si deseas colaborar:

1. Realiza un fork de este repositorio.
2. Crea una nueva rama para tus cambios (`git checkout -b feature/nueva-funcionalidad`).
3. Realiza tus modificaciones y haz commit de los cambios (`git commit -m 'Añadir nueva funcionalidad'`).
4. Envía un pull request detallando las modificaciones propuestas.

## Licencia

Este proyecto se distribuye bajo la licencia MIT. Para más detalles, consulta el archivo `LICENSE` en el repositorio.

---

