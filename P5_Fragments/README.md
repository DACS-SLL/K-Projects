# FoodCenter - Configurador de Pedidos de Comida

![Android](https://img.shields.io/badge/Android-7.0%2B-brightgreen)
![Kotlin](https://img.shields.io/badge/Kotlin-1.8.0-blue)
![Material Components](https://img.shields.io/badge/Material%20Components-1.9.0-6200EE)

Aplicación Android para armar pedidos de comida paso a paso, implementada con Fragments y Navigation Component.

## Características Principales

- 🛒 Flujo de pedido en 4 pasos:
  1. Pantalla de inicio
  2. Selección de comida principal
  3. Elección de extras
  4. Resumen y confirmación

- 🔄 Navegación entre fragments con:
  - Paso de datos mediante Bundles
  - Regreso con `popBackStack()`
  - Comunicación fragment-to-fragment

- 🎨 Interfaz con Material Design:
  - Temas para modo claro/oscuro
  - Componentes estilizados
  - Diseño responsive

## Estructura del Proyecto

```
app/
├── src/main/
│   ├── java/com/dacs/foodcenter/
│   │   ├── fragments/
│   │   │   ├── InicioFragment.kt
│   │   │   ├── SeleccionComidaFragment.kt
│   │   │   ├── SeleccionExtrasFragment.kt
│   │   │   └── ResumenPedidoFragment.kt
│   │   ├── MainActivity.kt
│   │   └── FoodCenterApplication.kt
│   ├── res/
│   │   ├── layout/
│   │   │   ├── activity_main.xml
│   │   │   ├── fragment_*.xml
│   │   ├── navigation/
│   │   │   └── nav_graph.xml
│   │   ├── values/
│   │   │   ├── colors.xml
│   │   │   ├── strings.xml
│   │   │   └── themes.xml
```

## Configuración Técnica

### Dependencias Principales

```gradle
dependencies {
    implementation 'androidx.core:core-ktx:1.10.1'
    implementation 'androidx.appcompat:appcompat:1.6.1'
    implementation 'com.google.android.material:material:1.9.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
    implementation 'androidx.navigation:navigation-fragment-ktx:2.7.5'
    implementation 'androidx.lifecycle:lifecycle-runtime-ktx:2.6.2'
}
```

### Requisitos del Sistema

- Android 7.0 Nougat (API 24) o superior
- Android Studio Flamingo (2022.2.1) o posterior
- JDK 17
