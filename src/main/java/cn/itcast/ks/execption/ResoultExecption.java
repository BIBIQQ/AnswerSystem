package cn.itcast.ks.execption;

import cn.itcast.ks.common.AppHttpCodeEnum;
import cn.itcast.ks.common.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 通用异常处理器
 */
//@ControllerAdvice
@Slf4j
public class ResoultExecption {

    @ExceptionHandler(Exception.class)
    public ResponseResult ex1(Exception e){
        log.error(e.getMessage());
        return ResponseResult.errorResult(AppHttpCodeEnum.SERVER_ERROR);
    }

}
