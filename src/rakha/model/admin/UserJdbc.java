package rakha.model.admin;

/**
 *
 * @author Rakha
 */
public interface UserJdbc {

    public Boolean login(String userName, String password);
    
    public Integer role(String userName);
    
    public Boolean supervisor(String password);

}
