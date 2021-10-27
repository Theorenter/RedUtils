<h2 align="center">
    <img src=".\readme-resources\logo-redutils.png" alt="RedUtils logo">
    <p>RedUtils – Технический плагин для RedProject</p>
</h2>

**Загрузка:**
- <img src=".\readme-resources\download-icon.png" width="20px"> <a href="https://github.com/Theorenter/RedUtils/releases">Все загрузки</a>

-----
<H2>Цель плагина</H3>

<p>Данный Spigot плагин <b><i>предназначен для внутреннего использования</i></b> и представляет собой инструментарий для реализации ряда задач:</p>
<ul>
    <li>Обработка HEX-цветов;</li>
    <li>Реализация продвинутых команд;</li>
    <li>Создание плагинов с клиент-ориентированной локализацией.</li>
</ul>
<p>Также, в ближайшем будущем, планируется введение следующих механик:</p>
<ul>
    <li>Реализация системы GUI через объекты инвентаря;</li>
    <li>Введение продвинутых пользовательских аргументов для команд.</li>
</ul>

-----
<H2>Использование</H2>
<p><b>ВАЖНО:</b> Использование библиотеки RedUtils требует, чтобы основной класс Вашего плагина наследовал интерфейс RedPlugin и, соответственно, реализовывал методы данного интерфейса!</p>
<details>
    <summary><b>Внедрение RedUtils в свой проект</b></summary>
    <ol type="1"><br>
        <li>Укажите в <code>plugin.yml</code> Вашего плагина зависимость от RedUtils:

````yaml
depend: [ RedUtils ]
````
</li><br>
        <li>Добавьте в свой <code>pom.xml</code> репозиторий jitpack.io и зависимость от RedUtils:

````xml
<repositories>
  <repository>
    <id>jitpack-io</id>
    <url>https://jitpack.io</url>
  </repository>
  ...
</repositories>
````

````xml
<dependencies>
  <dependency>
    <groupId>com.github.Theorenter</groupId>
    <artifactId>RedUtils</artifactId>
    <version>0.2.0-indev</version>
    <scope>provided</scope>
  </dependency>
</dependencies>
````

</li><br>

<li>Создайте в основном классе Вашего плагина поле класса <code>RedUtilsAPI</code> и имплементируйте интерфейс <code>RedPlugin</code>:

````java
public final class MyPlugin extends JavaPlugin implements RedPlugin {
    
    private RedUtilsAPI redUtilsAPI;
     // ...
}
````
</li><br>

<li>Инициализируйте RedUtilsAPI и добавьте проверку наличия плагина RedUtils в методе <code>onEnable()</code> основного класса:

````java
public final class MyPlugin extends JavaPlugin implements RedPlugin {
    // ...
    
    public void onEnable() {

        // RedUtils API check
        try {
            redUtilsAPI = RedUtils.instance().API();
        } catch (NoClassDefFoundError e) {
            getLogger().severe("\u001B[31mYour plugin cannot be enabled without the RedUtils plugin.\u001B[0m");
            getLogger().severe("\u001B[31mInstall the RedUtils plugin first!\u001B[0m");
            getLogger().info("");
            getLogger().info("--- \u001B[1;33mYOURPLUGIN HAS BEEN \u001B[0m\u001B[31mDISABLED\u001B[0m -----------------------------");
            setEnabled(false);
            return;
        }
    }
    // ...
}
````
</li><br>

<li>Объявите и инициализируйте основные менеджеры:

````java
public final class MyPlugin extends JavaPlugin implements RedPlugin {
    // ...
    private RedLogger redLogger;
    private CommandManager cmdManager;
    private NotificationManager ntfManager;
    
    public void onEnable() {
        // ...
        
        // Managers init
        redLogger = redUtilsAPI.createRedLogger(this);
        cmdManager = redUtilsAPI.createCommandManager(this);
        ntfManager = redUtilsAPI.createNotificationManager(this);
    
    }
    // ...
}
````

<li>Пропишите возврат менеджеров в наследных методах:

````java
public final class MyPlugin extends JavaPlugin implements RedPlugin {
    // ...
    
    @Override
    public boolean isDebug() {
        // Здесь, по-хорошему, должно браться
        // значение из конфигурации
        return false;
    }

    @Override
    public RedLocalization getLocalization() {
        return null;
    }

    @Override
    public RedConfiguration getRConfig() {
        return null;
    }
    
    
    // ...
}
````

</li><br>

<li><a href="https://github.com/Theorenter/RedUtils/releases">Скачайте</a> и закиньте в папку <code>plugins</code> Вашего сервера версию <code>RedUtils.jar</code>, которая указана Вами в зависимости <code>pom.xml</code>.</li><br>

<li><b>Поздравляю</b>, всё сделано успешно! Теперь Вы можете запустить свой плагин и взаимодействовать в нём с <code>RedUtilsAPI</code></li>
    </ol>
</details>