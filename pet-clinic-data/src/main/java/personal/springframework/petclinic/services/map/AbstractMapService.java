package personal.springframework.petclinic.services.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import personal.springframework.petclinic.model.BaseEntity;
import personal.springframework.petclinic.services.CrudService;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> implements
    CrudService<T,ID> {

  protected Map<Long, T> map = new HashMap<>();

  public Set<T> findAll(){
    return new HashSet<>(map.values());
  }

  public T findById(ID id){
    return map.get(id);
  }

  public T save(T object){
    return Optional.of(object)
        .map(this::saveMapElement)
        .orElse(null);
  }

  public void deleteById(ID id){
    map.remove(id);
  }

  public void delete(T object){
    map.entrySet().removeIf(entry -> entry.getValue().equals(object));
  }

  private T saveMapElement(T object){
    return map.put(getNextId(), object);
  }

  private Long getNextId(){
    return map.keySet()
        .stream()
        .max(Long::compareTo)
        .map(id -> id + 1L)
        .orElse(1L);
  }

}
