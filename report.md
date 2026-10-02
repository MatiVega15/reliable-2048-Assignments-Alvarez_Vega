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