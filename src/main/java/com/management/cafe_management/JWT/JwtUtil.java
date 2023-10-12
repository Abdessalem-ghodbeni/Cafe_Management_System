//
//// ce bloc de code en faite permet de  générer, valider et extraire des informations à partir
//// de JSON Web Tokens (JWT) dans une application Spring Boot.
//     package com.management.cafe_management.JWT;
////Ce bloc de code importe les classes nécessaires pour travailler avec
////        JWT, y compris Claims (revendications), Jwts (bibliothèque JWT)
////        ,SignatureAlgorithm (algorithme de signature),
////        UserDetails (informations sur l'utilisateur) et d'autres classes nécessaires.
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Service;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Objects;
//import java.util.function.Function;
//
////La classe JwtUtil est annotée avec @Service, ce qui signifie qu'elle est gérée par le conteneur Spring comme un composant pouvant être injecté dans d'autres parties de l'application. La clé secrète secret utilisée pour signer les tokens JWT est initialisée à "btechdays". Vous devriez sécuriser cette clé dans un environnement de production.
//@Service
//public class JwtUtil {
//
//    private  String secret ="btechdays";
////    Les claims sont des informations qui sont ajoutées au JWT pour
////    transporter des données spécifiques. Un JWT est composé de trois
////    parties : l'en-tête (header), les claims (payload) et la signature.
////    Les claims sont stockés dans la partie "payload" du JWT, qui est
////    généralement au format JSON.
//    public String extractUsername(String token){
//        return extractClamis(token,Claims::getSubject);
////        extractUsername est une méthode qui prend un token JWT en
////        entrée et extrait le nom d'utilisateur (subject) à partir
////        des claims du token en utilisant la méthode getSubject de
////        l'objet Claims.
//    }
//    public Date extractExpiration(String token){
//       return extractClamis(token,Claims::getExpiration);
////        extractExpiration est une méthode similaire qui extrait la
////        date d'expiration du token à partir des claims.
//    }
//    public <T> T extractClamis(String token, Function<Claims,T>claimsResolver){
//        final Claims claims = extractAllClaims(token);
//        return  claimsResolver.apply(claims);
////        extractClaims est une méthode générique qui prend un token
////        JWT et une fonction claimsResolver en entrée, puis extrait
////        toutes les revendications (claims) du token en utilisant
////        extractAllClaims et applique la fonction claimsResolver sur
////        ces claims. Cette méthode est utilisée par extractUsername
////        et extractExpiration
//    }
//
//
//    public Claims extractAllClaims(String token){
//        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
////        extractAllClaims prend un token JWT en entrée, vérifie sa
////        signature en utilisant la clé secrète secret, puis renvoie
////        l'objet Claims qui contient toutes les informations du
////        token.
//    }
// private Boolean isTokenExpired(String token) {
//        return extractExpiration(token).before(new Date());
////     isTokenExpired est une méthode privée qui vérifie si le token
////     a expiré en comparant la date d'expiration extraite du token
////     avec la date actuelle.
// }
// public String generateToken(String username,String role){
//        Map<String,Object> claims =new HashMap<>();
//        claims.put("role",role);
//       return createToken(claims,username);
////     generateToken prend un nom d'utilisateur (username) et un rôle
////     (role) en entrée, crée un ensemble de revendications (claims)
////     avec le rôle, puis utilise la méthode createToken pour générer
////     un nouveau token JWT.
// }
// private String createToken(Map<String, Object> claims, String subject){
//        return  Jwts.builder()
//                .setClaims(claims)
//                .setSubject(subject)
//                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis()+1000 * 60 * 60 * 10 ))
//                .signWith(SignatureAlgorithm.ES256,secret).compact();
////     createToken prend un ensemble de revendications et un sujet en
////     entrée, puis construit un nouveau token JWT en utilisant les
////     informations fournies. Il spécifie les revendications, la date
////     d'émission, la date d'expiration et signe le token avec
////     l'algorithme de signature spécifié
////     (ici, SignatureAlgorithm.ES256) et la clé secrète.
//    }
// public Boolean validateToken(String token, UserDetails userDetails){
//        final String username=extractUsername((token));
//        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
////     validateToken est une méthode qui prend un token JWT et
////     des détails sur l'utilisateur en entrée. Elle extrait le
////     nom d'utilisateur du token à l'aide de extractUsername,
////     puis vérifie si le nom d'utilisateur correspond à celui des
////     détails de l'utilisateur fournis et si le token a expiré.
//    }
//
//}
