[![Kotlin CI with Gradle](https://github.com/danuser2018/blockchain/actions/workflows/build.yml/badge.svg)](https://github.com/danuser2018/blockchain/actions/workflows/build.yml)
[![CD deployment with Jitpack](https://github.com/danuser2018/blockchain/actions/workflows/deploy.yml/badge.svg)](https://github.com/danuser2018/blockchain/actions/workflows/deploy.yml)
[![](https://jitpack.io/v/danuser2018/blockchain.svg)](https://jitpack.io/#danuser2018/blockchain)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=danuser2018_blockchain&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=danuser2018_blockchain)
# Librería Blockchain en Kotlin

Mi propia implementación de un blockchain muy sencillo con fines educativos. Está desarrollado enteramente en Kotlin, 
con un enfoque funcional.

Esta librería se desarrolla a partir de los ejercicios realizados durante el curso _Blockchain de la A a la Z: 
Crea tu propia criptomoneda en python_ que puedes encontrar en 
[Udemy](https://www.udemy.com/course/blockchain-de-la-a-a-la-z-crea-tu-criptomoneda-en-python).

Dado que se trata de un ejercicio meramente educativo, encaminado a entender cómo funcionan las cadenas de bloques,
**se desaconseja totalmente su uso en entornos productivos**. Repito, **NO LO USES NUNCA EN PRODUCCIÓN**.

## Cómo importar la librería en tu proyecto

Los paquetes se generan automáticamente en [Jitpack](https://jitpack.io/#danuser2018/blockchain). Para utilizarlo en tu
projecto, con gradle:

1. Añade el repo de Jitpack

```gradle
repositories {
	...
	maven { url 'https://jitpack.io' }
}
```

2. Añade la dependencia

```gradle
dependencies {
    implementation 'com.github.danuser2018:blockchain:Tag'
}
```

Asegúrate de tomar siempre la última versión.

## Créditos

- [Equipo de SuperData Science](https://www.udemy.com/user/superdatascience-team). Desarrolladores del curso
_Blockchain de la A a la Z: Crea tu propia criptomoneda en python_ que puedes encontrar en
  [Udemy](https://www.udemy.com/course/blockchain-de-la-a-a-la-z-crea-tu-criptomoneda-en-python).

## Licencia

The MIT License (MIT)

Copyright © 2022 danuser2018

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the “Software”), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
