# MeteoService with REST API

## Оглавление
* [Главная задача](#главная-задача)
* [Добавленный функционал web-приложения](#функционал)
* [Запросы приложения](#http-запросы)
* [Liquibase](#liquibase)
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
![sensor](https://github.com/necha143/MeteoService/assets/113212609/37bf8206-7e3e-43e6-a68e-0fcfc8ad30d6)

</br></br>
__/sensor/{id}__   
![sensorID](https://github.com/necha143/MeteoService/assets/113212609/3474daed-221d-4e63-8808-a151324044c4)

</br></br>
__/sensor/registration__   
![sensorReg](https://github.com/necha143/MeteoService/assets/113212609/7d5e9f8e-5168-4a54-b366-733b86ce2469)

</br></br>
__/measurements__   
![meas](https://github.com/necha143/MeteoService/assets/113212609/82930224-5772-442a-b2e2-3bc5e3bc615f)

</br></br>
__/measurements/rainyDaysCount__   
![measRain](https://github.com/necha143/MeteoService/assets/113212609/2b4ea791-6f7e-49c8-b2dd-744f48a4067c)

</br></br>
__/measurements/add__   
![measAdd](https://github.com/necha143/MeteoService/assets/113212609/f1bec538-7f3e-45a4-ba6b-010755a0d053)

</br></br>
__start client + /measurements__   
![client](https://github.com/necha143/MeteoService/assets/113212609/4856e37c-788c-42af-88d1-d9bb81b9d28f)
![clientSucc](https://github.com/necha143/MeteoService/assets/113212609/c1513e8a-07f4-4773-b09c-83def5482db3)
</br></br>

## Liquibase
__Удачное выполнение файлов миграции__
<img width="1338" alt="infos" src="https://github.com/necha143/MeteoService/assets/113212609/36b33440-fba3-42aa-bff3-01eb32b96b3c">
</br></br>

__Созданные таблицы__
<img width="487" alt="db" src="https://github.com/necha143/MeteoService/assets/113212609/8cc5aa16-2c10-4d58-aa3c-8458f45dba40">
</br></br>

[ChangeSets](https://github.com/necha143/MeteoService/tree/master/src/main/resources/db.changelog/changeset)
</br>
[ChangeLog-Master](https://github.com/necha143/MeteoService/blob/master/src/main/resources/db.changelog/db.changelog-master.yaml)
</br>


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
