package com.gmail.solovev.endpoint;

import com.gmail.solovev.api.IFileHandler;
import com.gmail.solovev.api.IFileNameService;
import com.gmail.solovev.dto.FileNameDto;
import com.gmail.solovev.exception.AccessForbiddenException;
import com.gmail.solovev.webservice.GetFileNameRequest;
import com.gmail.solovev.webservice.GetFileNameResponse;
import com.gmail.solovev.webservice.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

/**
 * Класс для обработки входящих SOAP сообщений
 */
@Endpoint
public class FilenameEndpoint {
    private static final String NAMESPACE_URI = "http://localhost:8800/webservice";

    private IFileHandler fileHandler;
    private IFileNameService repository;

    @Autowired
    public FilenameEndpoint(IFileHandler fileHandler, IFileNameService repository) {
        this.fileHandler = fileHandler;
        this.repository = repository;
    }

    /**
     * Выбор метода обработчика на основе namespace и localPart сообщения @return GetFilenameResponse
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getFilenameRequest")
    @ResponsePayload
    public GetFileNameResponse findNumber(@RequestPayload GetFileNameRequest request) {
        GetFileNameResponse response = new GetFileNameResponse();
        Result result = new Result();
        try {
            List<String> number = fileHandler.findNumber(request.getNumber());
            if (number == null || number.size() == 0) {
                result.setCode(Code.NOT_FOUND.getDescription());
            } else {
                result.getFilenames().addAll(number);
                result.setCode(Code.OK.getDescription());
            }
        } catch (AccessForbiddenException e) {
            result.setCode(Code.ERROR.getDescription());
            result.setError(e.getMessage());
        }

        save(request.getNumber(), result);

        response.setResult(result);

        return response;
    }

    private void save(int number, Result result) {
        final FileNameDto fileNameDto = new FileNameDto();
        fileNameDto.setCode(result.getCode());
        fileNameDto.setNumber(number);
        fileNameDto.setFilenames(result.getFilenames());
        fileNameDto.setError(result.getError());
        repository.save(fileNameDto);
    }
}
