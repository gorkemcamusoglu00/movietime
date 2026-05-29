# 🎬 MovieTime

Film bilgilerini yönetmek için geliştirilmiş RESTful bir backend API projesidir. Spring Boot ile yazılmış olup CRUD işlemleri, rol tabanlı erişim kontrolü ve gelişmiş filtreleme özelliklerine sahiptir.

---

## 🚀 Kullanılan Teknolojiler

| Teknoloji | Açıklama |
|---|---|
| Java 17 | Ana programlama dili |
| Spring Boot | Backend framework |
| Spring Data JPA | Veritabanı yönetimi ve ORM |
| Spring Security | Kimlik doğrulama ve RBAC |
| H2 Database | In-memory veritabanı |
| Jakarta Validation | DTO doğrulama |
| Maven | Bağımlılık yönetimi |

---

## 📁 Proje Yapısı

```
movietime/
├── src/main/java/org/example/movietime/
│   ├── config/
│   │   └── SecurityConfig.java       # Spring Security & RBAC ayarları
│   ├── controller/
│   │   └── MovieController.java      # HTTP isteklerini karşılar
│   ├── dto/
│   │   └── MovieRequest.java         # Gelen veriyi doğrular
│   ├── entity/
│   │   └── Movie.java                # Veritabanı tablosu modeli
│   ├── exception/
│   │   └── GlobalExceptionHandler.java  # Merkezi hata yönetimi
│   ├── repository/
│   │   └── MovieRepository.java      # CRUD + Derived Query Methods
│   ├── service/
│   │   └── MovieService.java         # İş mantığı
│   └── MovietimeApplication.java
├── frontend/
│   └── movietime-frontend.html       # Görsel arayüz
└── pom.xml
```

---

## 🔐 Kullanıcılar ve Roller (RBAC)

| Kullanıcı | Şifre | Rol | İzinler |
|---|---|---|---|
| `user` | `1234` | USER | Yalnızca GET |
| `admin` | `admin123` | ADMIN | GET, POST, PUT, DELETE |

---

## 📡 API Endpointleri

| Method | Endpoint | Açıklama | Yetki |
|---|---|---|---|
| GET | `/movies` | Tüm filmleri listele | USER, ADMIN |
| GET | `/movies/{id}` | ID'ye göre film getir | USER, ADMIN |
| GET | `/movies/search?title=` | Film adına göre ara | USER, ADMIN |
| GET | `/movies/genre/{genre}` | Türe göre filtrele | USER, ADMIN |
| GET | `/movies/top-rated` | En yüksek puanlı 5 film | USER, ADMIN |
| POST | `/movies` | Yeni film ekle | ADMIN |
| PUT | `/movies/{id}` | Film güncelle | ADMIN |
| DELETE | `/movies/{id}` | Film sil | ADMIN |

---

## ⚙️ Kurulum ve Çalıştırma

### Gereksinimler

- Java 17+
- Maven
- IntelliJ IDEA (önerilen)

### Adımlar

1. Repoyu klonla:
```bash
git clone https://github.com/gorkemcamusoglu00/movietime.git
cd movietime
```

2. Uygulamayı başlat:
```bash
./mvnw spring-boot:run
```

3. API çalışıyor mu kontrol et:
```
http://localhost:8080/movies
```

> Kullanıcı adı: `user` — Şifre: `1234`

### H2 Veritabanı Konsolu

Uygulama çalışırken tarayıcıdan erişilebilir:
```
http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:testdb
```

---

## 🖥️ Frontend Arayüzü

`frontend/movietime-frontend.html` dosyasına çift tıklayarak tarayıcıda açılır. Açılan login ekranından kullanıcı adı ve şifre ile giriş yapılır. Spring Boot çalışır durumdayken kimlik doğrulama API üzerinden gerçek zamanlı yapılır. OMDB API üzerinden gerçek film afişleri otomatik olarak çekilir.

---

## 📬 Postman ile Test

Basic Auth kullanılarak test edilebilir.

Örnek istek (film ekle):
```json
POST http://localhost:8080/movies
Authorization: Basic admin admin123

{
  "title": "Inception",
  "description": "Rüya içinde rüya kurgusu üzerine bir aksiyon filmi.",
  "genre": "Sci-Fi",
  "releaseYear": 2010,
  "rating": 8.8
}
```
