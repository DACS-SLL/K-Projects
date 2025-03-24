# Evaluación de Empleados

Este proyecto implementa un programa en Kotlin que evalúa el desempeño de los empleados en función de su puntuación en una evaluación semestral. Dependiendo del puntaje obtenido, se determina su nivel de rendimiento y la cantidad de dinero adicional que recibirán, calculada en base a su salario mensual.

## Autor
- **Daniel Casas**

## Fecha de Creación
- 16/03/2025

## Última Actualización
- 16/03/2025

## Funcionalidades
- Leer la puntuación de evaluación del usuario.
- Leer el salario mensual del usuario.
- Determinar el nivel de rendimiento según la puntuación obtenida.
- Calcular la cantidad de dinero adicional a recibir.
- Validar entradas para evitar puntuaciones fuera del rango permitido.

## Niveles de Evaluación
| Nivel       | Puntuación |
|------------|-----------|
| Inaceptable | 0 - 3     |
| Aceptable   | 4 - 6     |
| Meritorio   | 7 - 10    |

La cantidad de dinero adicional se calcula con la fórmula:

```
Dinero = Salario * (Puntuación / 10)
```

### Ejemplo
**Entrada:**
- Salario: $10,000
- Puntuación: 8

**Salida:**
```
Nivel de Rendimiento: Aceptable
Cantidad de Dinero Recibido: $8000.0
```

## Requisitos
- Tener instalado Kotlin en el sistema.
- Un entorno de desarrollo compatible con Kotlin.

## Cómo Ejecutar
1. Clonar este repositorio o descargar el archivo fuente.
2. Abrir un terminal en la carpeta del proyecto.
3. Compilar y ejecutar el código con Kotlin.
4. Seguir las instrucciones en pantalla para ingresar la puntuación y el salario.

## Código Fuente
Se puede ver el código fuente en el archivo Empleado.kt

## Validaciones Implementadas
- Verificación de que la puntuación ingresada esté dentro del rango permitido (0 a 10).
- Manejo de errores para entradas no numéricas.

## Contribuciones
Las contribuciones son bienvenidas. Si deseas mejorar este proyecto, siéntete libre de hacer un fork y enviar un pull request con mejoras o correcciones.
