package personal.springframework.petclinic.services;

import java.util.List;
import personal.springframework.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

  Owner findByLastName(String lastName);

  List<Owner> findAllByLastNameLike(String lastName);

}

