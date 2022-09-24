/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author jorge
 */
public interface Encryptservice {
//    encripta la contraseña
    String encryptPassword(String password);
//    Verificar la constraseña encriptada con la original
    boolean verifyPassword(String originalPassword, String hashPassword);
    
}
