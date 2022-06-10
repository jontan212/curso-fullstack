/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configuracionBD;

/**
 *
 * @author manana
 */
public class CargarDriver {
    public static void cargar(String drv) throws ClassNotFoundException {
        Class.forName(drv);
    }
}
