/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
/**
 *
 * @author jorge
 */
public class EncryptServiceImpl implements Encryptservice{

    @Override
    public String encryptPassword(String password) {
        
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    @Override
    public boolean verifyPassword(String originalPassword, String hashPassword) {
        
        return false;
    }
    
}
