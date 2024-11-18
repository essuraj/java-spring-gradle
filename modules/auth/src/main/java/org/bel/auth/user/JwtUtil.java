package org.bel.auth.user;


 import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtUtil {

    private final String secretKey = "20950089e72a55cf683d71f6f33bb80ad1d31fe7b7da9b4aaba99300a8ee88aca813e9f6be436f351017e591926513efd38266fcffd9443c151884b5204b84a1869d79f5e24f5b42a796f7d78e373000998d885fe510ba597f5a2209acc8af9d7f42afaacd78607fa0990e28e4933492b4473f261ba762e86b45fd21cb85bfb50f05b00e03c1f90822669037139d807c592d9382391de94f9a12e11a9f3b36f4fe94057024aeb0a0927384dc414701bcbc1a7ef29c437a2ab3acd26d40cddecdddbbd906dc2753299dc0672ec72f8182d1a7369c016c888c82125de0c260b8f9cbd657352ff41eb73a021c36545a176d4921964e8b8440cd1413833c5d517dd0"; // Replace with a secure key

    public String generateToken(User user) {
        return Jwts.builder()
                   .setSubject(user.getUsername())
                   .claim("role", user.getRole().name())
                   .setIssuedAt(new Date())
                   .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // 1 hour
                   .signWith(SignatureAlgorithm.HS256, secretKey)
                   .compact();
    }
}