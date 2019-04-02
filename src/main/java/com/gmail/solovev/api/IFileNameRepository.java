package com.gmail.solovev.api;

import com.gmail.solovev.entity.FileName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий для работы с таблицей FILENAME
 */
@Repository
public interface IFileNameRepository extends JpaRepository<FileName, Long> {

}