package com.gmail.solovev.service;


import com.gmail.solovev.api.IFileNameRepository;
import com.gmail.solovev.api.IFileNameService;
import com.gmail.solovev.dto.FileNameDto;
import com.gmail.solovev.entity.FileName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Сервис для сохранения сущности DbFilename в БД
 */
@Component
public class FileNameServiceImpl implements IFileNameService {

    private final IFileNameRepository repository;

    @Autowired
    public FileNameServiceImpl(IFileNameRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(FileNameDto filenameDTO) {
        repository.save(createFilenameEntity(filenameDTO));
    }

    private FileName createFilenameEntity(FileNameDto filenameDTO) {
        final FileName dbFilename = new FileName();
        dbFilename.setId();
        dbFilename.setCode(filenameDTO.getCode());
        dbFilename.setFilenames(filenameDTO.getFilenames());
        dbFilename.setNumber(filenameDTO.getNumber());
        dbFilename.setError(filenameDTO.getError());

        return dbFilename;
    }

}
