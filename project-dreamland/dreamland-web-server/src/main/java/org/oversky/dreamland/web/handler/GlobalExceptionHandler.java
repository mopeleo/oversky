package org.oversky.dreamland.web.handler;

import org.oversky.base.constant.PubDefine;
import org.oversky.base.service.BaseResDto;
import org.oversky.base.service.BaseServiceException;
import org.oversky.dreamland.web.config.WebException;
import org.oversky.valid.GSAValidException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.ExpiredJwtException;

@RestController
@ControllerAdvice
public class GlobalExceptionHandler {
	
	private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(value = WebException.class)
	public Object webExceptionHandler(WebException e) {
		log.warn("web message : {}", e.getMessage());
		BaseResDto restfulResult = new BaseResDto();
		restfulResult.setReturncode(PubDefine.RETCODE_FAILURE);
		restfulResult.setReturnmsg(e.getMessage());
		restfulResult.setSuccess(false);
		return ResponseEntity.status(e.getHttpStatus()).body(restfulResult);
	}

	@ExceptionHandler(value = GSAValidException.class)
	public Object paramValidExceptionHandler(GSAValidException e) {
		log.warn("GSAValid message : {}", e.getMessage());
		BaseResDto restfulResult = new BaseResDto();
		restfulResult.setReturncode(PubDefine.RETCODE_FAILURE);
		restfulResult.setReturnmsg(e.getMessage());
		restfulResult.setSuccess(false);
		return ResponseEntity.status(HttpStatus.OK).body(restfulResult);
	}

	@ExceptionHandler(value = BaseServiceException.class)
	public Object busiExceptionHandler(BaseServiceException e) {
		log.error("业务代码执行过程中发生未知异常", e);
		BaseResDto restfulResult = new BaseResDto();
		restfulResult.setReturncode(PubDefine.RETCODE_FAILURE);
		restfulResult.setReturnmsg(e.getMessage());
		restfulResult.setSuccess(false);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(restfulResult);
	}

	@ExceptionHandler(value = ExpiredJwtException.class)
	public Object tokenExpiredExceptionHandler(ExpiredJwtException e) {
		log.warn("JWT valid message : {}", e.getMessage());
		BaseResDto restfulResult = new BaseResDto();
		restfulResult.setReturncode(PubDefine.RETCODE_FAILURE);
		restfulResult.setReturnmsg("用户token已过期，请重新登录");
		restfulResult.setSuccess(false);
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(restfulResult);
	}

	@ExceptionHandler(value = Exception.class)
	public Object defaultExceptionHandler(Exception e) {
		log.error("服务器发生未知错误异常", e);
		BaseResDto restfulResult = new BaseResDto();
		restfulResult.setReturncode(PubDefine.RETCODE_FAILURE);
		String msg = e.getMessage();
		if(msg == null || "".equals(msg)) {
			msg = "服务器发生未知错误异常";
		}
		restfulResult.setReturnmsg(msg);
		restfulResult.setSuccess(false);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(restfulResult);
	}

}
