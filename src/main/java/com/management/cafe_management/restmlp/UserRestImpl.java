package com.management.cafe_management.restmlp;

import com.management.cafe_management.constens.CafeConstante;
import com.management.cafe_management.rest.userRest;
import com.management.cafe_management.services.UserServices;
import com.management.cafe_management.utils.CafeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserRestImpl implements userRest {
@Autowired //pour injecter le UserService ici
    UserServices userServices;

    @Override
    public ResponseEntity<String> signup(Map<String, String> requestMap) {
        try{
return  userServices.signUp(requestMap); //on doit passer requestMap au haut vers userSertvice.signUp methode
        }catch (Exception ex)
        {
ex.printStackTrace();
//car je veux pas envoyer le message d'exception au user final et  je veux personnaliser le message
        }
      return CafeUtils.getResponseEntity(CafeConstante.SOMTHING_WENT_WARING, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
