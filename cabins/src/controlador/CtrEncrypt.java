/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import org.springframework.security.crypto.bcrypt.BCrypt;

/**
 *
 * @author SENA
 */
public class CtrEncrypt {
      public String encryptPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
      }
      
      public boolean verifyPassword(String originalPassword, String hashpassword){
         
          return  BCrypt.checkpw(originalPassword, hashpassword);   
      }
      
      
}
