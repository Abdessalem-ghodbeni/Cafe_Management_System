package com.management.cafe_management.servicesmpl;

import com.management.cafe_management.POJO.User;
import com.management.cafe_management.constens.CafeConstante;
import com.management.cafe_management.dao.UserDao;
import com.management.cafe_management.services.UserServices;
import com.management.cafe_management.utils.CafeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Slf4j
@Service
public class userServices implements UserServices {
//maven permet de construire un projet spring boot,donner un livrable c'est à dire fichier excutable
    //maven nous offre une squellette standarisé
    //pom.xml c'est le ficheir de configuration de maven
    //le compilation en java ne fait pas la traduction en binaire mais en bytcode ...
// /java est portable car il s'exécute sur n'importe quelle machine la compilation se fait en traduire en byteCode
    @Autowired
    UserDao userDao;
    @Override
    public ResponseEntity<String> signUp(Map<String, String> requesMap) {
try {
    log.info("inside signup ",requesMap);
    if(validateSignUp(requesMap)){
        User user=userDao.findByEmailId(requesMap.get("email"));
        if(Objects.isNull(user)){
            userDao.save(getUserFromMap(requesMap));
            return CafeUtils.getResponseEntity("Successfully registred",HttpStatus.OK);
        }else{
            return CafeUtils.getResponseEntity("Email already exists",HttpStatus.BAD_REQUEST);
        }
    }else {
        return CafeUtils.getResponseEntity(CafeConstante.INVALID_DATA, HttpStatus.BAD_REQUEST);
    }

}
catch (Exception ex){
    ex.printStackTrace();
}
return CafeUtils.getResponseEntity(CafeConstante.SOMTHING_WENT_WARING,HttpStatus.INTERNAL_SERVER_ERROR);


    }

    private boolean validateSignUp(Map<String,String> requestMap){
       if( requestMap.containsKey("name")&& requestMap.containsKey("contactNumber")&& requestMap.containsKey("email")&& requestMap.containsKey("password")){
           return true;

       }else {
           return false;
       }
    }
    //nous avons besoin d'une methode pour récupérer les données du requestMap qui contient les données saisie par l'utilisateur
    private User getUserFromMap(Map<String,String>requestMap){
User user =new User();
 user.setName(requestMap.get("name"));
 user.setContactNumber(requestMap.get("contactNumber"));
 user.setEmail(requestMap.get("email"));
 user.setPassword(requestMap.get("password"));
 user.setStatus("false");
 user.setRole("user");
 return user;
    }
}

