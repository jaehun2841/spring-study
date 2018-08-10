package com.example.springstudy.controller;

        import com.example.springstudy.annotation.ClientIP;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    /**
     * 요청을 보낸 Client Ip를 return
     * @param clientIp
     * @return
     */
    @GetMapping("/client")
    public String getClientIp(@ClientIP String clientIp) {


        return String.format("Request Client Ip = %s", clientIp);
    }
}
