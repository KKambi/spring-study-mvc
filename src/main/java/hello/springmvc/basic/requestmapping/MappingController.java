package hello.springmvc.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MappingController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping({"/hello-basic", "/hello-go"})
    public String helloBasic() {
        log.info("basic");
        return "ok";
    }

    @GetMapping("/mapping-get-v2")
    public String mappingGetV2() {
        log.info("mapping-get-v2");
        return "ok";
    }

    @GetMapping("/mapping/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable("userId") String userId,
        @PathVariable("orderId") String orderId) {
        log.info("mappingPath userId={}", userId);
        log.info("mappingPath orderId={}", orderId);
        return "ok";
    }

    /**
     * 파라미터로 추가 매핑 params="mode" params="!mode" params="mode=debug" params="mode!=debug" (! = )
     * params = {"mode=debug","data=good"}
     */
    @GetMapping(value = "/mapping-param", params = "mode=debug")
    public String mappingParam() {
        log.info("mappingParam");
        return "ok";
    }

    /**
     * 특정 헤더로 추가 매핑 headers="mode", headers="!mode" headers="mode=debug" headers="mode!=debug" (! =
     * )
     */
    @GetMapping(value = "/mapping-header", headers = "mode=debug")
    public String mappingHeader() {
        log.info("mappingHeader");
        return "ok";
    }

    /**
     * Content-Type 헤더 기반 추가 매핑 Media Type consumes="application/json" consumes="!application/json"
     * consumes="application/*" consumes="*\/*" MediaType.APPLICATION_JSON_VALUE
     */
    @PostMapping(value = "/mapping-consume", consumes = "application/json")
    public String mappingConsumes() {
        log.info("mappingConsumes");
        return "ok";
    }

    /**
     * Accept 헤더 기반 Media Type produces = "text/html" produces = "!text/html" produces = "text/*"
     * produces = "*\/*"
     */
    @PostMapping(value = "/mapping-produce", produces = "text/html")
    public String mappingProduces() {
        log.info("mappingProduces");
        return "ok";
    }
}
