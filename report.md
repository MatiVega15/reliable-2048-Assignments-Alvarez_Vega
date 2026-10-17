***Seminario en Ciencias de la Computación.***  
***Departamento de Computación.***  
***Facultad de Ciencias Exactas, Físico-Químicas y Naturales.***  
***Universidad Nacional de Río Cuarto.***  
***ÁLVAREZ, Joel Facundo - VEGA, Matías Thomas - Año 2026.***

# ***Informe y reportes de Assignments***

Este documento resume el **proceso realizado sobre la implementación del juego 2048** a lo largo de los diferentes **Assignments** de la materia.

En el **Assignment 1** se desarrollaron pruebas unitarias, se identificaron y corrigieron bugs y se realizaron refactorizaciones sobre la implementación.

En el **Assignment 2** se profundizó el análisis de la calidad de las pruebas mediante métricas de cobertura y mutación, se incorporó la generación automática de pruebas con Randoop y se implementaron invariantes de representación mediante `repOk ()` y `@CheckRep`.

En el **Assignment 3** se incorporaron dos técnicas adicionales de testing automatizado: la generación evolutiva de pruebas mediante EvoSuite y el Fuzzing de la interfaz de línea de comandos. Estas técnicas se analizaron y compararon con las suites desarrolladas anteriormente.

En el **Assignment 4** se exploró la inferencia dinámica de invariantes utilizando la herramienta Daikon. Se recolectaron trazas de ejecución a partir de pruebas manuales, automáticas y rutinas de fuzzing, para luego evaluar los invariantes inferidos y determinar su utilidad como oráculos de prueba en comparación con las aserciones estáticas desarrolladas previamente.

---

# **Assignment 1 (Software Testing Exercise)**

Este documento resume el **proceso de testing, detección y corrección de bugs y refactorización** realizado sobre la implementación del juego 2048.

El trabajo se desarrolló siguiendo las **cuatro fases** propuestas en la consigna:

1. Implementación de tests unitarios.
2. Detección y documentación de bugs.
3. Corrección de bugs y pruebas de regresión.
4. Identificación y refactorización de problemas de diseño.

## ***Fase 1: Implementación de tests unitarios***

Se comenzó implementando **tests unitarios** para las clases principales del juego.

Los tests pueden revisarse en:

- [Tests para la clase `Cell`.](src/test/java/ar/edu/unrc/game2048/CellTest.java)
- [Tests para la clase `Board`.](src/test/java/ar/edu/unrc/game2048/BoardTest.java)

Se procuró **cubrir todos los métodos públicos** de las clases testeadas, incluyendo diferentes casos normales, casos límite y situaciones que pudieran revelar comportamientos incorrectos.

Para evaluar la calidad de las pruebas **se utilizó JaCoCo**, buscando alcanzar una **cobertura completa de sentencias y ramas**, con el fin de **aumentar las posibilidades de detectar errores** existentes en la implementación.

## ***Fase 2: Detección y documentación de bugs***

Los comportamientos incorrectos detectados mediante la ejecución de los tests fueron documentados individualmente mediante **Issues de GitHub**, utilizando la etiqueta `bug`.

Cada Issue inicialmente contiene:

- Una descripción del comportamiento incorrecto.
- La forma en que se detectó el problema.
- La causa probable del error.

Las Issues de bugs pueden consultarse en la sección correspondiente de [Issues cerradas.](https://github.com/Seminario-en-Ciencias-de-la-Computacion/basic-design-implementation-and-testing-assignment-alvarez-vega/issues?q=is%3Aissue+is%3Aclosed+label%3Abug)

## ***Fase 3: Corrección de bugs y pruebas de regresión***

Luego de identificar los errores, se realizaron las **correcciones correspondientes en el código fuente**.

Para cada bug, se realizó el siguiente **procedimiento**:

1. Se identificó la ubicación del error en el código.
2. Se realizó la modificación necesaria para corregirlo.
3. Se ejecutó nuevamente el test que había detectado el problema.
4. Se ejecutó la suite completa de tests para realizar pruebas de regresión.
5. Se creó un commit descriptivo asociado a la Issue correspondiente.
6. La Issue fue cerrada mediante el mensaje del commit, vinculándola con la corrección realizada. 

Luego de eso, **se actualizó la Issue** para dejar documentado:

- La corrección aplicada.
- La verificación realizada.

De esta manera, cada bug corregido queda documentado y vinculado con su Issue actualizada y con el commit que implementa su solución.

## ***Fase 4: Identificación y refactorización de problemas de diseño***

Luego de completar la corrección de los bugs, se realizó un **análisis del código** para identificar posibles problemas de diseño.

Los problemas encontrados fueron documentados mediante **Issues de GitHub** utilizando la etiqueta `refactor`.

Cada Issue inicialmente contiene:

- Una descripción del problema detectado.
- Su impacto en el diseño.
- Una posible estrategia de refactorización.
- Los criterios de aceptación a cumplir por la refactorización.

Para las refactorizaciones seleccionadas para su implementación, se realizó un proceso incremental, ejecutando la suite completa de tests durante y después de los cambios. Todos los tests continuaron pasando correctamente.

Una vez finalizada cada refactorización, se creó un **commit asociado a su Issue correspondiente**, utilizando el mensaje del commit para cerrar la Issue.

Posteriormente, la Issue fue actualizada agregando:

- Refactorización realizada.
- Verificación.
- Alternativa considerada (opcional).
- Criterios de aceptación cumplidos.

Las refactorizaciones identificadas que no fueron seleccionadas para implementar permanecen **abiertas** ([Issues abiertas](https://github.com/Seminario-en-Ciencias-de-la-Computacion/basic-design-implementation-and-testing-assignment-alvarez-vega/issues?q=is%3Aissue+is%3Aopen+label%3Arefactor)), mientras que las que fueron implementadas se encuentran documentadas y **cerradas** ([Issues cerradas](https://github.com/Seminario-en-Ciencias-de-la-Computacion/basic-design-implementation-and-testing-assignment-alvarez-vega/issues?q=is%3Aissue+is%3Aclosed+label%3Arefactor)).

---

# **Assignment 2 (Advanced Testing - Coverage, Mutation and Test Generation)**

Este apartado detalla la segunda etapa del proyecto, enfocada en la **medición exhaustiva, el análisis de mutaciones y la automatización de pruebas** para robustecer la confiabilidad del juego.

El trabajo se desarrolló siguiendo las **tres fases** propuestas en la consigna:

1. Revisión inicial de métricas de cobertura y mutación.
2. Mejora de la calidad de los tests.
3. Generación automática de pruebas mediante Randoop e implementación de invariantes de representación (`repOk ()`).

## ***Fase 1: Revisión inicial de métricas de cobertura***

Partiendo del Assignment 1, se estableció una línea base ejecutando la suite de pruebas existente. La herramienta **JaCoCo** arrojó un **100% de cobertura de sentencias y ramas** para las clases principales del dominio (`Board` y `Cell`):

| GROUP | PACKAGE | CLASS | INSTRUCTION MISSED | INSTRUCTION COVERED | BRANCH MISSED | BRANCH COVERED | LINE MISSED | LINE COVERED | COMPLEXITY MISSED | COMPLEXITY COVERED | METHOD MISSED | METHOD COVERED |
|---|---|---|---:|---:|---:|---:|---:|---:|---:|---:|---:|---:|
| 2048-game | ar.edu.unrc.game2048 | Cell | 0 | 132 | 0 | 28 | 0 | 23 | 0 | 24 | 0 | 10 |
| 2048-game | ar.edu.unrc.game2048 | Board.Direction | 0 | 27 | 0 | 0 | 0 | 2 | 0 | 1 | 0 | 1 |
| 2048-game | ar.edu.unrc.game2048 | Board | 0 | 906 | 0 | 116 | 0 | 152 | 0 | 82 | 0 | 24 |
| 2048-game | ar.edu.unrc.game2048 | Board.Position | 0 | 62 | 0 | 10 | 0 | 10 | 0 | 9 | 0 | 4 |

Posteriormente, se ejecutó un análisis de mutación utilizando **PITest** para evaluar la fortaleza de los oráculos. La métrica base reveló una **cobertura del 100% en `Cell`**, pero identificó **15 mutantes sobrevivientes en la clase `Board`**, estableciendo un **90% de cobertura inicial**:

| Name         | Line Coverage | Mutation Coverage | Test Strength |
|--------------|---:|---:|---:|
| Board.java   | 100% (162/162) | 90% (140/155) | 90% (140/155) |
| Cell.java    | 100% (23/23) | 100% (28/28) | 100% (28/28) |

*(Nota: La clase `MainCLI` fue excluida del reporte al no formar parte de los objetivos de testing de dominio).*

## ***Fase 2: Mejora de la calidad de los tests***

Para alcanzar el 100% de cobertura de mutación y eliminar los mutantes sobrevivientes de la clase `Board`, se analizó el reporte de PITest y se procedió a **fortalecer la suite de pruebas y refactorizar el código fuente** mediante las siguientes estrategias.

- Se agregaron casos de prueba en la clase [`BoardTest`](src/test/java/ar/edu/unrc/game2048/BoardTest.java) para cubrir los escenarios faltantes. Principalmente, se incorporaron validaciones que verificaran explícitamente los **índices perimetrales** (por ejemplo, la coordenada '0'), en donde se encontraban la mayoría de los mutantes que lograban sobrevivir.
- Se **refactorizaron** sectores específicos de la implementación de la clase [`Board`](src/main/java/ar/edu/unrc/game2048/Board.java) para limpiar código inalcanzable y corregir lógicas propensas a generar fallos silenciosos.
- Se **delegó la responsabilidad de generación de fichas** a una interfaz [`TileStrategy`](src/main/java/ar/edu/unrc/game2048/TileStrategy.java). Se implementaron las clases [`RandomTileStrategy`](src/main/java/ar/edu/unrc/game2048/RandomTileStrategy.java) (para preservar la jugabilidad en producción con aleatoriedad) y [`DeterministicTileStrategy`](src/main/java/ar/edu/unrc/game2048/DeterministicTileStrategy.java) (para eliminar la aleatoriedad en testing). Este cambio permitió inyectar comportamientos controlados y testear probabilidades matemáticas de forma exacta.

Como resultado de este proceso, se logró alcanzar un **100% de cobertura de mutación, sentencias y ramas** en todas las clases evaluadas: 

### ***Métricas de Cobertura de Código (JaCoCo)***

| GROUP | PACKAGE | CLASS | INSTRUCTION MISSED | INSTRUCTION COVERED | BRANCH MISSED | BRANCH COVERED | LINE MISSED | LINE COVERED | COMPLEXITY MISSED | COMPLEXITY COVERED | METHOD MISSED | METHOD COVERED |
|---|---|---|---:|---:|---:|---:|---:|---:|---:|---:|---:|---:|
| 2048-game | ar.edu.unrc.game2048 | Cell | 0 | 132 | 0 | 28 | 0 | 23 | 0 | 24 | 0 | 10 |
| 2048-game | ar.edu.unrc.game2048 | Board.Direction | 0 | 27 | 0 | 0 | 0 | 2 | 0 | 1 | 0 | 1 |
| 2048-game | ar.edu.unrc.game2048 | RandomTileStrategy | 0 | 37 | 0 | 2 | 0 | 8 | 0 | 5 | 0 | 4 |
| 2048-game | ar.edu.unrc.game2048 | Board | 0 | 909 | 0 | 114 | 0 | 163 | 0 | 82 | 0 | 25 |
| 2048-game | ar.edu.unrc.game2048 | Board.Position | 0 | 62 | 0 | 10 | 0 | 10 | 0 | 9 | 0 | 4 |
| 2048-game | ar.edu.unrc.game2048 | DeterministicTileStrategy | 0 | 45 | 0 | 10 | 0 | 13 | 0 | 8 | 0 | 3 |

### ***Métricas de Cobertura de Mutación (PITest)***

| Name | Line Coverage | Mutation Coverage | Test Strength |
|---|---:|---:|---:|
| Board.java | 100% (173/173) | 100% (145/145) | 100% (145/145) |
| Cell.java | 100% (23/23) | 100% (28/28) | 100% (28/28) |
| DeterministicTileStrategy.java | 100% (13/13) | 100% (8/8) | 100% (8/8) |
| RandomTileStrategy.java | 100% (8/8) | 100% (4/4) | 100% (4/4) |

## ***Fase 3.1: Generación Automática de Pruebas (Randoop)***

En esta etapa se empleó la **herramienta Randoop** para la exploración del dominio y la generación automatizada de casos de prueba sobre las clases `Board`, `Cell` y `DeterministicTileStrategy`. La clase `RandomTileStrategy` no fue considerada, debido a que su comportamiento depende de la generación de valores aleatorios y podría introducir **flakiness (comportamiento inestable)** en las pruebas generadas.

Durante las ejecuciones iniciales se observó que los constructores por defecto de la clase `Board` (`Board ()` y `Board (int)`) instancian internamente una `RandomTileStrategy`. En consecuencia, los objetos `Board` creados mediante estos constructores pueden presentar **estados iniciales diferentes entre ejecuciones**, dificultando la reproducibilidad en las pruebas generadas.

Para garantizar la total confiabilidad y reproducibilidad de la suite, se aplicó una **restricción durante la generación**: se indicó a Randoop que **no utilizara los constructores `Board ()` y `Board (int)`**, especificando sus firmas mediante el argumento `--omit-methods`. De esta forma, Randoop pudo utilizar el constructor `Board (int, TileStrategy)` **e instanciar los tableros inyectando explícitamente la `DeterministicTileStrategy`** desarrollada en la fase 2.

El comando utilizado fue:

```bash
java -cp "lib/randoop-all-4.3.4.jar:target/classes" randoop.main.Main gentests --testclass=ar.edu.unrc.game2048.Cell --testclass=ar.edu.unrc.game2048.Board --testclass=ar.edu.unrc.game2048.DeterministicTileStrategy --omit-methods="ar.edu.unrc.game2048.Board\(\)" --omit-methods="ar.edu.unrc.game2048.Board\(int\)" --time-limit=30 --junit-output-dir=src/test/java --junit-package-name=randoopTestsSinRepOk
```

Como resultado, durante un **tiempo límite de 30 segundos**, Randoop generó exitosamente una suite de regresión, [`RegressionTest0.java`](src/test/java/randoopTestsSinRepOk/RegressionTest0.java), compuesta por **45 casos de prueba** completamente reproducibles.

Para evaluar la efectividad de la generación automática de pruebas de manera aislada, **se ejecutó exclusivamente la suite generada por Randoop mediante Maven**. Se obtuvieron los siguientes resultados de cobertura estructural y de mutación.

### ***Cobertura exclusiva de Randoop (JaCoCo)***

```bash
mvn clean test jacoco:report "-Dtest=randoopTestsSinRepOk.RegressionTest0"
```

| GROUP | PACKAGE | CLASS | INSTRUCTION MISSED | INSTRUCTION COVERED | BRANCH MISSED | BRANCH COVERED | LINE MISSED | LINE COVERED | COMPLEXITY MISSED | COMPLEXITY COVERED | METHOD MISSED | METHOD COVERED |
|---|---|---|---:|---:|---:|---:|---:|---:|---:|---:|---:|---:|
| 2048-game | ar.edu.unrc.game2048 | Cell | 34 | 98 | 9 | 19 | 4 | 19 | 9 | 15 | 1 | 9 |
| 2048-game | ar.edu.unrc.game2048 | Board.Direction | 0 | 27 | 0 | 0 | 0 | 2 | 0 | 1 | 0 | 1 |
| 2048-game | ar.edu.unrc.game2048 | Board | 111 | 798 | 24 | 90 | 17 | 146 | 24 | 58 | 5 | 20 |
| 2048-game | ar.edu.unrc.game2048 | Board.Position | 17 | 45 | 6 | 4 | 1 | 9 | 6 | 3 | 1 | 3 |
| 2048-game | ar.edu.unrc.game2048 | DeterministicTileStrategy | 2 | 43 | 1 | 9 | 1 | 12 | 1 | 7 | 0 | 3 |

### ***Cobertura exclusiva de Randoop (PITest)***

```bash
mvn pitest:mutationCoverage "-DtargetTests=randoopTestsSinRepOk.RegressionTest0"
```

| Name | Line Coverage | Mutation Coverage | Test Strength |
|---|---:|---:|---:|
| Board.java | 90% (156/173) | 63% (92/145) | 74% (92/124) |
| Cell.java | 83% (19/23) | 64% (18/28) | 75% (18/24) |
| DeterministicTileStrategy.java | 92% (12/13) | 38% (3/8) | 38% (3/8) |

### ***Análisis de resultados***

Al analizar las métricas obtenidas exclusivamente a partir de las pruebas generadas por Randoop, se observa un **contraste importante con respecto a la suite manual** desarrollada en la fase 2. Si bien la generación automática **logró una cobertura de líneas y ramas considerable**, la **cobertura de mutación fue significativamente menor**.

Esto evidencia una de las **principales limitaciones de la generación aleatoria de pruebas**: las secuencias generadas pueden alcanzar y ejecutar una parte considerable del código y de sus caminos lógicos, pero **no necesariamente producen aserciones suficientemente precisas** para detectar comportamientos incorrectos. En otras palabras, una prueba puede ejecutar una determinada funcionalidad sin verificar de manera efectiva que el resultado obtenido sea el esperado.

## ***Fase 3.2: Implementación de invariantes de representación***

Como parte de la etapa de generación automática de pruebas, **se incorporó un método `repOk ()`** en las clases [`Cell`](src/main/java/ar/edu/unrc/game2048/Cell.java) y [`Board`](src/main/java/ar/edu/unrc/game2048/Board.java). Este método permite **verificar que los objetos se encuentren en un estado consistente con sus invariantes de representación**.

En la clase `Cell`, se verifica que **el valor de la celda sea no negativo** y que, cuando sea distinto de cero, corresponda a una **potencia de dos**.

En la clase `Board` se verifican los siguientes invariantes:

- `size` debe ser mayor que cero.
- `grid` no debe ser `null`.
- La matriz `grid` debe tener tamaño `size x size`.
- `score` debe ser mayor o igual que cero.
- Ninguna fila de `grid` debe ser `null` y todas deben tener el tamaño correspondiente.
- Ninguna celda debe ser `null`.
- Cada celda debe cumplir su propio `repOk ()`.
- `TileStrategy` debe estar definida.

Además de verificar los estados válidos durante las pruebas existentes, **se agregaron casos específicos para comprobar que `repOk ()` detecta correctamente distintas violaciones de estos invariantes**.

Para alcanzar estas situaciones inválidas **se utilizó reflexión**, ya que algunas de ellas no pueden producirse mediante la interfaz pública de `Board`: el constructor impide crear tableros con tamaños no positivos y garantiza inicialmente la correcta inicialización de la matriz. La reflexión permitió **modificar deliberadamente la representación interna y comprobar el comportamiento defensivo** de `repOk ()`.

### ***Regeneración de pruebas con Randoop***

Una vez incorporados los métodos `repOk ()`, se volvió a **ejecutar Randoop** para analizar cómo la disponibilidad de estos métodos afectaba la exploración automática del dominio.

Se mantuvieron las **mismas restricciones utilizadas en la primera ejecución**: no se incluyeron los constructores `Board ()` y `Board (int)`, debido a que utilizan internamente `RandomTileStrategy`. En su lugar, Randoop utilizó el constructor `Board (int, TileStrategy)`, permitiendo trabajar con `DeterministicTileStrategy` y mantener la reproducibilidad de las pruebas.

El comando utilizado fue:

```bash
java -cp "lib/randoop-all-4.3.4.jar:target/classes" randoop.main.Main gentests --testclass=ar.edu.unrc.game2048.Cell --testclass=ar.edu.unrc.game2048.Board --testclass=ar.edu.unrc.game2048.DeterministicTileStrategy --omit-methods="ar.edu.unrc.game2048.Board\(\)" --omit-methods="ar.edu.unrc.game2048.Board\(int\)" --time-limit=30 --junit-output-dir=src/test/java --junit-package-name=randoopTestsConRepOk
```

La ejecución finalizó correctamente luego de un **tiempo límite de 30 segundos**. Randoop exploró las tres clases indicadas y generó **523 casos de prueba de regresión**, distribuidos entre [`RegressionTest0.java`](src/test/java/randoopTestsConRepOk/RegressionTest0.java) y [`RegressionTest1.java`](src/test/java/randoopTestsConRepOk/RegressionTest1.java).

### ***Cobertura estructural de la nueva suite de Randoop***

Para evaluar exclusivamente la nueva suite generada por Randoop, se ejecutaron `RegressionTest0.java` y `RegressionTest1.java` mediante Maven:

```bash
mvn clean test jacoco:report "-Dtest=randoopTestsConRepOk.RegressionTest0,randoopTestsConRepOk.RegressionTest1"
```

Los **resultados obtenidos mediante JaCoCo** fueron:

| GROUP | PACKAGE | CLASS | INSTRUCTION MISSED | INSTRUCTION COVERED | BRANCH MISSED | BRANCH COVERED | LINE MISSED | LINE COVERED | COMPLEXITY MISSED | COMPLEXITY COVERED | METHOD MISSED | METHOD COVERED |
|---|---|---|---:|---:|---:|---:|---:|---:|---:|---:|---:|---:|
| 2048-game | ar.edu.unrc.game2048 | Cell | 13 | 133 | 3 | 31 | 1 | 23 | 4 | 24 | 1 | 10 |
| 2048-game | ar.edu.unrc.game2048 | Board.Direction | 0 | 27 | 0 | 0 | 0 | 2 | 0 | 1 | 0 | 1 |
| 2048-game | ar.edu.unrc.game2048 | Board | 234 | 750 | 37 | 99 | 39 | 142 | 30 | 64 | 4 | 22 |
| 2048-game | ar.edu.unrc.game2048 | Board.Position | 2 | 60 | 3 | 7 | 0 | 10 | 3 | 6 | 0 | 4 |
| 2048-game | ar.edu.unrc.game2048 | DeterministicTileStrategy | 2 | 43 | 1 | 9 | 1 | 12 | 1 | 7 | 0 | 3 |

### ***Cobertura de mutación de la nueva suite de Randoop***

Finalmente, se utilizó **PITest** para evaluar la capacidad de la nueva suite automática para detectar modificaciones artificiales en el código:

```bash
mvn pitest:mutationCoverage "-DtargetTests=randoopTestsConRepOk.RegressionTest0,randoopTestsConRepOk.RegressionTest1"
```

Los resultados obtenidos fueron:

| Name | Line Coverage | Mutation Coverage | Test Strength |
|---|---:|---:|---:|
| Board.java | 80% (152/191) | 69% (116/168) | 89% (116/130) |
| Cell.java | 96% (23/24) | 91% (30/33) | 97% (30/31) |
| DeterministicTileStrategy.java | 92% (12/13) | 88% (7/8) | 88% (7/8) |

### ***Análisis de resultados***

Al comparar los resultados obtenidos con la suite inicial de Randoop y la nueva suite generada luego de incorporar los métodos `repOk ()`, se observa una **mejora general en la efectividad de las pruebas, especialmente en términos de cobertura de mutación**.

En primer lugar, la cantidad de pruebas generadas aumentó considerablemente: **la primera ejecución produjo 45 casos de prueba, mientras que la nueva ejecución generó 523 casos de prueba**. Esto representa una exploración mucho más amplia de las combinaciones de operaciones y estados posibles de las clases analizadas.

En cuanto a la cobertura estructural medida con JaCoCo, se observa una mejora en algunas clases. En `Cell`, por ejemplo, la **cobertura de instrucciones** pasó de aproximadamente **74% a 91%**, mientras que la **cobertura de ramas** pasó de aproximadamente **68% a 91%**. En `Board.Position` la **cobertura de instrucciones** pasó de aproximadamente **71% a 97%**, y la **cobertura de ramas** pasó de **40% a 70%**. Por su parte, `DeterministicTileStrategy` mantuvo una cobertura elevada, con más del **95% de instrucciones cubiertas** y un **90% de ramas cubiertas**.

En `Board` se observa una situación diferente: **aunque la cantidad absoluta de ramas cubiertas aumentó, el porcentaje de cobertura disminuyó**. Esto se debe principalmente a que la incorporación de `repOk ()` y del código asociado a la verificación de invariantes **incrementó la cantidad total de código** que puede ser cubierto. Por ejemplo, la cantidad de ramas cubiertas pasó de 90 a 99. Por lo tanto, **el porcentaje de cobertura no debe interpretarse de manera aislada como un empeoramiento de las pruebas**. Además, la nueva suite contiene 523 pruebas frente a las 45 anteriores, por lo que representa una exploración considerablemente mayor del comportamiento del sistema.

La mejora más significativa se observa en la cobertura de mutación obtenida con **PITest**. En `Board`, la **cobertura de mutación** aumentó de **63% a 69%**, mientras que en `Cell` pasó de **64% a 91%**. La mejora más importante se produjo en `DeterministicTileStrategy`, donde aumentó de **38% a 88%**. También mejoró considerablemente el **Test Strength**, pasando de **74% a 89%** en `Board`, de **75% a 97%** en `Cell` y de **38% a 88%** en `DeterministicTileStrategy`.

El aumento de la cobertura de mutación indica que la nueva suite no solo explora más código, sino que también posee una **mayor capacidad para detectar comportamientos incorrectos**.

En conclusión, **la nueva ejecución de Randoop produjo una mejora sustancial en la calidad y capacidad de detección de las pruebas**, aún cuando no todas las métricas porcentuales de cobertura estructural aumentaron. La diferencia entre ambas ejecuciones también muestra que **un mayor número de pruebas no implica necesariamente un aumento proporcional de la cobertura de código**: al incorporar nuevos comportamientos e invariantes, también aumenta el código que debe ser cubierto. Por ese motivo, en este caso resulta especialmente importante **analizar conjuntamente la cobertura estructural, la cobertura de mutación y el Test Strength**.

## ***Fase 3.3: Incorporación de `@CheckRep` y nueva generación de pruebas***

Como etapa final del experimento con Randoop, **se incorporó la anotación `@CheckRep` sobre los métodos `repOk ()` de las clases `Cell` y `Board`**.

La anotación permite indicar explícitamente a Randoop que dichos métodos corresponden a **chequeos de la representación de los objetos**. De esta manera, **Randoop debe utilizar los invariantes de representación** durante la exploración del dominio y durante la generación de las secuencias de prueba.

Se mantuvieron las mismas **restricciones utilizadas en las ejecuciones anteriores**: no se incluyeron los constructores `Board ()` y `Board (int)`, debido a que utilizan internamente `RandomTileStrategy`. En su lugar, Randoop utilizó el constructor `Board (int, TileStrategy)`, permitiendo trabajar con `DeterministicTileStrategy` y mantener la reproducibilidad de las pruebas.

El comando utilizado fue:

```bash
java -cp "lib/randoop-all-4.3.4.jar:target/classes" randoop.main.Main gentests --testclass=ar.edu.unrc.game2048.Cell --testclass=ar.edu.unrc.game2048.Board --testclass=ar.edu.unrc.game2048.DeterministicTileStrategy --omit-methods="ar.edu.unrc.game2048.Board\(\)" --omit-methods="ar.edu.unrc.game2048.Board\(int\)" --time-limit=30 --junit-output-dir=src/test/java --junit-package-name=randoopTestsConCheckRep
```

La generación produjo una **suite [`RegressionTest0.java`](src/test/java/randoopTestsConCheckRep/RegressionTest0.java) compuesta por 41 casos de prueba**.

### ***Cobertura estructural de Randoop con `@CheckRep` (JaCoCo)***

Para medir la cobertura producida exclusivamente por esta suite se ejecutó:

```bash
mvn clean test jacoco:report "-Dtest=randoopTestsConCheckRep.RegressionTest0"
```

Los resultados obtenidos fueron:

| Group | Package | Class | Instruction Missed | Instruction Covered | Branch Missed | Branch Covered | Line Missed | Line Covered | Complexity Missed | Complexity Covered | Method Missed | Method Covered |
|---|---|---|---:|---:|---:|---:|---:|---:|---:|---:|---:|---:|
| 2048-game | ar.edu.unrc.game2048 | Cell | 70 | 95 | 18 | 16 | 7 | 17 | 15 | 13 | 2 | 9 |
| 2048-game | ar.edu.unrc.game2048 | Board.Direction | 0 | 44 | 0 | 0 | 0 | 2 | 0 | 1 | 0 | 1 |
| 2048-game | ar.edu.unrc.game2048 | Board | 233 | 756 | 53 | 83 | 43 | 138 | 42 | 52 | 6 | 20 |
| 2048-game | ar.edu.unrc.game2048 | Board.Position | 28 | 45 | 6 | 4 | 1 | 9 | 6 | 3 | 1 | 3 |
| 2048-game | ar.edu.unrc.game2048 | DeterministicTileStrategy | 5 | 40 | 2 | 8 | 2 | 11 | 2 | 6 | 0 | 3 |

Un aspecto relevante es que **el método `repOk ()` no presenta cobertura directa en esta ejecución**. Esto es consistente con el comportamiento esperado de `@CheckRep`: la anotación permite que Randoop utilice el método como chequeo de representación durante la generación y ejecución de pruebas, pero esto no implica que se generen necesariamente casos de prueba cuyo objetivo sea invocar explícitamente `repOk ()` como una operación observable de la clase.

### ***Cobertura de mutación de Randoop con `@CheckRep` (PITest)***

Para evaluar la capacidad de esta nueva suite para detectar modificaciones artificiales se ejecutó:

```bash
mvn pitest:mutationCoverage "-DtargetTests=randoopTestsConCheckRep.RegressionTest0"
```

Los resultados obtenidos fueron:

| Name | Line Coverage | Mutation Coverage | Test Strength |
|---|---:|---:|---:|
| Board.java | 77% (148/191) | 49% (83/168) | 70% (83/118) |
| Cell.java | 71% (17/24) | 52% (17/33) | 85% (17/20) |
| DeterministicTileStrategy.java | 85% (11/13) | 38% (3/8) | 38% (3/8) |

### ***Análisis de resultados***

La incorporación de `CheckRep` produjo un **resultado diferente** al observado al pasar de la primera ejecución de Randoop a la ejecución con `RepOk ()`.

En primer lugar, **la cantidad de pruebas generadas disminuyó considerablemente**. La ejecución sin `repOk ()` produjo **45 pruebas**, mientras que la ejecución con `repOk ()` produjo **523 pruebas**. Al incorporar `@CheckRep`, la suite generada utilizada en el experimento final estuvo compuesta por **41 pruebas**.

Por lo tanto, en este caso **la cantidad de pruebas generadas por Randoop no constituye por sí sola una medida de efectividad**.

Las **métricas de cobertura estructural obtenidas con JaCoCo** muestran que la suite con `@CheckRep` alcanza una parte significativa del código de las clases de interés, aunque no alcanza los niveles de cobertura obtenidos por la suite generada con `repOk ()` sin anotación. **La misma tendencia se observa con PITest**.

| Clase | Mutation Coverage con `repOk` | Mutation Coverage con `@CheckRep` | Test Strength con `repOk` | Test Strength con `@CheckRep` |
|---|---:|---:|---:|---:|
| `Board` | 69% | 49% | 89% | 70% |
| `Cell` | 91% | 52% | 97% | 85% |
| `DeterministicTileStrategy` | 88% | 38% | 88% | 38% |

**Este resultado debe interpretarse teniendo en cuenta que se están comparando suites de tamaños muy diferentes**.

Considerando las **tres configuraciones experimentadas**, se obtuvieron los siguientes resultados:

| Configuración | Tests generados | Mutation Coverage `Board` | Mutation Coverage `Cell` | Mutation Coverage `DeterministicTileStrategy` |
|---|---:|---:|---:|---:|
| Sin `repOk` | 45 | 63% | 64% | 38% |
| Con `repOk` | 523 | 69% | 91% | 88% |
| Con `repOk` + `@CheckRep` | 41 | 49% | 52% | 38% |

Los resultados muestran que **la incorporación de `repOk ()` tuvo un impacto significativo** sobre la generación de pruebas en el experimento realizado, aumentando considerablemente la cantidad de secuencias generadas y mejorando las métricas de mutación respecto de la primera ejecución.

En cambio, **la posterior incorporación de `@CheckRep` produjo una suite mucho más pequeña y, en esta ejecución concreta, métricas inferiores**. Esto no permite concluir que `@CheckRep` sea perjudicial en general, sino que muestra que **su efecto depende de las secuencias generadas y de la interacción entre los invariantes de representación y el proceso de exploración de Randoop**. De todas maneras, **ninguno de estos mecanismos reemplaza la necesidad de verificar el comportamiento funcional mediante aserciones y pruebas específicas**.

## ***Fase 3.4: Chequeos de precondiciones***

Con el objetivo de encontrar **problemas de robustez** en las implementaciones de las clases de interés, se agregaron algunos **parámetros adicionales** a la ejecución de Randoop con el objetivo de **detectar problemas de chequeos de precondición insuficientes**:

```text
--forbid-null=false --null-ratio=0.1 --npe-on-null-input=ERROR  --npe-on-non-null-input=ERROR
```

Estos parámetros permiten a Randoop **usar `NULL` como parámetro de métodos que toman objetos** y le indica que las **`NullPointerException` son consideradas errores**.

Además, se agregó el **parámetro**:

```text
--no-regression-tests=true
```

De esta manera, Randoop **no almacena tests de regresión, sino solamente los tests fallidos**.

Así, el **comando final** utilizado fue:

```bash
java -cp "lib/randoop-all-4.3.4.jar:target/classes" randoop.main.Main gentests --testclass=ar.edu.unrc.game2048.Cell --testclass=ar.edu.unrc.game2048.Board --testclass=ar.edu.unrc.game2048.DeterministicTileStrategy --omit-methods="ar.edu.unrc.game2048.Board\(\)" --omit-methods="ar.edu.unrc.game2048.Board\(int\)" --time-limit=30 --junit-output-dir=src/test/java --junit-package-name=randoopTestsChequeoPrecondiciones --forbid-null=false --null-ratio=0.1 --npe-on-null-input=ERROR  --npe-on-non-null-input=ERROR --no-regression-tests=true
```

Su ejecución dejó en la carpeta `randoopTestsChequeoPrecondiciones/` el archivo [ErrorTest0.java](src/test/java/randoopTestsChequeoPrecondiciones/ErrorTest0.java) con **5 tests que fallaron**.

Analizando los tests generados, se detectaron los siguientes **problemas**:

- **test1 ()**: dejó en evidencia que **el constructor `Board (Board)`de la clase `Board`** no presenta una implementación defensiva respecto de su precondición, permitiendo pasar como argumento un tablero nulo.
- **test2 ()**: algo similar ocurre en la **clase `Cell`**, en donde los **métodos `canMergeWith (Cell)` y `mergeWith (Cell)`** no validan las celdas que reciben como parámetro. Además, analizando estas implementaciones, se detectó que `canMergeWith (Cell)` presenta un **error en su condición `this.isEmpty () && other.isEmpty ()`**. Para determinar que dos celdas no pueden fusionarse (`return false`), alcanza con que alguna de las dos sea vacía, por lo cual, **lo correcto es utilizar un OR (`||`) en lugar de un AND (`&&`)**.
- **test3 (), test4 () y test5 ()**: demostraron que el otro **constructor de la clase `Board`, `Board (int, TileStrategy)`**, tampoco presenta una implementación defensiva, dejando pasar estrategias nulas como argumento.

Todos estos defectos del código fueron detallados en una **Issue en Github** y fueron correctamente reparados.

Cabe aclarar que, **algunos pocos tests previamente generados de forma automática debieron modificarse**, ya que en sus aserciones esperaban `NullPointerException`, y con la refactorización obtienen `IllegalArgumentException`.

Por su parte, esta última clase de tests generada, `randoopTestsChequeoPrecondiciones/ErrorTest0.java` se conserva como documentación en el repositorio pero fue **anotada como `@Ignore`** debido a que su propósito ya fue cumplido y conservar los tests rompería la ejecución de comandos como `mvn test`.

Además, **se agregaron algunos tests manuales** para recuperar el **100% de cobertura estructural y de mutación** luego de la refactorización mencionada.

---

# **Assignment 3 (Automated Test Generation and Fuzzing)**

En esta sección se desarrolla la tercera etapa del proyecto, dedicada a **la generación automática de pruebas evolutivas y fuzzing**, con el objetivo de conocer nuevas técnicas y poder comparar con las vistas anteriormente.

El trabajo se llevó a cabo a través de las **dos fases** propuestas en la consigna:

1. Generación automática de tests con EvoSuite.
2. Fuzzing.

## ***Fase 1.1: Generación automática de pruebas con EvoSuite***

En esta etapa se utilizó **EvoSuite para generar automáticamente suites de pruebas mediante búsqueda evolutiva**. Se realizaron ejecuciones sobre las clases principales del dominio que resultaban relevantes para el testing automatizado:

- [`ar.edu.unrc.game2048.Cell`](src/main/java/ar/edu/unrc/game2048/Cell.java)
- [`ar.edu.unrc.game2048.Board`](src/main/java/ar/edu/unrc/game2048/Board.java)
- [`ar.edu.unrc.game2048.DeterministicTileStrategy`](src/main/java/ar/edu/unrc/game2048/DeterministicTileStrategy.java)

No fueron consideradas `ar.edu.unrc.game2048.RandomTileStrategy` ni `ar.edu.unrc.game2048.MainCLI`.

Se utilizó **EvoSuite 1.0.6** con un **tiempo de búsqueda de 30 segundos por clase**, con el fin de mantener una cierta correspondencia con la configuración utilizada para Randoop (30 seg), salvando las diferencias propias en la forma de búsqueda y generación de cada herramienta.

Para evitar que la generación de pruebas dependiera de la aleatoriedad, **se modificó temporalmente la privacidad de pública a privada en los constructores** `Board ()`, `Board (int)` (de la clase `Board`),  `RandomTileStrategy ()` y `RandomTileStrategy (Random)` (de la clase `RandomTileStrategy`).

De esta manera, todos los tests generados por EvoSuite para la clase `Board` utilizaron el constructor `Board (int, TileStrategy)` que, por las restricciones planteadas, sólo podía ser instanciado con `DeterministicTileStrategy` como parámetro. Así, **se evitó la aleatoriedad propia de `RandomTileStrategy` durante la ejecución de los tests generados por `Board`, haciendo que el comportamiento del juego utilizado por las pruebas fuera determinista**.

**La ejecución se automatizó mediante el script `runEvosuite.sh`**, que se encarga de asegurar la descarga del `jar` de EvoSuite, compilar el proyecto y ejecutar la herramienta sobre cada una de las clases seleccionadas. 

Debido a inconvenientes encontrados durante las primeras ejecuciones, **se incorporaron ciertos parámetros en el script para controlar y condicionar los valores enteros que puede generar aleatoriamente EvoSuite para sus tests de `Board`**, utilizando `Dmax_int=16` junto con `Drestrict_pool=true`. Esto permitió limitar el espacio de valores explorados por EvoSuite y evitar la generación de algunos casos excesivamente grandes o costosos, como la creación de tableros con tamaños elevados.

Una vez obtenida la suite de pruebas, se quitaron las modificaciones temporales en el código de los constructores antes mencionados. **Las pruebas generadas se almacenaron en**:

```text
src/test/java/evosuiteTests/
```

**Entre los archivos generados se encuentran las clases de test**:

- [`Cell_ESTest.java`](src/test/java/evosuiteTests/Cell_ESTest.java)
- [`Board_ESTest.java`](src/test/java/evosuiteTests/Board_ESTest.java)
- [`DeterministicTileStrategy_ESTest.java`](src/test/java/evosuiteTests/DeterministicTileStrategy_ESTest.java)

Las suites generadas fueron incorporadas al proyecto y ejecutadas mediante Maven. En total, EvoSuite creó **33 pruebas para `Board`**, **25 para `Cell`** y **7 para `DeterministicTileStrategy`**.

## ***Fase 1.2: Inspección de las pruebas generadas***

La inspección de las pruebas generadas permitió observar que **EvoSuite explora automáticamente diferentes combinaciones de valores y operaciones para alcanzar distintos caminos de ejecución**.

### ***Tipo de entradas generadas por EvoSuite***

#### ***Inspección para Cell***

Para `Cell`, se observaron entradas generadas con diferentes **valores**:
- Potencias y no potencias de 2.
- Positivos y negativos.
- El valor correspondiente a la constante `EMPTY`.

Para valores negativos y valores que no cumplen las condiciones requeridas por la clase, las pruebas verifican el **lanzamiento de excepciones**.

También se observa la **invocación de diferentes métodos de la clase**, abarcando tanto aquellos propios de la lógica de la clase (`mergeWith (Cell)`, `getValue ()`, `canMergeWith (Cell)`, etc.), como también métodos utilitarios sobreescritos (`toString ()`, `repOk ()`, `equals (Object)`, `hashCode ()`, etc.).

Estos métodos utilitarios son principalmente invocados para **obtener resultados que luego son verificados mediante aserciones**, como `assertEquals ()`, `assertTrue ()` y `assertFalse ()`.

#### ***Inspección para Board***

En `Board`, Evosuite generó entradas que ejercitan **diferentes formas de construcción y manipulación del tablero**.

La suite generada utiliza principalmente el constructor `Board (int, TileStrategy)`, junto con instancias de `DeterministicTileStrategy`, debido a las restricciones aplicadas temporalmente durante la generación. De esta manera, los tests evitan depender del comportamiento aleatorio de `RandomTileStrategy`.

Entre las principales **operaciones ejercitadas** se encuentran:

- Creación de tableros con diferentes tamaños.
- Consulta y modificación de celdas mediante `getCell ()` y `setCell (int, int, Cell)`.
- Consulta del puntaje mediante `getScore ()`.
- Ejecución de movimientos en diferentes direcciones (`moveUp ()`, `moveDown ()`, `moveRight ()` y `moveLeft ()`).
- Consulta de la representación textual mediante `toString ()`.
- Verificación del estado interno mediante `repOk ()`-
- Utilización de objetos `Board.Position`.
- Uso de constantes como `DEFAULT_SIZE` y `WINNING_VALUE`.
- Casos relacionados con estados límite y entradas que pueden producir excepciones.

También se observan **secuencias de varias operaciones sobre un mismo tablero**. Esto permite que EvoSuite alcance estados internos que no necesariamente serían cubiertos mediante una única llamada a un método. Respecto a las aserciones, se comportan de la misma manera que se observó para la clase `Cell`.

Las entradas generadas incluyen **distintos tamaños de tablero y diferentes configuraciones de celdas**. Durante las primeras ejecuciones se observaron algunos casos especialmente problemáticos, como tableros de tamaño excesivamente grande, accesos a posiciones inválidas y valores que podían producir excepciones o tiempos de ejecución elevados. Estos casos motivaron el ajuste de la configuración utilizada durante la generación y la posterior revisión de la suite obtenida.

#### ***Inspección para DeterministicTileStrategy***

Para `DeterministicTileStrategy`, EvoSuite generó pruebas que permiten observar **distintos casos de entrada para el método `determinarPosicion ()` y para `determinarValor ()`**.

Se pueden identificar los siguientes **casos**:

- Invocación de `determinarPosicion ()` con un conjunto `null`, verificando el lanzamiento de `NullPointerException`.
- Conjuntos que contienen diferentes objetos `Board.Position`.
- Posiciones con coordenadas negativas y valores extremos.
- Conjuntos con más de una posición, utilizados para verificar cuál de ellas es seleccionada por la estrategia determinista.
- Un conjunto vacío, para el cual `determinarPosicion ()` devuelve `null`.
- Invocación de `determinarValor ()`, verificando que el valor obtenido sea `2` (el valor que siempre retorna dicho método).

Las pruebas con varios `Board.Position` permiten observar que EvoSuite explora **diferentes combinaciones de filas y columnas para ejercitar la lógica de selección de la posición**. Por ejemplo, se utilizan posiciones con la misma fila pero diferentes columnas, y posiciones con diferentes filas, permitiendo verificar el resultado seleccionado mediante aserciones sobre `row` y `col`.

En este caso, **los valores de las coordenadas no representan necesariamente posiciones válidas dentro de un tablero concreto**. Esto no impide que sean útiles para la generación automática, ya que el objetivo de EvoSuite es explorar el comportamiento de los métodos y alcanzar diferentes caminos de ejecución.

### ***Oráculos de prueba (aserciones)***

Las aserciones generadas por EvoSuite son principalmente **aserciones de regresión**: registran el comportamiento observado durante la generación y posteriormente verifican que la ejecución produzca nuevamente esos resultados.

Este tipo de oráculo resulta útil para detectar regresiones respecto del comportamiento actual de la implementación, aunque **no necesariamente expresa una especificación funcional independiente**. Por esta razón, una prueba puede verificar correctamente que el programa mantiene un comportamiento previo sin garantizar por sí sola que dicho comportamiento sea el esperado desde el punto de vista de los requisitos.

Esto resulta particularmente visible en la mayoría de los tests generados, donde **se verifican en las aserciones valores concretos obtenidos a partir de secuencias de operaciones o de entradas generadas previamente de manera automática**.

### ***Presencia de pruebas frágiles o difíciles de entender***

La utilización de `DeterministicTileStrategy` en la suite final hace que **todas las pruebas obtenidas sean reproducibles y no presenten fragilidad ni "flakys"**, eliminando la dependencia de la aleatoriedad propia del juego. Sin embargo, esto no significa que todas las pruebas sean igualmente fáciles de interpretar.

En particular, algunas pruebas generadas automáticamente contienen **secuencias largas de instrucciones y numerosas aserciones**, lo que dificulta identificar rápidamente cuál es el comportamiento funcional que se pretende verificar.

Además, **algunas entradas resultan poco naturales desde el punto de vista de un usuario de juego**. Por ejemplo, en los tests de `DeterministicTileStrategy` aparecen coordenadas negativas y valores extremos como -1 o -4195. Estos valores son útiles para explorar el comportamiento de la implementación, pero no representan necesariamente estados válidos de un tablero.

En `Board`, también se observaron durante la generación inicial casos con tamaños de tablero excesivamente grandes y operaciones que podían producir excepciones o tiempos de ejecución elevados. Estos casos muestran una de las diferencias respecto de los tests escritos manualmente: **EvoSuite prioriza la exploración de caminos y estados de ejecución, por lo que puede generar entradas poco intuitivas desde el punto de vista funcional**.

Por lo tanto, las pruebas generadas resultan útiles como mecanismo complementario de detección de regresiones y exploración automática, pero **requieren inspección humana para determinar qué comportamiento están verificando y si ese comportamiento resulta relevante desde el punto de vista de la especificación**.

## ***Fase 1.3: Medición de cobertura de las pruebas generadas***

### ***Cobertura estructural de EvoSuite (JaCoCo)***

Para evaluar la **cobertura estructural** de las suites generadas por EvoSuite, se aisló la ejecución de **JaCoCo** para dichos tests:

```bash
mvn clean test jacoco:report "-Dtest=evosuiteTests.*ESTest"
```

La ejecución correspondió exclusivamente a las pruebas generadas por EvoSuite para `Cell`, `Board` y `DeterministicTileStrategy`.

#### ***Resultados generales para las clases de interés***

| Clase | Instrucciones | Ramas | Líneas | Complejidad | Métodos |
|---|---:|---:|---:|---:|---:|
| `Cell` | 164/165 (99%) | 32/34 (94%) | 24/24 (100%) | 26/28 (93%) | 11/11 (100%) |
| `Board.Direction` | 44/44 (100%) | 0/0 (100%) | 2/2 (100%) | 1/1 (100%) | 1/1 (100%) |
| `Board` | 926/989 (93%) | 117/136 (86%) | 166/181 (92%) | 75/94 (80%) | 24/26 (92%) |
| `Board.Position` | 71/73 (97%) | 9/10 (90%) | 10/10 (100%) | 8/9 (89%) | 4/4 (100%) |
| `DeterministicTileStrategy` | 45/45 (100%) | 10/10 (100%) | 13/13 (100%) | 8/8 (100%) | 3/3 (100%) |

Considerando conjuntamente `Cell`, `Board`, `Board.Position` y `DeterministicTileStrategy`, EvoSuite alcanzó **1206 de 1272 instrucciones**, aproximadamente un **95% de cobertura de instrucciones**, y **168 de 180 ramas**, aproximadamente un **93% de cobertura de ramas**.

#### ***Cobertura específica para `Cell`***

| Método | Cobertura de instrucciones | Cobertura de ramas |
|---|---:|---:|
| `repOk()` | 92% | 66% |
| `Cell(int)` | 100% | 100% |
| `mergeWith(Cell)` | 100% | 100% |
| `equals(Object)` | 100% | 100% |
| `canMergeWith(Cell)` | 100% | 100% |
| `hashCode()` | 100% | n/a |
| `toString()` | 100% | 100% |
| `esPotenciaDeDos(int)` | 100% | 100% |
| `isEmpty()` | 100% | 100% |
| `getValue()` | 100% | n/a |

La clase `Cell` alcanzó un **99% de cobertura de instrucciones** y un **94% de cobertura de ramas**. Todas sus líneas y métodos fueron ejecutados al menos una vez. La única parte que no fue cubierta completamente corresponde a `repOk ()`.

Esto muestra que EvoSuite logró explorar prácticamente toda la funcionalidad de `Cell`. La cobertura que no se alcanzó corresponde principalmente a caminos específicos de validación del invariante de representación, lo cual resulta razonable ya que **alcanzar ciertas condiciones internas inválidas de una `Cell` no es necesariamente sencillo utilizando únicamente su interfaz pública, sin recurrir a estrategias como reflexión**.

#### ***Cobertura específica para `Board`***

| Método | Cobertura de instrucciones | Cobertura de ramas |
|---|---:|---:|
| `isLosingBoard()` | 61% | 57% |
| `repOk()` | 81% | 59% |
| `Board()` | 0% | n/a |
| `Board(int)` | 0% | n/a |
| `setCell(int, int, Cell)` | 73% | 50% |
| `equals(Object)` | 94% | 83% |
| `isWinningBoard()` | 93% | 83% |
| `toString()` | 100% | 100% |
| `procesarLinea(List)` | 100% | 100% |
| `moveDown()` | 100% | 100% |
| `moveRight()` | 100% | 100% |
| `moveUp()` | 100% | 100% |
| `moveLeft()` | 100% | 100% |
| `Board(Board)` | 100% | 100% |
| `getEmptyPositions()` | 100% | 100% |
| `Board(int, TileStrategy)` | 100% | 100% |
| `validatePosition(int, int)` | 100% | 100% |
| `addRandomTile()` | 100% | 100% |
| `initializeEmpty()` | 100% | 100% |
| `hashCode()` | 100% | n/a |
| `finalizarMovimiento(Board)` | 100% | 100% |
| `getCell(int, int)` | 100% | n/a |
| `hasEmptyCells()` | 100% | 100% |
| `isFull()` | 100% | 100% |
| `getSize()` | 100% | n/a |
| `getScore()` | 100% | n/a |

En `Board`, EvoSuite alcanzó un **93% de cobertura de instrucciones**, **86% de ramas**, **92% de líneas** y **92% de métodos**.

Los constructores `Board` y `Board (int)` quedaron **sin cubrir debido a que fueron hechos temporalmente privados durante la generación de EvoSuite**, con el objetivo de evitar que la herramienta utilizara `RandomTileStrategy`.

También quedaron algunos caminos sin cubrir en `isLosingBoard ()`, `repOk ()`, `setCell ()` e `isWinningBoard ()`. En estos casos, EvoSuite **consiguió ejecutar los métodos, pero no alcanzó todas las condiciones internas posibles**.

En contraste, las operaciones principales de movimiento junto con los demás métodos indispensables alcanzaron el **100% de cobertura de instrucciones y ramas**. Esto indica que la búsqueda evolutiva consiguió explorar una parte importante de la lógica central del juego.

#### ***Cobertura específica para `DeterministicTileStrategy`***

| Método | Cobertura de instrucciones | Cobertura de ramas |
|---|---:|---:|
| `determinarPosicion(Set)` | 100% | 100% |
| `DeterministicTileStrategy()` | 100% | n/a |
| `determinarValor()` | 100% | n/a |

La clase `DeterministicTileStrategy` alcanzó **%100 de cobertura de instrucciones, ramas, líneas, complejidad y métodos**.

#### ***Análisis de resultados***

Los resultados muestran que **EvoSuite consiguió una cobertura estructural elevada con una cantidad relativamente pequeña de pruebas**: 33 tests para `Board`, 25 para `Cell` y 7 para `DeterministicTileStrategy`.

`DeterministicTileStrategy` **alcanzó el 100% de cobertura en todas las métricas principales.** **`Cell` también presentó una cobertura muy elevada**. **`Board` presentó la mayor cantidad de código y, consecuentemente, fue la clase donde quedaron más caminos sin explorar**. Sin embargo, EvoSuite consiguió cubrir considerablemente la clase, además de abarcar completamente las principales operaciones relacionadas con los movimientos del juego.

Un aspecto relevante es que **la cobertura de código no implica necesariamente que todos los comportamientos funcionales hayan sido verificados correctamente**. Por este motivo, **las métricas de JaCoCo deben analizarse conjuntamente** con la calidad de las aserciones generadas y con los resultados obtenidos mediante las otras técnicas de testing.

### ***Cobertura de mutación de EvoSuite (PITest)***

Para evaluar la **cobertura de mutación** de las suites generadas por EvoSuite, se aisló la ejecución de **PITest** para dichos tests utilizando el comando configurado:

```bash
mvn pitest:mutationCoverage "-DtargetTests=evosuiteTests.*ESTest" -Pevosuite
```

La ejecución evaluó la efectividad de las pruebas automáticas inyectando mutantes en el código fuente de `Cell`, `Board` y `DeterministicTileStrategy`.

#### ***Resultados generales para las clases de interés***

| Name | Line Coverage | Mutation Coverage | Test Strength |
|---|---:|---:|---:|
| Cell.java | 100% (28/28) | 94% (33/35) | 94% (33/35) |
| Board.java | 92% (195/212) | 82% (140/170) | 91% (140/154) |
| DeterministicTileStrategy.java | 100% (13/13) | 88% (7/8) | 88% (7/8) |

#### ***Análisis de resultados***

Los resultados de PITest demuestran que las suites generadas por EvoSuite no solo alcanzan una alta cobertura estructural, sino que también poseen una **excelente capacidad para detectar fallos (matar mutantes)**:

- `Cell`: presentó un rendimiento sobresaliente, alcanzando una **cobertura de mutación del 94%**. Esto refuerza el hallazgo de JaCoCo, demostrando que la suite es altamente robusta para esta clase.
- `Board`: alcanzó una **cobertura de mutación del 82% (con un *Test Strength* del 91% sobre el código cubierto)**. Considerando la complejidad y la cantidad de lógica de negocio que encapsula el tablero del juego 2048, este porcentaje evidencia que las aserciones automáticas de EvoSuite fueron eficaces desafiando las condiciones lógicas de los movimientos y estados.
- `DeterministicTileStrategy`: obtuvo un **88% de cobertura de mutación**, validando de forma contundente la estrategia determinista para la colocación de fichas.

### ***Conclusión conjunta***

El análisis combinado de **JaCoCo y PITest** confirma que EvoSuite es una **herramienta sumamente potente para automatizar la generación de pruebas en dominios lógicos acotados**. Si bien la cobertura de mutación es ligeramente menor que la cobertura estructural (lo cual es esperado, ya que ejecutar una línea no garantiza que exista una aserción capaz de detectar cualquier alteración sutil en ella), los porcentajes obtenidos validan que **las pruebas automáticas complementan de forma muy sólida el trabajo de testing manual**.

## ***Fase 1.4: Comparación EvoSuite vs Randoop vs pruebas manuales***

En esta fase se comparan las pruebas manuales, Randoop en sus distintas configuraciones y EvoSuite. **La comparación considera tanto la cobertura estructural obtenida con JaCoCo como la efectividad de detección de fallos evaluada mediante cobertura de mutación con PITest**.

Es importante aclarar que los resultados corresponden a las ejecuciones realizadas durante las distintas fases del proyecto. El código fue evolucionando entre ellas, especialmente con la incorporación de `repOk ()`, por lo que **los porcentajes permiten observar diferencias entre las técnicas pero no constituyen una comparación estrictamente controlada sobre exactamente la misma versión del código**.

### ***Cantidad de pruebas generadas***

| Técnica | Cantidad de pruebas |
|---|---:|
| Pruebas manuales | 109 |
| Randoop sin `repOk` | 45 |
| Randoop con `repOk` | 523 |
| Randoop con `repOk` + `@CheckRep` | 41 |
| EvoSuite | 65 |

El número de pruebas generadas por **Randoop** cambia considerablemente según la configuración. **EvoSuite** se caracteriza por minimizar el tamaño de sus suites, sin perder cobertura. Las **pruebas manuales** se fueron agregando progresivamente hasta conseguir la totalidad de la cobertura.

### ***Cobertura estructural y de mutación***

| Técnica | Clase | Instrucciones | Ramas | Mutación
|---|---|---:|---:| ---: |
| Manual | `Cell` | 100% | 100% | 100% |
| Manual | `Board` | 100% | 100% | 100% |
| Manual | `DeterministicTileStrategy` | 100% | 100% | 100% |
| Randoop sin `repOk` | `Cell` | 74% | 68% | 64% |
| Randoop sin `repOk` | `Board` | 88% | 79% | 63% |
| Randoop sin `repOk` | `DeterministicTileStrategy` | 96% | 90% | 38% |
| Randoop con `repOk` | `Cell` | 91% | 91% | 91% |
| Randoop con `repOk` | `Board` | 76% | 73% | 69% |
| Randoop con `repOk` | `DeterministicTileStrategy` | 96% | 90% | 88% |
| Randoop con `repOk` + `@CheckRep` | `Cell` | 58% | 47% | 52% |
| Randoop con `repOk` + `@CheckRep` | `Board` | 76% | 61% | 49% |
| Randoop con `repOk` + `@CheckRep` | `DeterministicTileStrategy` | 89% | 80% | 38% |
| EvoSuite | `Cell` | 99% | 94% | 94% |
| EvoSuite | `Board` | 93% | 86% | 82% |
| EvoSuite | `DeterministicTileStrategy` | 100% | 100% | 88% |

Los resultados muestran que las **pruebas manuales** alcanzaron la cobertura estructural y de mutación completa en las clases principales durante las fases anteriores. **Randoop** alcanzó distintos niveles de cobertura dependiendo de la utilización de `repOk ()` y `@CheckRep`. En la ejecución de **EvoSuite**, `Cell`, `Board` y `DeterministicTileStrategy` alcanzaron coberturas estructurales y de mutación muy elevadas, demostrando una sólida efectividad en la eliminación de mutantes.

### ***Análisis de las pruebas manuales***

Las pruebas manuales fueron diseñadas específicamente para **corroborar el comportamiento esperado del sistema**. Esto permite que las pruebas no solamente recorran el código, sino que también estén **relacionadas con la lógica del juego**.

Es un proceso algo tedioso y complejo en juegos como el 2048, con manejo de tableros y aleatoriedad.

### ***Análisis de Randoop***

Randoop genera secuencias de llamadas automáticamente y permite **explorar combinaciones de operaciones que pueden ser difíciles de anticipar manualmente**.

Los resultados muestran que **la incorporación de mecanismos de comprobación de estado puede modificar significativamente las secuencias y los resultados** producidos por una herramienta de generación automática.

Si bien agiliza el esfuerzo requerido en las pruebas manuales, **sus tests son muy difíciles de leer e interpretar**. Esto dificulta que el desarrollador pueda identificar rápidamente qué comportamiento funcional está siendo evaluado.

### ***Análisis de EvoSuite***

EvoSuite utiliza **algoritmos genéticos para maximizar la cobertura de código, minimizando el tamaño de la suite**. Las pruebas generadas utilizan aserciones de regresión para comprobar que el comportamiento observado durante la generación se mantenga al ejecutar posteriormente las pruebas.

Al igual que Randoop, agiliza la generación manual de tests. Su nivel de legibilidad es superior al de Randoop, y mediante la integración de PITest se pudo comprobar que sus suites poseen una **alta capacidad de matar mutantes**. No obstante, **algunas secuencias generadas son largas y difíciles de interpretar, y aparecen valores poco naturales para el usuario**.

### ***Comparación general***

| Aspecto | Pruebas manuales | Randoop | EvoSuite |
|:---:|:---:|:---:|:---:|
| Generación | Manual | Automática | Automática mediante búsqueda evolutiva |
| Control sobre los casos | Alto | Bajo | Bajo/medio |
| Exploración automática | Limitada por los casos diseñados | Alta | Alta |
| Orientación a comportamientos conocidos | Alta | Baja/media | Media |
| Exploración de secuencias | Depende del diseño | Alta | Alta |
| Legibilidad de las pruebas | Generalmente alta | Baja | Baja/Media |
| Aserciones | Diseñadas por el programador | Generadas a partir de las secuencias y contratos disponibles | Generadas automáticamente |
| Revisión humana | Sí | Sí | Sí |

#### ***Similitudes***

Las tres técnicas tienen como objetivo **detectar errores y aumentar la confianza en el comportamiento del programa**.

Las pruebas manuales, Randoop y EvoSuite pueden utilizarse junto con JaCoCo y PITest para **medir qué partes del código son ejercitadas por las pruebas y qué tan efectivas son las aserciones**. Además, las tres requieren una **revisión de los resultados**, ya que una prueba que ejecuta una parte del código no necesariamente representa un caso funcional relevante.

Randoop y EvoSuite comparten la característica de **generar automáticamente** las pruebas, mientras que las pruebas manuales dependen directamente del **conocimiento y las decisiones del desarrollador**.

Las tres técnicas también pueden utilizarse de manera complementaria. **Las pruebas manuales permiten cubrir comportamientos conocidos y casos específicos, mientras que las herramientas automáticas pueden explorar combinaciones que podrían no haber sido consideradas durante el diseño manual**.

#### ***Diferencias***

La diferencia principal está en la **forma en que se construyen los casos de prueba**.

Las pruebas manuales son diseñadas **explícitamente por el programador**. Esto permite controlar las entradas, los estados y los resultados esperados, y facilita relacionar cada prueba con un comportamiento concreto del sistema.

Randoop **genera automáticamente secuencias de llamadas a los métodos de las clases**. Por su parte, EvoSuite utiliza una **estrategia de búsqueda evolutiva para generar y mejorar los casos de prueba**.

Otra diferencia importante es el **control sobre los casos generados**. Las pruebas manuales permiten decidir exactamente qué escenario se quiere probar. En cambio, Randoop y EvoSuite pueden generar secuencias, valores y combinaciones que no necesariamente corresponden a escenarios que un desarrollador elegiría manualmente.

#### ***Fortalezas de las pruebas manuales***

- Permiten expresar directamente los **comportamientos esperados**.
- El programador **controla las entradas y los resultados** esperados.
- Facilitan **relacionar cada prueba con un requisito** o caso funcional.
- Generalmente se producen pruebas más **fáciles de leer y mantener**.

#### ***Debilidades de las pruebas manuales***

- Requieren **tiempo de diseño y mantenimiento**.
- **La exploración queda limitada** a los casos que al programador se le ocurre considerar.
- **Pueden no explorar combinaciones poco evidentes** de operaciones o estados.
- A medida que aumenta la cantidad o la complejidad de los casos posibles, resulta más **difícil cubrir sistemáticamente todo el espacio de entrada**.

#### ***Fortalezas de Randoop***

- Genera automáticamente **secuencias de llamadas**.
- Permite explorar combinaciones de operaciones que pueden ser **difíciles de anticipar manualmente**.
- Puede generar una **gran cantidad de pruebas** en poco tiempo.

#### ***Debilidades de Randoop***

- Las pruebas generadas pueden ser **difíciles de interpretar**.
- Una gran cantidad de pruebas **no implica necesariamente una mayor cobertura**.
- Las secuencias generadas **no siempre representan escenarios funcionales significativos**.
- Puede generar valores aleatorios que hagan que las pruebas se vuelvan **lentas y pesadas**.

#### ***Fortalezas de EvoSuite***

- Genera automáticamente casos de prueba orientados a objetivos de **cobertura mediante búsqueda evolutiva**.
- Puede generar automáticamente **aserciones de regresión**.
- En poco tiempo, es capaz de obtener **suites con alta cobertura de código y de mutación, con relativamente pocas pruebas**.

#### ***Debilidades de EvoSuite***

- Algunas pruebas generadas son **largas y difíciles de interpretar**.
- Puede generar **valores y secuencias poco naturales** desde el punto de vista de un usuario.
- **Las pruebas generadas requieren revisión** para determinar si representan escenarios funcionalmente relevantes.
- Presenta **desafíos técnicos de configuración y aislamiento en entornos específicos** (como WSL) al ser evaluadas con herramientas de mutación como PITest.

### ***Reflexión final***

En términos de **cobertura de código y mutación**, para este programa, las **pruebas manuales** fueron las que permitieron expresar con mayor precisión los comportamientos esperados, logrando analizar la totalidad de las implementaciones.

Sin embargo, se destaca también en un segundo escalón la gran capacidad de **EvoSuite** para ampliar la cobertura estructural y de mutación de manera automática con una cantidad relativamente reducida de pruebas, alcanzando resultados muy sólidos en las clases analizadas tras resolver las configuraciones de aislamiento.

Por su parte, **Randoop** también fue de gran utilidad para explorar distintas secuencias de operaciones y analizar el efecto de los invariantes de representación, aunque generó demasiadas pruebas sin una gran mejoría de cobertura y además, algunas secuencias generadas pueden resultar costosas de ejecutar debido a la cantidad de operaciones que contienen.

Así, la experiencia muestra que no existe una única técnica suficiente por sí sola. **La combinación de las pruebas permite obtener una exploración más amplia y complementaria del comportamiento del sistema**.

## ***Fase 2.1: Comprensión del Fuzzer base***

Para esta fase se analizó el script `fuzzer.py` proporcionado. El script implementa un **fuzzer dinámico que interactúa con el programa ensamblado** a través de su interfaz externa (la línea de comandos), inyectando secuencias de entradas generadas aleatoriamente para detectar caídas, bloqueos o violaciones de invariantes.

La **arquitectura del script** sigue la estructura teórica propuesta en *The Fuzzing Book*, dividiendo la herramienta en dos componentes principales:

1. **El Runner (`CLIRunner`)**: Es el componente encargado de **envolver y ejecutar el programa Java (`MainCLI`) como un subproceso**. Toma la cadena de texto generada por el fuzzer, la inyecta a través de la entrada estándar (`stdin`) y monitorea la ejecución (con un tiempo límite de 10 segundos). Finalmente, se evalúa el código de salida y la salida de error (`stderr`) para clasificar la prueba como `PASS` (éxito), `FAIL` (fallo o error) o `UNRESOLVED` (tiempo agotado o error del propio runner).

2. **El Fuzzer (`RandomFuzzer`)**: Es la clase base responsable de **generar la "basura" o los datos aleatorios** que servirán de entrada para estresar el programa.

## ***Fase 2.2: Implementación del generador de entradas (`fuzz ()`)***

La tarea principal de desarrollo consistió en **implementar el cuerpo del método `fuzz ()` dentro de la case `RandomFuzzer`**. Este método debía retornar un único *string* formateado correctamente para simular las secuencias de movimientos en la terminal.

Para su **diseño e implementación**, se analizaron las consideraciones planteadas en la consigna, definiendo el siguiente comportamiento:

1. **Longitud de la secuencia**: se determinó que la cantidad de movimientos **debe ser aleatoria** para cada prueba. Esto permite estresar el programa evaluando tanto partidas cortas como estados de juego más profundos. Para ello, se genera un número entero aleatorio acotado por los límites `min_length` (10) y `max_length` (50) definidos en la clase.
2. **Probabilidad de las teclas**: se optó por una **distribución equiprobable** al seleccionar los movimientos. Mediante un bucle, se elige aleatoriamente una tecla del conjunto válido (`KEYS = ['a', 's', 'w', 'd']`), otorgando a cada dirección la misma probabilidad de ocurrencia (25%).
3. **Formateo y cierre controlado**: cada tecla seleccionada se concatena en la cadena de texto seguida de un **salto de línea (`\n`)**, simulando la pulsación de *Enter*. Finalmente, para garantizar que el proceso termine de forma segura y no quede en ejecución permanente, se añade incondicionalmente el **comando de salida** (`QUIT = 'q'`) con su respectivo salto de línea al final de la cadena.

*La implementación puede consultarse en el archivo [fuzzer.py](fuzzer.py).*

## ***Fase 2.3: Ejecución inicial del Fuzzer***

Una vez implementado el método de generación, se procedió a **ejecutar el script sobre el proyecto previamente compilado**. Para mantener un registro de la prueba y poder incluir la evidencia en los *commits* del repositorio, se redirigió la salida estándar hacia un archivo de texto ejecutando el comando:

```bash
python3 fuzzer.py > fuzzer_report_sin_repOk.txt
```

*Dicho archivo puede revisarse en [fuzzer_report_sin_repOk.txt](fuzzer_report_sin_repOk.txt).*

### ***Análisis de los resultados y entradas generadas***

El reporte generado documenta la ejecución completa de **20 partidas automáticas**. Al analizar los inputs inyectados por el script, se corroboró el **correcto funcionamiento** de la implementación de `fuzz ()`. Cada prueba recibió una **cadena de texto** compuesta aleatoriamente por los comandos de dirección (`a`, `s`, `w`, `d`) con longitudes dinámicas, cerrando incondicionalmente con la tecla `q`.

Estas entradas permitieron **simular el avance del juego**, provocando movimientos en el tablero, fusiones de fichas y la suma de diferentes puntajes finales, dependiendo del éxito aleatorio de la secuencia.

Ante la interrogante de si el programa experimentó caídas (*crashes*), **la respuesta es negativa**. A lo largo de las 20 pruebas, el juego procesó todos los comandos, ignoró correctamente los movimientos que no alteraban el tablero (imprimiendo *"No tiles moved. Try a different direction."*), y finalizó cada ejecución de manera limpia al leer la instrucción `q`, imprimiendo *"Thanks for playing!"*.

Todas las ejecuciones retornaron un código de estado del sistema operativo impecable (`Exit : 0`) y no se registraron volcados de errores en la salida estándar de error (`stderr`). En consecuencia, el fuzzer clasificó la totalidad de los intentos como exitosos:

- ***PASS***: 20/20.
- ***FAIL***: 0/20.
- ***UNRESOLVED***: 0/20.

### ***Conclusión de la ejecución inicial***

Esta primera iteración de *fuzzing* permitió comprobar que, para las 20 secuencias generadas, **la aplicación manejó correctamente el flujo de entrada de datos y finalizó cada ejecución sin errores de proceso**. No existen bloqueos, bucles infinitos ni excepciones a nivel de la máquina virtual que interrumpan el juego de forma catastrófica.

Sin embargo, como el oráculo del fuzzer base se limita exclusivamente a monitorear caídas severas del proceso (códigos de salida distintos a cero), **los posibles errores de lógica profunda o corrupción silenciosa del tablero pueden haber pasado completamente desapercibidos**. Esto fundamenta la necesidad de acoplar la herramienta con los métodos `repOk ()`, lo cual se aborda en la siguiente fase.

## ***Fase 2.4: Mejora en la detección de errores***

Con el fin de poder contemplar también posibles errores en la lógica del juego, se habilitó la **bandera de aserciones (`-ea`)** en la máquina virtual de Java.

Además, se integraron **2 validaciones de `Board.repOk ()`** en [mainCLI.java](src/main/java/ar/edu/unrc/game2048/MainCLI.java): una apenas comienza el juego, para verificar su correcta inicialización, y otra luego de cada movimiento ejecutado, para corroborar que no se corrompe el estado del juego.

Cabe aclarar que, **implícitamente**, también se está utilizando `Cell.repOk ()`, en la implementación de  `Board.repOk ()`.

El Fuzzer se **ejecutó** nuevamente redirigiendo la salida:

```bash
python3 fuzzer.py > fuzzer_report_con_repOk.txt
```

*Dicho archivo puede revisarse en [fuzzer_report_con_repOk.txt](fuzzer_report_con_repOk.txt).*

### ***Análisis de los resultados y comportamiento del motor***

Luego de realizar las 20 pruebas automatizadas inyectando secuencias caóticas de comandos direccionales, el reporte refleja los siguientes **datos cuantitativos**:

- ***Total de intentos ejecutados***: 20 pruebas de *fuzzing*.
- ***Pruebas Exitosas (PASS)***: 20/20.
- ***Pruebas Fallidas (FAIL)***: 0/20.
- ***Casos No Resueltos (UNRESOLVED)***: 0/20.

De esta manera, logró demostrarse una **alta robustez** por parte de la aplicación ante entradas externas. Todas las pruebas fueron exitosas, registrando 0 fallos de proceso y 0 violaciones de aserciones.

Esto no implica necesariamente que no existan errores en el programa, sino que **ninguno de los casos generados activó una condición detectada por el oráculo utilizado**.

Las **secuencias de comandos** forzaron múltiples movimientos consecutivos contra bordes bloqueados y cadenas complejas de fusiones de celdas. Además, las partidas cubrieron un rango diverso de puntajes finales acuerdo con las acciones aleatorias del Fuzzer.

### ***Conclusión de la fase***

La ausencia de fallos indica que, durante las 20 ejecuciones, las llamadas a `board.repOk ()` **no arrojaron un valor falso en ninguno de los turnos auditados**. Esto permite afirmar que, para las entradas generadas, se mantuvieron las invariantes verificadas por:

1. La matriz del tablero mantiene sus **dimensiones correctas** y **no presenta referencias nulas**.
2. Los valores de las celdas se mantienen estrictamente dentro del **dominio válido del juego** (celdas vacías o potencias de dos).
3. Los estados del juego **no sufren corrupciones silenciosas** tras procesar movimientos válidos o inválidos.

## ***Fase 2.5: Reflexiones finales***

El **Fuzzer de comandos (CLI)** es una técnica ligera y directa para aplicaciones interactivas en consola. Al interactuar enviando secuencias de caracteres como entrada estándar, evalúa el sistema de forma integral, simulando el comportamiento real de un usuario estresando el bucle principal del juego.

Por su parte, **EvoSuite y Randoop** son herramientas orientadas a la generación automática de pruebas unitarias a nivel de clases y métodos de Java. Aunque son excelentes para encontrar fallos lógicos a nivel de unidades aisladas, requieren configuraciones específicas para interactuar con entradas de consola o bucles interactivos.

Para el juego 2048 en particular (una aplicación basada en una interfaz de línea de comandos CLI con un bucle interactivo de texto), **el fuzzer personalizado combinado con aserciones estructurales (`repOk`) resultó ser, probablemente, la técnica más efectiva para comprobar la integración completa del sistema a través de su interfaz CLI**.

En este sentido, EvoSuite y Randoop, aunque son excelentes para pruebas aisladas, chocan con las limitaciones de interactuar con **flujos de entrada/salida** de consola en tiempo de ejecución. El fuzzer, en cambio, **permitió estresar el bucle principal del juego simulando el uso real de un usuario** y asegurando, mediante aserciones defensivas, que el tablero no sufriera corrupciones lógicas silenciosas en ningún momento durante las ejecuciones realizadas.

De esta manera, todas estas herramientas en conjunto, sumadas a nuestros tests manuales, **brindan una base sólida y dan diferentes perspectivas, todas ellas igualmente necesarias para aumentar la garantía de que nuestra aplicación está correctamente implementada**.

---

# **Assignment 4 (Oracle Generation with Daikon)**

Este apartado detalla la cuarta etapa del trabajo práctico, enfocada en la **inferencia dinámica de invariantes** mediante la herramienta Daikon.

A diferencia de las pruebas de regresión o aserciones manuales, Daikon **observa los valores de las variables durante la ejecución del programa** y deduce automáticamente propiedades lógicas (precondiciones, postcondiciones e invariantes de clase) que se mantienen verdaderas en todas las ejecuciones observadas.

El trabajo se desarrolló siguiendo las **fases** propuestas en la consigna:

1. Instrumentación y recolección de trazas.
2. Inferencia de invariantes.
3. Inspección y evaluación de los invariantes inferidos.
4. Comparaciones con herramientas y técnicas previas.

## ***Fase 1.1: Instrumentación de pruebas unitarias manuales y automáticas (Randoop)***

Los **tests unitarios** son fundamentales para **registrar el comportamiento del sistema ante casos de borde** que no suelen ocurrir mediante el uso normal de la interfaz del juego.

Para instrumentar estas ejecuciones, se utilizó **Chicory** sobre el corredor de JUnit, pasándole explícitamente las **109 pruebas manuales** realizadas por el grupo.

El **comando** utilizado para restringir la instrumentación a las clases `Board` y `Cell` fue:

```bash
java -cp "lib/daikon.jar:target/classes:target/test-classes:$(mvn dependency:build-classpath -q -DforceStdout)" \
     daikon.Chicory \
     --ppt-select-pattern="ar.edu.unrc.game2048.Board|ar.edu.unrc.game2048.Cell" \
     --output-dir=daikon-traces \
     org.junit.runner.JUnitCore \
     ar.edu.unrc.game2048.BoardTest \
     ar.edu.unrc.game2048.CellTest
```

Los **resultados** generados se encuentran en:

```text
daikon-traces/JUnitCore.dtrace.gz
```

## ***Fase 1.2: Recolección de trazas interactivas mediante Fuzzing***

Para **capturar el comportamiento dinámico del juego y el ciclo de vida real de un tablero**, se complementaron las trazas de los tests utilizando el **Fuzzer** desarrollado en el Assignment 3.

Con el fin de evitar que el Fuzzer perdiera rápidamente en partidas cortas y se quedara sin explorar estados profundos, se ejecutó un **bucle Bash** que inyectó secuencias dinámicas de entre **10 y 60 movimientos aleatorios válidos** a través de la terminal en **50 ejecuciones consecutivas**.

El **comando** utilizado fue:

```bash
for i in {1..50}; do python3 -c "from fuzzer import RandomFuzzer; print(RandomFuzzer(10, 60).fuzz(), end='')" | java -cp "lib/daikon.jar:target/classes" daikon.Chicory --output-dir=daikon-traces ar.edu.unrc.game2048.MainCLI; done
```

Chicory registró estas partidas y comprimió los **resultados** en:

```text
daikon-traces/MainCLI.dtrace.gz
```

## ***Fase 2.1: Procesamiento de trazas y generación de invariantes***

Para consolidar las trazas obtenidas y **generar simultáneamente el reporte de texto legible y la representación binaria persistente**, se ejcutó Daikon indicando la opción de salida binaria `-o` y redirigiendo la salida estándar hacia un archivo de texto [`daikon-output.txt`](daikon-output.txt):

```bash
java -cp lib/daikon.jar daikon.Daikon \
     -o daikon-traces/output.inv \
     daikon-traces/*.dtrace.gz > daikon-output.txt
```

> *Nota*: se optó por no descomprimir las trazas obtenidas durante la fase 1, debido a que Daikon permite procesar directamente los archivos comprimidos `.gz`.

## ***Fase 2.2: Archivos generados***

El procesamiento de las trazas produjo **dos artefactos**:

- **`daikon-output.txt`**: Archivo de texto plano ubicado en la raíz del proyecto que contiene la totalidad de las propiedades e invariantes inferidos, agrupados por puntos de programa.
- **`daikon-traces/output.inv`**: Archivo binario consolidado que almacena la estructura compilada de los invariantes. Este archivo permite realizar consultas, filtrados o formateos posteriores mediante las herramientas de Daikon sin requerir reevaluar las trazas comprimidas.

## ***Fase 2.3: Verificación de la integridad del archivo binario***

Con el objetivo de confirmar que el archivo binario `output.inv` se generó correctamente y sin corrupción de datos, se verificó su contenido utilizando la **utilidad `PrintInvariants`**:

```bash
java -cp lib/daikon.jar daikon.PrintInvariants daikon-traces/output.inv
```

La ejecución confirmó la **correcta compilación** de los puntos de programa observados para las clases instrumentadas, dejando el entorno listo para la etapa de inspección y evaluación de invariantes.

## ***Fase 3.1: Inspección y evaluación de los invariantes inferidos para la clase `Cell`***

Para realizar el análisis, se seleccionaron los **principales métodos** de interés de la clase.

### *1. Invariante de clase (`OBJECT` / `CLASS`)*

```text
===========================================================================
ar.edu.unrc.game2048.Cell:::CLASS
ar.edu.unrc.game2048.Cell.EMPTY != null
ar.edu.unrc.game2048.Cell.EMPTY.value == 0
===========================================================================
ar.edu.unrc.game2048.Cell:::OBJECT
===========================================================================
```

- **Clasificación**: Correcto pero trivial / Limitación de la herramienta.
- **¿Es correcto?** Lo inferido en `CLASS` es correcto, refleja el estado estático de la constante `EMPTY`. El bloque `OBJECT` vacío indica que Daikon no halló propiedades globales de instancia.
- **¿Es útil?** No aporta gran valor. Lo útil es notar la incapacidad de Daikon para inferir un invariante global.
- **¿Ya está expresado en otro lugar?** En `repOk ()`, se exige globalmente que `value >= 0` y que sea potencia de dos. Daikon, por el contrario, no logró generalizar este invariante de clase en `OBJECT`, pero sí lo infirió como postcondiciones de algunos métodos.
- **¿Es demasiado fuerte?** No aplica. La herramienta no pudo construir un invariante de representación completo con los tests dados.

### *2. Constructor `Cell (int)` (`ENTER` - `EXIT`)*

```text
===========================================================================
ar.edu.unrc.game2048.Cell.Cell(int):::ENTER
value >= 0
===========================================================================
ar.edu.unrc.game2048.Cell.Cell(int):::EXIT
this.value == orig(value)
this.value >= 0
this.value >= ar.edu.unrc.game2048.Cell.EMPTY.value
===========================================================================
```

- **Clasificación**: Correcto y útil (con un invariante trivial en `EXIT`).
- **¿Es correcto?** La precondición `value >= 0` es genuina y la postcondición `this.value == orig (value)` demuestra que la asignación de la variable al atributo se realiza correctamente y sin mutaciones previas.
- **¿Es útil?** Absolutamente. Previene la instanciación de valores negativos, protegiendo la integridad de la ficha desde el momento de su creación.
- **¿Ya está expresado en otro lugar?** Sí. Daikon redescubrió el límite inferior que está programado explícitamente tanto en el constructor (`if (value < 0)`) como en `repOk ()` (`value >= 0`). Además, el invariante `this.value >= Cell.EMPTY.value` es una deducción trivial, ya que `EMPTY.value` es 0, redundando con la validación anterior.
- **¿Es demasiado fuerte?** No. Este grupo de invariantes aplica universalmente para toda celda válida (0 o bien cualquier potencia de 2 positiva) en cualquier etapa del juego.

### *3. Método `isEmpty ()` (`ENTER` - `EXIT`)*

```text
===========================================================================
ar.edu.unrc.game2048.Cell.isEmpty():::ENTER
this.value >= 0
this.value >= ar.edu.unrc.game2048.Cell.EMPTY.value
===========================================================================
ar.edu.unrc.game2048.Cell.isEmpty():::EXIT
this.value == orig(this.value)
ar.edu.unrc.game2048.Cell.EMPTY == orig(ar.edu.unrc.game2048.Cell.EMPTY)
ar.edu.unrc.game2048.Cell.EMPTY.value == orig(ar.edu.unrc.game2048.Cell.EMPTY.value)
(this.value == 0)  <==>  (return == true)
(this.value == 0)  <==>  (this.value == ar.edu.unrc.game2048.Cell.EMPTY.value)
this.value >= 0
this.value >= ar.edu.unrc.game2048.Cell.EMPTY.value
===========================================================================
ar.edu.unrc.game2048.Cell.isEmpty():::EXIT;condition="return == true"
this.value == ar.edu.unrc.game2048.Cell.EMPTY.value
this.value == orig(ar.edu.unrc.game2048.Cell.EMPTY.value)
this.value == 0
return == true
===========================================================================
ar.edu.unrc.game2048.Cell.isEmpty():::EXIT;condition="not(return == true)"
this.value >= 2
this.value is a power of 2
return == false
this.value > ar.edu.unrc.game2048.Cell.EMPTY.value
===========================================================================
```

- **Clasificación**: Correcto y útil (con varias postcondiciones triviales/redundantes).
- **¿Es correcto?** La equivalencia lógica (`(this.value == 0) <==> (return == true)`) es perfectamente correcta y refleja la línea `return value == 0;` del código fuente. Además, la deducción en el bloque condicional (`not (return == true)`) de que `this.value is a power of 2` y `this.value >= 2` capta matemáticamente las reglas del juego.
- **¿Es útil?** Sí, en dos aspectos. Primero, valida sin errores la lógica de consulta de estado del método. Segundo, el invariante `this.value == orig (this.value)` garantiza que consultar si una celda está vacía no altera su valor (el método es puro y libre de efectos secundarios).
- **¿Ya está expresado en otro lugar?** Sí. Daikon logró redescubrir la regla fundamental de validación implementada a mano en `repOk ()`, la cual exige que un valor no vacío sea obligatoriamente validado por `esPotenciaDeDos (value)`. También redescubrió que `value >= 0`.
- **¿Es demasiado fuerte?** No. Si bien Daikon imprime mucho "ruido" comparando constantemente con la constante `EMPTY` y su valor original (lo cual es trivial y redundante), ninguna de estas afirmaciones restringe falsamente el dominio. Las reglas inferidas aplican al 100% de los casos de uso válidos de una celda no vacía en el juego.

### *4. Método `mergeWith (Cell)` (`ENTER` - `EXIT`)*

```text
===========================================================================
ar.edu.unrc.game2048.Cell.mergeWith(ar.edu.unrc.game2048.Cell):::ENTER
this.value == other.value
this.value >= 2
this.value is a power of 2
other != null
this.value > ar.edu.unrc.game2048.Cell.EMPTY.value
===========================================================================
ar.edu.unrc.game2048.Cell.mergeWith(ar.edu.unrc.game2048.Cell):::EXIT
this.value == other.value
this.value == orig(this.value)
this.value == orig(other.value)
ar.edu.unrc.game2048.Cell.EMPTY == orig(ar.edu.unrc.game2048.Cell.EMPTY)
ar.edu.unrc.game2048.Cell.EMPTY.value == orig(ar.edu.unrc.game2048.Cell.EMPTY.value)
this.value >= 2
this.value is a power of 2
return != null
return.value is a power of 2
this.value > ar.edu.unrc.game2048.Cell.EMPTY.value
2 * this.value - return.value == 0
this.value < return.value
ar.edu.unrc.game2048.Cell.EMPTY.value < return.value
===========================================================================
```

- **Clasificación**: Correcto y útil (con deducciones triviales sobre constantes).
- **¿Es correcto?** Sí. Refleja fielmente la lógica genuina del programa. Las precondiciones exigen que ambas celdas sean válidas (`>= 2`, potencias de 2), no nulas y con el mismo valor. En el `EXIT`, la expresión matemática `2 * this.value - return.value == 0` es la representación algebraica perfecta de la fusión.
- **¿Es útil?** Es extremadamente útil. Este conjunto de invariantes capturó la esencia semántica completa del método. Además, `this.value == orig (this.value)` garantiza la inmutabilidad de la celda original.
- **¿Ya está expresado en otro lugar?** Las precondiciones aisladas se validan a través de `canMergeWith ()` y excepciones en el código fuente. Sin embargo, la relación transicional (`2 * this.value - return.value == 0` y `this.value < return.value`) es un descubrimiento novedoso de Daikon, ya que el método `repOk ()` implementado en el Assignment 2 solamente evalúa el estado estático de la celda, no su evolución tras una operación.
- **¿Es demasiado fuerte?** No. A pesar del extenso ruido visual generado por el seguimiento de la constante `EMPTY`, los invariantes lógicos inferidos son reglas universales estrictas de todo juego válido de 2048. Ninguna ejecución violaría estas restricciones.

### *5. Método `getValue ()` (`ENTER` - `EXIT`)*

```text
===========================================================================
ar.edu.unrc.game2048.Cell.getValue():::ENTER
this.value >= 0
this.value >= ar.edu.unrc.game2048.Cell.EMPTY.value
===========================================================================
ar.edu.unrc.game2048.Cell.getValue():::EXIT
this.value == return
ar.edu.unrc.game2048.Cell.EMPTY == orig(ar.edu.unrc.game2048.Cell.EMPTY)
ar.edu.unrc.game2048.Cell.EMPTY.value == orig(ar.edu.unrc.game2048.Cell.EMPTY.value)
return == orig(this.value)
return >= 0
ar.edu.unrc.game2048.Cell.EMPTY.value <= return
===========================================================================
```

- **Clasificación**: Correcto y útil (con redundancias triviales sobre constantes).
- **¿Es correcto?** Sí. Las equivalencias `this.value == return` y `return == orig (this.value)` describen con total exactitud el comportamiento de la instrucción `return value;` del código fuente.
- **¿Es útil?** Sí. Garantiza estructualmente dos cosas fundamentales: que el método efectivamente retorna el estado interno de la celda, y que al hacerlo no altera dicho estado (es un método puro y de solo lectura que respeta la inmutabilidad de la clase).
- **¿Ya está expresado en otro lugar?** La regla de que el valor (y por ende el retorno) es `>= 0` ya está controlada en el `repOk ()` y en el constructor. Sin embargo, el `repOk ()` no evalúa el comportamiento de los métodos de acceso (getters), por lo que esta garantía de inmutabilidad en la consulta es un aporte exclusivo de Daikon.
- **¿Es demasiado fuerte?** No. Aunque Daikon introduce mucho "ruido" comparando el retorno con la constante `EMPTY` de forma redundante (`EMPTY.value <= return`), ninguna de estas reglas restringe el dominio. Cualquier celda válida en el juego devolverá siempre un valor mayor o igual a cero sin mutar el objeto original.

### *6. Método `canMergeWith (Cell)` (`ENTER` - `EXIT`)*

```text
===========================================================================
ar.edu.unrc.game2048.Cell.canMergeWith(ar.edu.unrc.game2048.Cell):::ENTER
other != null
this.value >= ar.edu.unrc.game2048.Cell.EMPTY.value
ar.edu.unrc.game2048.Cell.EMPTY.value <= other.value
===========================================================================
ar.edu.unrc.game2048.Cell.canMergeWith(ar.edu.unrc.game2048.Cell):::EXIT90
this.value one of { 0, 2 }
ar.edu.unrc.game2048.Cell.EMPTY has only one value
other.value one of { 0, 2 }
return == false
===========================================================================
ar.edu.unrc.game2048.Cell.canMergeWith(ar.edu.unrc.game2048.Cell):::EXIT90;condition="not(return == true)"
===========================================================================
ar.edu.unrc.game2048.Cell.canMergeWith(ar.edu.unrc.game2048.Cell):::EXIT92
(return == false)  <==>  (this.value != other.value)
(return == true)  <==>  (this.value == other.value)
this.value >= 2
this.value is a power of 2
other.value >= 2
other.value is a power of 2
this.value > ar.edu.unrc.game2048.Cell.EMPTY.value
ar.edu.unrc.game2048.Cell.EMPTY.value < other.value
===========================================================================
ar.edu.unrc.game2048.Cell.canMergeWith(ar.edu.unrc.game2048.Cell):::EXIT92;condition="return == true"
===========================================================================
ar.edu.unrc.game2048.Cell.canMergeWith(ar.edu.unrc.game2048.Cell):::EXIT92;condition="not(return == true)"
this.value != other.value
===========================================================================
ar.edu.unrc.game2048.Cell.canMergeWith(ar.edu.unrc.game2048.Cell):::EXIT
this.value == orig(this.value)
ar.edu.unrc.game2048.Cell.EMPTY == orig(ar.edu.unrc.game2048.Cell.EMPTY)
ar.edu.unrc.game2048.Cell.EMPTY.value == orig(ar.edu.unrc.game2048.Cell.EMPTY.value)
other.value == orig(other.value)
(return == true)  ==>  (ar.edu.unrc.game2048.Cell.EMPTY.value < other.value)
(return == true)  ==>  (other.value >= 2)
(return == true)  ==>  (other.value is a power of 2)
(return == true)  ==>  (this.value == other.value)
(return == true)  ==>  (this.value > ar.edu.unrc.game2048.Cell.EMPTY.value)
(return == true)  ==>  (this.value >= 2)
(return == true)  ==>  (this.value is a power of 2)
this.value >= ar.edu.unrc.game2048.Cell.EMPTY.value
ar.edu.unrc.game2048.Cell.EMPTY.value <= other.value
===========================================================================
ar.edu.unrc.game2048.Cell.canMergeWith(ar.edu.unrc.game2048.Cell):::EXIT;condition="return == true"
this.value == other.value
this.value == orig(other.value)
this.value >= 2
this.value is a power of 2
return == true
this.value > ar.edu.unrc.game2048.Cell.EMPTY.value
===========================================================================
ar.edu.unrc.game2048.Cell.canMergeWith(ar.edu.unrc.game2048.Cell):::EXIT;condition="not(return == true)"
return == false
===========================================================================
```

- **Clasificación**: Correcto y útil (con invariante espurio en `EXIT92`).
- **¿Es correcto?** Sí. En `ENTER`, garantiza que `other != null` ya que el código lanza una excepción de lo contrario. En `EXIT92` (cuando ninguna celda está vacía), deduce correctamente que para que se puedan fusionar (`return == true`), ambas celdas deben tener valores iguales, mayores o iguales a 2 y ser potencias de 2.
- **¿Es útil?** Absolutamente. El bloque `EXIT` general resume la regla de compatibilidad estructural del juego con aserciones formales (`return == true ==> this.value == other.value`), garantizando además que la consulta no muta ninguna de las dos celdas evaluadas (`== orig`).
- **¿Ya está expresado en otro lugar?** No. El `repOk ()` valida el estado de una sola celda a la vez (que sea `>= 0` y potencia de 2). No tiene forma de expresar la relación de compatibilidad y equivalencia cruzada entre dos objetos `Cell` distintos en tiempo de ejecución.
- **¿Es demasiado fuerte?** El `EXIT90` presenta un invariante espurio por escasez de datos: afirma que `this.value one of { 0, 2 }` y `other.value one of { 0, 2 }`. Esto sucede porque en los tests analizados, la condición de falla por "celda vacía" se dio mayormente al principio del juego, cuando solo existían valores de 2. Sin embargo, el análisis global (`EXIT`) absorbe este caso y presenta las reglas lógicas correctas sin restricciones de dominio falsas.

## ***Fase 3.2: Inspección y evaluación de los invariantes inferidos para la clase `Board`***

Para realizar el análisis, se seleccionaron los **principales métodos** de interés de la clase.

### *1. Invariante de clase (`OBJECT` / `CLASS`)*

```text
===========================================================================
ar.edu.unrc.game2048.Board:::CLASS
===========================================================================
ar.edu.unrc.game2048.Board:::OBJECT
this.grid.getClass().getName() == ar.edu.unrc.game2048.Cell[][].class
this.tileStrategy.getClass().getName() == ar.edu.unrc.game2048.RandomTileStrategy.class
ar.edu.unrc.game2048.Board.DEFAULT_SIZE != size(this.grid[])-1
ar.edu.unrc.game2048.Board.WINNING_VALUE > this.size
ar.edu.unrc.game2048.Board.WINNING_VALUE > this.score
ar.edu.unrc.game2048.Board.WINNING_VALUE > size(this.grid[])
this.size >= size(this.grid[])
this.grid.getClass().getName() != this.tileStrategy.getClass().getName()
===========================================================================
```

- **Clasificación**: Mezcla de "Correcto pero trivial" e "Incorrecto".
- **¿Es correcto?** Las validaciones de tipos (`this.grid.getClass ().getName () == ar.edu.unrc.game2048.Cell [] [].class`) y `this.size >= size(this.grid [])` son estructuralmente correctas. Sin embargo, afirmar que el score es menor al valor ganador (`WINNING_VALUE > this.score`) es incorrecto respecto al dominio, y fijar la estrategia a `RandomTileStrategy` (`this.tileStrategy.getClass ().getName () == ar.edu.unrc.game2048.RandomTileStrategy.class`) es un artefacto de los tests.
- **¿Es útil?** La mayoría de estos invariantes aportan muy poco valor real. Las aserciones sobre clases son redundantes en Java y la relación `this.size >= size (this.grid [])` es más débil que la igualdad estricta esperada.
- **¿Ya está expresado en otro lugar?** Hay discrepancias notables con el `repOk ()`, el cual exige explícitamente `grid.length == size` (igualdad estricta) y `score >= 0`. Daikon solo pudo deducir una desigualdad (`>=`) para la grilla y falló completamente en inferir el límite inferior del puntaje a nivel global de objeto.
- **¿Es demasiado fuerte?** Sí, en dos aspectos críticos. Primero, el constructor de `Board` permite inyectar cualquier implementación de `TileStrategy`; obligar a que sea `RandomTileStrategy` violaría ejecuciones válidas con estrategias deterministas para testing. Segundo, `WINNING_VALUE > this.score` es falso: en una partida real, el puntaje acumulado puede superar ampliamente los 2048 puntos, pero las trazas provistas por pruebas aleatorias cortas nunca lograron alcanzar esos valores, sesgando la inferencia.

### *2. Constructor `Board (int)` (`ENTER` - `EXIT`)*

```text
===========================================================================
ar.edu.unrc.game2048.Board.Board(int):::ENTER
===========================================================================
ar.edu.unrc.game2048.Board.Board(int):::EXIT
this.size == orig(size)
this.size == size(this.grid[])
this.grid != null
this.grid[] elements != null
this.score == 0
this.tileStrategy != null
this.score <= size(this.grid[])-1
===========================================================================
```

- **Clasificación**: Correcto y útil (con una relación espuria al final).
- **¿Es correcto?** Sí. Garantiza la asignación de la variable (`this.size == orig (size)`), inicializa el puntaje (`this.score == 0`) e instancia correctamente las dependencias (`grid`, las filas internas de la matriz y `tileStrategy`), todo de acuerdo con las líneas del constructor en el código fuente.
- **¿Es útil?** Sumamente útil. Confirma que la instanciación de un objeto `Board` deja la memoria en un estado seguro, sin referencias nulas colgantes y listo para procesar movimientos.
- **¿Ya está expresado en otro lugar?** Sí. Daikon logró redescubrir de forma brillante casi todas las validaciones estructurales del método `repOk ()`. Identificó que el tamaño de la matriz debe coincidir (`grid.length == size`), que no debe haber nulos (`grid != null, grid [] elements != null`) y que la estrategia debe estar definida (`tileStrategy != null`).
- **¿Es demasiado fuerte?** El invariante `this.score <= size (this.grid []) - 1` es espurio. Aparece como una coincidencia matemática (dado que el score inicial es 0 y el tamaño en las pruebas es de 2, 3 o 4), pero carece de sentido en el dominio del juego. Adicionalmente, Daikon falló en detectar la precondición genuina en el `ENTER` (`size > 0` que lanza excepción en el código), lo cual evidencia una limitación si las pruebas no abarcaron casos con tamaños negativos.

### *3. Método `setCell (int, int, Cell)` (`ENTER` - `EXIT`)*

```text
===========================================================================
ar.edu.unrc.game2048.Board.setCell(int, int, ar.edu.unrc.game2048.Cell):::ENTER
this.grid != null
this.score one of { 0, 4 }
row >= 0
col >= 0
cell != null
cell.value >= 0
ar.edu.unrc.game2048.Board.DEFAULT_SIZE > row
ar.edu.unrc.game2048.Board.DEFAULT_SIZE > col
row <= size(this.grid[])-1
col <= size(this.grid[])-1
===========================================================================
ar.edu.unrc.game2048.Board.setCell(int, int, ar.edu.unrc.game2048.Cell):::EXIT
this.size == orig(this.size)
this.grid == orig(this.grid)
this.score == orig(this.score)
cell.value == orig(cell.value)
this.score one of { 0, 4 }
orig(row) <= size(this.grid[])-1
orig(col) <= size(this.grid[])-1
===========================================================================
```

> (*Nota*: Se omitieron para la lectura las líneas redundantes comparando contra `EMPTY`, `WINNING_VALUE` y repeticiones de los invariantes de objeto estructurales, dejando las reglas específicas de los parámetros y el estado del método).

- **Clasificación**: Correcto y útil (con precondiciones y postcondiciones de estado espurias).
- **¿Es correcto?** Sí. En el `ENTER`, Daikon capturó perfectamente las precondiciones exigidas por el método auxiliar `validatePosition (row, col)` : `row >= 0`, `col >= 0`, `row <= size (this.grid []) - 1` y `col <= size (this.grid []) - 1`. También detectó la aserción explícita de que `cell != null`. En el `EXIT`, determinó correctamente que setear una celda muta el contenido de la matriz, pero no reasigna la matriz en sí (`this.grid == orig (this.grid)`), ni altera el puntaje (`this.score == orig (this.score)`) ni el tamaño del tablero (`this.size == orig (this.size)`).
- **¿Es útil?** Absolutamente. Es la comprobación matemática de que el método inyecta una ficha respetando los límites de la matriz (evitando `IndexOutOfBoundsException`) y aislando los demás atributos del juego (efectos secundarios nulos sobre `score` o `size`).
- **¿Ya está expresado en otro lugar?** El chequeo de `cell != null` y los límites de la matriz se evalúan de forma estática sobre todo el tablero en el `repOk ()`. Sin embargo, Daikon descubre las reglas protectoras antes de que el objeto ingrese a la estructura de datos (precondiciones del parámetro).
- **¿Es demasiado fuerte?** Sí, tanto en el `ENTER` como en el `EXIT`, se presentan invariantes demasiado fuertes por escasez de datos. Se afirma que `this.score one of { 0, 4 }` y `DEFAULT_SIZE > row` (que asume que la fila debe ser menor a 4, tamaño por defecto). Esto revela que las pruebas unitarias utilizan `setCell` casi exclusivamente al inicio de la partida y sobre tableros estándar de 4x4 o inferior. En el juego real, `setCell` puede usarse con el score de miles de puntos y en tableros de dimensiones variadas.

### *4. Método `isLosingBoard ()` (`ENTER` - `EXIT`)*

```text
===========================================================================
ar.edu.unrc.game2048.Board.isLosingBoard():::ENTER
this.size == size(this.grid[])
this.size one of { 2, 3, 4 }
this.grid != null
this.grid[] elements != null
this.score >= 0
this.tileStrategy != null
ar.edu.unrc.game2048.Board.DEFAULT_SIZE >= this.size
this.score % ar.edu.unrc.game2048.Board.DEFAULT_SIZE == 0
this.score % this.size == 0
this.score != size(this.grid[])-1
===========================================================================
ar.edu.unrc.game2048.Board.isLosingBoard():::EXIT241
this.size one of { 2, 4 }
return == false
===========================================================================
ar.edu.unrc.game2048.Board.isLosingBoard():::EXIT241;condition="not(return == true)"
===========================================================================
ar.edu.unrc.game2048.Board.isLosingBoard():::EXIT250
this.size one of { 2, 3 }
this.score == 0
return == false
===========================================================================
ar.edu.unrc.game2048.Board.isLosingBoard():::EXIT250;condition="not(return == true)"
===========================================================================
ar.edu.unrc.game2048.Board.isLosingBoard():::EXIT254
this.size == 2
this.grid has only one value
this.grid[] contains no nulls and has only one value, of length 2
this.score == 0
this.tileStrategy has only one value
return == false
orig(this) has only one value
this.grid[this.size-1] has only one value
this.grid[this.score] has only one value
===========================================================================
ar.edu.unrc.game2048.Board.isLosingBoard():::EXIT254;condition="not(return == true)"
===========================================================================
ar.edu.unrc.game2048.Board.isLosingBoard():::EXIT258
this.size == 2
this.grid has only one value
this.grid[] contains no nulls and has only one value, of length 2
this.score == 0
this.tileStrategy has only one value
return == true
orig(this) has only one value
this.grid[this.size-1] has only one value
this.grid[this.score] has only one value
===========================================================================
ar.edu.unrc.game2048.Board.isLosingBoard():::EXIT258;condition="return == true"
===========================================================================
ar.edu.unrc.game2048.Board.isLosingBoard():::EXIT
this.size == orig(this.size)
this.size == size(this.grid[])
this.size == orig(size(this.grid[]))
this.grid == orig(this.grid)
this.grid.getClass().getName() == orig(this.grid.getClass().getName())
this.grid[] == orig(this.grid[])
this.score == orig(this.score)
this.tileStrategy == orig(this.tileStrategy)
this.tileStrategy.getClass().getName() == orig(this.tileStrategy.getClass().getName())
(return == false)  ==>  (this.size one of { 2, 3, 4 })
(return == true)  ==>  (orig(this) has only one value)
(return == true)  ==>  (orig(this.grid[post(this.score)]) has only one value)
(return == true)  ==>  (orig(this.grid[this.score]) has only one value)
(return == true)  ==>  (this.grid has only one value)
(return == true)  ==>  (this.grid[] contains no nulls and has only one value, of length 2)
(return == true)  ==>  (this.grid[orig(this.score)] has only one value)
(return == true)  ==>  (this.grid[this.score] has only one value)
(return == true)  ==>  (this.grid[this.size-1] has only one value)
(return == true)  ==>  (this.score == 0)
(return == true)  ==>  (this.size == 2)
(return == true)  ==>  (this.tileStrategy has only one value)
this.size one of { 2, 3, 4 }
this.grid != null
this.grid[] elements != null
this.score >= 0
this.tileStrategy != null
ar.edu.unrc.game2048.Board.DEFAULT_SIZE >= this.size
this.score % ar.edu.unrc.game2048.Board.DEFAULT_SIZE == 0
this.score % this.size == 0
this.score != size(this.grid[])-1
===========================================================================
ar.edu.unrc.game2048.Board.isLosingBoard():::EXIT;condition="return == true"
this.size == 2
this.grid has only one value
this.grid[] contains no nulls and has only one value, of length 2
this.score == 0
this.tileStrategy has only one value
return == true
orig(this) has only one value
this.grid[this.size-1] has only one value
this.grid[this.score] has only one value
===========================================================================
ar.edu.unrc.game2048.Board.isLosingBoard():::EXIT;condition="not(return == true)"
return == false
===========================================================================
```

- **Clasificación**: Correcto y útil (por demostrar pureza) / Totalmente espurio (en las condiciones de derrota).
- **¿Es correcto?** A nivel estructural, es correcto. Daikon deduce en los puntos de salida (ej. `EXIT241` correspondiente al código `if (hasEmptyCells ()) { return false }`; y `EXIT258` correspondiente al final del método `return true;`) que el método no muta el estado del objeto. Todos los atributos permanecen idénticos a su estado original (`this.score == orig (this.score)`, etc.).
- **¿Es útil?** La comprobación de inmutabilidad (`== orig (...)`) es muy útil. Garantiza que verificar si el jugador perdió la partida no altera el tablero ni el puntaje (es un método de consulta pura).
- **¿Ya está expresado en otro lugar?** Las precondiciones del `ENTER` (`score >= 0`, `grid != null`) son las mismas que valida el `repOk ()` globalmente. Sin embargo, la garantía de que el método no produce efectos secundarios no está cubierta por `repOk ()` y es un aporte valioso de Daikon.
- **¿Es demasiado fuerte?** Es un gran ejemplo de invariantes demasiado fuertes o espurios debido a pruebas limitadas. En la sección `condition = "return true"` o en las implicaciones `(return == true) ==> ...`, Daikon afirma que solo se puede perder si el tablero es de 2x2 (`this.size == 2`) y el puntaje es 0 (`this.score == 0`). Esto revela que, en los tests unitarios, los pocos casos de derrota fueron escenarios artificialmente preparados con un mini tablero de 2x2 lleno de piezas sin posibilidad de fusión y con puntaje 0. Una partida estándar violaría inmediatamente este invariante. Además, Daikon hace muchas asumpciones de que ciertos campos toman apenas un conjunto de pocos valores debido a que no detecta otros en los tests.

### *5. Método `isFull ()` (`ENTER` - `EXIT`)*

```text
===========================================================================
ar.edu.unrc.game2048.Board.isFull():::ENTER
this.size == size(this.grid[])
this.size == 2
this.score == 0
===========================================================================
ar.edu.unrc.game2048.Board.isFull():::EXIT
this.size == orig(this.size)
this.size == size(this.grid[])
this.size == orig(size(this.grid[]))
this.grid == orig(this.grid)
this.grid.getClass().getName() == orig(this.grid.getClass().getName())
this.grid[] == orig(this.grid[])
this.score == orig(this.score)
this.tileStrategy == orig(this.tileStrategy)
this.tileStrategy.getClass().getName() == orig(this.tileStrategy.getClass().getName())
(return == true)  ==>  (orig(this) has only one value)
(return == true)  ==>  (this.grid has only one value)
(return == true)  ==>  (this.grid[] contains no nulls and has only one value, of length 2)
(return == true)  ==>  (this.grid[this.score] has only one value)
(return == true)  ==>  (this.grid[this.size-1] has only one value)
(return == true)  ==>  (this.tileStrategy has only one value)
this.size == 2
this.score == 0
===========================================================================
ar.edu.unrc.game2048.Board.isFull():::EXIT;condition="return == true"
this.grid has only one value
this.grid[] contains no nulls and has only one value, of length 2
this.tileStrategy has only one value
return == true
orig(this) has only one value
this.grid[this.size-1] has only one value
this.grid[this.score] has only one value
===========================================================================
ar.edu.unrc.game2048.Board.isFull():::EXIT;condition="not(return == true)"
return == false
===========================================================================
```

- **Clasificación**: Correcto y útil (por demostrar pureza) / Totalmente espurio (por escasez extrema de datos).
- **¿Es correcto?** Estructuralmente, las aserciones de inmutabilidad (`== orig (...)`) son correctas; el método solo consulta el estado delegando en `!hasEmptyCells ()` sin modificar nada. Sin embargo, afirmar globalmente que `this.size == 2` y `this.score == 0` es falso para el dominio del juego.
- **¿Es útil?** La comprobación de pureza (métodos sin efectos secundarios) es arquitectónicamente útil. Las restricciones de tamaño y puntaje, por el contrario, son inútiles y causarían fallos si se usaran como aserciones en producción.
- **¿Ya está expresado en otro lugar?** El chequeo de `this.size == size (this.grid [])` si está cubierto globalmente en el `repOk ()`. La pureza del método y que los atributos conserven su estado original no se evalúa en `repOk ()`.
- **¿Es demasiado fuerte?** Es excesivamente fuerte y revela la imposibilidad de buenas inferencias con la suite dada. En el bloque `ENTER`, Daikon afirma que cada vez que se llama a este método, el tablero era de 2x2 y el score era 0. A diferencia de `isLosingBoard` (donde el fuzzer aportó tableros de más tamaño), acá el fuzzer jamás invocó `isFull ()`. Cualquier ejecución en una partida real normal violaría este invariante inmediatamente.

### *6. Método `moveUp ()` (`ENTER` - `EXIT`)*

```text
===========================================================================
ar.edu.unrc.game2048.Board.moveUp():::ENTER
this.size == size(this.grid[])
this.size one of { 2, 4 }
this.grid != null
this.grid[] elements != null
this.score >= 0
this.tileStrategy != null
ar.edu.unrc.game2048.Board.DEFAULT_SIZE >= this.size
ar.edu.unrc.game2048.Board.DEFAULT_SIZE != this.score
this.score % ar.edu.unrc.game2048.Board.DEFAULT_SIZE == 0
this.score % this.size == 0
this.size != this.score
this.score != size(this.grid[])-1
===========================================================================
ar.edu.unrc.game2048.Board.moveUp():::EXIT
this.size == orig(this.size)
this.size == size(this.grid[])
this.size == orig(size(this.grid[]))
this.grid == orig(this.grid)
this.grid.getClass().getName() == orig(this.grid.getClass().getName())
this.grid[] == orig(this.grid[])
this.tileStrategy == orig(this.tileStrategy)
this.tileStrategy.getClass().getName() == orig(this.tileStrategy.getClass().getName())
(return == false)  ==>  (orig(this.score) one of { 0, 136 })
(return == false)  ==>  (this.score == orig(this.score))
(return == false)  ==>  (this.score one of { 0, 136 })
this.size one of { 2, 4 }
this.grid != null
this.grid[] elements != null
this.tileStrategy != null
ar.edu.unrc.game2048.Board.DEFAULT_SIZE >= this.size
this.score % ar.edu.unrc.game2048.Board.DEFAULT_SIZE == 0
this.score % this.size == 0
orig(this.score) % this.size == 0
this.size != orig(this.score)
this.score >= orig(this.score)
this.score != size(this.grid[])-1
orig(this.score) != size(this.grid[])-1
===========================================================================
ar.edu.unrc.game2048.Board.moveUp():::EXIT;condition="return == true"
return == true
===========================================================================
ar.edu.unrc.game2048.Board.moveUp():::EXIT;condition="not(return == true)"
this.score == orig(this.score)
this.score one of { 0, 136 }
return == false
===========================================================================
```

- **Clasificación**: Correcto y útil (en sus propiedades transicionales) / Demasiado fuerte y espurio (en los valores absolutos del score y size).
- **¿Es correcto?** Sí. En el `EXIT`, Daikon descubre que el tablero mantiene su estructura intacta (la referencia a la matriz, su tamaño y la estrategia no cambian: `== orig (...)`). Luego, capta la regla dorada del método: el puntaje nunca decrece (`this.score >= orig (this.score)`). Además, demuestra que si el movimiento falla o no altera el tablero (`return == false`), el puntaje no sufre modificaciones (`this.score == orig (this.score)`).
- **¿Es útil?** Absolutamente vital. Este invariante es una prueba matemática de que la lógica de acumulación de puntos (`score += mergedCell.getValue ()`) funciona siempre en forma monótonamente creciente. Si un error en el código provocara que el jugador perdiera puntos al moverse, este invariante atraparía el bug al instante.
- **¿Ya está expresado en otro lugar?** No. El método `repOk ()` solo verifica el estado estático afirmando que `score >= 0`. No tiene capacidad para evaluar la relación transicional del estado, es decir, garantizar que `score_final >= score_inicial` luego de un intento de movimiento. Daikon complementa perfectamente a `repOk ()` en este sentido.
- **¿Es demasiado fuerte?** Sí, en dos aspectos muy marcados, producto de las trazas limitadas. En primer lugar, el invariante afirma que `this.size one of { 2, 4 }` en el `ENTER`. Esto demuestra que ni las pruebas manuales ni el fuzzer lograron ejecutar `moveUp ()` en un tablero de 3x3 (o cualquier otro tamaño válido > 0). En segundo lugar, en el bloque condicional donde `return == false`, Daikon sentencia que `this.score one of { 0, 136 }`, Esto revela un claro sobreajuste (overfitting): en las trazas generadas, las únicas veces que el tablero no pudo moverse hacia arriba fue al inicio de la partida (score 0) o en una partida específica que se trabó exactamente en los 136 puntos. En una partida real, un intento válido de movimiento hacia arriba puede ocurrir con cualquier puntaje.

## ***Fase 3.3: Iteración ampliada con pruebas generadas por Randoop***

Con el objetivo de intentar eliminar las limitaciones detectadas en las pruebas manuales y evaluar cómo reacciona Daikon ante un espacio de estados más diverso, se reejecutó el análisis dinámico incorporando **523 casos de prueba automáticos generados por Randoop** (`randoopTestsConRepOk.RegressionTest`). El comando utilizado fue:

```bash
java -cp "lib/daikon.jar:target/classes:target/test-classes:$(mvn dependency:build-classpath -q -DforceStdout)" \
     daikon.Chicory \
     --ppt-select-pattern="ar.edu.unrc.game2048.Board|ar.edu.unrc.game2048.Cell" \
     --dtrace-file=daikon-traces/randoop.dtrace.gz \
     org.junit.runner.JUnitCore \
     ar.edu.unrc.game2048.BoardTest \
     ar.edu.unrc.game2048.CellTest \
     randoopTestsConRepOk.RegressionTest
```

Posteriormente, se procesó el **archivo binario** `output-randoop.inv` resultante con Daikon para generar el nuevo **reporte de texto** [`daikon-output-randoop.txt`](daikon-output-randoop.txt):

```bash
java -cp "lib/daikon.jar:target/classes" daikon.Daikon \
     daikon-traces/randoop.dtrace.gz \
     -o daikon-traces/output-randoop.inv \
     > daikon-output-randoop.txt
```

> *Nota*: El archivo de trazas generado (`randoop.dtrace.gz`) alcanzó un peso de 200 MB, superando el límite de GitHub de 100 MB por archivo. Por tal motivo, dicho archivo no se encuentra versionado en el repositorio.

### *Análisis de resultados: cambios respecto de las fases 3.1 y 3.2*

La incorporación de las trazas de Randoop generó cambios profundos, divididos entre aciertos notables en unidades aisladas y una clara evidencia de las limitaciones de las pruebas aleatorias en estructuras complejas:

- **Acierto en casos de borde (`Cell`)**: Randoop logró instanciar y probar celdas con el valor mínimo `1` (`this.value one of { 1, 2 }`). Matemáticamente, $1 = 2^0$, por lo que cumple con la validación de bits de `esPotenciaDeDos ()`. Las pruebas manuales originales y el fuzzer nunca contemplaron fichas con valor 1, debido a que naturalmente el juego 2048 comienza con fichas mínimas de valor 2 o 4. Esto demuestra la utilidad de Randoop para descubrir casos límite numéricos inesperados.
- **Degradación en ecuaciones relacionales (`Cell.mergeWith` y `Cell.canMergeWith`)**: Inesperadamente, la relación algebraica descubierta anteriormente (`2 * this.value - return.value == 0`) desapareció en este reporte. Al introducir pruebas puramente aleatorias, Randoop casi no ejecutó fusiones exitosas con fichas grandes. La escasez de datos en escenarios de celdas avanzadas provocó que Daikon "olvidara" la regla general y la redujera a rangos numéricos simples.
- **Flexibilidad en la estrategia de fichas (`TileStrategy`)**: En los análisis anteriores, Daikon había inferido restrictivamente que la estrategia del tablero debía ser obligatoriamente `RandomTileStrategy` en lo que respecta a la clase `Board`. Con la inclusión de Randoop y la ejecución de pruebas sobre los constructores alternativos que permiten inyectar la estrategia determinística `DeterministicTileStrategy` (`Board (int, TileStrategy)`), esta aserción espuria desapareció del estado global (`OBJECT`), demostrando que el diseño del tablero es desacoplado y admite cualquier implementación de la interfaz `TileStrategy`.
- **Persistencia del sobreajuste en estados profundos (`Board`)**: Los invariantes espurios más graves, como la restricción en `isLosingBoard ()` que afirma que solo se puede perder en un tablero de 2x2 con score 0, se mantuvieron intactos o con invariantes espurios similares en la mayoría de los métodos evaluados. Esto deja en evidencia que ni siquiera las pruebas aleatorias son capaces de alcanzar estados de juego complejos con secuencias lógicas precisas de decenas de movimientos.

### *Conclusión de la iteración*

La integración de Randoop demostró un **impacto de doble filo**. Por un lado, es una herramienta excelente para **inyectar aleatoriedad y descubrir valores límite a nivel de unidad**. Por el otro, confirmó que **la inferencia de invariantes dinámicos para lógicas de negocio secuenciales y profundas no puede depender de la aleatoriedad pura**. Sin una suite de pruebas guiada que explore estados avanzados del juego, la herramienta sigue siendo vulnerable a los falsos positivos por escasez de datos.

## ***Fase 4.1: Comparación Daikon vs `repOk ()`***

En el Assignment 2 **se escribieron manualmente los métodos `repOk ()` de las clases `Cell` y `Board`** para capturar el conocimiento humano sobre los estados válidos de los objetos. Al contrastar estas aserciones estáticas con la **salida inferida dinámicamente por Daikon**, se observa lo siguiente:

- **¿Qué invariantes de `repOk ()` infirió Daikon?**

     Daikon logró **redescubrir dinámicamente** casi todas las validaciones estructurales clave definidas manualmente.

     En `Board`, detectó la **existencia y validez de la grilla** (`grid != null` y `grid [] elements != null`), la **correspondencia de dimensiones** para asegurar que la matriz es cuadrada (`this.size >= 0` y `this.size == size (this.grid [])`), el **límite inferior del puntaje** (`score >= 0`) y la **instanciación de la estrategia** (`tileStrategy != null`).

     En la clase `Cell`, también detectó correctamente el **límite inferior del valor** (`value >= 0`).

- **¿Qué omitió Daikon y por qué?**

     Daikon no pudo inferir la validación recursiva y estricta de que **cada celda interna de `Board` debe cumplir individualmente con su propio `repOk ()`**, ni la regla lógica compuesta global de `Cell` que expresa que **el valor debe ser cero o una potencia de dos simultáneamente**.

     Esto ocurre porque las plantillas de Daikon se basan en un **conjunto predefinido de propiedades matemáticas**. La herramienta no puede "inventar" ni inferir lógica de negocio condicional compleja (como expresiones con operadores lógicos `OR` y `AND`) ni bucles anidados que invoquen métodos auxiliares de validación.

- **¿Infirió Daikon algún invariante nuevo, correcto y útil no incluido en `repOk ()`?**

     Sí, Daikon aportó una dimensión completamente ausente en el `repOk ()`: **los invariantes transicionales y de pureza funcional**.

     Mediante el uso de la cláusula `orig (...)`, Daikon demostró matemáticamente que métodos como `isEmpty ()`, `isFull ()` o `isLosingBoard ()` son funciones puras que **no mutan el estado del tablero** (`== orig (...)`).

     Además, descubrió **relaciones transicionales muy valiosas** que podrían usarse en pruebas unitarias o incluso como aserciones de pre y post condiciones en las implementaciones de los métodos, como el crecimiento monótono del puntaje en los movimientos (`this.score >= orig (this.score)`) y la relación algebraica exacta de las celdas tras una fusión (`2 * this.value - return.value == 0`). 

     El `repOk ()` no puede evaluar estas reglas porque **carece de "memoria"** sobre el estado previo del objeto. 

## ***Fase 4.2: Comparación Daikon vs Oráculos de prueba manuales y automatizados***

A lo largo de los cuatro Assignments, se interactuó con **diversas fuentes de oráculos**. A continuación, se contrastan sus enfoques, fortalezas y debilidades:

| **Fuente** | **Cómo se producen los oráculos** | **Fortalezas** | **Debilidades** |
| :---: | :---: | :---: | :---: |
| ***Aserciones de pruebas manuales*** | Escritas a mano por el desarrollador. | Precisas y con alto significado funcional (lógica de negocio). | Requieren mucho esfuerzo humano y pueden omitir casos de borde. |
| ***repOk ()*** | Escrito a mano por el desarrollador. | Reutilizable de forma global, se verifica constantemente. | Mismas limitaciones que las pruebas manuales (depende del diseño humano). |
| ***Aserciones de regresión (Randoop)*** | Observadas a partir de una única ejecución aleatoria. | Completamente automáticas y rápidas de generar. | Frágiles (se rompen fácil), basadas en valores crudos y sin significado semántico. |
| ***Aserciones evolutivas (EvoSuite)*** | Evolucionadas mediante algoritmos para maximizar la cobertura. | Automáticas, garantizan alta cobertura de ramas y mutantes. | Suelen ser oráculos del tipo "regresión", con secuencias difíciles de leer e interpretar. |
| ***Invariantes de Daikon*** | Inferidos dinámicamente a partir de múltiples ejecuciones. | Generalizan reglas algebraicas y transicionales a través de las ejecuciones. | Dependen 100% de la calidad de las trazas aportadas y son muy propensos a arrojar invariantes espurios. |

### *¿Qué enfoque produjo los oráculos más útiles para este programa?*

Para un proyecto con una lógica de dominio tan estricta como 2048, la combinación de **oráculos manuales (`repOk ()` y pruebas unitarias)** demostró ser el enfoque fundamentalmente más útil y confiable para validar la base del juego.

Esto se debe a que herramientas basadas en fuzzing y aleatoriedad sufren severas **limitaciones para explorar el espacio de estados profundo** (como alcanzar un "Game Over" o realizar fusiones masivas en tableros grandes), lo que provoca que los oráculos automáticos caigan en aserciones sobreajustadas o invariantes espurios.

Sin embargo, Randoop, EvoSuite y Fuzzing son herramientas muy útiles para una primera evaluación de un proyecto, detectando rápidamente sin mucho esfuerzo los **errores más grotescos** que puedan existir, así como ciertos **casos bordes** o **situaciones extraordinarias** que un desarrollador podría pasar por alto. Luego de eso, se debe complementar con una buena suite de pruebas manuales, diseñadas y guiadas lógicamente y no aleatoriamente, con el objetivo de encontrar posibles errores más finos y discretos.

Por otro lado, **Daikon demostró ser la herramienta complementaria de mayor valor analítico**. Una vez que se le proveen trazas de pruebas manuales robustas, Daikon es capaz de extraer relaciones algebraicas transicionales que el desarrollador rara vez escribe a mano por considerarlas abstractas (como la pureza de las funciones o la preservación incondicional de los atributos originales del tablero).

En este sentido, Daikon brinda excelentes invariantes principalmente para **pre y post condiciones de métodos**, los cuales pueden ser agregados como aserciones dentro del código de implementación, activadas para detectar errores durante el desarrollo y desactivadas en producción. De esta manera, complementan el trabajo del `repOk ()` manual que no debería ser delegado a Daikon, pero sí podría estar inspirado en los resultados iniciales que esta herramienta arroje.

En conclusión, **el ecosistema de testing ideal para un proyecto como 2048 resultó ser un diseño híbrido y escalonado**. La base innegociable debe ser siempre el **conocimiento humano**, expresado a través de pruebas manuales guiadas y aserciones estructurales fuertes (`repOk ()`). Sobre esta base sólida, herramientas exploratorias como **Randoop, EvoSuite y el Fuzzing** actúan como una línea de defensa vital y automatizada para estresar el sistema, maximizar la cobertura y descubrir casos límite imprevistos. Finalmente, **Daikon** corona el proceso siendo un auditor analítico excepcional, capaz de inferir reglas transicionales y algebraicas ocultas que perfeccionan el diseño sin intentar reemplazar, sino potenciar, la lógica dictada por el desarrollador.