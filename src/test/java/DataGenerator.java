

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generationDate(int shift) {
        return LocalDate.now().plusDays(shift).
                format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateCity() {
        var cities = new String[]{
                "Алушта", "Феодосия", "Ялта", "Севастополь", "Симферополь", "Абакан", "Адлер", "Анапа",
                "Ангарск", "Архангельск", "Астрахань", "Барнаул", "Белгород", "Благовещенск", "Чебоксары",
                "Челябинск", "Череповец", "Черняховск", "Чита", "Екатеринбург", "Геленджик", "Иркутск",
                "Ижевск", "Кабардинка", "Калининград", "Казань", "Кемерово", "Хабаровск", "Ханты-Мансийск",
                "Кисловодск", "Комсомольск-на-Амуре", "Кострома", "Краснодар", "Красноярск", "Курган",
                "Курск", "Липецк", "Листвянка", "Магадан", "Магнитогорск", "Махачкала", "Минеральные Воды",
                "Москва", "Мурманск", "Находка", "Нальчик", "Нижневартовск", "Нижний Новгород", "Ноябрьск",
                "Норильск", "Новокузнецк", "Новороссийск"
        };
        return cities[new Random().nextInt(cities.length)];

    }

    public static String generateName(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.name().lastName() + " " + faker.name().firstName();
    }

    public static String generatePhone(String locale) {
        var faker = new Faker(new Locale(locale));
        ;
        return faker.phoneNumber().phoneNumber();
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            return new UserInfo(generateCity(), generateName("ru"), generatePhone("ru"));
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}