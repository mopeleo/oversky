package org.oversky.dreamland.handler;

import org.oversky.base.constant.PubDefine;
import org.oversky.base.service.BaseResDto;
import org.oversky.base.service.BaseServiceException;
import org.oversky.valid.GSAValidException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.jsonwebtoken.ExpiredJwtException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(value = GSAValidException.class)
	public Object paramValidExceptionHandler(GSAValidException e) {
		log.warn("GSAValid message : {}", e.getMessage());
		BaseResDto restfulResult = new BaseResDto();
		restfulResult.setReturncode(PubDefine.RETCODE_FAILURE);
		restfulResult.setReturnmsg(e.getMessage());
		return ResponseEntity.status(HttpStatus.OK).body(restfulResult);
	}

	@ExceptionHandler(value = BaseServiceException.class)
	public Object busiExceptionHandler(BaseServiceException e) {
		log.error("业务代码执行过程中发生未知异常", e);
		BaseResDto restfulResult = new BaseResDto();
		restfulResult.setReturncode(PubDefine.RETCODE_FAILURE);
		restfulResult.setReturnmsg(e.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(restfulResult);
	}

	@ExceptionHandler(value = ExpiredJwtException.class)
	public Object tokenExpiredExceptionHandler(ExpiredJwtException e) {
		log.error("JWT valid message : {}", e.getMessage());
		BaseResDto restfulResult = new BaseResDto();
		restfulResult.setReturncode(PubDefine.RETCODE_FAILURE);
		restfulResult.setReturnmsg("用户token已过期，请重新登录");
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(restfulResult);
	}

	@ExceptionHandler({Exception.class, RuntimeException.class})
	public Object defaultExceptionHandler(Exception e) {
		log.error("服务器发生未知错误异常", e);
		BaseResDto restfulResult = new BaseResDto();
		restfulResult.setReturncode(PubDefine.RETCODE_FAILURE);
		String msg = e.getMessage();
		if(StringUtils.isEmpty(msg)) {
			msg = "服务器发生未知错误异常";
		}
		restfulResult.setReturnmsg(msg);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(restfulResult);
	}

    /**
     	* 处理所有不可知的异常
     */
    @ExceptionHandler(Throwable.class)
    public Object handleException(Throwable e){
		log.error("服务器发生未知错误异常", e);
		BaseResDto restfulResult = new BaseResDto();
		restfulResult.setReturncode(PubDefine.RETCODE_FAILURE);
		String msg = e.getMessage();
		if(StringUtils.isEmpty(msg)) {
			msg = "服务器发生未知错误异常";
		}
		restfulResult.setReturnmsg(msg);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(restfulResult);
    }
}
