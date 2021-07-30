package personal.springframework.petclinic.services.map;

import java.util.List;
import personal.springframework.petclinic.model.Owner;
import personal.springframework.petclinic.services.OwnerService;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

  @Override
  public Owner findByLastName(String lastName) {
    return null;
  }

  @Override
  public List<Owner> findAllByLastNameLike(String lastName) {
    return null;
  }

}
