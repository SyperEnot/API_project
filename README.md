<h1 >Проект по автоматизации API тестирования сервиса <a href="https://reqres.in/ ">Reqres.in</a></h1>

<p align="center">  
<img src="media/reqres.in.png" alt="MainLogo" width="950"/></a>  
</p>

# 🧾 Содержание:

- [Технологии и инструменты](#технологии-и-инструменты)
- [Реализованные проверки](#Реализованные-проверки)
- [Запуск тестов (Сборка в Jenkins и параметры)](#запуск-тестов-сборка-в-jenkins)
- [Запуск тестов (Из терминала)](#запуск-тестов-из-терминала)
- [Интеграция с Allure Report](#allure-report)
- [Интеграция с Allure TestOps](#интеграция-с-allure-testops)
- [Интеграция с Jira](#интеграция-с-jira)
- [Уведомление в Telegram о результатах выполнения автоматизированных тестов](#уведомление-в-telegram-о-результатах-выполнения-автоматизированных-тестов)

<a id="технологии-и-инструменты"></a>

## 🔨 Технологии и инструменты:
| Java                                                                                                    | IntelliJ  <br>  Idea                                                                                              | GitHub                                                                                                    | JUnit 5                                                                                                          | Gradle                                                                                                    | Rest Assured                                                                                                        | Allure <br> Report                                                                                                        | Jenkins                                                                                                         | Jira                                                                                                                                   | Telegram                                                                                                           |                                                                                               Allure <br> TestOps |
|:--------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------:|
| <a href="https://www.java.com/"><img src="media/java.svg" width="50" height="50"  alt="Java"/></a> | <a href="https://www.jetbrains.com/idea/"><img src="media/IJ.svg" width="50" height="50"  alt="IDEA"/></a> | <a href="https://github.com/"><img src="media/gitHub.svg" width="50" height="50"  alt="Github"/></a> | <a href="https://junit.org/junit5/"><img src="media/jUnit5.svg" width="50" height="50"  alt="JUnit 5"/></a> | <a href="https://gradle.org/"><img src="media/gradle.svg" width="50" height="50"  alt="Gradle"/></a> | <a href="https://selenide.org/"><img src="media/RestAssured.svg" width="50" height="50"  alt="Selenide"/></a> | <a href="https://github.com/allure-framework"><img src="media/allure.svg" width="50" height="50"  alt="Allure"/></a> | <a href="https://www.jenkins.io/"><img src="media/jenkins.svg" width="50" height="50"  alt="Jenkins"/></a> | <a href="https://www.atlassian.com/software/jira/"><img src="media/Jira.svg" width="50" height="50" alt="Java" title="Java"/></a> | <a href="https://web.telegram.org/"><img src="media/telegram.svg" width="50" height="50" alt="Telegram"/></a> | <a href="https://qameta.io/"><img src="media/AllureTestOps.svg" width="50" height="50" alt="Allure_TO"/></a> |

Автотесты написаны на языке `Java` с использованием `JUnit 5`, `Selenide`, `Rest-Assured`. Сборщик проекта - `Gradle`. Для удаленного запуска реализована задача в `Jenkins` с формированием `Allure-отчета` и
отправкой результатов в `Telegram` при помощи бота. Так же осуществлена интеграция с `Allure TestOps` и `Jira`.

<a id="Реализованные-проверки"></a>

## 🏁 Реализованные проверки:

- Создание нового пользователя (успешно)
- Регистрация пользователя (успешно)
- Отправка на регистрацию с незаполненными email/password
- Проверка данных существующего пользователя
- Обновление данных пользователя
- Удаление пользователя


<a id="запуск-тестов-сборка-в-jenkins"></a>

## <img alt="Jenkins" height="25" src="media/jenkins.svg" width="25"/> Сборка в [Jenkins](https://jenkins.autotests.cloud/job/API_prj_emonovaev/)

<p align="center">  
<img src="media/jenkins_job.png" alt="Jenkins" width="950"/></a>  
</p>

<a id="запуск-тестов-из-терминала"></a>

## 🚀 Команда для запуска автотестов из терминала

```bash  
gradle clean test 
```

<a id="allure-report"></a>

## <img alt="Allure" height="25" src="media/allure.svg" width="25"/> </a>Интеграция с <a target="_blank" href="https://jenkins.autotests.cloud/job/API_prj_emonovaev/6/allure/#">Allure Report</a>

- Основная страница отчёта
<p align="center">  
<img title="Allure Overview Dashboard" src="media/allure.png" width="850">  
</p>  

- Тест-кейсы

<p align="center">  
<img title="Allure Tests" src="media/allure_tests.png" width="850">   
</p>

## <img alt="Allure_TO" height="25" src="media/AllureTestOps.svg" width="25"/> </a>Интеграция с <a target="_blank" href="https://allure.autotests.cloud">Allure TestOps</a>

- Основная страница отчёта

<p align="center">  
<img title="Allure TestOps Dashboard" src="media/dashboard.png" width="850">  
</p>  

- Страница запуска

<p align="center">  
<img title="Allure TestOps launch" src="media/allure_launch.png" width="850">  
</p>

<a id="#интеграция-с-jira"></a>
## <img alt="Jira" height="25" src="media/Jira.svg" width="25"/></a> Интеграция с <a target="_blank" href="https://jira.autotests.cloud/browse/HOMEWORK-1094">Jira</a>

<p align="center">  
<img title="Jira" src="media/jira_task.png" width="">  
</p>

____

<a id="уведомление-в-telegram-о-результатах-выполнения-автоматизированных-тестов"></a>

## <img alt="Allure" height="25" src="media/telegram.svg" width="25"/></a> Уведомление в Telegram при помощи бота

____
<p align="center">  
<img title="TG Overview" src="media/tg.png" width="400">  
</p>

____
