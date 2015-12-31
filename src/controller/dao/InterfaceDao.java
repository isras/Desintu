package controller.dao;
import java.util.List;

/**
 * Interface para el Dao
 * @author Sergio
 * @param <T>
 */
public interface InterfaceDao<T> {
    T obterner(Long id);
    List<T> lista();
    long contraTodos();
    void guarda(T obj);
    void modificar(T obj);//metodos sin cuerpos
    void eliminar(T obj);
}
