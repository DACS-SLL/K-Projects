# 🧠 Simon Dice App 🎮

Una aplicación interactiva desarrollada en **Kotlin con Android Studio Meerkat** que simula el clásico juego “Simón Dice/Juego de colores”. Esta app reta la memoria visual del usuario mediante colores y niveles dinámicos de dificultad.

---

## 🚀 Características principales

- 🎨 Interfaz dividida en múltiples fragments con navegación estructurada.
- ⏱️ Temporizador de 30 segundos para lograr el mayor puntaje posible.
- ✅ Sistema de puntaje por aciertos con feedback sonoro y visual.
- 🧪 Sistema de niveles de dificultad basado en el Efecto Stroop.
- 🔊 Integración de sonidos: música de fondo, efectos de acierto/error y lectura de texto.
- 💾 Almacenamiento local del puntaje más alto y preferencias de sonido con `SharedPreferences`.
- ⚙️ Pantalla de configuración para activar/desactivar sonido.
- 💡 Animaciones sutiles y diseño responsivo con `ConstraintLayout`.

---

## 🧱 Estructura del proyecto

```
com.dacs.simondiceapp
│
├── data/
│   └── PreferencesManager.kt     # Gestión de puntaje y preferencias
│   
├── managers/  
|   └── SettingsManager.kt     # Interfaz de usuario para opciones
│
├── ui/
│   ├── game/
│   │   └── GameFragment.kt
│   ├── result/
│   │   └── ResultFragment.kt
│   ├── settings/
│   │   └── SettingsFragment.kt
│   ├── welcome/
│   │   └── WelcomeFragment.kt
│   ├── util/
│   │   └── SoundManager.kt          # Control global de sonidos
│
├── res/
│   ├── anim/                  # Archivos .xml para animaciones de cambios
│   ├── font/                  # Fuentes cargadas por el usuario
│   ├── layout/                  # Archivos .xml de diseño por fragmento
│   ├── raw/                     # Archivos de sonido (deben ser importados)
│   ├── values/                  # colors.xml, themes.xml, strings.xml
│   └── navigation/             # nav_graph.xml (gestión de navegación)
│
└── MainActivity.kt             # Contenedor de fragments
```

---

## 🛠️ Tecnologías y herramientas

- Lenguaje: [Kotlin](https://kotlinlang.org/)
- IDE: [Android Studio Meerkat](https://developer.android.com/studio)
- UI: ConstraintLayout
- Almacenamiento: SharedPreferences
- Sonidos: MediaPlayer
- Animaciones: View.animate() y efectos básicos

---

## 📲 Requisitos

- Android Studio Meerkat
- SDK mínimo: API 21 (Android 50)
- Kotlin 1.9+

---

## 📦 Recursos que debes importar

- 🎵 Archivos de sonido (`.mp3`) a la carpeta `res/raw`:
  - Música de fondo
  - Sonido de acierto
  - Sonido de error
  - Sonido de botón inicial

---

## 👨‍💻 Autor

- Daniel Casas Soto — [Desarrollador principal y diseñador de la lógica del juego + Estilos]

---