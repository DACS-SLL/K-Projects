# NweApp

## Descripción
NweApp es una aplicación de Android desarrollada en **Kotlin** que permite la interacción con una imagen y la reproducción de archivos de audio locales.

### **Funcionalidades:**
1. **Interacción con Imagen**: Al hacer clic en la imagen "cats", se muestra un Toast con un mensaje personalizado.
2. **Reproductor de Música**:
   - Botón para **reproducir** el audio.
   - Botón para **pausar** la reproducción.
   - Botón para **detener** la reproducción y reiniciar el audio.
   - Compatible con los archivos de audio **bad_liar.mp3** y **meilleure.mp3**.

## Requisitos
- Android Studio (versión más reciente)
- Kotlin
- SDK de Android (API 24 o superior)

## Instalación y Configuración
1. **Clonar el repositorio**
   ```sh
   git clone https://github.com/DACS-SLL/K-Projects.git
   ```
2. **Abrir en Android Studio**
   - Ir a **File → Open** y seleccionar la carpeta del proyecto.
3. **Agregar los archivos multimedia**
   - Copiar la imagen `cats` en `res/drawable`.
   - Agregar los archivos de audio `bad_liar.mp3` y `meilleure.mp3` en `res/raw`.
4. **Ejecutar la aplicación**
   - Conectar un dispositivo o iniciar un emulador.
   - Hacer clic en **Run** en Android Studio.

## Estructura del Proyecto
```
NweApp/
│-- app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/nweapp/MainActivity.kt
│   │   │   ├── res/
│   │   │   │   ├── layout/activity_main.xml
│   │   │   │   ├── drawable/cats.png
│   │   │   │   ├── raw/bad_liar.mp3
│   │   │   │   ├── raw/meilleure.mp3
│   ├── AndroidManifest.xml
│-- README.md
```

## Uso
- **Interacción con imagen**: Haz clic sobre la imagen "cats" para ver el mensaje emergente.
- **Reproducción de audio**: Usa los botones para controlar la reproducción de los archivos **bad_liar.mp3** y **meilleure.mp3**.

## Tecnologías Utilizadas
- **Kotlin**
- **Android SDK**
- **MediaPlayer API**

## Autor
Daniel Casas - GitHub: DACS-SLL
