 ## ParseUrl

### Тестовое задание от Analytics Company

#### Описание 
___
```sh
 Есть два сайта: https://finance.yahoo.com/ и https://www.indeed.com/.
 На которых есть страницы с информацией о компаниях.
 Название индустрий отличаются на двух сайтах.
 Например компания Alphabet на https://finance.yahoo.com/quote/GOOG/profile?p=GOOG https://www.indeed.com/cmp/Alphabet Industry: Internet Content & Information Information Technology
 Нужно придумать способ объединить название индустрий на двух сайтах.
 finance.yahoo.comfinance.yahoo.com Yahoo Finance - Stock Market Live, Quotes, Business & Finance News At Yahoo Finance, you get free stock quotes, up-to-date news, portfolio management resources, international market data, social interaction and mortgage rates that help you manage your financial life.(2 КБ) 
 https://finance.yahoo.com/ indeed.com Job Search | Indeed With Indeed, you can search millions of jobs online to find the next step in your career. With tools for job search, resumes, company reviews and more, we're with you every step of the way. finance.yahoo.comfinance.yahoo.com Alphabet Inc. (GOOG) Company Profile & Facts - Yahoo Finance See the company profile for Alphabet Inc. (GOOG) including business summary, industry/sector information, number of employees, business summary, corporate governance, key executives and their compensation. (2 КБ)
 https://finance.yahoo.com/quote/GOOG/profile?p=GOOG Indeed.comIndeed.com Alphabet Careers and Employment Find out what works well at Alphabet from the people who know best. Get the inside scoop on jobs, salaries, top office locations, and CEO insights. Compare pay for popular roles and read about the team’s work-life balance. Uncover why Alphabet is the best company for you.
 Вам нужно выбрать 50 любых индустрий на двух сайтах и объединить их в одну с помощью программы , которую Вы сами придумаете
 ```
 ### Endpoints:
___
Получить Базу:
```sh
http://localhost:8082/main
```
### Настройка БД:
___
```sh
Используется PostgreSQL
Дамп - dump-postgres-202208211339
```
### Запуск .jar:
___
```sh
java -jar ParseUrl.jar
```
