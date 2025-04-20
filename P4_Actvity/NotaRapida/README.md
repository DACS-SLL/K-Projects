# Nota Rápida

![Kotlin](https://img.shields.io/badge/Kotlin-2.0.21-blue?logo=kotlin)
![AGP](https://img.shields.io/badge/AGP-8.9.0-orange?logo=android)
![Min API](https://img.shields.io/badge/Min%20API-21%20(Lollipop)-green?logo=android)

Aplicación en Kotlin que permite al usuario redactar una nota, visualizarla en una segunda pantalla y decidir si desea compartirla o volver a editarla. Utiliza comunicación entre actividades mediante `Intent` y `setResult`, junto con `onSaveInstanceState()` para mantener el contenido al rotar la pantalla.

## 📌 Características principales

- Edición libre de notas.
- Segunda pantalla con resumen y botones:
  - "Compartir por correo"
  - "Editar de nuevo"
- Envío de información entre actividades usando `Intent`.
- Preservación del texto tras rotación de pantalla.

## 🗂 Estructura de directorios

Este proyecto corresponde a una aplicación independiente ubicada en:

📁 [`/app/src/main/java/com/dacs/notarapida`](./app/src/main/java/com/dacs/notarapida)

### Archivos principales:
- `EditAct.kt`
- `OptionsAct.kt`

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
