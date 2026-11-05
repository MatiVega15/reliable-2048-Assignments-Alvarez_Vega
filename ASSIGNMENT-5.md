# Assignment 5: Grammar & Mutation Fuzzing and LLM-based Oracle Refinement

## Ejercicio 1

**a.** Desarrollar una funcionalidad de su implementación de *2048* que permita comenzar con un tablero inicial dado como un string, por ejemplo: `[0,0,0,0,4,2,0,0,0,0,0,0,2,2,2,2]`. Implemente un *grammar-based fuzzer* para generar los tableros, y un arnés para fuzzear su implementación. Genere una gran cantidad de tableros usando fuzzing y evalúe su implementación en busca de nuevos errores. Documente y corrija los errores encontrados.

**b.** Desarrolle un *mutador básico* (e.g., que implemente agregado, modificación, eliminación de caracteres en un string) para generar tableros inválidos a partir de las cadenas generadas por el fuzzer anterior. Construya un arnés para fuzzear su implementación. Verifique que su implementación rechaza los tableros inválidos, sin crashear. Documente y corrija los errores encontrados.

***

## Ejercicio 2

Implemente una versión sencilla de la herramienta *OASIs* para refinamiento de oráculos utilizando *LLMs*. La idea es, dado un programa y una aserción, hacer consultas a un LLM para generar feedback que sirva al usuario para refinar la aserción. 

* Para aserciones que son **falsos positivos** (demasiado fuertes), la herramienta debería generar tests para el programa que violen la aserción. 
* Para aserciones que son **falsos negativos** (demasiado débiles), la herramienta debería producir mutantes que la aserción no puede matar. 

> **Nota:** Recordar que la idea de OASIs es proveer feedback al usuario, por lo que la decisión final de refinar la aserción la toma el usuario.

Desarrolle al menos **dos casos de estudio** en los que aplicar la herramienta, y documente los resultados. Los casos de estudio pueden consistir, por ejemplo, en refinamientos de postcondiciones para métodos simples Java. Por ejemplo, podría utilizar contratos *Daikon* que haya descubierto que son muy débiles y aplicar la herramienta para refinarlos.

Su implementación debe hacer consultas a un LLM a través de una API key. Puede usar cualquier modelo *open source* con API keys gratuitas. Algunas opciones son:

- [OpenRouter - Free Models](https://openrouter.ai/collections/free-models)
- [NVIDIA Build - Models](https://build.nvidia.com/models)

*Se recomienda implementar esta herramienta en Python.*