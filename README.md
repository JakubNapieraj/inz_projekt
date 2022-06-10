# Menedżer Haseł Online - MHO

## Spis treści
- [Menedżer Haseł Online - MHO](#menedżer-haseł-online---mho)
  - [Spis treści](#spis-treści)
  - [Opis](#opis)
  - [Diagramy](#diagramy)
    - [Diagram wzorca projektowego UML](#diagram-wzorca-projektowego-uml)
    - [Diagram klas UML](#diagram-klas-uml)
    - [Diagram użycia (Use-Case Diagram)](#diagram-użycia-use-case-diagram)
  - [Obsługa narzędzia](#obsługa-narzędzia)
    - [Uruchomienie programu](#uruchomienie-programu)
    - [Logowanie](#logowanie)
    - [Rejestracja](#rejestracja)
    - [Interfejs zalogowanego użytkownika](#interfejs-zalogowanego-użytkownika)
    - [Wyszukiwanie hasła](#wyszukiwanie-hasła)
    - [Rejestracja nowej pozycji](#rejestracja-nowej-pozycji)
    - [Edycja pozycji](#edycja-pozycji)
  - [Czynności administracyjne](#czynności-administracyjne)
    - [Zarządzanie bazą danych](#zarządzanie-bazą-danych)

## Opis

Aplikacja "web-based" stworzona na podstawie [Spring Boot Framework](https://spring.io/) oraz [H2 Database Engine](http://h2database.com/html/main.html). Pozwala na przetrzymywanie nieograniczonej ilości haseł do popularnych stron internetowych, szyfrowanych w bazie danych. Program jest skierowany do osób, które chciałyby zapisywać wszystkie swoje dane dostępowe w jednym miejscu. Działa w systemach opracyjnych: Windows, MacOS, Linux.

## Diagramy

### Diagram wzorca projektowego UML
![diagram_wzorca_uml](https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fsomospnt.com%2Fimages%2Fblog%2Farticulos%2F159-node-mvc%2Fmodel-view-controller-light-blue.png&f=1&nofb=1)

### Diagram klas UML
![diagram_klas_uml](https://cdn.discordapp.com/attachments/981690125190836304/982515354729324594/InzynieriaProjekt.jpg)

### Diagram użycia (Use-Case Diagram)
![diagram_uzycia](https://scontent.xx.fbcdn.net/v/t1.15752-9/286586339_395303169315769_7686017604562546848_n.png?stp=dst-png_p403x403&_nc_cat=108&ccb=1-7&_nc_sid=aee45a&_nc_ohc=NdZviy3xVPAAX_Sq5qz&_nc_ad=z-m&_nc_cid=0&_nc_ht=scontent.xx&oh=03_AVLFX_k3AO5M2yuURHuJwhrLOfMTqHAiW4UaqUXVfmlfyA&oe=62CA9E3E)


## Obsługa narzędzia

### Uruchomienie programu
Po uruchomieniu programu strona będzie dostępna pod adresem IP oraz portem 8080 aktualnego komputera/serwera. Po wygenerowaniu pliku .jar, można aplikację uruchomić przez:

```sh
  java -jar aplikacja.jar
```

Aby dostać się do strony logowania należy wpisać adres URL, np.:
```
  https://localhost:8080
```

### Logowanie
Po załadowaniu strony wyświetli nam się strona logowania. Jeżeli mamy już konto to wystarczy wpisać swój Login (Username) oraz Hasło (Password).
![strona_logowania](https://i.imgur.com/I4mLZ8J.png)

### Rejestracja
Jednak w sytuacji gdy nie posiadamy jeszcze konta, należy zarejestrować się. Zostaniemy przeniesieni do strony z rejestracją po kliknięciu **Register here**.
![strona_rejestracji](https://i.imgur.com/jSFu3WU.png)


### Interfejs zalogowanego użytkownika
Po udanej próbie zalogowania, aplikacja przeniesie nas do głównego strony zarządzania naszymi zapisanymi hasłami. Pozycje są przedstawione w formie tabeli z takimi danymi jak:
 - Strona (adres url)
 - Login
 - Hasło
 - Ostatnia zmiana hasła
 - Przyciski do usuwania/edycji pozycji

Interfejs wygląda następująco:
![strona_po_zalogowaniu](https://i.imgur.com/HOpcUXp.png)

### Wyszukiwanie hasła
Pod komunikatem o udanym zalogowaniu, mamy pasek wyszukiwania. Tutaj można wyszukać strony url, które nas interesują. Funkcjonalność działa na bazie wyrażeń regularnych. W przypadku kiedy wprowadzimy pierwsze litery interesującej nas rekordu, zostanie ono poprawnie odnaleziona:
![wyszukiwanie](https://i.imgur.com/0UUqKyX.png)

### Rejestracja nowej pozycji
Przy chęci zarejestrowania nowego hasła, użytkownik zostanie przeniesiony na podstronę, gdzie może wprowadzić swoje nowe dane do bazy danych.
![rejestracja_hasla](https://i.imgur.com/Xk4Ma4N.png)

### Edycja pozycji
Po przejściu do edycji naszej wygranej pozycji, ukażę nam się strona specjalnie dedykowana pod zmianę adresu e-mail, url strony lub samego hasła zapisanego w bazie danych. Operację zapisania naszej edycji akceptujemy przyciskiem **Save**.
![edycja_hasla](https://i.imgur.com/o08ZQ9N.png)

## Czynności administracyjne

### Zarządzanie bazą danych
Dostęp do bazy danych jest dostępny nawet z poziomu przeglądarki pod adresem:

```sh
  localhost:8080/h2
```

![baza_logowanie](https://i.imgur.com/OFBqDjp.png)

Aplikacja korzysta ze sterownika [JDBC](https://pl.wikipedia.org/wiki/Java_DataBase_Connectivity). W ten sposób komunikuję się automatycznie z bazą danych i wykonuje takie operacje jak **SELECT**, **UPDATE**, **INSERT INTO**, **DELETE**.
