package api.ecommerce.br.apiecommerce.config.jwt;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import javax.crypto.SecretKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    @Autowired
    private SecretUserKey secretUserKey;

    public String extractUserEmail(String token) {
        return exctractClaim(token, Claims::getSubject);
    }
    

   public <T> T exctractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
   }

   public String generatedToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
   }


   public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
        return Jwts
        .builder()
        .setClaims(extraClaims)
        .setSubject(userDetails.getUsername())
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
        .signWith(getSignInKey(), SignatureAlgorithm.HS512)
        .compact();
        
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String email = extractUserEmail(token);
        return(email.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }


    private boolean isTokenExpired(String token) {
        return exctractExpiration(token).before(new Date());
    }

    

    private Date exctractExpiration(String token) {
        return exctractClaim(token, Claims::getExpiration);
    }


    private Claims extractAllClaims(String token) {
        return Jwts
            .parserBuilder()
            .setSigningKey(getSignInKey())
            .build()
            .parseClaimsJws(token)
            .getBody();

    }


   private SecretKey getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretUserKey.secret());
        return Keys.hmacShaKeyFor(keyBytes);
    }




}
