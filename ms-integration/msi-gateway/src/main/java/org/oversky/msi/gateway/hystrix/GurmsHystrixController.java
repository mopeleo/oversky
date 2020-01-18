package org.oversky.msi.gateway.hystrix;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GurmsHystrixController {

	@RequestMapping("/fallback")
	public String fallBackController() {
        return "熔断：服务读取超时";
	}
}
