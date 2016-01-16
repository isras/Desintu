package controller;

import model.UserAccount;

/**
 *Mantiene una cuenta viva para obtener la sesion correspondiente del usuario
 * @author 
 */
public class Sessions 
{
    private static  UserAccount user;

    /**
     * @return the user
     */
    public static UserAccount getUser() {
        return user;
    }

    /**
     * @param aUser the user to set
     */
    public static void setUserAccount(UserAccount aUser) {
        user = aUser;
    }


       
}
