package com.assosetvous.assosetvous.service.impl;

import com.assosetvous.assosetvous.entity.User;
import com.assosetvous.assosetvous.service.JWTService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JWTServiceImpl implements JWTService {
    //Je vais créer une méthode qui permet de générer un token
    public String generateToken(UserDetails userDetails){
      return Jwts.builder().setSubject(userDetails.getUsername())
              .setIssuedAt(new Date(System.currentTimeMillis()))
              .setExpiration(new Date(System.currentTimeMillis()+1000*60*24)) // Expiration more than one day
              .signWith(getSigninKey(), SignatureAlgorithm.HS256)
              // créer le token et le serialize
              .compact();
    }
    public String generateRefreshToken(Map<String, Object> extraClaims, UserDetails userDetails) {
        return Jwts.builder().setClaims(extraClaims).setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+604800000)) // Valid for  7 days
                .signWith(getSigninKey(), SignatureAlgorithm.HS256)
                // créer le token et le serialize
                .compact();
    }

    //Méthode qui permet d'extraire le token
    private <T> T extractClaim(String token, Function<Claims, T> claimsResolvers){
        //Va récupéer toutes les réclamations dans notre Token
        final Claims claims = extractAllClaims(token);
        return claimsResolvers.apply(claims);
    }

    //Méthode qui permet d'extraire les tokens
    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(getSigninKey())
                .build().parseClaimsJws(token).getBody();
    }
    public String extractUserName(String token){
        return extractClaim(token, Claims::getSubject);
    }
    // Creation d'une clé  pour la signature de notre token
    private Key getSigninKey(){
        // Je créer un tableau de byte cqui va contenir ma clé secrète
        byte[] key = Decoders.BASE64.decode("413F4428472B4B6250655368566D5970337336763979244226452948404D6351"); // Putting our secret key
        return Keys.hmacShaKeyFor(key);
    }

    //Méthode qui permet de vérifier que mon Token est valide
    public boolean isTokenValid(String token, UserDetails userDetails){
       final String username = extractUserName(token);
       // Je vérifie que le token n'est pas expiré avec la méthode isTokenExpired
      return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));

    }

    private boolean isTokenExpired(String token) {
        //je vais chercher mon token, je récupère sa date d'expiration cela me retourne si la date est antérieur à la date du jour
        return extractClaim(token, Claims::getExpiration)
                .before(new Date());
    }



}
