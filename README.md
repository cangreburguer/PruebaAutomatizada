
# Proyecto de Automatización de Pruebas para Roblox

## Descripción
Este proyecto está desarrollado en Java y utiliza Selenium WebDriver para automatizar pruebas sobre la página web de Roblox. Permite ejecutar diversos escenarios de prueba que incluyen:

- **Inicio de sesión:** Validación del proceso de autenticación en la plataforma, tanto con credenciales correctas como incorrectas.
- **Búsqueda y navegación:** Realización de búsquedas de juegos, navegación a la página principal, acceso al perfil del usuario y selección de juegos específicos.
- **Interacción con elementos:** Ejecución de acciones como dar "Me gusta", marcar juegos como favoritos y seguirlos.
- **Generación de reportes:** Creación de reportes HTML detallados utilizando ExtentReports, con capturas de pantalla que evidencian cada paso y resultado de las pruebas.

## Características
- **Automatización de pruebas:** Implementa múltiples escenarios de prueba sobre la web de Roblox para validar la funcionalidad.
- **Capturas de pantalla automáticas:** Se generan y guardan en la carpeta `screenshots`, permitiendo revisar visualmente los estados de la aplicación.
- **Reportes HTML:** Al finalizar la ejecución, se genera un reporte en `test-output/roblox-report.html` que documenta el progreso y resultados de cada caso de prueba.
- **Gestión del ChromeDriver:** Utiliza WebDriverManager para gestionar la descarga y configuración del ChromeDriver.
- **Integración con JUnit 5:** Aprovecha la estructura y herramientas de JUnit 5 para la organización y ejecución de las pruebas.

## Requisitos
- **Java 8 o superior.**
- **Google Chrome** instalado en la máquina.
- **Dependencias:**  
  - Selenium WebDriver.
  - ExtentReports.
  - JUnit 5.
  - WebDriverManager.
- Se recomienda el uso de un gestor de dependencias como Maven o Gradle.

## Configuración y Ejecución

### 1. Clonar el repositorio
Clona el repositorio en tu máquina local:
```bash
git clone <URL-del-repositorio>
```

### 2. Instalar las dependencias
- **Maven:** Asegúrate de tener el archivo `pom.xml` configurado y ejecuta:
  ```bash
  mvn clean install
  ```
- **Gradle:** Verifica que el archivo `build.gradle` esté correctamente configurado y ejecuta:
  ```bash
  gradle build
  ```

### 3. Ejecutar las pruebas
Puedes ejecutar el conjunto de pruebas utilizando uno de los siguientes comandos:

- **Con Maven:**
  ```bash
  mvn test
  ```
- **Con Gradle:**
  ```bash
  gradle test
  ```

### 4. Visualizar el reporte
Una vez finalizada la ejecución, abre el archivo generado en:
```
test-output/roblox-report.html
```
para revisar el reporte completo con los resultados y las capturas de pantalla.

## Estructura del Proyecto

- **com.robloxtest.ExtentReportUtil:**  
  Esta clase se encarga de inicializar y configurar el reporte HTML mediante ExtentReports. Se definen parámetros como:
  - Nombre del reporte.
  - Título del documento.
  - Codificación y tema (oscuro).
  - Información del entorno (Tester, Browser, Environment).

- **com.robloxtest.RobloxTest:**  
  Clase que contiene la suite de pruebas automatizadas, organizada en diferentes métodos:
  - **testLogin y testLoginGeneral:** Pruebas para el inicio de sesión.
  - **testBuscarJuego:** Búsqueda de un juego específico y verificación de su acceso.
  - **testVolverHomePage:** Navegación de regreso a la página principal después de una búsqueda.
  - **testAbrirPerfil:** Acceso al perfil del usuario desde el menú.
  - **testMarcarJuego:** Ejecución de interacciones sobre un juego (dar "Me gusta", marcar como favorito y seguir).
  - **testLoginFail:** Verificación del manejo de credenciales incorrectas.
  
  Además, se incluye el método `takeScreenshot`, el cual captura y guarda imágenes en la carpeta `screenshots`.

## Notas Adicionales
- **Capturas de pantalla:** Las imágenes se guardan en la carpeta `screenshots`. Si la carpeta no existe, se crea automáticamente.
- **Credenciales:** Las pruebas utilizan datos de ejemplo para las credenciales, los cuales deberán actualizarse según el entorno de prueba.
- **Reportes:** El reporte HTML se genera de forma automática y se encuentra en `test-output/roblox-report.html` tras la ejecución de las pruebas.

