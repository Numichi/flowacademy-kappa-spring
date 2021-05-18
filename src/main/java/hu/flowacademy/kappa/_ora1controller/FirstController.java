package hu.flowacademy.kappa._ora1controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class FirstController {

    private final FirstControllerHelper helper;

    public FirstController(FirstControllerHelper helper) {
        this.helper = helper;
    }

    /**
     * Focus: @GetMapping
     */
    @GetMapping
    public String getExample() {
        return "Első GET method.";
    }

    /**
     * Focus: @PathVariable
     */
    @GetMapping("{id}")
    public String getMethodWithPathVariable(@PathVariable Integer id) {
        return "A '" + id + "' értéket kaptam az URL-ből.";
    }

    /**
     * Focus: @ResponseStatus, @RequestBody
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void postExample(@RequestBody RequestModel model) {
        helper.model(model);
    }

    /**
     * Focus: @RequestParam
     */
    @GetMapping("request-param-1")
    public String getRequestParam1(@RequestParam String testKey) {
        return testKey;
    }

    /**
     * Focus: @RequestHeader (paraméter nélkül)
     */
    @GetMapping("header-1")
    public String headerExample1(@RequestHeader String xTestHeader) {
        return xTestHeader;
    }

    /**
     * Focus: @RequestHeader (paraméterrel)
     */
    @GetMapping("header-2")
    public String headerExample2(@RequestHeader("x-test-header") String header) {
        return header;
    }

    /**
     * Focus: ResponseEntity
     */
    @GetMapping("response-entity")
    public ResponseEntity<String> responseEntity() {
        return ResponseEntity.ok("Programozottan konfigurálom a választ");
    }

    /**
     * Focus: egyéb, lásd teszt
     */
    @PutMapping
    public RequestModel putExample(@RequestBody RequestModel model) {
        return model;
    }
}
