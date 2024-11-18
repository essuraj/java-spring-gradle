
package org.bel.auth;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }
    @GetMapping("/")
    public String home() {
        return "<html><head> <meta charset=\"UTF-8\"> <style> @media " +
               "(prefers-color-scheme: light) { body { background-color: " +
               "#f4f4f4; color: #0b0f10; } } @media (prefers-color-scheme: " + "dark) { body { background-color: #0b0f10; color: #f4f4f4; } }" + " </style> </head> <body><h1 style=\"font-family: monospace; " + "text-align: center; font-size: 72px\"> <br><br><br> " + "\uD83D\uDC69\u200D\uD83D\uDCBB\uD83D\uDCBB\uD83D\uDC68\u200D\uD83D\uDCBB<br>Auth API is Ready!<br> </h1> </body></html>";

    }

}
