package ru.allwdesign.firstapplication

sealed class ValidationResult {
    object Success : ValidationResult()
    data class Error(val message: String) : ValidationResult()
}

fun validateMessage(text: String): ValidationResult {
    val clean = text.trim()
    return when {
        clean.isEmpty() -> ValidationResult.Error("Введите сообщение (не только пробелы)")
        clean.length > 200 -> ValidationResult.Error("Сообщение слишком длинное (максимум 200 символов)")
        else -> ValidationResult.Success
    }
}

fun validatePhone(text: String): ValidationResult {
    val clean = text.trim()
    return when {
        clean.isEmpty() -> ValidationResult.Error("Введите номер телефона")
        !clean.any { it.isDigit() } -> ValidationResult.Error("Для звонка нужен номер (хотя бы одна цифра)")
        else -> ValidationResult.Success
    }
}