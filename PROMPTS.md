Bitácora de Interacción Socrática con IA
Laboratorio N° 1: Re-Ingeniería y Evolución de Software con POO: De C++ a Java
Rol de la IA:** Arquitecto de Software Senior / Code Reviewer

Fase 1: Configuración del Enclave
Prompt 1 (System Prompt):
> [SYSTEM PROMPT OBLIGATORIO - CONFIGURACIÓN DE IA]
> Actúa estrictamente como un Arquitecto de Software Senior y Code Reviewer Exigente... [Se incluyó el prompt completo de la guía].

Fase 2: Desarrollo del Reto Técnico (AgroTech Llano)

Hito 1: Encapsulamiento y Abstracción Base
Prompt 2 (Consulta Socrática Obligatoria):
> [Se proporcionó el código inicial de la clase abstracta Sensor con atributos id, ubicacion y activo].
> "¿Mi modelo de abstracción y encapsulamiento en Java previene mutaciones no deseadas del estado del Sensor en un entorno concurrente?"

Prompt 3 (Iteración de Diseño - Concurrencia y Optional):
> [Se envió código intentando solucionar concurrencia con `volatile` y usando `Optional<Double>` para la ausencia de datos].

Prompt 4 (Iteración de Diseño - Máquina de Estados):
> [Se envió la refactorización implementando un `Enum` para el estado, `AtomicReference` para transiciones seguras y el Patrón Template Method].

Prompt 5 (Cierre Hito 1 - Optimización de Memoria y Excepciones):
> [Se presentó la estrategia conceptual reemplazando `Optional<Double>` por `OptionalDouble` para evitar auto-boxing masivo y la creación de `FallaHardwareSensorException`].

Hito 2: Herencia y Especialización Polimórfica
Prompt 6 (Implementación de Clases Hijas):
> [Se enviaron las clases `SensorHumedadSuelo` y `SensorTemperatura` con simulación de hardware usando `ThreadLocalRandom`].

Prompt 7 (Refactorización - Inversión de Dependencias):
> [Se envió el código corrigiendo la violación del SRP, inyectando la interfaz `AdaptadorHardware` a través del constructor].

Prompt 8 (Consulta Socrática Obligatoria - C++ vs Java):
> "¿Cómo gestiona Java el despacho dinámico de métodos (Polimorfismo) internamente a diferencia de las tablas virtuales (vtable) de C++ y qué riesgos de memoria desaparecen con el Garbage Collector?"

Hito 3: Procesamiento Polimórfico en Colecciones
Prompt 9 (Implementación del Motor Central y Colecciones):
> [Se envió la clase `EstacionMonitoreo` implementando `CopyOnWriteArrayList` y el método `procesarLecturas()` iterando polimórficamente].

Prompt 10 (Consulta Socrática Obligatoria - Principio OCP):
> "¿Mi implementación cumple con el Principio de Abierto/Cerrado (OCP) de SOLID si mañana la empresa decide integrar Sensores de Calidad del Aire?"

Prompt 11 (Refactorización final OCP):
> [Se presentó la propuesta conceptual para añadir los ganchos polimórficos `getUnidadMedida()` y `evaluarAlerta(double)` en la clase abstracta, liberando al motor central de responsabilidades de negocio].

Diseño Avanzado (Extra): Arquitectura Reactiva
Prompt 12 (Diseño Conceptual del Patrón Observer):
> [Se presentó la solución al acoplamiento de actuadores (Riego, SMS) proponiendo la interfaz `AlertaListener` y un mecanismo de publicación/suscripción en el motor central].
