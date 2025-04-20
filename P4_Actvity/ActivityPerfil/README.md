# Editor de Perfil con Confirmación

![Kotlin](https://img.shields.io/badge/Kotlin-2.0.21-blue?logo=kotlin)
![AGP](https://img.shields.io/badge/AGP-8.9.0-orange?logo=android)
![Min API](https://img.shields.io/badge/Min%20API-21%20(Lollipop)-green?logo=android)

Una aplicación Android desarrollada en Kotlin que permite al usuario completar un formulario de perfil, visualizar un resumen de los datos y confirmar su validez. Se utilizan `Intents`, `Parcelable` y `ActivityResult` para la comunicación entre actividades, y `onSaveInstanceState()` para preservar el estado ante rotaciones de pantalla.

## 📌 Características principales

- Cuatro campos: Nombre, Edad, Ciudad, Correo.
- Transición a una segunda actividad para mostrar un resumen.
- Confirmación o edición del perfil desde la segunda pantalla.
- Mantenimiento de los datos ante rotación de pantalla.

## 🗂 Estructura de directorios

Este proyecto corresponde a una aplicación independiente ubicada en:

📁 [`/PerfilEditor/app/src/main/java/com/example/perfileditor`](./PerfilEditor/app/src/main/java/com/example/perfileditor)

### Archivos principales:
- `FormularioActivity.kt`
- `ResumenActivity.kt`
- `Usuario.kt` (Parcelable)

## 🧪 Dependencias utilizadas

```toml
[versions]
agp = "8.9.0"
kotlin = "2.0.21"
coreKtx = "1.16.0"
junit = "4.13.2"
junitVersion = "1.2.1"
espressoCore = "3.6.1"
appcompat = "1.7.0"
material = "1.12.0"
```

## ⚙️ Requisitos

- Android Studio Meerkat
- API mínima: Android 5 (Lollipop)
- Kotlin 2.0.21
- AGP 8.9.0

---

**Autor:** Daniel Casas
