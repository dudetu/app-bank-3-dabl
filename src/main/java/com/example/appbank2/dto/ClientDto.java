package com.example.appbank2.dto;
import lombok.Data;

/**
 * Класс представляет собой объект данных (DTO) для клиента.
 */
@Data
public class ClientDto {

    /** Полное имя клиента. */
    private String fullname;

    /** Адрес электронной почты клиента. */
    private String email;

    /**
     * Конструктор с параметрами, используемый для инициализации полей объекта.
     *
     * @param l       Не используется (заглушка).
     * @param janeDoe Не используется (заглушка).
     */
    public ClientDto(long l, String janeDoe) {
    }

    /** Конструктор по умолчанию. */
    public ClientDto() {

    }
}
