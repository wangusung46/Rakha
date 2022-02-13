package rakha.model.admin;

/**
 *
 * @author Khanza
 */
public interface UserJdbc {

    public Boolean login(String userName, String password);
    
    public Integer role(String userName);

}
