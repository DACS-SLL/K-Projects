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

## Estructura del Proyecto

```
app/
├── src/main/
│   ├── java/com/dacs/foodcenter/
│   │   ├── FragPrincipal.kt
│   │   ├── ComidaSelect.kt
│   │   ├── Extras.kt
│   │   ├── ResPedido.kt
│   │   └── MainActivity.kt
│   ├── res/
│   │   ├── layout/
│   │   │   ├── activ_principal.xml
│   │   │   ├── extras.xml
│   │   │   ├── init_frag.xml
│   │   │   ├── res_pedido.xml
│   │   │   └── select_food.xml
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
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
```

### Requisitos del Sistema

- Android 7.0 Nougat (API 24) o superior
- Android Studio Meertat o posterior
- JDK 17
