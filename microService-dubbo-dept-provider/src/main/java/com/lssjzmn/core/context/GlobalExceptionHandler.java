package com.lssjzmn.core.context;

import com.lssjzmn.model.SimpResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public SimpResult handleException(HttpServletRequest request, Exception e) {
        e.printStackTrace();
        StringBuilder errorsMsg = new StringBuilder();
        if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException methodArgumentNotValidException = (MethodArgumentNotValidException) e;
            BindingResult bindingResult = methodArgumentNotValidException.getBindingResult();
            List<ObjectError> errors = bindingResult.getAllErrors();
            for (ObjectError objectError : errors) {
                String objectName = objectError.getCodes()[0].split("\\.")[1];
                String fieldName = objectError.getCodes()[0].split("\\.")[2];
                errorsMsg.append(objectName + "." + fieldName + ":" + objectError.getDefaultMessage() + " ");
            }
        } else {
            errorsMsg.append(e.getMessage());
        }
        SimpResult simpResult = new SimpResult();
        return simpResult.failer(-1, errorsMsg.toString());
    }

}
