package com.gmail.solovev.api;

import com.gmail.solovev.exception.AccessForbiddenException;

import java.util.List;

/**
 *  Поиск тестовых файлов
 */
public interface IFileHandler {

    List<String> findNumber(Integer number) throws AccessForbiddenException;

}
