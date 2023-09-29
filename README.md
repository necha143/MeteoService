# MeteoService with REST API

## Оглавление
* [Главная задача](#главная-задача)
* [Добавленный функционал web-приложения](#функционал)
* [Запросы приложения](#http-запросы)
* [Используемые технологии](#используемые-технологии)

## Главная задача
Допустим, что вы приобрели метеорологический датчик (для простоты дальше будем называть его просто "сенсор"). Этот датчик измеряет температуру окружающего воздуха и может определять, идет дождь или нет. Необходимо создать REST API сервис, который будет принимать данные от "сенсора". Также необходимо реализовать клиент, для отправки 100 запросов от сенсора.</br>

## Функционал
1) Показ всех сенсоров
2) Показ сенсора по id
3) Регистрация сенсора
4) Получение всех измерений
5) Добавление измерения от сенсора
6) Получение количества дождливых дней

## Http-запросы
__/sensor__    
![sensor](https://github.com/necha143/MeteoService/assets/113212609/4160cc7c-99db-469c-a761-fe0a5fcc2e76)

</br></br>
__/sensor/{id}__   
![sensorID](https://github.com/necha143/MeteoService/assets/113212609/35cff83a-d8e8-4c68-bf11-42fb110104da)

</br></br>
__/sensor/registration__   
![sensorReg](https://github.com/necha143/MeteoService/assets/113212609/bdeaeda1-257a-4f90-8a3a-154eff6992da)

</br></br>
__/measurements__   
![meas](https://github.com/necha143/MeteoService/assets/113212609/92917f98-a821-4819-b369-00a28365746c)

</br></br>
__/measurements/rainyDaysCount__   
![measRain](https://github.com/necha143/MeteoService/assets/113212609/d5d0a285-a825-419f-a70d-6df7cb148db5)

</br></br>
__/measurements/add__   
![measAdd](https://github.com/necha143/MeteoService/assets/113212609/490d2e9a-8277-4cd6-82fe-9f4d2ed2f5f4)

</br></br>
__start client + /measurements__   
![client](https://github.com/necha143/MeteoService/assets/113212609/f04751f7-d8c7-4841-b2f2-3c567ff3dacf)
![clientSucc](https://github.com/necha143/MeteoService/assets/113212609/7640ce21-522c-4630-9857-2d097b5f1e03)

## Используемые технологии 
* Java(JDK 17)
* Spring Framework
* Hibernate
* Spring Data JPA
* Spring REST API
* Maven
* Thymeleaf
* Hibernate validator
* ModelMapper
* PostgreSQL
* Tomcat
